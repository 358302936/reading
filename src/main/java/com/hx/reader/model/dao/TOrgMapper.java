package com.hx.reader.model.dao;

import com.hx.reader.model.pojo.TOrg;

public interface TOrgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TOrg record);

    int insertSelective(TOrg record);

    TOrg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TOrg record);

    int updateByPrimaryKey(TOrg record);
}