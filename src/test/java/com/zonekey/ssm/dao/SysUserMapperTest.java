package com.zonekey.ssm.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zonekey.ssm.dao.SysUserMapper;
import com.zonekey.ssm.views.SysUserView;
/**
 * 
 * @author admin
 * 使用'@RunWith'或者可以继承SpringTxTestCase
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class SysUserMapperTest {
	@Resource
	private SysUserMapper suMapper;

	@Test
	public void test() {
		SysUserView user = suMapper.findByLoginname("admin", "123456");
		System.out.println(user.getLoginname());
	}
}
