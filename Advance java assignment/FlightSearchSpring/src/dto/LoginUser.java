package dto;

import javax.persistence.*;

/**
 * Model class for User
 *
 */
@Entity
@Table(name = "login_users")
public class LoginUser {
	@Id
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "phone")
	private int phone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
