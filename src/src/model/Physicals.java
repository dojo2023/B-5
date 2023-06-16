package model;

import java.security.Timestamp;

public class Physicals {
private int physicals_id;
private int users_id;
private int physicals_resistance;
private int physicals_condition ;
private Timestamp created_at;
private Timestamp updated_at;


public Physicals(int physicals_id, int users_id, int physicals_resistance, int physicals_condition,
		Timestamp created_at, Timestamp updated_at) {
	super();
	this.physicals_id = physicals_id;
	this.users_id = users_id;
	this.physicals_resistance = physicals_resistance;
	this.physicals_condition = physicals_condition;
	this.created_at = created_at;
	this.updated_at = updated_at;
}
public Physicals() {
	super();
	this.physicals_id = 0;
	this.users_id = 0;
	this.physicals_resistance = 0;
	this.physicals_condition = 0;
	this.created_at = null;
	this.updated_at = null;
}
public int getPhysicals_id() {
	return physicals_id;
}
public void setPhysicals_id(int physicals_id) {
	this.physicals_id = physicals_id;
}
public int getUsers_id() {
	return users_id;
}
public void setUsers_id(int users_id) {
	this.users_id = users_id;
}
public int getPhysicals_resistance() {
	return physicals_resistance;
}
public void setPhysicals_resistance(int physicals_resistance) {
	this.physicals_resistance = physicals_resistance;
}
public int getPhysicals_condition() {
	return physicals_condition;
}
public void setPhysicals_condition(int physicals_condition) {
	this.physicals_condition = physicals_condition;
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
