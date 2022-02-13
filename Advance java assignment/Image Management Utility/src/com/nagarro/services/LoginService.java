package com.nagarro.services;

import com.nagarro.Models.User;
import com.nagarro.utils.HibernateUtilities;
import org.hibernate.Session;


public class LoginService {

	/**
	 * Returns true if user with the given name and password exists
	 */
	public boolean userAuthentication(String username, String password) {
		try (Session session = HibernateUtilities.getSessionInstance()) {
			User user = session.get(User.class, username);
			if (user.getUsername() != null && user.getPassword().equals(password))
				return true;
		} catch (Exception e) {
//			System.out.println(e.getMessage());
		}
		return false;
	}

	/**
	 * Returns user with given username
	 */
	public User getUserDetails(String username) {
		User user = null;
		try (Session session = HibernateUtilities.getSessionInstance()) {
			user = session.get(User.class, username);
		} catch (Exception e) {
//			System.out.println(e.getMessage());
		}
		return user;
	}
}