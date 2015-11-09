package com.zonekey.ssm.common.utils;

import javax.servlet.http.HttpServletRequest;

public class IPUtils {
	/**
	 * 根据请求获取IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddrByRequest(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 把ip地址格式化为：000.000.000.000
	 * 
	 * @param ip
	 * @return 返回规格ip
	 */
	public static String strfullip(String ip) {
		StringBuffer buff = new StringBuffer();
		buff.append("");
		String strzero = "000";
		int ilen = 0;
		if (ip != null) {
			String[] arrip = ip.split("\\.");
			if (arrip.length == 4) {
				for (int i = 0; i < 4; i++) {
					if (i == 0) {
						ilen = arrip[i].length();
						if (ilen < 3) {
							buff.append(strzero.substring(0, 3 - ilen)).append(arrip[i]);
						} else {
							buff.append(arrip[i]);
						}
					} else {
						ilen = arrip[i].length();
						if (ilen < 3) {
							buff.append(".").append(strzero.substring(0, 3 - ilen)).append(arrip[i]);
						} else {
							buff.append(".").append(arrip[i]);
						}
					}
				}
			}
		}
		return buff.toString();
	}
	public static void main(String[] args) {
		String ip = strfullip("192.168.12.214");
		System.out.println(ip);
	}

	/**
	 * 通过ip地址查询地区名称
	 * 
	 * @param strip
	 * @return ip所在地区名称
	 */
	/*
	 * public static String getArea(String strip) { Connection conn = null;
	 * PreparedStatement pstmt = null; String sql; String strRtn = null; try {
	 * MyJdbc myjdbc = new MyJdbc(); conn = myjdbc.getConn(); sql =
	 * "select * from fullip where startip<='" + strip + "' and endip>='" +
	 * strip + "'"; pstmt = conn.prepareStatement(sql); ResultSet rs =
	 * pstmt.executeQuery(); if (rs.next()) { strRtn = rs.getString("country");
	 * } else { strRtn = "未确定"; } rs.close(); rs = null; } catch (Exception e) {
	 * e.printStackTrace(); } finally { if (pstmt != null) try { pstmt.close();
	 * pstmt = null; } catch (Exception e) { } if (conn != null) try {
	 * conn.close(); conn = null; } catch (Exception e) { } } return strRtn; }
	 */

}
