package com.hx.reader.components.upload;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


public class ImageUtil {
	/**
	 * * 图片文件读取
	 * 
	 * @param srcImgPath
	 * @return
	 */
	private static BufferedImage InputImage(String srcImgPath) throws RuntimeException {

		BufferedImage srcImage = null;
		FileInputStream in = null;
		try {
			// 构造BufferedImage对象
			File file = new File(srcImgPath);
			in = new FileInputStream(file);
			byte[] b = new byte[5];
			in.read(b);
			srcImage = javax.imageio.ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取图片文件出错！", e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					throw new RuntimeException("读取图片文件出错！", e);
				}
			}
		}
		return srcImage;
	}

	/**
	 * * 将图片按照指定的图片尺寸、源图片质量压缩(默认质量为1)
	 * 
	 * @param srcImgPath
	 *            :源图片路径
	 * @param outImgPath
	 *            :输出的压缩图片的路径
	 * @param new_w
	 *            :压缩后的图片宽
	 * @param new_h
	 *            :压缩后的图片高
	 */
	public static void resize(String srcImgPath, String outImgPath, int new_w, int new_h) {
		resize(srcImgPath, outImgPath, new_w, new_h, 1F);
	}

	/**
	 * 将图片按照指定的尺寸比例、源图片质量压缩(默认质量为1)
	 * 
	 * @param srcImgPath
	 *            :源图片路径
	 * @param outImgPath
	 *            :输出的压缩图片的路径
	 * @param ratio
	 *            :压缩后的图片尺寸比例
	 * @param per
	 *            :百分比
	 */
	public static void resize(String srcImgPath, String outImgPath, float ratio) {
		resize(srcImgPath, outImgPath, ratio, 1F);
	}

	/**
	 * 将图片按照指定长或者宽的最大值来压缩图片(默认质量为1)
	 * 
	 * @param srcImgPath
	 *            :源图片路径
	 * @param outImgPath
	 *            :输出的压缩图片的路径
	 * @param maxLength
	 *            :长或者宽的最大值
	 * @param per
	 *            :图片质量
	 */
	public static void resize(String srcImgPath, String outImgPath, int maxLength) {
		resize(srcImgPath, outImgPath, maxLength, 1F);
	}

	/**
	 * * 将图片按照指定的图片尺寸、图片质量压缩
	 * 
	 * @param srcImgPath
	 *            :源图片路径
	 * @param outImgPath
	 *            :输出的压缩图片的路径
	 * @param new_w
	 *            :压缩后的图片宽
	 * @param new_h
	 *            :压缩后的图片高
	 * @param per
	 *            :百分比
	 * @author cevencheng
	 */
	public static void resize(String srcImgPath, String outImgPath, int new_w, int new_h, float per) {
		// 得到图片
		BufferedImage src = InputImage(srcImgPath);
		int old_w = src.getWidth();
		// 得到源图宽
		int old_h = src.getHeight();
		// 得到源图长
		// 根据原图的大小生成空白画布
		BufferedImage tempImg = new BufferedImage(old_w, old_h, BufferedImage.TYPE_INT_RGB);
		// 在新的画布上生成原图的缩略图
		Graphics2D g = tempImg.createGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, old_w, old_h);
		g.drawImage(src, 0, 0, old_w, old_h, Color.white, null);
		g.dispose();
		BufferedImage newImg = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
		newImg.getGraphics().drawImage(tempImg.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0, 0, null);
		// 调用方法输出图片文件
		outImage(outImgPath, newImg, per);
	}

	/**
	 * * 将图片按照指定的尺寸比例、图片质量压缩
	 * 
	 * @param srcImgPath
	 *            :源图片路径
	 * @param outImgPath
	 *            :输出的压缩图片的路径
	 * @param ratio
	 *            :压缩后的图片尺寸比例
	 * @param per
	 *            :百分比
	 * @author cevencheng
	 */
	public static void resize(String srcImgPath, String outImgPath, float ratio, float per) {
		// 得到图片
		BufferedImage src = InputImage(srcImgPath);
		int old_w = src.getWidth();
		// 得到源图宽
		int old_h = src.getHeight();
		// 得到源图长
		int new_w = 0;
		// 新图的宽
		int new_h = 0;
		// 新图的长
		BufferedImage tempImg = new BufferedImage(old_w, old_h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = tempImg.createGraphics();
		g.setColor(Color.white);
		// 从原图上取颜色绘制新图g.fillRect(0, 0, old_w, old_h);
		g.drawImage(src, 0, 0, old_w, old_h, Color.white, null);
		g.dispose();
		// 根据图片尺寸压缩比得到新图的尺寸new_w = (int) Math.round(old_w * ratio);
		new_h = (int) Math.round(old_h * ratio);
		BufferedImage newImg = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
		newImg.getGraphics().drawImage(tempImg.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0, 0, null);
		// 调用方法输出图片文件OutImage(outImgPath, newImg, per);
	}

	/**
	 * <b> 指定长或者宽的最大值来压缩图片 推荐使用此方法 </b>
	 * 
	 * @param srcImgPath
	 *            :源图片路径
	 * @param outImgPath
	 *            :输出的压缩图片的路径
	 * @param maxLength
	 *            :长或者宽的最大值
	 * @param per
	 *            :图片质量
	 * @author cevencheng
	 */
	public static void resize(String srcImgPath, String outImgPath, int maxLength, float per) {
		// 得到图片
		BufferedImage src = InputImage(srcImgPath);
		int old_w = src.getWidth();
		// 得到源图宽
		int old_h = src.getHeight();
		// 得到源图长
		int new_w = 0;
		// 新图的宽
		int new_h = 0;
		// 新图的长
		BufferedImage tempImg = new BufferedImage(old_w, old_h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = tempImg.createGraphics();
		g.setColor(Color.white);
		// 从原图上取颜色绘制新图
		g.fillRect(0, 0, old_w, old_h);
		g.drawImage(src, 0, 0, old_w, old_h, Color.white, null);
		g.dispose();
		// 根据图片尺寸压缩比得到新图的尺寸
		if (old_w > old_h) {
			if(old_w<maxLength){
				new_w = old_w;
				new_h = old_h;
			}else{
				// 图片要缩放的比例
				new_w = maxLength;
				new_h = (int) Math.round(old_h * ((float) maxLength / old_w));
			}
		} else {
			if(old_h<maxLength){
				new_w = old_w;
				new_h = old_h;
			}else{
				new_w = (int) Math.round(old_w * ((float) maxLength / old_h));
				new_h = maxLength;
			}
		}
		BufferedImage newImg = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
		newImg.getGraphics().drawImage(tempImg.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0, 0, null);
		// 调用方法输出图片文件
		outImage(outImgPath, newImg, per);
	}

	/**
	 * 将图片压缩成指定宽度， 高度等比例缩放
	 *
	 * @param srcImgPath
	 * @param outImgPath
	 * @param width
	 * @param per
	 */
	public static void resizeFixedWidth(String srcImgPath, String outImgPath, int width, float per) {
		// 得到图片
		BufferedImage src = InputImage(srcImgPath);
		int old_w = src.getWidth();
		// 得到源图宽
		int old_h = src.getHeight();
		// 得到源图长
		int new_w = 0;
		// 新图的宽
		int new_h = 0;
		// 新图的长
		BufferedImage tempImg = new BufferedImage(old_w, old_h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = tempImg.createGraphics();
		g.setColor(Color.white);
		// 从原图上取颜色绘制新图
		g.fillRect(0, 0, old_w, old_h);
		g.drawImage(src, 0, 0, old_w, old_h, Color.white, null);
		g.dispose();
		// 根据图片尺寸压缩比得到新图的尺寸
		if (old_w > old_h) {
			// 图片要缩放的比例
			new_w = width;
			new_h = (int) Math.round(old_h * ((float) width / old_w));
		} else {
			new_w = (int) Math.round(old_w * ((float) width / old_h));
			new_h = width;
		}
		BufferedImage newImg = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
		newImg.getGraphics().drawImage(tempImg.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0, 0, null);
		// 调用方法输出图片文件
		outImage(outImgPath, newImg, per);
	}

	/**
	 * * 将图片文件输出到指定的路径，并可设定压缩质量
	 * 
	 * @param outImgPath
	 * @param newImg
	 * @param per
	 * @author cevencheng
	 */
	private static void outImage(String outImgPath, BufferedImage newImg, float per) {
		// 判断输出的文件夹路径是否存在，不存在则创建
		File file = new File(outImgPath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		// 输出到文件流
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outImgPath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(newImg);
			// 压缩质量
			jep.setQuality(per, true);
			encoder.encode(newImg, jep);
			fos.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	/**
	 * 图片剪切工具方法
	 *
	 * @param srcfile
	 *            源图片
	 * @param outfile
	 *            剪切之后的图片
	 * @param x
	 *            剪切顶点 X 坐标
	 * @param y
	 *            剪切顶点 Y 坐标
	 * @param width
	 *            剪切区域宽度
	 * @param height
	 *            剪切区域高度
	 *
	 * @throws IOException
	 * @author cevencheng
	 */
	public static void cut(File srcfile, File outfile, int x, int y, int width, int height) throws IOException {
		FileInputStream is = null;
		ImageInputStream iis = null;
		try {
			// 读取图片文件
			is = new FileInputStream(srcfile);

			/*
			 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
			 * 参数：formatName - 包含非正式格式名称 .（例如 "jpeg" 或 "tiff"）等 。
			 */
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("jpg");
			ImageReader reader = it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(is);

			/*
			 * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。
			 * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			 */
			reader.setInput(iis, true);

			/*
			 * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O
			 * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
			 * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
			 */
			ImageReadParam param = reader.getDefaultReadParam();

			/*
			 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
			 */
			Rectangle rect = new Rectangle(x, y, width, height);

			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);

			/*
			 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
			 * BufferedImage 返回。
			 */
			BufferedImage bi = reader.read(0, param);

			// 保存新图片
			ImageIO.write(bi, "jpg", outfile);
		} finally {
			if (is != null) {
				is.close();
			}
			if (iis != null) {
				iis.close();
			}
		}
	}
	
	
	/**
     * 缩放图片(压缩图片质量，改变图片尺寸)
     * 若原图宽度小于新宽度，则宽度不变！
     * @param newWidth 新的宽度
     * @param quality 图片质量参数 0.7f 相当于70%质量
         * 2016年12月21日
     */
    public static void resize(File originalFile, File resizedFile,  
            int newWidth, float quality) throws IOException {  
   
        if (quality > 1) {  
            throw new IllegalArgumentException(  
                    "Quality has to be between 0 and 1");  
        }  
        ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());  
        Image i = ii.getImage();  
        Image resizedImage = null;  
   
        int iWidth = i.getWidth(null);  
        int iHeight = i.getHeight(null);  
   
        if(iWidth < newWidth){
            newWidth = iWidth;
        }
        if (iWidth > iHeight) {  
            resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight)  
                    / iWidth, Image.SCALE_SMOOTH);  
        } else {  
            resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight,  
                    newWidth, Image.SCALE_SMOOTH);  
        }  
        // This code ensures that all the pixels in the image are loaded.  
        Image temp = new ImageIcon(resizedImage).getImage();  
   
        // Create the buffered image.  
        BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),  
                temp.getHeight(null), BufferedImage.TYPE_INT_RGB);  
   
        // Copy image to buffered image.  
        Graphics g = bufferedImage.createGraphics();  
   
        // Clear background and paint the image.  
        g.setColor(Color.white);  
        g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));  
        g.drawImage(temp, 0, 0, null);  
        g.dispose();  
   
        // Soften.  
        float softenFactor = 0.05f;  
        float[] softenArray = { 0, softenFactor, 0, softenFactor,  
                1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };  
        Kernel kernel = new Kernel(3, 3, softenArray);  
        ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);  
        bufferedImage = cOp.filter(bufferedImage, null);  
   
        // Write the jpeg to a file.  
        FileOutputStream out = new FileOutputStream(resizedFile);  
   
        // Encodes image as a JPEG data stream  
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
   
        JPEGEncodeParam param = encoder  
                .getDefaultJPEGEncodeParam(bufferedImage);  
   
        param.setQuality(quality, true);  
   
        encoder.setJPEGEncodeParam(param);  
        encoder.encode(bufferedImage);  
    } // Example usage  
   
