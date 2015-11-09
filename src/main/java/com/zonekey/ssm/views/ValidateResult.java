package com.zonekey.ssm.views;

public class ValidateResult {

	// 验证类型
	private String type;
	// true表示没通过验证，
	private boolean result;
	// 验证消息
	private String message;

	public ValidateResult() {
	}

	public ValidateResult(String type, boolean result, String message) {
		this.type = type;
		this.result = result;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ValidateMsg [type=" + type + ", result=" + result + ", message=" + message + "]";
	}
}
