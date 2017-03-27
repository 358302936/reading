package com.hx.reader.model.service;

import java.sql.SQLException;
import java.util.List;

import com.hx.reader.model.pojo.TUser;

/**
 * 用户接口类
 * @author chuhx
 * @version 2017年3月21日
 */
public interface IUserService {

	public int deleteByPrimaryKey(Long id);

	public int insert(TUser record);

	public int insertSelective(TUser record);

	public TUser selectByPrimaryKey(Long id);

	public int updateByPrimaryKeySelective(TUser record);

	public int updateByPrimaryKey(TUser record);
	
	/**
     * 根据条件查询用户
     * @param record
     * @return
     * @throws SQLException
     */
    List<TUser> selectByCondition(TUser record) throws SQLException;
    
    /**
     * 根据账户查找用户信息
     * @param account
     * @return
     * @throws SQLException
     */
    public TUser selectByAccount(String account) throws SQLException;
}
