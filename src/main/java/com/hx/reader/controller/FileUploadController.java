package com.hx.reader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.hx.reader.components.ReturnData;
import com.hx.reader.components.upload.UploadFileUtils;

@Controller
@RequestMapping(value="/file")
public class FileUploadController {

	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public ResponseEntity<ReturnData> onUpload(HttpServletRequest request,HttpServletResponse response){
		ReturnData ret = ReturnData.newSuccessReturnData();
		List<String> files = UploadFileUtils.tranferFile(request, "D:\\yayi\\reader\\file", "");
		if(files.isEmpty()){
			ret.setMessage("无文件信息");
		}else{
			ret.setMessage("文件信息");
			ret.setData(files.get(0));
		}
		return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);
	}
}
