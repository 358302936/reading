package com.hx.reader.components.shiro;

import java.sql.SQLException;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hx.reader.components.HttpException;
import com.hx.reader.model.pojo.TUser;
import com.hx.reader.model.service.IUserService;


@Component
public class AuthRealm extends AuthorizingRealm {

	@Autowired
	private IUserService userService;
//	@Autowired
//	private IStaffService staffService;
	private static final Logger log = LoggerFactory.getLogger(AuthRealm.class);

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userid =principals.fromRealm(getName()).iterator().next().toString();

		//通过用户名去获得用户的所有资源，并把资源存入info中
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//		if (userid != null) {			
//
//			User userlogin = userService.getUserById(Integer.valueOf(userid));
//			authorizationInfo = new SimpleAuthorizationInfo();
//			System.out.println("用户角色授权："+userlogin.getRole());
//			switch(userlogin.getRole()){
//			case 1:authorizationInfo.addRole("patient");break;
//			case 2:authorizationInfo.addRole("doctor");break;
//			case 3:authorizationInfo.addRole("staff");
//			      try {
//						Set<String> perms = staffService.selectPermByUserid(Integer.valueOf(userid));
//						authorizationInfo.addStringPermissions(perms);
//					} catch (NumberFormatException e) {
//						e.printStackTrace();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//			break;
//			case 4:authorizationInfo.addRole("special");break;
//			default:break;
//			}
//		}
		return authorizationInfo;
	}

	/**
	 * 用户认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
		UsernamePasswordToken tkn = (UsernamePasswordToken) token;
		String username = tkn.getUsername(); //token中储存着输入的用户名和密码
		// 与数据库中用户名和密码进行比对, 比对成功则返回info，比对失败则抛出对应信息的异常AuthenticationException
		
		if (username != null && !"".equals(username)) {
			
			TUser userlogin;
			try {
				userlogin = userService.selectByAccount(username);
				if(userlogin != null){
					String[] saltAndPassword = userlogin.getPassword().split("-");
					String salt = saltAndPassword[0]+saltAndPassword[2];
					String password =saltAndPassword[1];
					
//					PrincipalCollection principals = new SimplePrincipalCollection(userlogin.getId(), getName());
					SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo(userlogin.getId(),password,getName());
					authInfo.setCredentialsSalt(ByteSource.Util.bytes(salt));    
//					authInfo.setPrincipals(principals);
					return authInfo;
				}else{
					throw new AuthenticationException("用户不存在！");
				}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new HttpException(500, "出现错误，请稍后重试！");
			}catch (UnknownAccountException uae){
				log.info(uae.getMessage());
				throw new UnknownAccountException("用户不存在！");
			}catch(IncorrectCredentialsException ce){
				log.info(ce.getMessage());
				throw new IncorrectCredentialsException("密码错误！");
			}catch(AuthenticationException ae){
				log.info(ae.getMessage());
				throw new AuthenticationException("认证异常");
			}
			
		}else{
			throw new AuthenticationException("用户名为空！");
		}
	}
}