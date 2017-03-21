package com.hx.reader.model.dao;

import com.hx.reader.model.pojo.TUserOrg;

public interface TUserOrgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TUserOrg record);

    int insertSelective(TUserOrg record);

    TUserOrg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUserOrg record);

    int updateByPrimaryKey(TUserOrg record);
}