package com.hx.reader.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hx.reader.components.ReturnData;
import com.hx.reader.components.SerializeUtil;
import com.hx.reader.redis.RedisCachedImpl;
import com.hx.reader.redis.RedisService;

@Controller
@RequestMapping(value="/redis")
public class TestRedisController {

	@Resource
	private RedisService redisService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET,produces="application/json;charset=UTF-8")	
	public ResponseEntity<ReturnData> testRedis(HttpServletRequest request,HttpServletResponse response){
		ReturnData ret = ReturnData.newSuccessReturnData();
		
		RedisCachedImpl redis = new RedisCachedImpl();
		
		byte[] key = request.getSession().getId().toString().getBytes();
		byte[] sessions = SerializeUtil.serialize(request.getSession());
		Long expireSec = request.getSession().getLastAccessedTime()/100;
		
		try {
			redis.updateCached(key,sessions,expireSec);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String ping = redisService.ping();//测试是否连接成功,连接成功输出PONG  
//        System.out.println(ping);  
//        
//        //首先,我们看下redis服务里是否有数据
//        long dbSizeStart = redisService.dbSize();
//        System.out.println(dbSizeStart);
//        
//        redisService.set("username", "oyhk");//设值(查看了源代码,默认存活时间30分钟)
//        String username = redisService.get("username");//取值 
//        System.out.println(username);
//        redisService.set("username1", "oyhk1", 1);//设值,并且设置数据的存活时间(这里以秒为单位)
//        String username1 = redisService.get("username1");
//        System.out.println(username1);
//        try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//我睡眠一会,再去取,这个时间超过了,他的存活时间
//        String liveUsername1 = redisService.get("username1");
//        System.out.println(liveUsername1);//输出null
//
//        //是否存在
//        boolean exist = redisService.exists("username");
//        System.out.println(exist);
//
//        //查看keys
//        Set<String> keys = redisService.keys("*");//这里查看所有的keys
//        System.out.println(keys);//只有username username1(已经清空了)
//
//        //删除
//        redisService.set("username2", "oyhk2");
//        String username2 = redisService.get("username2");
//        System.out.println(username2);
//        redisService.del("username2");
//        String username2_2 = redisService.get("username2");
//        System.out.println(username2_2);//如果为null,那么就是删除数据了
//
//        //dbsize
//        long dbSizeEnd = redisService.dbSize();
//        System.out.println(dbSizeEnd);

        //获得列表中的数据
//        List<String> list = redisService.lrange("list-key");
//        for(int i=0,j=list.size();i<j;i++){
//        	System.out.println(list.get(i));
//        }
        //清空reids所有数据
        //redisService.flushDB();
		return new ResponseEntity<ReturnData>(ret,HttpStatus.OK);
	}
}
