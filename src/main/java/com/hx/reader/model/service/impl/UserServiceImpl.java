package com.hx.reader.model.service.impl;


import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hx.reader.components.dataSource.DynamicDataSourceHolder;
import com.hx.reader.model.dao.TUserMapper;
import com.hx.reader.model.pojo.TUser;
import com.hx.reader.model.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Resource
	private TUserMapper userMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(TUser record) {
		this.userMapper.insert(record);
		return 0;
	}

	@Override
	public int insertSelective(TUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TUser selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(TUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(TUser record) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
     * 根据条件查询用户
     * @param record
     * @return
     * @throws SQLException
     */
    public List<TUser> selectByCondition(TUser record) throws SQLException{
    	DynamicDataSourceHolder.setRouteKey("dataSource");
    	return this.userMapper.selectByConditionByPage(record);
    }
    
    /**
     * 根据账户查找用户信息
     * @param account
     * @return
     * @throws SQLException
     */
    public TUser selectByAccount(String account) throws SQLException{
    	return this.userMapper.selectByAccount(account);
    }

}
