package model;
import java.io.Serializable;

public class LoginId implements Serializable {
	private String users_id;	// ID

	public LoginId(String users_id) {
		this.users_id = users_id;
	}
	public LoginId() {
		this.users_id = "";
	}
	public String getUsers_id() {
		return users_id;
	}
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}

}
