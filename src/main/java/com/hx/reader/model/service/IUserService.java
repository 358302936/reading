package com.hx.reader.model.service;

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
}
