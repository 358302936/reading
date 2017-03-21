package com.hx.reader.model.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

}
