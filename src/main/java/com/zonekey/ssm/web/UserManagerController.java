package com.zonekey.ssm.web;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zonekey.ssm.views.SysUserView;

@Controller
@RequestMapping(value = "admin")
public class UserManagerController {
	/**
	 * 跳转到注册页	
	 * @return
	 */
	@RequestMapping(value = "/toRegister", method = RequestMethod.GET)
	public String toRegister() {
		return "admin/register";
	}
	/**
	 * 跳转到找回密码页面
	 * @return
	 */
	@RequestMapping(value = "/toRetrive", method = RequestMethod.GET)
	public String toRetrive() {
		return "admin/retrivePassword";
	}
    /**
     * 注册用户
     * @param user
     * @param res
     */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(SysUserView user, HttpServletResponse res) {
          try {
			res.getWriter().write("注册了");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
