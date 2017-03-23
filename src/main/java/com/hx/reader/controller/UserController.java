package com.hx.reader.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hx.reader.components.HttpException;
import com.hx.reader.components.ReturnData;
import com.hx.reader.model.pojo.TUser;
import com.hx.reader.model.service.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Resource
	private IUserService userService;
	
	/**
	 * 添加用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseEntity<ReturnData> addUser(HttpServletRequest request,HttpServletResponse response,
			@RequestBody TUser record){
		ReturnData ret  = null;
		
		try {
			this.userService.insert(record);
			ret = ReturnData.newSuccessReturnData();
			ret.setMessage("用户添加成功！");
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
	@RequestMapping(value="/query",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public ResponseEntity<ReturnData> queryUser(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String name){
		ReturnData ret  = null;
		
		try {
			TUser u = new TUser();
			u.setName(name);
			List<TUser> list = this.userService.selectByCondition(u);
			ret = ReturnData.newSuccessReturnData();
			ret.setData(list);
		} catch (Exception e) {
			throw new HttpException(500, e.getMessage());
		}
		
		return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);
	}
}
