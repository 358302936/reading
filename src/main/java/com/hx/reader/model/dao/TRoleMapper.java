package com.hx.reader.model.dao;

import com.hx.reader.model.pojo.TRole;

public interface TRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);
}