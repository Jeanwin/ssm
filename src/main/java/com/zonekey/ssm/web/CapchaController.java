package com.zonekey.ssm.web;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zonekey.ssm.common.utils.CapchaUtil;

@Controller
@RequestMapping(value = "admin")
public class CapchaController {

	@RequestMapping(value = "/getCode")
	public void getCapcha(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// 将四位数字的验证码保存到Session中。
		StringBuilder code = new StringBuilder();
		BufferedImage image = CapchaUtil.codeImage(code);
		//HttpSession session = req.getSession();
		//apache shiro session
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("code", code.toString());
		// 禁止图像缓存。
		res.setHeader("Pragma", "no-cache");
		res.setHeader("Cache-Control", "no-cache");
		res.setDateHeader("Expires", 0);
		res.setContentType("image/jpeg");
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = res.getOutputStream();
		ImageIO.write(image, "jpeg", sos);
		sos.close();
	}
}
