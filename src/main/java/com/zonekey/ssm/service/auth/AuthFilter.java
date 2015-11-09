package com.zonekey.ssm.service.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author admin
 * 
 */
public class AuthFilter implements Filter {
	private String encoding;

	// private static Logger logger =
	// Logger.getLogger(AuthFilter.class.getName());
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		// HttpServletResponse httpResponse = (HttpServletResponse) response;
		// Subject currentUser = SecurityUtils.getSubject();
		request.setCharacterEncoding(encoding);
		String strUrl = httpRequest.getRequestURI();
		String temp[] = strUrl.split("/");
		if (temp != null & temp.length > 0) {
			// 截取url地址最后一段
			strUrl = temp[temp.length - 1];
		}
		String tempurl = strUrl.replace(".html", "");
		// boolean b = false;
		if (tempurl.indexOf(".tpl") > -1) {
			// b = true;
			tempurl = tempurl.replace(".tpl", "");
			tempurl = tempurl.replaceAll(".", "_");
		}
		if (strUrl.indexOf("/login") != -1) {
			chain.doFilter(request, response);
			return;
		}
		/*
		 * if(!currentUser.hasRole("loginok")){
		 * ((HttpServletResponse)response).sendRedirect
		 * (((HttpServletRequest)(request)).getContextPath()+"/login"); return;
		 * }else{ return;
		 * 
		 * }
		 */
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}
}
