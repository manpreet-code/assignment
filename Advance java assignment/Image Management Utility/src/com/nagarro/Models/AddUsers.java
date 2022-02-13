package com.nagarro.Models;

import org.hibernate.Session;

import com.nagarro.utils.HibernateUtilities;

public class AddUsers {

	public static void main(String[] args) {

		User user1 = new User("manpreet","Manpreet Singh", "abc");
		
		
		
		Session session = HibernateUtilities.getSessionInstance();
		
		session.save(user1);
		
		session.getTransaction().commit();
		
	}

}
