package com.hx.reader.model.dao;

import com.hx.reader.model.pojo.WeixinMenu;

public interface WeixinMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeixinMenu record);

    int insertSelective(WeixinMenu record);

    WeixinMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeixinMenu record);

    int updateByPrimaryKey(WeixinMenu record);
}