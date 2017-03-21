package com.hx.reader.model.dao;

import com.hx.reader.model.pojo.TRoleOrg;

public interface TRoleOrgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TRoleOrg record);

    int insertSelective(TRoleOrg record);

    TRoleOrg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TRoleOrg record);

    int updateByPrimaryKey(TRoleOrg record);
}