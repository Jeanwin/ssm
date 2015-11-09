package com.zonekey.ssm.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zonekey.ssm.common.utils.StringUtil;
import com.zonekey.ssm.service.auth.Token;
import com.zonekey.ssm.views.SysUserView;

@Controller
public class ShiroController {
	/**
	 * shiro登录
	 * 
	 * @param req
	 * @param user
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "login")
	public String login(HttpServletRequest req, SysUserView user, Model model) {
		// 如果是GET方式，直接返回登录页面
		if ("GET".equals(req.getMethod())) {
			model.addAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, null);
			return "login";
		}
		if (!StringUtil.notNullOrBlankAll(new String[] { user.getLoginname(), user.getPassword() })) {
			model.addAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, "用户名和密码不能为空");
			return "login";
		}
		try {
			SecurityUtils.getSubject().login(new Token(user.getLoginname(), user.getPassword(), user.getCode()));
			model.addAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, null);
			req.getSession(false).setAttribute("count", 0);
			SecurityUtils.getSubject().getSession(false).setAttribute("count", 0);
			//return "redirect:/index";
			return "redirect:index";
		} catch (AccountException e1) {
			model.addAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, e1.getMessage());
			// 记录密码出错次数
			System.out.println(SecurityUtils.getSubject().getSession(false).getAttribute("count"));
			if (e1.getMessage() != null && "用户名或密码错误".equals(e1.getMessage())) {
				req.getSession().setAttribute("count", SecurityUtils.getSubject().getSession(false).getAttribute("count"));
			}
			return "login";
		} catch (AuthenticationException e) {
			model.addAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, "登录异常，请重试");
			return "login";
		}
	}

	/**
	 * shiro注销登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		}
		return "redirect:login";
	}
	/**
	 * 跳转到首页
	 */
	@RequestMapping(value = "/index")
	public String index(){
		return "index";
	}
}
