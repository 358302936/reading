package com.hx.reader.model.pojo;

public class WeixinMenu {
    /**
     *   id
     */
    private Integer id;

    /**
     *   微信Id
     */
    private String weixinid;

    /**
     *   名称
     */
    private String name;

    /**
     *   上级Id
     */
    private String pid;

    /**
     *   跳转方式
     */
    private String linktype;

    /**
     *   跳转业务Id
     */
    private String linkid;

    /**
     *   跳转地址
     */
    private String href;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeixinid() {
        return weixinid;
    }

    public void setWeixinid(String weixinid) {
        this.weixinid = weixinid == null ? null : weixinid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getLinktype() {
        return linktype;
    }

    public void setLinktype(String linktype) {
        this.linktype = linktype == null ? null : linktype.trim();
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid == null ? null : linkid.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }
}