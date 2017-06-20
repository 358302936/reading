package com.hx.reader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.hx.reader.components.ReturnData;

@Controller
@RequestMapping(value="/file")
public class FileUploadController {

	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public ResponseEntity<ReturnData> onUpload(HttpServletRequest request,HttpServletResponse response,MultipartFile file){
		ReturnData ret = null;
		String filename = file.getOriginalFilename();
		return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);
	}
}
