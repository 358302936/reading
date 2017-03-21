package com.hx.reader.model.pojo;

public class TTableindex {
    /**
     *   主键
     */
    private Long id;

    /**
     *   表名
     */
    private String tablename;

    /**
     *   表记录最大的行,一直累加
     */
    private Integer maxindex;

    /**
     *   前缀 单个字母加 _
     */
    private String prefix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public Integer getMaxindex() {
        return maxindex;
    }

    public void setMaxindex(Integer maxindex) {
        this.maxindex = maxindex;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }
}