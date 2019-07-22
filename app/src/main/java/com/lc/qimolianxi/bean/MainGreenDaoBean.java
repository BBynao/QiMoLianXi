package com.lc.qimolianxi.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class MainGreenDaoBean {
    @Id(autoincrement = true)
    private Long id;
    private String desc;
    private String type;
    private String Url;
    @Generated(hash = 1725909876)
    public MainGreenDaoBean(Long id, String desc, String type, String Url) {
        this.id = id;
        this.desc = desc;
        this.type = type;
        this.Url = Url;
    }
    @Generated(hash = 1262614382)
    public MainGreenDaoBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return this.Url;
    }
    public void setUrl(String Url) {
        this.Url = Url;
    }
    

}
