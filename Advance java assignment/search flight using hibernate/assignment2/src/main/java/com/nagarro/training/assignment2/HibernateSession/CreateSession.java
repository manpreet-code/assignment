package com.nagarro.training.assignment2.HibernateSession;

//import java.lang.module.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.training.assignment2.Model.FlightModel;

public class CreateSession {
	public static SessionFactory getSession() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		return sessionFactory;
	}

}
