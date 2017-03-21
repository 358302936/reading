package com.hx.reader.model.dao;

import com.hx.reader.model.pojo.TRoleMenu;

public interface TRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TRoleMenu record);

    int insertSelective(TRoleMenu record);

    TRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TRoleMenu record);

    int updateByPrimaryKey(TRoleMenu record);
}