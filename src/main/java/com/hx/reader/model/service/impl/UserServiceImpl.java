package com.hx.reader.model.service.impl;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import com.hx.reader.everyday.august2017.RandomValue;
import com.hx.reader.model.dao.TUserMapper;
import com.hx.reader.model.dao.WeixinMenuMapper;
import com.hx.reader.model.pojo.TUser;
import com.hx.reader.model.service.IUserService;
import com.hx.reader.model.vo.JyEnWordInfoVO;
import com.hx.reader.weChat.WeixinUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private WeixinMenuMapper weixinMenuMapper;

	
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

        ExecutorService executorService  = new ThreadPoolExecutor(10,20,500,
				                  TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(5000), new ThreadPoolExecutor.DiscardPolicy());

		for(int i=0;i<1000000;i++){
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
		this.tUserMapper.insert(record);
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
//    	DynamicDataSourceHolder.setRouteKey("dataSource1");
    	return this.tUserMapper.selectByConditionByPage(record);
    }
    
    /**
     * 根据账户查找用户信息
     * @param account
     * @return
     * @throws SQLException
     */
    public TUser selectByAccount(String account) throws SQLException{
    	return this.tUserMapper.selectByAccount(account);
    }

	@Override
	public void getWordInfo() {
        List<JyEnWordInfoVO> words = weixinMenuMapper.selectAllWord();
        if(CollectionUtils.isEmpty(words)){
        	return;
		}
		for(int i=6378;i<words.size();i++){
			JSONObject jsonObject = WeixinUtil.getWordInfo(words.get(i).getWord());
			JyEnWordInfoVO jyEnWordInfoVO = new JyEnWordInfoVO();
			jyEnWordInfoVO.setWord(words.get(i).getWord());
			try {
				if(jsonObject.get("basic")!=null && !org.apache.commons.lang.StringUtils.isBlank(jsonObject.get("basic").toString())) {
					jyEnWordInfoVO.setExplainText(jsonObject.get("basic").toString());
				}
				if(jsonObject.get("uksm") != null && !org.apache.commons.lang.StringUtils.isBlank(jsonObject.get("uksm").toString())) {
					jyEnWordInfoVO.setSoundmarkUK(WeixinUtil.stringToUnicode(jsonObject.get("uksm").toString()));
				}
				if(jsonObject.get("ussm") != null && !org.apache.commons.lang.StringUtils.isBlank(jsonObject.get("ussm").toString())) {
					jyEnWordInfoVO.setSoundmarkUS(WeixinUtil.stringToUnicode(jsonObject.get("ussm").toString()));
				}
			}catch (Exception e){
				e.printStackTrace();
			}


			System.out.println("单词：new;音标：["+jyEnWordInfoVO.getSoundmark()+"],译文："+jyEnWordInfoVO.getExplainText());
            weixinMenuMapper.insertWordInfo(jyEnWordInfoVO);
		}
	}


}
