package cn.zzs.serialize.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户服务
 * @author zzs
 * @date 2020年11月6日 下午1:49:07
 */
public class UserService {
    
    public List<User> getList(int count){
        List<User> list = new ArrayList<User>(count);
        for(int i = 0; i < count; i++) {
            User user = new User();
            user.setId(UUID.randomUUID().toString().replace("-", ""));
            user.setAccount("account" + i);
            user.setPassword("password" + i);
            user.setStatus(1);
            user.setName("zzs" + i);
            user.setNo("No." + i);
            user.setSex("male");
            user.setBirthday(new Date());
            user.setMobile("12345678912");
            user.setInnerTel("****-123456");
            user.setOuterTel("****-123456");
            user.setWeixin("powerfulzzs" + i);
            user.setWeixinQrcode("zzs/" + i + ".jpg");
            user.setFax("fax" + i);
            user.setQq("1769464444" + i);
            user.setEmail(user.getQq() + "@qq.com");
            user.setPicture("zzs2/" + i + ".jpg");
            user.setType("king");
            user.setAddress("address" + i);
            user.setLeaved(0);
            user.setJoinDate(new Date());
            user.setIdCard("433556462" + i);
            user.setDiploma(0);
            user.setMaritalStatus(1);
            user.setAge(18);
            user.setJob("king");
            user.setPermanentAddress("广东");
            user.setLoginDate(new Date());
            user.setPinyin("zzs" + i);
            
            
            Position position = new Position();
            position.setId(UUID.randomUUID().toString().replace("-", ""));
            position.setName("King");
            position.setParentId("1");
            position.setNo("PNo.123456");
            position.setLevel(2);
            position.setOrderNo(0);
            user.setPosition(position);
            
            Department department = new Department();
            department.setId(UUID.randomUUID().toString().replace("-", ""));
            department.setName("软件研发部");
            department.setParentId("1");
            department.setNo("DNo.123456");
            department.setLevel(2);
            department.setAddress("广东");
            department.setOrderNo(0);
            Department department2 = new Department();
            department2.setId(UUID.randomUUID().toString().replace("-", ""));
            department2.setName("软件研发部");
            department2.setParentId(department.getId());
            department2.setNo("DNo.123457");
            department2.setLevel(2);
            department2.setAddress("广东");
            department2.setOrderNo(0);
            department.setChildren(Arrays.asList(department2));
            user.setDepartment(department);
            
            list.add(user);
        }
        return list;
    }
    
    
    public User get() {
        return getList(1).get(0);
    }
    
}
