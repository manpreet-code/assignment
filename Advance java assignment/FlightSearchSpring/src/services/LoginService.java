package services;

import org.springframework.beans.factory.annotation.Autowired;

import dao.LoginDao;
import dto.LoginUser;

/**
 * Class used to provide Service<p>
 * layer for Login related functionalities.
 *
 */
public class LoginService {
	@Autowired
	private LoginDao logindao;

	/**
	 * Returns true if User is authentic<p>
	 * , false otherwise.
	 * @param username : String
	 * @param password : String
	 * @return
	 */
	public Boolean loginAuthentication(String username, String password) {

		LoginUser user = (LoginUser) logindao.getUserDetails(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	/**
	 * Signs Up A  New User
	 * @param username : String
	 * @param password : String
	 * @param phone : int
	 */
	public void signUp(String username, String password, int phone) {

		LoginUser user = new LoginUser();
		user.setPassword(password);
		user.setPhone(phone);
		user.setUsername(username);
		logindao.signup(user);
	}

	/**
	 * Updates User Password in case<p>
	 * User forgets.
	 * @param username : String
	 * @param password : String
	 * @param phone : int
	 */
	public void forgetPassword(String username, String password , int phone) {
		LoginUser user = (LoginUser) logindao.getUserDetails(username);
		if (user != null && user.getPhone()==phone) {
			logindao.updatePassword(username, password);
		}
	}
}
