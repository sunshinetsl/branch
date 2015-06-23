package com.dragon.common.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

	// 生成缩略图，原图路径，生成图片路径，宽高
	public static void reduceImage(String imgsrc, String imgdist, int widthdist,
								   int heightdist) throws Exception {
		FileOutputStream out = null;
		try {
			File srcfile = new File(imgsrc);
			if (!srcfile.exists()) {
				throw new Exception("文件不存在！");
				// return;//修改后，保证回滚
			}
			BufferedImage src = ImageIO.read(srcfile);

			int sw = src.getWidth();
			int sh = src.getHeight();

			int tw = widthdist, th = heightdist;
			int x = 0, y = 0;

			double sx = (double) widthdist / sw;
			double sy = (double) heightdist / sh;
			if (sx < sy) {
				tw = (int) (sy * sw);
				x = (tw - widthdist) / 2;
			} else {
				th = (int) (sx * sh);
				y = (th - heightdist) / 2;
			}

			BufferedImage tag = new BufferedImage((int) tw, (int) th,
					BufferedImage.TYPE_INT_RGB);

			tag.getGraphics().drawImage(
					src.getScaledInstance(tw, th, Image.SCALE_SMOOTH), 0, 0,
					null);
			tag.getGraphics().dispose();
			out = new FileOutputStream(imgdist);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(tag.getSubimage(x, y, widthdist, heightdist));
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new Exception(ex);
		} finally {
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Util.encryptMD5("admin"));
	}
}
