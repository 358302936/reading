package com.hx.reader.components.shiro;

import java.text.ParseException;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 安全认证工具类
 * @author chuhx
 * @date 20160303
 */
public class ShiroUtils {
	
	/**
	 * 字符串加密
	 * @param Password
	 * @return
	 */
	public static String encryptStr(String str){
		String salt = new SecureRandomNumberGenerator().nextBytes(16).toHex();  
		String hashedPassword =  new SimpleHash("md5", str, ByteSource.Util.bytes(salt), 2).toHex();
		return salt.substring(0, 16)+"-"+hashedPassword+"-"+salt.substring(16,salt.length());
	} 
	
	/**
	 * 字符串加密
	 * @param Password
	 * @return
	 */
	public static String encryptStr(String str,String salt){
		//String salt = new SecureRandomNumberGenerator().nextBytes(16).toHex();  
		String hashedPassword =  new SimpleHash("md5", str, ByteSource.Util.bytes(salt), 2).toHex();
		return hashedPassword;
	} 
	
	
	/**
	 * 测试
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
//		Calendar cal = Calendar.getInstance(); 
//		cal.set(Calendar.HOUR_OF_DAY, 0); 
//		cal.set(Calendar.SECOND, 1); 
//		cal.set(Calendar.MINUTE, 0); 
//		System.out.println(encryptStr("123456","f6b4daece96fe5ce1130f463ac636cdf"));
		System.out.println(encryptStr("123456"));
		
		
	}
	
}
