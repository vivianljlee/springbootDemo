package com.estar.util;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * @author 张立然
 *
 */
public class NarrowImage {

	/**
	 * @param im 原始图像
	 * @param resizeTimes 倍数,比如0.5就是缩小一半,0.98等等double类型
	 * @return 返回处理后的图像
	 */
	public BufferedImage zoomImage(String src, int toWidth, int toHeight) {

		BufferedImage result = null;

		try {
			File srcfile = new File(src);
			if (!srcfile.exists()) {
//				System.out.println("文件不存在");
			}
			BufferedImage im = ImageIO.read(srcfile);

			/* 新生成结果图片 */
			result = new BufferedImage(toWidth, toHeight,BufferedImage.TYPE_INT_RGB);

			result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight,java.awt.Image.SCALE_SMOOTH), 0, 0, null);

		} catch (Exception e) {
//			System.out.println("创建缩略图发生异常" + e.getMessage());
			e.printStackTrace();
		}
		return result;

	}

	public boolean writeHighQuality(BufferedImage im, String fileFullPath,float quality) {
		try {
			
			/* 输出到文件流 */
			FileOutputStream newimage = new FileOutputStream(fileFullPath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(im);
			/* 压缩质量 */
			jep.setQuality(quality, true);
			encoder.encode(im, jep);
			/* 近JPEG编码 */
			newimage.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {

		String inputFoler = "C:\\develop\\tomcat8\\wtpwebapps\\BDCS\\img\\bdcs\\1515035527916_100.jpg";
		/* 这儿填写你存放要缩小图片的文件夹全地址 */
		String outputFolder = "C:\\100.jpg";
		/* 这儿填写你转化后的图片存放的文件夹 */

		NarrowImage narrowImage = new NarrowImage();
		narrowImage.writeHighQuality(narrowImage.zoomImage(outputFolder, 1920, 1080), outputFolder,0.5f);

	}

}
