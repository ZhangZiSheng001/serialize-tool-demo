# 简介

实际项目中，我们经常需要使用序列化工具来存储和传输对象。目前用得比较多的序列化工具有：jackson、fastjson、kryo、protostuff、fst 等，本文将简单对比这几款工具序列化和反序列化的性能。

# 项目环境

本文使用 jmh 作为测试工具。

os：win 10

jdk：1.8.0_231

jmh：1.25

选择的序列化工具及对应的版本如下：

fastjson：1.2.74

jackson：2.11.3

kryo：5.0.0

fst：2.57

protostuff：1.7.2

# 测试代码

为了公平，我尽量让测试用例中对序列化工具的用法更贴近实际项目，例如，kryo 的`Kryo`对象不是线程安全的，实际项目中我们并不会每次使用就直接 new 一个新对象，而是使用 ThreadLocal 或者池来减少创建对象的开销。

本文使用的 java bean 如下。一个用户对象，一对一关联部门对象和岗位对象，其中部门对象又存在自关联。

```java
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    // 普通属性--29个
    private String id;
    private String account;
    private String password;
    private Integer status;
    // ······
    
    /**
     * 所属部门
     */
    private Department department;
    /**
     * 岗位
     */
    private Position position;
    
    // 以下省略setter/getter方法
}
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    // 普通属性--7个
    private String id;
    private String parentId;
    // ······
    /**
     * 子部门
     */
    private List<Department> children;
    
    // 以下省略setter/getter方法
}
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;
    // 普通属性--6个
    private String id;
    private String name;
    // ······
    // 以下省略setter/getter方法
}
```

下面展示部分测试代码，完整代码见末尾链接。

## JDK 自带的序列化工具

JDK 提供了`ObjectOutputStream`用于支持序列化，`ObjectInputStream`用于反序列化。注意，**使用 JDK 自带的序列化工具时，java bean 必须实现` Serializable `，否则会抛出`NotSerializableException`异常** 。使用关键字 transient 修饰的成员属性不会被序列化。

```java
    // 序列化
    @Benchmark
    public byte[] jdkSerialize(CommonState commonState) throws Exception {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArray);
        outputStream.writeObject(commonState.user);
        outputStream.flush();
        outputStream.close();
        return byteArray.toByteArray();
    }
    // 反序列化
    @Benchmark
    public User jdkDeSerialize(JdkState jdkState) throws Exception {
        ByteArrayInputStream byteArray = new ByteArrayInputStream(jdkState.bytes);
        ObjectInputStream inputStream = new ObjectInputStream(byteArray);
        User user = (User)inputStream.readObject();
        inputStream.close();
        assert "zzs0".equals(user.getName());
        return user;
    }
```

## fastjson

fastjson 由阿里团队开发，是目前最快的Java 实现的 json 库。 fastjson 的 API 非常简洁，并且支持一定程度的定制（例如，注解` @JSONField`、枚举`Feature`等定制序列化）。被人诟病的，可能是 fastjson 的 bug 比较多。

```java
    // 序列化
    @Benchmark
    public byte[] fastJsonSerialize(CommonState commonState) {
        return JSON.toJSONBytes(commonState.user);
    }
    // 反序列化
    @Benchmark
    public User fastJsonDeSerialize(FastJsonState fastJsonState) {
        User user = JSON.parseObject(fastJsonState.bytes, User.class);
        assert "zzs0".equals(user.getName());
        return user;
    }
```

## jackson

jackson 由 fasterxml 组织开发，相比 fastjson，有着更强大的功能、更高的稳定性、更好的扩展性、更丰富的定制支持。Spring 默认使用的 json 解析工具就是 jackson。

使用 jackson 需要注意，**`ObjectMapper`对象是线程安全的，可以重复使用**。

