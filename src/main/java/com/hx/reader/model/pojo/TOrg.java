package com.hx.reader.model.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class TOrg {
    /**
     *   编号
     */
    private Long id;

    /**
     *   名称
     */
    private String name;

    /**
     *   代码
     */
    private String comcode;

    /**
     *   上级部门ID
     */
    private String pid;

    /**
     *   对应的角色Id
     */
    private String managerroleid;

    /**
     *   子系统ID
     */
    private String sysid;

    /**
     *   0组织机构 ,1.部门,2.虚拟权限组
     */
    private Integer orgtype;

    /**
     *   叶子节点(0:树枝节点;1:叶子节点)
     */
    private Integer leaf;

    /**
     *   排序号
     */
    private Integer sortno;

    /**
     *   描述
     */
    private String description;

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

    public String getComcode() {
        return comcode;
    }

    public void setComcode(String comcode) {
        this.comcode = comcode == null ? null : comcode.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getManagerroleid() {
        return managerroleid;
    }

    public void setManagerroleid(String managerroleid) {
        this.managerroleid = managerroleid == null ? null : managerroleid.trim();
    }

    public String getSysid() {
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid == null ? null : sysid.trim();
    }

    public Integer getOrgtype() {
        return orgtype;
    }

    public void setOrgtype(Integer orgtype) {
        this.orgtype = orgtype;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}