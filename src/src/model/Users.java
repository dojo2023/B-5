package model;
import java.sql.Timestamp;


public class Users {
private int users_id;
private String users_name;
private String users_password;
private String users_birthday;
private Timestamp created_at;
private Timestamp updated_at;


public Users(int users_id, String users_name, String users_password, String users_birthday, Timestamp created_at,
		Timestamp updated_at) {
	super();
	this.users_id = users_id;
	this.users_name = users_name;
	this.users_password = users_password;
	this.users_birthday = users_birthday;
	this.created_at = created_at;
	this.updated_at = updated_at;
}

public Users() {
	super();
	this.users_id = 0;
	this.users_name = "";
	this.users_password = "";
	this.users_birthday = "";
	this.created_at = null;
	this.updated_at = null;
}

public int getUsers_id() {
	return users_id;
}

public void setUsers_id(int users_id) {
	this.users_id = users_id;
}

public String getUsers_name() {
	return users_name;
}

public void setUsers_name(String users_name) {
	this.users_name = users_name;
}

public String getUsers_password() {
	return users_password;
}

public void setUsers_password(String users_password) {
	this.users_password = users_password;
}

public String getUsers_birthday() {
	return users_birthday;
}

public void setUsers_birthday(String users_birthday) {
	this.users_birthday = users_birthday;
}

public Timestamp getCreated_at() {
	return created_at;
}

public void setCreated_at(Timestamp created_at) {
	this.created_at = created_at;
}

public Timestamp getUpdated_at() {
	return updated_at;
}

public void setUpdated_at(Timestamp updated_at) {
	this.updated_at = updated_at;
}

}
