package com.nagarro.congif;

import org.springframework.context.annotation.Bean;

import com.nagarro.dao.HRDao;
import com.nagarro.daoimpl.HRDaoImp;
import com.nagarro.service.EmpMangService;
import com.nagarro.service.SignService;

public class AppConfig {
	@Bean
	public HRDao getHRManager() {
		return new HRDaoImp();
	}
	@Bean
	public SignService getSignService() {
		return new SignService();
	}
	@Bean
	public EmpMangService getEmpMangService() {
		return new EmpMangService();
	}


}
