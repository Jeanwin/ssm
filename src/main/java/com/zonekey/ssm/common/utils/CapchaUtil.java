package com.zonekey.ssm.common.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CapchaUtil {
	private static int width = 80; // 定义图片的width
	private static int height = 34; // 定义图片的height
	private static int lineNum = 50; // 干扰线数量
	private static int codeCount = 4;// 定义图片上显示验证码的个数
	private static Random random = new Random();
	private static final String RANDOM_STRS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // 随机字符串

	private static final String FONT_NAME = "Fixedsys";
	private static final int FONT_SIZE = 20;

	/**
	 * 产生图形验证码
	 * 
	 * @param code
	 * @return
	 */
	public static BufferedImage codeImage(StringBuilder code) {
		// 定义图像buffer
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics gd = buffImg.getGraphics();
		// 设置背景色
		gd.setColor(getRandColor(200, 250));
		gd.fill3DRect(0, 0, width, height,true);

		// 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
		gd.setColor(getRandColor(110, 120));
		for (int i = 0; i < lineNum; i++) {
			drowLine(gd);
		}

		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。Font.ROMAN_BASELINE
		gd.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
		// 随机产生codeCount数字的验证码。
		for (int i = 0; i < codeCount; i++) {
			code.append(drowString(gd, i));
		}
		return buffImg;
	}

	/**
	 * 给定范围获得随机颜色
	 */
	private static Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	/**
	 * 绘制干扰线
	 */
	private static void drowLine(Graphics g) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int x0 = random.nextInt(16);
		int y0 = random.nextInt(16);
		g.drawLine(x, y, x + x0, y + y0);
	}

	/**
	 * 绘制字符串
	 */
	private static String drowString(Graphics g, int i) {
		g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
		String rand = String.valueOf(getRandomString(random.nextInt(RANDOM_STRS.length())));
		g.translate(random.nextInt(6), random.nextInt(4));
		g.drawString(rand, 16 * i, 20);
		return rand;
	}

	/**
	 * 获取随机的字符
	 */
	private static String getRandomString(int num) {
		return String.valueOf(RANDOM_STRS.charAt(num));
	}
}
