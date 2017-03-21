package com.hx.reader.model.dao;

import com.hx.reader.model.pojo.TMenu;

public interface TMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    TMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TMenu record);

    int updateByPrimaryKey(TMenu record);
}