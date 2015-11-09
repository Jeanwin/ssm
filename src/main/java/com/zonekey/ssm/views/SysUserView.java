package com.zonekey.ssm.views;

import java.util.List;
import java.util.Map;

import com.zonekey.ssm.entity.SysUser;

public class SysUserView extends SysUser {
	private static final long serialVersionUID = 3663710449981831560L;
	private Map<String, Object> terms;
	private List<String> authenticatid;
	private String timeStamp;
	private String repassword;
	private String year;
	private String month;
	private String day;

	public List<String> getAuthenticatid() {
		return authenticatid;
	}

	public void setAuthenticatid(List<String> authenticatid) {
		this.authenticatid = authenticatid;
	}

	public Map<String, Object> getTerms() {
		return terms;
	}

	public void setTerms(Map<String, Object> terms) {
		this.terms = terms;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Override
	public String toString() {
		return "SysUserView [terms=" + terms + ", authenticatid=" + authenticatid + ", timeStamp=" + timeStamp + ", repassword=" + repassword + ", year=" + year + ", month=" + month + ", day=" + day
				+ "]";
	}
}
