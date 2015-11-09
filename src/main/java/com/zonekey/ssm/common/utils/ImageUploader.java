package com.zonekey.ssm.common.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zonekey.ssm.views.ValidateMsg;
import com.zonekey.ssm.views.ValidateResult;

/**
 * 图片上传工具类
 * 
 * @author admin
 * 
 */
public class ImageUploader {

	// 不能超过2m
	public static final long SIZE_MAX_IMG = 2097152;
	public static final String FOLDER_IMG = "C:" + File.separator + "images" + File.separator;
	public static final int WIDTH_MAX_IMG = 1920;
	public static final int HEIGHT_MAX_IMG = 1080;
	public static final String MSG_ERROR_EXT = "请选择扩展名为jpg、jpeg、png、bpm、gif的图片";
	public static final String MSG_ERROR_STORE = "图片大小不能超过2Mb";
	public static final String MSG_ERROR_SIZE = "图片尺寸应小于1920*1080像素";
	public static final List<String> EXT_IMG = new ArrayList<String>() {
		private static final long serialVersionUID = -6340094436493008215L;
		{
			add(".jpg");
			add(".jpeg");
			add(".bmp");
			add(".gif");
			add(".png");
		}
	};

	/**
	 * springMVC上传
	 * @param req
	 * @param customPath
	 *            用户自定义路径
	 * @param delFile
	 *            要删除的文件
	 * @param fileInput
	 *            表单文件名
	 * @return
	 */
	public static Map<String,Object> uploadImg(MultipartFile file, String customPath, String delFile) {
		Map<String,Object> data = new HashMap<String,Object>();
		// 保存文件的路径
		String newPath = FOLDER_IMG;
		if (StringUtil.notNullOrBlank(customPath)) {
			newPath += customPath;
		}
		//获取并转存文件
		if(StringUtil.notNullOrBlank(file.getOriginalFilename())){
			String picture = transferFile(file,newPath);
			data.put("picture", customPath+picture);
		}
		return data;
	}

	private static String transferFile(MultipartFile file,String path) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 图片验证
	 * 
	 * @param image
	 * @return
	 */
	public static ValidateMsg validateImg(String imagePath) {
		List<ValidateResult> result = new ArrayList<ValidateResult>();
		ValidateResult r;
		ValidateMsg msg = new ValidateMsg();
		msg.setName(imagePath);
		File imgFile = new File(imagePath);
		String[] fileArray = imagePath.split(".");
		String extention = fileArray[fileArray.length - 1];
		BufferedImage image = fileToImage(imgFile);
		// 校验扩展名
		if (!EXT_IMG.contains(extention)) {
			r = new ValidateResult("扩展名", false, MSG_ERROR_EXT);
			result.add(r);
			msg.setValid(false);
		}
		// 校验文件大小
		if (imgFile.length() > SIZE_MAX_IMG) {
			r = new ValidateResult("文件大小", false, MSG_ERROR_STORE);
			result.add(r);
			msg.setValid(false);
		}
		// 校验图片宽高
		if (image.getWidth() > WIDTH_MAX_IMG || image.getHeight() > HEIGHT_MAX_IMG) {
			r = new ValidateResult("图片宽高", false, MSG_ERROR_SIZE);
			result.add(r);
			msg.setValid(false);
		}
		msg.setResults(result);
		return msg;
	}

	/**
	 * 将文件转换为图片
	 * 
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static BufferedImage fileToImage(File file) {
		BufferedImage bi;
		try {
			bi = ImageIO.read(new FileInputStream(file));
			return bi;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
