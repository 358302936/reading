package com.hx.reader.oss;

import java.util.List;

import javax.swing.JComboBox.KeySelectionManager;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.ram.model.v20150501.AttachPolicyToRoleRequest;
import com.aliyuncs.ram.model.v20150501.AttachPolicyToRoleResponse;
import com.aliyuncs.ram.model.v20150501.AttachPolicyToUserRequest;
import com.aliyuncs.ram.model.v20150501.AttachPolicyToUserResponse;
import com.aliyuncs.ram.model.v20150501.CreateAccessKeyRequest;
import com.aliyuncs.ram.model.v20150501.CreateAccessKeyResponse;
import com.aliyuncs.ram.model.v20150501.CreateRoleRequest;
import com.aliyuncs.ram.model.v20150501.CreateRoleResponse;
import com.aliyuncs.ram.model.v20150501.CreateUserRequest;
import com.aliyuncs.ram.model.v20150501.CreateUserResponse;
import com.aliyuncs.ram.model.v20150501.DeleteUserRequest;
import com.aliyuncs.ram.model.v20150501.DeleteUserResponse;
import com.aliyuncs.ram.model.v20150501.GetRoleRequest;
import com.aliyuncs.ram.model.v20150501.GetRoleResponse;
import com.aliyuncs.ram.model.v20150501.GetUserRequest;
import com.aliyuncs.ram.model.v20150501.GetUserResponse;
import com.aliyuncs.ram.model.v20150501.ListAccessKeysRequest;
import com.aliyuncs.ram.model.v20150501.ListAccessKeysResponse;
import com.aliyuncs.ram.model.v20150501.ListAccessKeysResponse.AccessKey;

public class RamServiceSample {

	 
	 
