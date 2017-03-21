package com.hx.reader.model.pojo;

public class TRole {
    /**
     *   角色ID
     */
    private Long id;

    /**
     *   角色名称
     */
    private String name;

    /**
     *   权限编码
     */
    private String code;

    /**
     *   上级角色ID,暂时不实现
     */
    private String pid;

    /**
     *   0系统角色,1部门主管,2业务岗位
     */
    private Integer roletype;

    /**
     *   备注
     */
    private String remark;

    /**
     *   是否有效(0否,1是)
     */
    private Integer active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Integer getRoletype() {
        return roletype;
    }

    public void setRoletype(Integer roletype) {
        this.roletype = roletype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}