```java
    // 序列化
    @Benchmark
    public byte[] jacksonSerialize(CommonState commonState, JacksonState jacksonState) throws Exception {
        return jacksonState.objectMapper.writeValueAsBytes(commonState.user);
    }
    // 反序列化
    @Benchmark
    public User jacksonDeSerialize(JacksonState jacksonState) throws Exception {
        User user = jacksonState.objectMapper.readValue(jacksonState.bytes, User.class);
        assert "zzs0".equals(user.getName());
        return user;
    }
```

## kryo

 kryo 由 EsotericSoftware 组织开发，不兼容 jdk 自带序列化工具的数据，kryo 序列化后的数据要更小，至于 API 的简洁性方面，我觉得还是差了一些，一不小心就会采坑。使用 kryo 需要注意以下几点：

1. **`Kryo`对象不是线程安全的，可以使用`ThreadLocal`或池来获取**（本文使用池获取）；
2.  kryo 通过类注册可以在序列化数据中写入类的 class id，而不是类的全限定类名，从而减小序列化数据的大小。但是，我们很难保证同样的类在不同的机器上注册的 class id，所以，建议设置`kryo.setRegistrationRequired(false);`，因为同样的 Class 在不同的机器上注册编号很难保证一致；
3. 当 java bean 出现循环引用时，使用 kryo 可能会出现栈内存溢出，这个时候可以通过设置`kryo.setReferences(true);`来避免。如果项目中不可能出现循环引用，则可以设置为 false 以提高性能。

```java
	// 序列化
    @Benchmark
    public byte[] kryoSerialize(CommonState commonState, KryoState kryoState) {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        Output output = new Output(byteArray);
        Kryo kryo = kryoState.kryoPool.obtain();
        kryo.writeClassAndObject(output, commonState.user);
        kryoState.kryoPool.free(kryo);
        output.flush();
        output.close();
        return byteArray.toByteArray();
    }
	//反序列化
    @Benchmark
    public User kryoDeSerialize(KryoState kryoState) throws Exception {
        ByteArrayInputStream byteArray = new ByteArrayInputStream(kryoState.bytes);
        Input input = new Input(byteArray);
        Kryo kryo = kryoState.kryoPool.obtain();
        User user = (User)kryo.readClassAndObject(input);
        kryoState.kryoPool.free(kryo);
        input.close();
        assert "zzs0".equals(user.getName());
        return user;
    }
```

## fst

fst（fast-serialization）是由 RuedigerMoeller 开发，API 非常简洁。**使用时需要注意，`FSTConfiguration`对象可以重复使用**。

其实，fst 也支持以 json 形式序列化，但是这一块的性能稍差而且用的人较少，这里就不提及了。

```java
	// 序列化
    @Benchmark
    public byte[] fstSerialize(CommonState commonState, FSTConfigurationState fSTConfigurationState) {
        return fSTConfigurationState.fSTConfiguration.asByteArray(commonState.user);
    }
	// 反序列化
    @Benchmark
    public User fstDeSerialize(FSTState fstState) throws Exception {
        User user = (User)fstState.fSTConfiguration.asObject(fstState.bytes);
        assert "zzs0".equals(user.getName());
        return user;
    }
```

## protostuff

protostuff 是基于 google protobuf 开发而来（与 protobuf 相比，protostuff 在几乎不损耗性能的情况下做到了不用写.proto文件来实现序列化），不兼容 jdk 自带序列化工具的数据，序列化后的数据要更小。使用 protostuff 需要注意几点：

1. protostuff 使用字段的定义顺序作为字段的 tag，新增字段时必须保证原字段顺序不变，否则旧数据可能会反序列化失败；
2. protostuff 不能直接序列化 Array、List、Map，如果需要序列化，需要先包装成 java bean；

