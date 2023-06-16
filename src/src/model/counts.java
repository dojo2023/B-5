package model;
import java.security.Timestamp;
import java.util.Date;

public class counts {
private int counts_id;
private int users_id;
private int counts_alcohol;
private Date counts_date;
private Timestamp created_at;
private Timestamp updated_at;


public counts(int counts_id, int users_id, int counts_alcohol, Date counts_date, Timestamp created_at,
		Timestamp updated_at) {
	super();
	this.counts_id = counts_id;
	this.users_id = users_id;
	this.counts_alcohol = counts_alcohol;
	this.counts_date = counts_date;
	this.created_at = created_at;
	this.updated_at = updated_at;
}
public counts() {
	super();
	this.counts_id = 0;
	this.users_id = 0;
	this.counts_alcohol = 0;
	this.counts_date = null;
	this.created_at = null;
	this.updated_at = null;
}
public int getCounts_id() {
	return counts_id;
}
public void setCounts_id(int counts_id) {
	this.counts_id = counts_id;
}
public int getUsers_id() {
	return users_id;
}
public void setUsers_id(int users_id) {
	this.users_id = users_id;
}
public int getCounts_alcohol() {
	return counts_alcohol;
}
public void setCounts_alcohol(int counts_alcohol) {
	this.counts_alcohol = counts_alcohol;
}
public Date getCounts_date() {
	return counts_date;
}
public void setCounts_date(Date counts_date) {
	this.counts_date = counts_date;
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
