package com.zonekey.ssm.entity;

import java.io.Serializable;

public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String loginname;
	private String password;
	private String email;
	private String status;
	private String sex;
	private String mobile;
	private String birthday;
	private String picture;
	private String birthPlace;
	private String province;
	private String district;
	private String county;
	// 验证码
	private String code;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", name=" + name + ", loginname=" + loginname + ", password=" + password + ", email=" + email + ", status=" + status + ", sex=" + sex + ", mobile=" + mobile
				+ ", birthday=" + birthday + ", picture=" + picture + ", birthPlace=" + birthPlace + ", province=" + province + ", district=" + district + ", county=" + county + ", code=" + code
				+ "]";
	}
}
