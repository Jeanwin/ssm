package com.zonekey.ssm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zonekey.ssm.dao.SysUserMapper;
import com.zonekey.ssm.views.SysUserView;

@Service
@Transactional(readOnly = true)
public class SysUserService {
	@Resource
	SysUserMapper userMapper;
    /**
     * 登录验证用户名和密码
     * @param loginname
     * @param paw
     * @return
     */
	public SysUserView findByLoginname(String loginname, String paw) {
		return userMapper.findByLoginname(loginname, paw);
	}

}
