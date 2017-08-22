package com.hx.reader.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hx.reader.components.HttpException;
import com.hx.reader.components.PageParameter;
import com.hx.reader.components.ReturnData;
import com.hx.reader.components.apiVersion.ApiVersion;
import com.hx.reader.components.dataSource.DynamicDataSourceHolder;
import com.hx.reader.components.shiro.ShiroUtils;
import com.hx.reader.model.pojo.TUser;
import com.hx.reader.model.service.IUserService;
import com.hx.reader.redis.RedisService;

@RestController
@RequestMapping(value="/{version}/user/")
public class UserController {

	@Resource
	private IUserService userService;
	@Resource
	private RedisService redisService;
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * 添加用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/registerUser",method=RequestMethod.POST,produces="application/json;charset=UTF-8")	
	public ResponseEntity<ReturnData> addUser(HttpServletRequest request,HttpServletResponse response,
			@RequestBody TUser record){
		ReturnData ret  = null;
		String unencryptedPwd = "123456";//默认密码
		
		try {
			if(record.getPassword() != null && !record.getPassword().equals("")){
				unencryptedPwd = record.getPassword();
				record.setPassword(ShiroUtils.encryptStr(record.getPassword()));
			}else{
				record.setPassword(ShiroUtils.encryptStr("123456"));
			}
			this.userService.insert(record);
			
			//注册完成同时登陆
    		UsernamePasswordToken token = new UsernamePasswordToken(record.getAccount(),unencryptedPwd);
			Subject currentUser = SecurityUtils.getSubject();
			token.setRememberMe(true);
			currentUser.login(token);
			
			ret = ReturnData.newSuccessReturnData();
			ret.setMessage("用户注册成功！");
		} catch (Exception e) {
			throw new HttpException(500, e.getMessage());
		}
		
		return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);
	}
	
	/**
	 * 查询用户
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiVersion(1)
	@RequestMapping(value="/query",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public ResponseEntity<ReturnData> queryUser(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String name){
		ReturnData ret  = null;
		
		try {
			PageParameter page = new PageParameter();
			TUser u = new TUser();
			u.setName(name);
			u.setPage(page);
			List<TUser> list = this.userService.selectByCondition(u);
			ret = ReturnData.newSuccessReturnData();
			ret.setData(list);
			ret.setMessage("v1");
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpException(500, e.getMessage());
		} finally{
			DynamicDataSourceHolder.removeRouteKey();
		}
		
		return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);
	}
	
	
	/**
	 * 查询用户
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiVersion(2)
	@RequestMapping(value="/query",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public ResponseEntity<ReturnData> queryUser1(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String name){
		ReturnData ret  = null;
		
		try {
			PageParameter page = new PageParameter();
			TUser u = new TUser();
			u.setName(name);
			u.setPage(page);
			List<TUser> list = this.userService.selectByCondition(u);
			ret = ReturnData.newSuccessReturnData();
			ret.setData(list);
			ret.setMessage("v2");
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpException(500, e.getMessage());
		} finally{
			DynamicDataSourceHolder.removeRouteKey();
		}
		
		return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseEntity<ReturnData> userLogin(HttpServletRequest request,HttpServletResponse response,
			@RequestBody TUser record) throws Exception{
		ReturnData ret  = null;
		
		if(record.getAccount() == null || "".equals(record.getAccount())){
			throw new HttpException(400, "用户名不能为空！");
		}
		if(record.getPassword() == null || "".equals(record.getPassword())){
			throw new HttpException(400, "密码不能为空！");
		}
		
		//注册完成同时登陆
		UsernamePasswordToken token = new UsernamePasswordToken(record.getAccount(),record.getPassword());
		Subject currentUser = SecurityUtils.getSubject();
		token.setRememberMe(true);
		currentUser.login(token);
        		
		currentUser.getSession().setAttribute("account", record.getAccount());
		currentUser.getSession().setAttribute("id", currentUser.getPrincipal().toString());
		
//		redisService.rpush(currentUser.getSession().getId().toString(),record.getAccount(),currentUser.getPrincipal().toString());
		
		
		ret = ReturnData.newSuccessReturnData();
		ret.setMessage("登录成功！");
		ret.setData(currentUser.getSession());
		return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);
	}
	
	/**
	 * 单点登录测试
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/sso",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public ResponseEntity<ReturnData> ssoTest(HttpServletRequest request,HttpServletResponse response){
		ReturnData ret  = ReturnData.newSuccessReturnData();
		ret.setMessage("通过拦截");
		return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);
	}
	
	public static void main(String[] args) {
		log.info("log4j测试");
	}
}
