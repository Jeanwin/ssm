package com.zonekey.ssm.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zonekey.ssm.common.utils.StringUtil;
import com.zonekey.ssm.service.SysUserService;
import com.zonekey.ssm.views.SysUserView;

@Controller
@RequestMapping(value="/admin")
public class LoginController {
	@Resource
	private SysUserService userService;
    /**
     * 简单登陆
     * @param user
     * @param model
     * @return
     */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(SysUserView user, ModelMap model) {
		if (user != null) {
			if (StringUtil.notNullOrBlank(user.getLoginname()) && StringUtil.notNullOrBlank(user.getPassword())) {
			    SysUserView currentUser = userService.findByLoginname(user.getLoginname(), user.getPassword());
				if (currentUser != null) {
					//将用户信息保存到模型里
					model.addAttribute(currentUser);
					return "index";
				} else {
					model.addAttribute("loginMessage", "用户名或密码错误");
					return "login";
				}
			} else {
				model.addAttribute("loginMessage", "用户名或密码不能为空");
				return "login";
			}
		} else {
			model.addAttribute("loginMessage", "用户名或密码不能为空");
			return "login";
		}
	}
	/**
	 * 退出登录
	 * @param req
	 * @return
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req){
		HttpSession session = req.getSession(false);
		if(session != null){
			session.invalidate();
		}
		return "redirect:login";
	}
}
