package cn.zzs.serialize.other;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户对象
 * @author zzs
 * @date 2020年11月6日 下午1:34:50
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    // 普通属性
    private String id;
    private String account;
    private String password;
    private Integer status;
    private String name;
    private String no;
    private String sex;
    private Date birthday;
    private String mobile;
    private String innerTel;
    private String outerTel;
    private String weixin;
    private String weixinQrcode;
    private String fax;
    private String qq;
    private String email;
    private String picture;
    private String type;
    private String address;
    private Integer leaved;
    private Date joinDate;
    private String idCard;
    private Integer diploma;
    private Integer maritalStatus;
    private Integer age;
    private String job;
    private String permanentAddress;
    private Date loginDate;
    private String pinyin;
    
    /**
     * 所属部门
     */
    private Department department;
    /**
     * 岗位
     */
    private Position position;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getAccount() {
        return account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getNo() {
        return no;
    }
    
    public void setNo(String no) {
        this.no = no;
    }
    
    public String getSex() {
        return sex;
    }
    
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getInnerTel() {
        return innerTel;
    }
    
    public void setInnerTel(String innerTel) {
        this.innerTel = innerTel;
    }
    
    public String getOuterTel() {
        return outerTel;
    }
    
    public void setOuterTel(String outerTel) {
        this.outerTel = outerTel;
    }
    
    public String getWeixin() {
        return weixin;
    }
    
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }
    
    public String getWeixinQrcode() {
        return weixinQrcode;
    }
    
    public void setWeixinQrcode(String weixinQrcode) {
        this.weixinQrcode = weixinQrcode;
    }
    
    public String getFax() {
        return fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    
    public String getQq() {
        return qq;
    }
    
    public void setQq(String qq) {
        this.qq = qq;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPicture() {
        return picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public Integer getLeaved() {
        return leaved;
    }
    
    public void setLeaved(Integer leaved) {
        this.leaved = leaved;
    }
    
    public Date getJoinDate() {
        return joinDate;
    }
    
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
    
    public String getIdCard() {
        return idCard;
    }
    
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
    public Integer getDiploma() {
        return diploma;
    }
    
    public void setDiploma(Integer diploma) {
        this.diploma = diploma;
    }
    
    public Integer getMaritalStatus() {
        return maritalStatus;
    }
    
    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getJob() {
        return job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }
    
    public String getPermanentAddress() {
        return permanentAddress;
    }
    
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }
    
    public Date getLoginDate() {
        return loginDate;
    }
    
    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
    
    public String getPinyin() {
        return pinyin;
    }
    
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        result = prime * result + ((department == null) ? 0 : department.hashCode());
        result = prime * result + ((diploma == null) ? 0 : diploma.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((fax == null) ? 0 : fax.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((idCard == null) ? 0 : idCard.hashCode());
        result = prime * result + ((innerTel == null) ? 0 : innerTel.hashCode());
        result = prime * result + ((job == null) ? 0 : job.hashCode());
        result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
        result = prime * result + ((leaved == null) ? 0 : leaved.hashCode());
        result = prime * result + ((loginDate == null) ? 0 : loginDate.hashCode());
        result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
        result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((no == null) ? 0 : no.hashCode());
        result = prime * result + ((outerTel == null) ? 0 : outerTel.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((permanentAddress == null) ? 0 : permanentAddress.hashCode());
        result = prime * result + ((picture == null) ? 0 : picture.hashCode());
        result = prime * result + ((pinyin == null) ? 0 : pinyin.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((qq == null) ? 0 : qq.hashCode());
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((weixin == null) ? 0 : weixin.hashCode());
        result = prime * result + ((weixinQrcode == null) ? 0 : weixinQrcode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        User other = (User)obj;
        if(account == null) {
            if(other.account != null)
                return false;
        } else if(!account.equals(other.account))
            return false;
        if(address == null) {
            if(other.address != null)
                return false;
        } else if(!address.equals(other.address))
            return false;
        if(age == null) {
            if(other.age != null)
                return false;
        } else if(!age.equals(other.age))
            return false;
        if(birthday == null) {
            if(other.birthday != null)
                return false;
        } else if(!birthday.equals(other.birthday))
            return false;
        if(department == null) {
            if(other.department != null)
                return false;
        } else if(!department.equals(other.department))
            return false;
        if(diploma == null) {
            if(other.diploma != null)
                return false;
        } else if(!diploma.equals(other.diploma))
            return false;
        if(email == null) {
            if(other.email != null)
                return false;
        } else if(!email.equals(other.email))
            return false;
        if(fax == null) {
            if(other.fax != null)
                return false;
        } else if(!fax.equals(other.fax))
            return false;
        if(id == null) {
            if(other.id != null)
                return false;
        } else if(!id.equals(other.id))
            return false;
        if(idCard == null) {
            if(other.idCard != null)
                return false;
        } else if(!idCard.equals(other.idCard))
            return false;
        if(innerTel == null) {
            if(other.innerTel != null)
                return false;
        } else if(!innerTel.equals(other.innerTel))
            return false;
        if(job == null) {
            if(other.job != null)
                return false;
        } else if(!job.equals(other.job))
            return false;
        if(joinDate == null) {
            if(other.joinDate != null)
                return false;
        } else if(!joinDate.equals(other.joinDate))
            return false;
        if(leaved == null) {
            if(other.leaved != null)
                return false;
        } else if(!leaved.equals(other.leaved))
            return false;
        if(loginDate == null) {
            if(other.loginDate != null)
                return false;
        } else if(!loginDate.equals(other.loginDate))
            return false;
        if(maritalStatus == null) {
            if(other.maritalStatus != null)
                return false;
        } else if(!maritalStatus.equals(other.maritalStatus))
            return false;
        if(mobile == null) {
            if(other.mobile != null)
                return false;
        } else if(!mobile.equals(other.mobile))
            return false;
        if(name == null) {
            if(other.name != null)
                return false;
        } else if(!name.equals(other.name))
            return false;
        if(no == null) {
            if(other.no != null)
                return false;
        } else if(!no.equals(other.no))
            return false;
        if(outerTel == null) {
            if(other.outerTel != null)
                return false;
        } else if(!outerTel.equals(other.outerTel))
            return false;
        if(password == null) {
            if(other.password != null)
                return false;
        } else if(!password.equals(other.password))
            return false;
        if(permanentAddress == null) {
            if(other.permanentAddress != null)
                return false;
        } else if(!permanentAddress.equals(other.permanentAddress))
            return false;
        if(picture == null) {
            if(other.picture != null)
                return false;
        } else if(!picture.equals(other.picture))
            return false;
        if(pinyin == null) {
            if(other.pinyin != null)
                return false;
        } else if(!pinyin.equals(other.pinyin))
            return false;
        if(position == null) {
            if(other.position != null)
                return false;
        } else if(!position.equals(other.position))
            return false;
        if(qq == null) {
            if(other.qq != null)
                return false;
        } else if(!qq.equals(other.qq))
            return false;
        if(sex == null) {
            if(other.sex != null)
                return false;
        } else if(!sex.equals(other.sex))
            return false;
        if(status == null) {
            if(other.status != null)
                return false;
        } else if(!status.equals(other.status))
            return false;
        if(type == null) {
            if(other.type != null)
                return false;
        } else if(!type.equals(other.type))
            return false;
        if(weixin == null) {
            if(other.weixin != null)
                return false;
        } else if(!weixin.equals(other.weixin))
            return false;
        if(weixinQrcode == null) {
            if(other.weixinQrcode != null)
                return false;
        } else if(!weixinQrcode.equals(other.weixinQrcode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=");
        builder.append(id);
        builder.append(", account=");
        builder.append(account);
        builder.append(", password=");
        builder.append(password);
        builder.append(", status=");
        builder.append(status);
        builder.append(", name=");
        builder.append(name);
        builder.append(", no=");
        builder.append(no);
        builder.append(", sex=");
        builder.append(sex);
        builder.append(", birthday=");
        builder.append(birthday);
        builder.append(", mobile=");
        builder.append(mobile);
        builder.append(", innerTel=");
        builder.append(innerTel);
        builder.append(", outerTel=");
        builder.append(outerTel);
        builder.append(", weixin=");
        builder.append(weixin);
        builder.append(", weixinQrcode=");
        builder.append(weixinQrcode);
        builder.append(", fax=");
        builder.append(fax);
        builder.append(", qq=");
        builder.append(qq);
        builder.append(", email=");
        builder.append(email);
        builder.append(", picture=");
        builder.append(picture);
        builder.append(", type=");
        builder.append(type);
        builder.append(", address=");
        builder.append(address);
        builder.append(", leaved=");
        builder.append(leaved);
        builder.append(", joinDate=");
        builder.append(joinDate);
        builder.append(", idCard=");
        builder.append(idCard);
        builder.append(", diploma=");
        builder.append(diploma);
        builder.append(", maritalStatus=");
        builder.append(maritalStatus);
        builder.append(", age=");
        builder.append(age);
        builder.append(", job=");
        builder.append(job);
        builder.append(", permanentAddress=");
        builder.append(permanentAddress);
        builder.append(", loginDate=");
        builder.append(loginDate);
        builder.append(", pinyin=");
        builder.append(pinyin);
        builder.append(", department=");
        builder.append(department);
        builder.append(", position=");
        builder.append(position);
        builder.append("]");
        return builder.toString();
    }

    

    
    
}