//    public static void main(String[] args) throws IOException {  
////       File originalImage = new File("C:\\11.jpg");  
////       resize(originalImage, new File("c:\\11-0.jpg"),150, 0.7f);  
////       resize(originalImage, new File("c:\\11-1.jpg"),150, 1f);  
//         File originalImage = new File("d:\\testImg\\1.jpg");  
//         System.out.println("源文件大小" + originalImage.length());
////         File resizedImg = new File("d:\\testImg\\11.jpg");
////         resize(originalImage, resizedImg, 850, 1f);  
////         System.out.println("0.5转换后文件大小" + resizedImg.length());
////         File resizedImg1 = new File("d:\\testImg\\111.jpg");
//         File resizedImg1 = new File("/alidata/zkyj/dashixiong/tempImgFile/11.jpg");
//         resize(originalImage, resizedImg1, 1550, 0.7f);  
//         System.out.println("0.7转换后文件大小" + resizedImg1.length());
//    }  

	public static void main(String args[]) throws Exception {
//		String srcImg = "e:test.png";
//		String tarDir = "c:/img/newImg/";
//		URL url = ImageUtil.class.getResource("");
//		File srcfile = new File(url.toURI());
//		System.out.println(url);
//		System.out.println(srcfile.exists() + ", dir=" + srcfile.getParent());
//		tarDir = srcfile.getParent();
//		srcImg = srcfile.getPath();
//		System.out.println("srcImg=" + srcImg);
//		long startTime = new Date().getTime();
//		resize(srcImg, tarDir + "car_1_maxLength_1-200px.jpg", 200);
//
//		//Tosmallerpic(srcImg, tarDir + "car_1_maxLength_2.jpg", 0.5F);
//		resize(srcImg, tarDir + "car_1_maxLength_3.jpg", 400, 500);
//		resize(srcImg, tarDir + "car_1_maxLength_4-400x400.jpg", 220, 220);
//		resize(srcImg, tarDir + "car_1_maxLength_11-220px-yinhui.jpg", 220, 0.7F);
//
//		//Tosmallerpic(srcImg, tarDir + "car_1_maxLength_22.jpg", 0.5F, 0.8F);
//		resize(srcImg, tarDir + "car_1_maxLength_33.jpg", 400, 500, 0.8F);
//		System.out.println(new Date().getTime() - startTime);
		File file = new File("e://11.png");
		System.out.println(file.getPath());
		resize(file, new File("e://a11.png"), 1000, 1f);
		resize(file.getPath(), "e://a21.png", 1000, 1f);
	}

}
