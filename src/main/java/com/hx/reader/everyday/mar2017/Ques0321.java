package com.hx.reader.everyday.mar2017;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.alibaba.fastjson.JSON;

public class Ques0321 {
	private static final Pattern JSON_VALIDATION_PATTERN=Pattern.compile("\\{.*\\}|\\[.*\\]");
	 public static void main(String[] args) {
	        Ques0321 test = new Ques0321();
	        test.method(null);

		 String configValue="[{\"applicationId\":\"APP817509987866449400163E130B4C0\",\"templateId\":\"34XUS8PG8iMV0w1f-alFY7qE18rcgW3Kx1wNeDeZjw8\"},{\"applicationId\":\"APP175156442480211100163E130B4C0\",\"templateId\":\"BYg6j1dHOIkFPyk7_TG0MDaQLI1Y1PryYy1YCuA4qUc\"},{\"applicationId\":\"APP817521153660119500163E130B4C0\",\"templateId\":\"wlfNUP4J2C0V8Tych6ARcG3XUABbLqrO9aVUSpajcN8\"}]\n";
		 Matcher matcher=JSON_VALIDATION_PATTERN.matcher(configValue);
		 if(matcher.find()){
			 try{
				 List<TemplateConfig> templateConfigs= JSON.parseArray(configValue,TemplateConfig.class);
				 for(TemplateConfig templateConfig:templateConfigs){
//					 if(applicationId.equals(templateConfig.getApplicationId())){
//						 return templateConfig.getTemplateId();
//					 }
				 }
			 }catch (Exception ex){}
//			 return "";
		 }else {
//			 return configValue;
		 }
	    }    
	    
	    public void method(Object o) {
	        System.out.println("Object");
	    }    
	    
//	    public void method(String s) {
//	        System.out.println("String");
//	    }
	    
	    public void method(Integer s) {
	        System.out.println("Integer");
	    }
	    
	    public void method(int s) {
	        System.out.println("int");
	    }
	    
	    /**
	     * 当传入null时能同时满足method(Object o)和method(String s)两个方法，但String是Object的子类，
	     * 系统调用是处理更具体、更有针对性的method(String s)方法，所以最终输出String。
	     * 
	     * 如果同时有method(String s),method(Integer s) 两个方法，因为String,Integer都是Object的子类，
	     * 而String，Integer又没有集成关系，导致test.method(null)不知道选择哪个一个，而编译报错
	     */

	/**
	 * 模板配置临时对象
	 */

	public static class TemplateConfig{
		/**
		 * 应用标识ID
		 */
		private String applicationId;

		/**
		 * 模板ID
		 */
		private String templateId;

		/**
		 * 是否启用  true 启用  false 不启用
		 */
		private Boolean enable;

		public String getApplicationId() {
			return applicationId;
		}

		public void setApplicationId(String applicationId) {
			this.applicationId = applicationId;
		}

		public String getTemplateId() {
			return templateId;
		}

		public void setTemplateId(String templateId) {
			this.templateId = templateId;
		}

		public Boolean getEnable() {
			return enable;
		}

		public void setEnable(Boolean enable) {
			this.enable = enable;
		}
	}
}
