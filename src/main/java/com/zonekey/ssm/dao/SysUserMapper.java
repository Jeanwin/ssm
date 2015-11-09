package com.zonekey.ssm.dao;

import org.apache.ibatis.annotations.Param;

import com.zonekey.ssm.dao.base.BaseMapper;
import com.zonekey.ssm.dao.base.MyBatisRepository;
import com.zonekey.ssm.views.SysUserView;
@MyBatisRepository
public interface SysUserMapper extends BaseMapper<SysUserView, Integer> {
	public SysUserView findByLoginname(@Param("loginname") String loginname, @Param("password") String password);
}