```java
	// 序列化
    @Benchmark
    public byte[] protostuffSerialize(CommonState commonStateme) {
        Schema<User> schema = (Schema<User>)RuntimeSchema.getSchema(User.class);
        return ProtostuffIOUtil.toByteArray(commonStateme.user, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
    }
	// 反序列化
    @Benchmark
    public User protostuffDeSerialize(ProtostuffState protostuffState) throws Exception {
        User user = new User();
        Schema<User> schema = (Schema<User>)RuntimeSchema.getSchema(User.class);
        ProtostuffIOUtil.mergeFrom(protostuffState.bytes, user, schema);
        assert "zzs0".equals(user.getName());
        return user;
    }
```

# 测试结果

以下以吞吐量作为指标，相同条件下，吞吐量越大越好。

## 序列化

cmd 指令如下：

```powershell
mvn clean package
java -ea -jar target/benchmarks.jar cn.zzs.serialize.SerializeTest -f 1 -t 1 -wi 10 -i 10
```

测试结果：

```powershell
# JMH version: 1.25
# VM version: JDK 1.8.0_231, Java HotSpot(TM) 64-Bit Server VM, 25.231-b11
# VM invoker: D:\growUp\installation\jdk1.8.0_231\jre\bin\java.exe
# VM options: -ea
# Warmup: 10 iterations, 10 s each
# Measurement: 10 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
Benchmark                           Mode  Cnt    Score    Error   Units
SerializeTest.fastJsonSerialize    thrpt   10  449.474 ±  1.851  ops/ms
SerializeTest.fstSerialize         thrpt   10  694.716 ±  7.240  ops/ms
SerializeTest.jacksonSerialize     thrpt   10  330.610 ±  6.968  ops/ms
SerializeTest.jdkSerialize         thrpt   10  132.483 ±  0.379  ops/ms
SerializeTest.kryoSerialize        thrpt   10  609.969 ±  3.288  ops/ms
SerializeTest.protostuffSerialize  thrpt   10  762.737 ± 10.918  ops/ms
```

可以看到，**序列化速度方面：protostuff > fst > kryo > fastjson > jackson > jdk**。

## 反序列化

cmd 指令如下：

```powershell
mvn clean package
java -ea -jar target/benchmarks.jar cn.zzs.serialize.DeSerializeTest -f 1 -t 1 -wi 10 -i 10
```

测试结果：

```powershell
# JMH version: 1.25
# VM version: JDK 1.8.0_231, Java HotSpot(TM) 64-Bit Server VM, 25.231-b11
# VM invoker: D:\growUp\installation\jdk1.8.0_231\jre\bin\java.exe
# VM options: -ea
# Warmup: 10 iterations, 10 s each
# Measurement: 10 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time

fastjson serialized data size:1044
fst serialized data size:607
jackson serialized data size:1060
jdk serialized data size:1700
kryo serialized data size:597
protostuff serialized data size:543

Benchmark                               Mode  Cnt    Score   Error   Units
DeSerializeTest.fastJsonDeSerialize    thrpt   10  397.069 ± 3.507  ops/ms
DeSerializeTest.fstDeSerialize         thrpt   10  465.813 ± 4.700  ops/ms
DeSerializeTest.jacksonDeSerialize     thrpt   10  226.412 ± 1.436  ops/ms
DeSerializeTest.jdkDeSerialize         thrpt   10   27.919 ± 0.352  ops/ms
DeSerializeTest.kryoDeSerialize        thrpt   10  448.978 ± 3.504  ops/ms
DeSerializeTest.protostuffDeSerialize  thrpt   10  499.328 ± 4.485  ops/ms
```

可以看到，**反序列化速度方面：protostuff > fst > kryo > fastjson > jackson > jdk**，该结果和序列化一致。

**序列化数据的大小方面：protostuff < kryo < fst < fastjson < jackson < jdk**。

以上数据仅供参考。感谢阅读。



> 相关源码请移步：[ serialize-tool-demo](https://github.com/ZhangZiSheng001/serialize-tool-demo)

> 本文为原创文章，转载请附上原文出处链接：[https://www.cnblogs.com/ZhangZiSheng001/p/13196228.html](