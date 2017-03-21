package com.hx.reader.model.pojo;

public class TRoleMenu {
    /**
     *   编号
     */
    private Long id;

    /**
     *   角色编号
     */
    private String roleid;

    /**
     *   菜单编号
     */
    private String menuid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }
}