	 public void createUser(DefaultAcsClient client){
		// 构造"CreateUser"请求
        final CreateUserRequest request = new CreateUserRequest();

        //设置参数 - UserName
        request.setUserName("alice");

        // 发起请求，并得到response
        try {
            final CreateUserResponse response = client.getAcsResponse(request);

            System.out.println("UserName: " + response.getUser().getUserName());
            System.out.println("CreateTime: " + response.getUser().getCreateDate());
        } catch (ClientException e) {
            System.out.println("Failed.");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg());
        }
	 }
	 
	 public void deleteUser(DefaultAcsClient client){
		//构造"DeleteUser"请求
        final DeleteUserRequest drequest = new DeleteUserRequest();
        //设置参数 - UserName
        drequest.setUserName("alice");
        // 发起请求，并得到response
        try {
        	final DeleteUserResponse dresponse = client.getAcsResponse(drequest);

            System.out.println("操作结果: " + dresponse.toString());
        } catch (ClientException e) {
            System.out.println("Failed.");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg());
        }
	 }
	 
	 public void getUser(DefaultAcsClient client){
		//构造"GetUser"请求
	        final GetUserRequest getr = new GetUserRequest();
	        //设置参数
	        getr.setUserName("alice");
	        try{
	        	final GetUserResponse getrp = client.getAcsResponse(getr);
	        	System.out.println(getrp.getUser().getUserId());
	        }catch(ClientException e) {
	            System.out.println("Failed.");
	            System.out.println("Error code: " + e.getErrCode());
	            System.out.println("Error message: " + e.getErrMsg());
	        } 
	 }
	 
	 public void createRole(DefaultAcsClient client){
		  //构造“CreateRole”请求
	        final CreateRoleRequest crr = new CreateRoleRequest();
	        //设置参数
	        crr.setActionName("CreateRole");
	        crr.setRoleName("ECSAdminAlice");
	        crr.setDescription("ECS管理员");
//	        crr.setProtocol(ProtocolType.HTTPS);
//	        String assumeRolePolicyDocument = "{"+
//	        		                                "\"Statement\":["+
//						        		                           		"{"+
//							        		                                "\"Action\":\"sts:AssumeRole"+
//							        		                                "\",\"Effect\":\"Allow"+
//							        		                                "\",\"Principal\":{"+
//						        		                                					    "\"RAM\":\"acs:ram::296320991550518885:alice"+
//						        		                                                      "\"}"+
//						        		                                  "}"+
//						        		                              "],"+
//						        		                              "\"Version\":\"2"+
//	        		                           "\"}";
	        String assumeRolePolicyDocument = "{"+
                    "\"Statement\":["+
		                           		"{"+
    		                                "\"Action\":\"sts:AssumeRole"+
    		                                "\",\"Effect\":\"Allow"+
    		                                "\",\"Principal\":{"+
		                                					    "\"RAM\":[\"acs:ram::296320991550518885:alice"+
		                                                      "\"]}"+
		                                  "}"+
		                              "],"+
		                              "\"Version\":\"1"+
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
	 
	 public void getRole(DefaultAcsClient client){
		 
		 final GetRoleRequest grr = new GetRoleRequest();
		 grr.setRoleName("ECSAdmin");
		 grr.setActionName("GetRole");
		 try{
			 final GetRoleResponse resp = client.getAcsResponse(grr);
			 System.out.println("role:"+resp.getRole().getArn()+";"+resp.getRole().getAssumeRolePolicyDocument());
			 System.out.println("requestId:"+resp.getRequestId());
		 }catch(ClientException e){
			System.out.println("Failed.");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg()); 
		 }
		 
	 }
	 
	 public void attachPolicyToRole(DefaultAcsClient client){
		 AttachPolicyToRoleRequest req = new AttachPolicyToRoleRequest();
		 req.setPolicyType("System");
		 req.setPolicyName("AliyunSTSAssumeRoleAccess");
		 req.setRoleName("ECSAdmin");
		 try{
			 final AttachPolicyToRoleResponse resp = client.getAcsResponse(req);
			System.out.println(resp.getRequestId());
		 }catch(ClientException e){
			System.out.println("Failed.");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg()); 
		 }
	 }
	 
	 public void attachPolicyToUser(DefaultAcsClient client){
		AttachPolicyToUserRequest req = new AttachPolicyToUserRequest();
		req.setPolicyName("AdministratorAccess");
		req.setPolicyType("System");
		req.setUserName("alice");
		 try{
			 final AttachPolicyToUserResponse resp = client.getAcsResponse(req);
			System.out.println(resp.getRequestId());
		 }catch(ClientException e){
			System.out.println("Failed.");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg()); 
		 }
	 }
	 
	 public void createAccessKey(DefaultAcsClient client){
		 CreateAccessKeyRequest req = new CreateAccessKeyRequest();
		 req.setUserName("alice");
		 req.setActionName("CreateAccessKey");
		 try{
			 final CreateAccessKeyResponse resp = client.getAcsResponse(req);
			System.out.println("keyid:"+resp.getAccessKey().getAccessKeyId()+",KeySecret:"+resp.getAccessKey().getAccessKeySecret());
		 }catch(ClientException e){
			System.out.println("Failed.");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg()); 
		 }
	 }
	 
	 public void listAccessKeys(DefaultAcsClient client){
		 ListAccessKeysRequest req = new ListAccessKeysRequest();
		 req.setActionName("ListAccessKeys");
		 req.setUserName("alice");
		 try{
			final ListAccessKeysResponse resp = client.getAcsResponse(req);
			List<AccessKey> keys = resp.getAccessKeys();
			System.out.println(keys.get(0).getAccessKeyId());
		 }catch(ClientException e){
			 
		 }
	 }
	 
	 public static void main(String[] args) {		    
		    RamServiceSample rss = new RamServiceSample();
	        // 构建一个 Aliyun Client, 用于发起请求
	        // 构建Aliyun Client时需要设置AccessKeyId和AccessKeySevcret
	        // RAM是Global Service, API入口位于华东 1 (杭州) , 这里Region填写"cn-hangzhou"
		 
		    String accessKeyId = "LTAIGge8psFz9XKF";    	
	    	String accessKeySecret = "XvWXbtyy7RjTXfuvINXHQe06zzkCmc";
	    	
	        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessKeySecret);
	        DefaultAcsClient client = new DefaultAcsClient(profile);
	        
//	        rss.createRole(client);
//	        rss.getRole(client);
//	        rss.attachPolicyToRole(client);
//	        rss.attachPolicyToUser(client);
//	        rss.getUser(client);
//	        rss.createAccessKey(client);
	        rss.listAccessKeys(client);
	    }
}
