package com.hx.reader.model.dao;

import com.hx.reader.model.pojo.TUserRole;

public interface TUserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TUserRole record);

    int insertSelective(TUserRole record);

    TUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUserRole record);

    int updateByPrimaryKey(TUserRole record);
}