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
            
            user.setField00("field00");
            user.setField01("field01");
            user.setField02("field02");
            user.setField03("field03");
            user.setField04("field04");
            user.setField05("field05");
            user.setField06("field06");
            user.setField07("field07");
            user.setField08("field08");
            user.setField09("field09");
            user.setField10("field10");
            user.setField11("field11");
            user.setField12("field12");
            user.setField13("field13");
            user.setField14("field14");
            user.setField15("field15");
            user.setField16("field16");
            user.setField17("field17");
            user.setField18("field18");
            user.setField19("field19");
            user.setField20("field20");
            user.setField21("field21");
            user.setField22("field22");
            user.setField23("field23");
            user.setField24("field24");
            user.setField25("field25");
            user.setField26("field26");
            user.setField27("field27");
            user.setField28("field28");
            user.setField29("field29");
            user.setField30("field30");
            user.setField31("field31");
            user.setField32("field32");
            user.setField33("field33");
            user.setField34("field34");
            user.setField35("field35");
            user.setField36("field36");
            user.setField37("field37");
            user.setField38("field38");
            user.setField39("field39");
            user.setField40("field40");
            user.setField41("field41");
            user.setField42("field42");
            user.setField43("field43");
            user.setField44("field44");
            user.setField45("field45");
            user.setField46("field46");
            user.setField47("field47");
            user.setField48("field48");
            user.setField49("field49");
            user.setField50("field50");
            user.setField51("field51");
            user.setField52("field52");
            user.setField53("field53");
            user.setField54("field54");
            user.setField55("field55");
            user.setField56("field56");
            user.setField57("field57");
            user.setField58("field58");
            user.setField59("field59");
            user.setField60("field60");
            user.setField61("field61");
            user.setField62("field62");
            user.setField63("field63");
            user.setField64("field64");
            user.setField65("field65");
            user.setField66("field66");
            user.setField67("field67");
            user.setField68("field68");
            user.setField69("field69");
            user.setField70("field70");
            user.setField71("field71");
            user.setField72("field72");
            user.setField73("field73");
            user.setField74("field74");
            user.setField75("field75");
            user.setField76("field76");
            user.setField77("field77");
            user.setField78("field78");
            user.setField79("field79");
            user.setField80("field80");
            user.setField81("field81");
            user.setField82("field82");
            user.setField83("field83");
            user.setField84("field84");
            user.setField85("field85");
            user.setField86("field86");
            user.setField87("field87");
            user.setField88("field88");
            user.setField89("field89");
            user.setField90("field90");
            user.setField91("field91");
            user.setField92("field92");
            user.setField93("field93");
            user.setField94("field94");
            user.setField95("field95");
            user.setField96("field96");
            user.setField97("field97");
            user.setField98("field98");
            user.setField99("field99");
            
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
