package dao;

import dto.LoginUser;

/**
 * Deals with User Login related queries<p>
 * like getting details, updating password and signup.
 *
 */
public interface LoginDao {
	LoginUser getUserDetails(String username);

	void updatePassword(String username, String password);

	void signup(LoginUser user);
}
