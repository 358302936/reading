package com.hx.reader.everyday.mar2017;

import java.util.List;

/**
 * @Author yanuun
 * @Date 15:27 2018/3/27
 **/
public class DefaultSizeProductTypeVo {

    /**
     * 是否选中
     */
    private boolean checked;

    /**
     * 选项id
     */
    private String paramId;

    /**
     * 序号
     */
    private Integer orderNo;

    /**
     * 选项文本
     */
    private ParamValue paramValue;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getParamId() {
        return paramId;
    }

    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public ParamValue getParamValue() {
        return paramValue;
    }

    public void setParamValue(ParamValue paramValue) {
        this.paramValue = paramValue;
    }


    public static class ParamValue{
        private String name;
        private String type;
        private List<String> options;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> options) {
            this.options = options;
        }
    }
}
