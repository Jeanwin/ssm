package com.zonekey.ssm.views;

import java.util.List;

public class ValidateMsg {
	private String name;
	private boolean isValid = true;
	private List<ValidateResult> results;

	public ValidateMsg() {
		super();
	}

	public ValidateMsg(String name, boolean isValid, List<ValidateResult> results) {
		super();
		this.name = name;
		this.isValid = isValid;
		this.results = results;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public List<ValidateResult> getResults() {
		return results;
	}

	public void setResults(List<ValidateResult> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "ValidateMsg [name=" + name + ", isValid=" + isValid + ", results=" + results + "]";
	}
}
