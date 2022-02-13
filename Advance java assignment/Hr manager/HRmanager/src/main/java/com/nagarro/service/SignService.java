package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.HRDao;
import com.nagarro.model.HR;

public class SignService {
	@Autowired
	private HRDao hrmDao;

	public boolean validateHRManager(String hrmId, String hrmPswd) {

		HR hrmObject = hrmDao.getHR(hrmId);

		return hrmObject != null && hrmObject.getHrPswd().equals(hrmPswd);
	}

}
