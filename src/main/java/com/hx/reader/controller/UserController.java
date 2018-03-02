package com.hx.reader.controller;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.http.client.HttpClient;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
public class UserController{

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
	@ApiVersion(1)
	@RequestMapping(value="/registerUser",method=RequestMethod.POST,produces="application/json;charset=UTF-8")	
	public ResponseEntity<ReturnData> addUser(HttpServletRequest request,HttpServletResponse response,
			@RequestBody @Valid TUser record,BindingResult result){
		ReturnData ret  = null;
		String unencryptedPwd = "123456";//默认密码
		if(result.hasErrors()){
			log.info(result.getFieldError().getDefaultMessage());
			ret = ReturnData.newSuccessReturnData();
			ret.setMessage(result.getFieldError().getDefaultMessage());
		}else{
			
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
	@RequestMapping(value="/query1",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
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
	@ApiVersion(1)
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
	@ApiVersion(1)
	@RequestMapping(value="/sso",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public ResponseEntity<ReturnData> ssoTest(HttpServletRequest request,HttpServletResponse response){
		
		ReturnData ret  = ReturnData.newSuccessReturnData();
    	TUser record = new TUser();
    	log.info("开始时间："+String.valueOf(System.currentTimeMillis()));
    	this.userService.insert(record);
    	log.info("结束时间："+String.valueOf(System.currentTimeMillis()));
		return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);
	}
	
	@ApiVersion(1)
	@RequestMapping(value="/ws",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public ResponseEntity<ReturnData> webService(HttpServletRequest request,HttpServletResponse response){		
		ReturnData ret  = ReturnData.newSuccessReturnData();
		String endpoint = "http://192.168.1.254/WebService/Keson_Interface.asmx?wsdl";
		// 直接引用远程的wsdl文件        
        Service service = new Service();  
		try {
			Call call = (Call)service.createCall();
			call.setTargetEndpointAddress(endpoint);  
	        call.setOperationName("Keson_GetDoctorList");// WSDL里面描述的接口名称  
	        call.addParameter("ReturnType",  
	                org.apache.axis.encoding.XMLType.XSD_INT,  
	                javax.xml.rpc.ParameterMode.IN);// 接口的参数  
	        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型  
	        int temp = 2;  
	        String result = (String) call.invoke(new Object[] { temp });  
	        // 给方法传递参数，并且调用方法  
	        System.out.println("result is " + result);  
		} catch (ServiceException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);
	}

	@RequestMapping(value = "/test",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public ResponseEntity<ReturnData> testService(){
		ReturnData returnData = ReturnData.newSuccessReturnData();
//		ServiceLoader<IUserService> serviceLoader = ServiceLoader.load(IUserService.class);
//		Iterator<IUserService> it = serviceLoader.iterator();
//		while (it.hasNext()){
//			IUserService userService = it.next();
//			log.info("class:"+userService.getClass().getName());
//		}
		userService.getWordInfo();
		return new ResponseEntity<ReturnData>(returnData,HttpStatus.OK);
	}
}
