package cn.zzs.serialize.other;

import java.io.Serializable;

/**
 * 职位
 * @author zzs
 * @date 2020年11月6日 下午1:40:08
 */
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String parentId;
    private String no;
    private Integer level;
    private Integer orderNo;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getParentId() {
        return parentId;
    }
    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    public String getNo() {
        return no;
    }
    
    public void setNo(String no) {
        this.no = no;
    }
    
    
    public Integer getLevel() {
        return level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public Integer getOrderNo() {
        return orderNo;
    }
    
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((no == null) ? 0 : no.hashCode());
        result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
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
        Position other = (Position)obj;
        if(id == null) {
            if(other.id != null)
                return false;
        } else if(!id.equals(other.id))
            return false;
        if(level == null) {
            if(other.level != null)
                return false;
        } else if(!level.equals(other.level))
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
        if(orderNo == null) {
            if(other.orderNo != null)
                return false;
        } else if(!orderNo.equals(other.orderNo))
            return false;
        if(parentId == null) {
            if(other.parentId != null)
                return false;
        } else if(!parentId.equals(other.parentId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Position [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", parentId=");
        builder.append(parentId);
        builder.append(", no=");
        builder.append(no);
        builder.append(", level=");
        builder.append(level);
        builder.append(", orderNo=");
        builder.append(orderNo);
        builder.append("]");
        return builder.toString();
    }
    
    
    
}
