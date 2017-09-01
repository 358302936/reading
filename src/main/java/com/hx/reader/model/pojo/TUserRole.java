package com.hx.reader.model.pojo;

import org.springframework.validation.*;

public class TUserRole {
    /**
     *   编号
     */
    private Long id;

    /**
     *   用户编号
     */
    private String userid;

    /**
     *   角色编号
     */
    private String roleid;

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

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }
}