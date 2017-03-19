<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
<script type="text/javascript" src="http://192.168.1.100:8080/ya/static/js/jquery-1.12.0.min.js"></script>
<script type="text/javascript">
   //测试登录
   function userLogin1(){alert("ddd");
       var data = {
			"mobile":"13858118593",
			"password":"123456"
		};
	   $.ajax({
			url:'http://192.168.1.100:8080/ya/site/userLogin',
			method:"post",
			dataType :"json",
			data:JSON.stringify(data),
			contentType:"application/json",
			success:function(data){
				alert(data.status);
				alert(data.message);
				alert(data.data.mobile);
				alert(data.data.username);
			}
		});

   }
   
   //测试病人信息添加
   function patientAdd(){
	   var data = {
			"fullname":"张四",   
			"idcard":"372926198901015417",
			"gender":"1",
			"mobile":"13858118599",
			"areacode":"372926",
			"birthday":"1989-09-09",
			"familyid":"1",
			"address":"浙江大学国家科技园"
	   };
	   $.ajax({
			url:'http://192.168.1.100:8080/ya/site/patientAdd',
			method:"post",
			dataType :"json",
			data:JSON.stringify(data),
			contentType:"application/json",
			success:function(data){
				alert(data.status);
				alert(data.message);
				alert(data.data.mobile);
				alert(data.data.idcard);
			}
		});
   }
   
   //测试病人信息修改
   function patientEdit(){
	     var data = {
			    "id":"1",
				"fullname":"褚红旭1",   
				"idcard":"372926198501015417",
				"gender":"1",
				"mobile":"13858118593",
				"areacode":"372926",
				"birthday":"1986-05-09",
				"familyid":"1",
				"address":"浙江大学国家科技园"
		   };
		   $.ajax({
				url:'http://192.168.1.100:8080/ya/site/patientEdit',
				method:"post",
				dataType :"json",
				data:JSON.stringify(data),
				contentType:"application/json",
				success:function(data){
					alert(data.status);
					alert(data.message);
					alert(data.data.mobile);
					alert(data.data.fullname);
				}
			});
   }
   
   //测试病人查询
   function patientList(){
	     var data = {
				"fullname":"张四",	
				"currentPage":"1"
		   };
		   $.ajax({
				url:'http://192.168.1.100:8080/ya/site/patientList',
				method:"post",
				dataType :"json",
				data:JSON.stringify(data),
				contentType:"application/json",
				success:function(data){
					alert(data.status);
					alert(data.message);
					//alert(data.data.mobile);
					//alert(data.data.fullname);
				}
			});
   }
   
   //获得地理位置
   function getLocation(){
	   var data = {
				"id":"4205"			
		   };
		   $.ajax({
				url:'http://192.168.1.100:8080/ya/site/getLocation',
				method:"post",
				dataType :"json",
				data:JSON.stringify(data),
				contentType:"application/json",
				success:function(data){
					alert(data.status);
					alert(data.message);
					//alert(data.data.mobile);
					//alert(data.data.fullname);
				}
			});
   }
   
   //发送短信验证码
   function setMsg(){
	   $.ajax({
			url:'http://192.168.1.100:8080/ya/site/getCaptcha?mobile=13858118593',
			method:"get",
			dataType :"json",
			//data:JSON.stringify(data),
			contentType:"application/json",
			success:function(data){
				alert(data.status);
				alert(data.message);
				//alert(data.data.mobile);
				//alert(data.data.fullname);
			}
		});
   }
   
   //病历信息查询测试
   function getCase(){
	  var condition = "?currentPage=2"; 
	  $.ajax({
			url:'http://192.168.1.100:8080/ya/site/caseQuery',
			method:"get",
			dataType :"json",
			//data:JSON.stringify(data),
			contentType:"application/json",
			success:function(data){
				alert(data.status);
				alert(data.message);
				//alert(data.data.mobile);
				//alert(data.data.fullname);
			}
		});
   }
</script>
</head>
<body>
    <input type="button"  value = "登录" onclick="userLogin1()">  
    <input type="button"  value = "添加病人信息" onclick="patientAdd()">
    <input type="button"  value = "修改病人信息" onclick="patientEdit()">
    <input type="button"  value = "查询病人信息" onclick="patientList()">
    <input type="button"  value = "查询位置信息" onclick="getLocation()">
    <input type="button"  value = "发送短信验证码" onclick="setMsg()">
    <input type="button"  value = "查询病历" onclick="getCase()">
</body>
</html>