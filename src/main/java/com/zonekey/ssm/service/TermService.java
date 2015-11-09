package com.zonekey.ssm.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zonekey.ssm.dao.TermMapper;


@Service
@Transactional(readOnly = true)
public class TermService {
	@Autowired
	private TermMapper termMapper;

	public Map<String, Object> findTermtips() {
		// TODO Auto-generated method stub
		return null;
	}

}
