package com.hx.reader.redis;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import com.hx.reader.components.SerializableUtils;


public class ShiroSessionDao extends CachingSessionDAO{

	public static ShiroSessionDao shiroSessionDao;
	
	@Resource
	private RedisService redisService;
	
	public void setRedisServer(RedisService redisService) {
		this.redisService = redisService;
	}  
	
	@PostConstruct
	public void init(){
		shiroSessionDao = this;
		shiroSessionDao.redisService=this.redisService;
	}
	
	@Override
	protected void doUpdate(Session session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doDelete(Session session) {
		redisService.del(session.getId().toString());
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);  
        assignSessionId(session, sessionId);
        redisService.set(sessionId.toString(), SerializableUtils.serialize(session));
		return session.getId();
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		return SerializableUtils.deserialize(redisService.get(sessionId.toString()));
	}

}
