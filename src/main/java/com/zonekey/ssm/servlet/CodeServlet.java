package com.zonekey.ssm.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author gly
 * 
 */
public class CodeServlet extends HttpServlet {
	private static final long serialVersionUID = 2769929625410381522L;

	public void service(HttpServletRequest req, HttpServletResponse res) {
		StringBuilder code = new StringBuilder();
		BufferedImage image = codeImage(code);
		HttpSession session = req.getSession();
		session.setAttribute("code", code.toString());

		res.setHeader("Pragma", "no-cache");
		res.setHeader("Cache-Control", "no-cache");
		res.setDateHeader("Expires", 0);

		res.setContentType("image/jpeg");

		ServletOutputStream sos = null;
		try {
			sos = res.getOutputStream();
			ImageIO.write(image, "jpeg", sos);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/****************************************************************/
	private static int width = 80;
	private static int height = 32;
	private static int lineNum = 50;
	private static int codeCount = 4;
	private static Random random = new Random();
	private static final String RANDOM_STRS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static final String FONT_NAME = "Fixedsys";
	private static final int FONT_SIZE = 20;

	private static BufferedImage codeImage(StringBuilder code) {
		BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics gd = buffImg.getGraphics();
		gd.setColor(getRandColor(200, 250));
		gd.fillRect(0, 0, width, height);

		gd.setColor(getRandColor(110, 120));
		for (int i = 0; i < lineNum; i++) {
			drowLine(gd);
		}

		gd.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));
		for (int i = 0; i < codeCount; i++) {
			code.append(drowString(gd, i));
		}
		return buffImg;
	}

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

	private static void drowLine(Graphics g) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int x0 = random.nextInt(16);
		int y0 = random.nextInt(16);
		g.drawLine(x, y, x + x0, y + y0);
	}

	private static String drowString(Graphics g, int i) {
		g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
		String rand = String.valueOf(getRandomString(random.nextInt(RANDOM_STRS.length())));
		g.translate(random.nextInt(5), random.nextInt(3));
		g.drawString(rand, 16 * i, 20);
		return rand;
	}

	private static String getRandomString(int num) {
		return String.valueOf(RANDOM_STRS.charAt(num));
	}
}
