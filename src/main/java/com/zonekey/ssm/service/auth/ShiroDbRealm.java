/*****************************
 * Copyright (c) 2014 by Zonekey Co. Ltd.  All rights reserved.
 ****************************/
package com.zonekey.ssm.service.auth;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.zonekey.ssm.common.utils.StringUtil;
import com.zonekey.ssm.service.SysUserService;
import com.zonekey.ssm.service.TermService;
import com.zonekey.ssm.views.SysUserView;

/**
 * @Title: ShiroDbRealm.java
 * @Description: <p>
 *               自实现用户与权限查询.
 *               </p>
 * @author gly
 * @date 2014-7-24 下午2:12:49
 * @version v 1.0
 */
public class ShiroDbRealm extends AuthorizingRealm {
	@Autowired
	private SysUserService sysUserService;
	@Resource
	private TermService termService;
	/**
	 * 登录名
	 */
	public String LOGINNAME;

	/**
	 * 认证用户身份回调函数, 登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		Token token = (Token) authcToken;
		String loginname = token.getUsername();
		String password = String.valueOf(token.getPassword());
		//判断用户名和密码不为空或者null
		if (!StringUtil.notNullOrBlankAll(new String[]{loginname,password})) {
			throw new AccountException("用户名和密码不能为空");
		}
		//Subject中保存当前用户信息
		Subject currentUser = SecurityUtils.getSubject();
		int count = currentUser.getSession().getAttribute("count") == null ? 0 : Integer.parseInt(currentUser.getSession().getAttribute("count")+"");
		//密码错误超过3次，校验验证码
		if (count >= 3) {
			String code = (String) currentUser.getSession().getAttribute("code");
			if (StringUtils.isEmpty(token.getCode()) || !token.getCode().equalsIgnoreCase(code)) {
				throw new AccountException("验证码错误");
			}
		}
		//String paw = MD5Utils.md5(String.valueOf(password));
		//校验用户名密码是否正确的 功能

		SysUserView user = sysUserService.findByLoginname(loginname, password);
		if (user != null) {
			//检验用户状态是否可用
			if ("1".equals(user.getStatus())) {
				throw new AccountException("此用户不可用，请更换用户重新登录");
			}
			LOGINNAME = user.getLoginname();
			currentUser.getSession().removeAttribute("count");
			//Map<String,Object> terms = termService.findTermtips();
		    //user.setTerms(terms);
			return new SimpleAuthenticationInfo(user, token.getPassword(), getName());
		} else {
			//如果验证码不为空
			if (token.getCode() != null && !"".equals(token.getCode())) {
				if (token.getCode().equals("mobile")) {
					//如果来自手机端
				} else {
					// 记录登录出错次数
					count += 1;
					currentUser.getSession().setAttribute("count", count);
				}
			}else{
				// 记录登录出错次数
				count += 1;
				currentUser.getSession().setAttribute("count", count);
			}
			throw new AccountException("用户名或密码错误");
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUserView shiroUser = (SysUserView) principals.fromRealm(getName()).iterator().next();
		// 授权信息
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<String> perms = Lists.newArrayList();
		// 获取权限数据
		List<String> role = shiroUser.getAuthenticatid();

		for (int i = 0; i < role.size(); i++) {
			String view = role.get(i);
			perms.add(view);
			info.addRole(view);
		}
		info.addRole("loginok");

		info.addStringPermissions(perms);

		return info;
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

	/**
	 * 取出Shiro中的当前登录名.
	 */
	public static String getCurrentLoginName() {
		SysUserView user = (SysUserView) SecurityUtils.getSubject().getPrincipal();
		if (user == null) {
			return null;
		} else {
			return user.getLoginname();
		}
	}

	/**
	 * 取出Shiro中的当前用户.
	 */
	public static SysUserView getSysUserView() {
		return (SysUserView) SecurityUtils.getSubject().getPrincipal();
	}
}
