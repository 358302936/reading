package com.hx.reader.oss;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.ram.model.v20150501.CreateRoleRequest;
import com.aliyuncs.ram.model.v20150501.CreateRoleResponse;
import com.aliyuncs.ram.model.v20150501.CreateUserRequest;
import com.aliyuncs.ram.model.v20150501.CreateUserResponse;
import com.aliyuncs.ram.model.v20150501.DeleteUserRequest;
import com.aliyuncs.ram.model.v20150501.DeleteUserResponse;
import com.aliyuncs.ram.model.v20150501.GetUserRequest;
import com.aliyuncs.ram.model.v20150501.GetUserResponse;

public class RamServiceSample {

	 public static void main(String[] args) {
	        // 构建一个 Aliyun Client, 用于发起请求
	        // 构建Aliyun Client时需要设置AccessKeyId和AccessKeySevcret
	        // RAM是Global Service, API入口位于华东 1 (杭州) , 这里Region填写"cn-hangzhou"
		 
		    String accessKeyId = "**";    	
	    	String accessKeySecret = "**";
	    	
	        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessKeySecret);
	        DefaultAcsClient client = new DefaultAcsClient(profile);

//	        // 构造"CreateUser"请求
//	        final CreateUserRequest request = new CreateUserRequest();
//
//	        //设置参数 - UserName
//	        request.setUserName("alice");
//
//	        // 发起请求，并得到response
//	        try {
//	            final CreateUserResponse response = client.getAcsResponse(request);
//
//	            System.out.println("UserName: " + response.getUser().getUserName());
//	            System.out.println("CreateTime: " + response.getUser().getCreateDate());
//	        } catch (ClientException e) {
//	            System.out.println("Failed.");
//	            System.out.println("Error code: " + e.getErrCode());
//	            System.out.println("Error message: " + e.getErrMsg());
//	        }
	        
//	        //构造"DeleteUser"请求
//	        final DeleteUserRequest drequest = new DeleteUserRequest();
//	        //设置参数 - UserName
//	        drequest.setUserName("alice");
//	        // 发起请求，并得到response
//	        try {
//	        	final DeleteUserResponse dresponse = client.getAcsResponse(drequest);
//
//	            System.out.println("操作结果: " + dresponse.toString());
//	        } catch (ClientException e) {
//	            System.out.println("Failed.");
//	            System.out.println("Error code: " + e.getErrCode());
//	            System.out.println("Error message: " + e.getErrMsg());
//	        }
	        
//	        //构造"GetUser"请求
//	        final GetUserRequest getr = new GetUserRequest();
//	        //设置参数
//	        getr.setUserName("alice");
//	        try{
//	        	final GetUserResponse getrp = client.getAcsResponse(getr);
//	        	System.out.println(getrp.getUser().getUserId());
//	        }catch(ClientException e) {
//	            System.out.println("Failed.");
//	            System.out.println("Error code: " + e.getErrCode());
//	            System.out.println("Error message: " + e.getErrMsg());
//	        }
	        
	        //构造“CreateRole”请求
	        final CreateRoleRequest crr = new CreateRoleRequest();
	        //设置参数
	        crr.setActionName("CreateRole");
	        crr.setRoleName("ECSAdmin");
	        crr.setDescription("ECS管理员");
//	        crr.setProtocol(ProtocolType.HTTPS);
	        String assumeRolePolicyDocument = "{"+
	        		                                "\"Statement\":["+
						        		                           		"{"+
							        		                                "\"Action\":\"sts:AssumeRole"+
							        		                                "\",\"Effect\":\"Allow"+
							        		                                "\",\"Principal\":{"+
						        		                                					    "\"RAM\":\"acs:ram::296320991550518885:alice"+
						        		                                                      "\"}"+
						        		                                  "}"+
						        		                              "],"+
						        		                              "\"Version\":\"2"+
	        		                           "\"}";
	        
	        crr.setAssumeRolePolicyDocument(assumeRolePolicyDocument);
	        try{
	        	final CreateRoleResponse crrp = client.getAcsResponse(crr);
	        	System.out.println(crrp.getRole().toString());
	        }catch(ClientException e) {
	            System.out.println("Failed.");
	            System.out.println("Error code: " + e.getErrCode());
	            System.out.println("Error message: " + e.getErrMsg());
	        }
	    }
}
