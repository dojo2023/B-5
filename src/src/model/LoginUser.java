package model;
import java.io.Serializable;

public class LoginUser implements Serializable {
	private String users_name;	// ログイン時のusers_name

	public LoginUser() {
		this(null);
	}
	public LoginUser(String users_name) {
		this.users_name = users_name;
	}
	public String getusers_name() {
		return users_name;
	}
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

}
