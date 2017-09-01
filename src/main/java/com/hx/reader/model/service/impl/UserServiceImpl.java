package com.hx.reader.model.service.impl;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hx.reader.components.dataSource.DynamicDataSourceHolder;
import com.hx.reader.everyday.august2017.RandomValue;
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
		long starttime = System.currentTimeMillis();
		// 创建可以容纳3个线程的线程池  
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
        
        for(int i=0;i<10;i++){
        	final UserServiceImpl userServiceImpl=this;
        	fixedThreadPool.execute(new Runnable() {			
        		@SuppressWarnings("unchecked")
				@Override
        		public void run() {
        			Map<String,Object> newUser = RandomValue.getAddress();
        			TUser record = new TUser();
        			record.setEmail(newUser.get("email").toString());
        			record.setAccount(newUser.get("tel").toString());
        			record.setName(newUser.get("name").toString());
        			record.setSex(newUser.get("sex").toString());
        			record.setMobile(newUser.get("tel").toString());
        			userServiceImpl.insertUser(record);				
        		}
        	});
        }
        //关闭线程
        fixedThreadPool.shutdown();
        //等待子线程结束
        try {
			fixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        long endtime = System.currentTimeMillis();
        System.out.println("消耗时间："+(endtime-starttime));
		return 0;
	}
	
	public void insertUser(TUser record){
		this.userMapper.insert(record);
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
    	DynamicDataSourceHolder.setRouteKey("dataSource1");
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
