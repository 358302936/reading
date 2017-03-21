package com.hx.reader.model.pojo;

public class TRoleOrg {
    /**
     *   编号
     */
    private Long id;

    /**
     *   角色编号
     */
    private String roleid;

    /**
     *   部门编号
     */
    private String orgid;

    /**
     *   0组织机构 ,1.部门,2.虚拟权限组
     */
    private Integer orgtype;

    /**
     *   是否包含子部门,0不包含,1包含
     */
    private Integer hasleaf;

    /**
     *   是否可用,0不可用,1不可用
     */
    private Integer active;

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

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public Integer getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(Integer orgtype) {
        this.orgtype = orgtype;
    }

    public Integer getHasleaf() {
        return hasleaf;
    }

    public void setHasleaf(Integer hasleaf) {
        this.hasleaf = hasleaf;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}