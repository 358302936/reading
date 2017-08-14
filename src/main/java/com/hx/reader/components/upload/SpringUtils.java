package com.hx.reader.components.upload;

import java.util.Map;

public class SpringUtils {

	/**
     * 判断字符是否为空
     * @param str
     * @return
     */
	public static boolean isNull(String str) {
		if(str==null||"".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}
	
	public static String getString(Map<String,Object> map,String key){
		return map==null?null:map.get(key)==null?null:String.valueOf(map.get(key));
	}
	
	public static int getInt(Map<String,Object> map,String key){
		return Integer.parseInt(getString(map,key));
	}
	
	/**
	 * mabatis相关特殊字符查询时的替换  
	 * @param str
	 * @param repStr
	 * @return
	 */
	public static String replaceMybatis(String str,String repStr){
		if(isNull(str))
			return null;
		if(isNull(repStr))
			repStr = "";
		return str.replaceAll("'", repStr).replaceAll("<", repStr).replaceAll(">", repStr)
				.replaceAll("\"", repStr).replaceAll("&", repStr);
	}
	public static String replaceMybatis(String str){
		return replaceMybatis(str,null);
	}
	
	/**
	 * String每个字符后添加字符
	 * 如(北京德倍尔,%)-》北%京%德%倍%尔
	 * @param str
	 * @param addChar
	 * @return
	 */
	public static String addStringByChar(String str,String addChar){
		if(isNotNull(str)){
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<str.length()-1;i++){
				char c = str.charAt(i);
				sb.append(c).append(addChar);
			}
			sb.append(str.charAt(str.length()-1));
			return sb.toString();
		}
		return "";
	}
	
}
