package model;
import java.io.Serializable;

public class LoginId implements Serializable {
	private int users_id;	// ID

	public LoginId(int users_id) {
		this.users_id = users_id;
	}
	public LoginId() {
		this.users_id = 0;
	}
	public int getUsers_id() {
		return users_id;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

}
