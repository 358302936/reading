package com.hx.reader.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.hx.reader.model.pojo.TUser;

public interface TUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
    
    /**
     * 根据条件查询用户
     * @param record
     * @return
     * @throws SQLException
     */
    List<TUser> selectByConditionByPage(TUser record) throws SQLException;
    
    /**
     * 根据账户查找用户信息
     * @param account
     * @return
     * @throws SQLException
     */
    public TUser selectByAccount(String account) throws SQLException;
}