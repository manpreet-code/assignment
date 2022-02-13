package daoImpl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import dao.Dao;
import dao.LoginDao;
import dto.LoginUser;

public class LoginDaoImpl implements LoginDao{
	@Autowired
	private Dao dao;

	public LoginUser getUserDetails(String username) {
		LoginUser user = null;
		dao.begin();
		user = (LoginUser) dao.getSession().get(LoginUser.class, username);
		dao.commit();
		dao.close();
		return user;
	}
	
	public void updatePassword(String username, String password) {
		LoginUser user = null;
		dao.begin();
		Session session = dao.getSession();
		user = session.get(LoginUser.class, username);
		System.out.println("in dao");
		user.setPassword(password);
		session.update(user);
		dao.commit();
		dao.close();
	}
	
	public void signup(LoginUser user) {
		dao.begin();
		Session session = dao.getSession();
		session.save(user);
		session.getTransaction();
		dao.commit();
		dao.close();
	}

}
