package com.dragon.common.util;

import com.dragon.bean.UserSessionInfo;
import com.dragon.entity.ImageRepository;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

/**
 * 通用工具类
 */
public class Util {

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return true：为空； false：非空
	 */
	public static boolean isNull(String str) {
		if (str != null && !str.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * MD5 加密
	 */
	public static String encryptMD5(String str) {
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");

			messageDigest.reset();

			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("NoSuchAlgorithmException caught!");
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(
						Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}

	/**
	 * 得到抛异常的信息
	 * 
	 * @param t
	 * @return
	 */
	public static String getTrace(Throwable t) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		t.printStackTrace(writer);
		StringBuffer buffer = stringWriter.getBuffer();
		return buffer.toString();
	}

	/**
	 * 保存文件
	 * @return
	 */
	public static boolean SaveFileFromInputStream(InputStream stream, String path, long filename, String fileType){
		boolean flag = false;
		FileOutputStream fs = null;
		String suffix = getImageType(fileType);
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
			return SaveFileFromInputStream(stream,path,filename,fileType);
		}
		try {
			fs = new FileOutputStream( path + File.separator + filename + suffix);
			byte[] buffer = new byte[1024*1024];
			int bytesum = 0;
			int byteread = 0;
			while ((byteread = stream.read(buffer)) != -1){
				bytesum += byteread;
				fs.write(buffer,0,byteread);
				fs.flush();
			}
			fs.close();
			stream.close();
			flag = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 *
	 * 功能描述：取图片类型
	 *
	 * @param type
	 * @return
	 *
	 * @author 陶盛龙
	 *
	 * @since 2014年12月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	public static String getImageType(String type) {
		String suffix = "";
		if ("image/x-ms-bmp".equals(type)) {
			suffix = ".bmp";
		} else if ("image/gif".equals(type)) {
			suffix = ".gif";
		} else if ("image/jpeg".equals(type)) {
			suffix = ".jpg";
		} else if ("image/png".equals(type)) {
			suffix = ".png";
		} else if ("image/pjpeg".equals(type)) {
			suffix = ".jpg";
		} else if ("image/bmp".equals(type)) {
			suffix = ".bmp";
		} else if ("image/x-png".equals(type)) {
			suffix = ".png";
		}
		return suffix;
	}

	/**
	 * 上传文件
	 * @return
	 */
	public static String[][] upload(String nPath, String sPath, UserSessionInfo userInfo, HttpServletRequest request){
		String[][] reback = null;
		boolean flag = false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = format.format(new Date());
		//替换文件来源
		String narmalPath = nPath.replaceAll("FILE-SOURCE","homeImpress").replaceAll("DATE-STR", dateStr).replaceAll("USER-ID",userInfo.getUserId().toString());
		String smallPath = sPath.replaceAll("FILE-SOURCE","homeImpress").replaceAll("DATE-STR", dateStr).replaceAll("USER-ID",userInfo.getUserId().toString());
		try {
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                    request.getSession().getServletContext());
			if (multipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

                List<MultipartFile> fileList = multiRequest.getFiles("fileList");
				reback = new String[fileList.size()][2];
				int i = 0;
                for(MultipartFile file : fileList){
                    if(file != null){
                        //保存图片
                        Random dom = new Random();
                        //文件名称
                        long times = System.currentTimeMillis();
                        long imageName = times + dom.nextInt(1000);
						flag = Util.SaveFileFromInputStream(file.getInputStream(), narmalPath, imageName, file.getContentType());
                        if(!flag){
                            break;
                        }else{
                            String newPath = narmalPath + File.separator + imageName + Util.getImageType(file.getContentType());
                            String smallNewPath = smallPath + File.separator + imageName + Util.getImageType(file.getContentType());
                            try {
                                Util.reduceImage(newPath,smallNewPath,smallPath);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
							reback[i][0] = newPath;
							reback[i][1] = smallNewPath;
                        }
                    }
					i++;
                }
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reback;
	}

	/**
	 *
	 * @param inPath
	 * @param outPath
	 * @return
	 */
	public static String reduceImage(String inPath, String outPath, String smallPath) throws IOException, IllegalFormatException {
		float times = 0.2f;
		File file = new File(inPath);
		if(!file.exists()){
			return null;
		}
		BufferedImage bufferImage = ImageIO.read(file);
		 /*原始图像的宽度和高度*/
		int width = bufferImage.getWidth();
		int height = bufferImage.getHeight();

        /*调整后的图片的宽度和高度*/
		int toWidth = (int) (Float.parseFloat(String.valueOf(width)) * times);
		int toHeight = (int) (Float.parseFloat(String.valueOf(height)) * times);

        /*新生成结果图片*/
		BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);

		result.getGraphics().drawImage(bufferImage.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);

		File sfile = new File(smallPath);
		if(!sfile.exists()){
			sfile.mkdirs();
		}
		 /*输出到文件流*/
		FileOutputStream newimage = new FileOutputStream(outPath);
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
		JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(result);
            /* 压缩质量 */
		jep.setQuality(1f, true);
		encoder.encode(result, jep);
           /*近JPEG编码*/
		newimage.close();
		return null;
	}


	public static void main(String[] args) {
		System.out.println(Util.encryptMD5("admin"));
	}
}
