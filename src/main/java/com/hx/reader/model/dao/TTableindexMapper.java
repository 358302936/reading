package com.hx.reader.model.dao;

import com.hx.reader.model.pojo.TTableindex;

public interface TTableindexMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TTableindex record);

    int insertSelective(TTableindex record);

    TTableindex selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TTableindex record);

    int updateByPrimaryKey(TTableindex record);
}