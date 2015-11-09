package com.zonekey.ssm.dao;

import org.springframework.stereotype.Repository;

import com.zonekey.ssm.dao.base.BaseMapper;
import com.zonekey.ssm.views.SysUserView;

@Repository
public interface TermMapper extends BaseMapper<SysUserView, Integer> {
}
