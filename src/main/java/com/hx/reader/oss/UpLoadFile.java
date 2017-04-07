package com.hx.reader.oss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.GetObjectRequest;


public class UpLoadFile {
	
	String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
	
	String accessKeyId = "**";
	
	String secretAccessKey = "**";
	
    
    public void uploadFiles(){
    	OSSClient client = new OSSClient(endpoint, accessKeyId, secretAccessKey);
    	
    	File file = new File("E:\\资料\\mysql36条军规.pdf");
    	try {
			InputStream inputStream = new FileInputStream(file);
			//上传本地文件
			client.putObject("yayi-avatar", "mysql", file);
			// 关闭client
			client.shutdown();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void downloadFiles(){
    	OSSClient client = new OSSClient(endpoint, accessKeyId, secretAccessKey);
    	client.getObject(new GetObjectRequest("yayi-avatar", "mysql"),new File("E:\\mysql36条.pdf"));
    	client.shutdown();
    }
    
    public void getBuckets(){
    	OSSClient client = new OSSClient(endpoint, accessKeyId, secretAccessKey);
    	List<Bucket> buckets = client.listBuckets();
    	for (Bucket bucket : buckets) {
    	    System.out.println(" - " + bucket.getName());
    	}
    	client.shutdown();
    }
    
    public static void main(String[] args) {
    	UpLoadFile uf =new UpLoadFile();
//    	uf.uploadFiles();
//    	uf.downloadFiles();
    	uf.getBuckets();
	}
}
