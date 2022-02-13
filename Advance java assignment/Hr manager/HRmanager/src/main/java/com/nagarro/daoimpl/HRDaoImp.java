package com.nagarro.daoimpl;

import org.hibernate.Session;

import com.nagarro.congif.HibernateConfig;
import com.nagarro.dao.HRDao;
import com.nagarro.model.HR;

public class HRDaoImp implements HRDao {

	public HR getHR(String hrmId) {
Session session = HibernateConfig.getSessionFactory().openSession();
		
		HR hrObject = session.get(HR.class, hrmId);
		
		session.close();
		
		return hrObject;
	}

}
