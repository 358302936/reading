package com.hx.reader.model.pojo;

public class TUserOrg {
    /**
     *   编号
     */
    private Long id;

    /**
     *   用户编号
     */
    private String userid;

    /**
     *   机构编号
     */
    private String orgid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }
}