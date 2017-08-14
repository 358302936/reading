package com.hx.reader.components.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


/**
 * @Description: 文件上传
 * @date 创建时间：2016年3月25日 下午4:54:20
 * @version 1.0
 */
public class UploadFileUtils {
	
	private final static int IMAGEWIDTH = 400;
	//压缩治疗
	private final static float IMAGEPER = 1f;
	
	/**
	 * 
	 * @param request
	 * @param storePath    文件存储路径
	 * @param editname     修改后的文件名   如果为空则修改为UUID的随机数   
	 * 					      如果不为空而且多个文件命名为 如a.jpeg,a_1.jpeg,a_2.jpeg.....
	 * @return
	 */
	public static List<String> tranferFile(HttpServletRequest request, String storePath,String editname) {
		List<String> filenameList = new ArrayList<String>();
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// // 判断 request 是否有文件上传,即多部分请求      
		if (multipartResolver.isMultipart(request)) {
			// 再将request中的数据转化成multipart类型的数据      转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			
			List<MultipartFile> list =  multiRequest.getFiles("ygMulFiles");
			if(list.size()>0){//文件数组上传   单张或多张    name一定要是ygMulFiles
				for(int j=0;j<list.size();j++){
					MultipartFile file = list.get(j);
					getFilenameList(filenameList,file,storePath,editname);
				}
			}else{//多张照片和参数并列上传
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					// 取得上传文件
					MultipartFile file = multiRequest.getFile((String) iter.next());
					getFilenameList(filenameList,file,storePath,editname);
				}
			}
		}
		return filenameList;
	}

	private static void getFilenameList(List<String> filenameList,MultipartFile file, String storePath, String editname) {
		int i=0;
		if (file != null) {
			// 取得当前上传文件的文件名称
			String originalFileName = file.getOriginalFilename();
			//取得文件后缀
			String suff = getFileSuffix(originalFileName);
			// 得到存储到本地的文件名
			String localFileName = UUID.randomUUID().toString() + suff;
			if(SpringUtils.isNotNull(editname)){
				localFileName = editname + (i==0?"":"_"+i) + suff;
				i++;
			}
			// 新建本地文件
			File localFile = new File(storePath, localFileName);
			// 创建目录
			File fileDir = new File(storePath);
			if (!fileDir.isDirectory()) {
				// 如果目录不存在，则创建目录
				fileDir.mkdirs();
			}

			String src = storePath + "/" + localFileName;
			filenameList.add(src);
			// 写文件到本地
			try {
				file.transferTo(localFile);
				//如果是图片的话进行压缩
				if(isImage(localFile))
					ImageUtil.resize(localFile.getPath(), localFile.getPath(),IMAGEWIDTH, IMAGEPER);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取文件后缀
	 * 
	 * @param originalFileName
	 * @return
	 */
	public static String getFileSuffix(String originalFileName) {
		int dot = originalFileName.lastIndexOf('.');
		if ((dot > -1) && (dot < originalFileName.length())) {
			return originalFileName.substring(dot);
		}
		return originalFileName;
	}
	
	/**
	 * 判断文件是否是图片
	 * @param file
	 * @return
	 */
	private static boolean isImage(File file) {
		boolean flag = false;
		try {
			ImageInputStream is = ImageIO.createImageInputStream(file);
			if (null == is) {
				return flag;
			}
			is.close();
			flag = true;
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return flag;
	}
}