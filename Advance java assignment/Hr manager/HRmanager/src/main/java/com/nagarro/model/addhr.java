package com.nagarro.model;

import org.hibernate.Session;

import com.nagarro.congif.HibernateConfig;



public class addhr {
	public static void main(String[] args) {

		HR user1 = new HR("manpreet","abc");
		
		
		
		Session session =  HibernateConfig.getSessionFactory().openSession();
		session.getTransaction().begin();
		session.save(user1);
		
		session.getTransaction().commit();
		
	}

}
