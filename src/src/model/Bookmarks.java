package model;

import java.security.Timestamp;

public class Bookmarks {
private int bookmarks_id;
private int libraries_id;
private int users_id;
private String bookmarks_remarks;
private Timestamp created_at;
private Timestamp updated_at;


public Bookmarks(int bookmarks_id, int libraries_id, int users_id, String bookmarks_remarks, Timestamp created_at,
		Timestamp updated_at) {
	super();
	this.bookmarks_id = bookmarks_id;
	this.libraries_id = libraries_id;
	this.users_id = users_id;
	this.bookmarks_remarks = bookmarks_remarks;
	this.created_at = created_at;
	this.updated_at = updated_at;
}
public Bookmarks() {
	super();
	this.bookmarks_id = 0;
	this.libraries_id = 0;
	this.users_id = 0;
	this.bookmarks_remarks = "";
	this.created_at = null;
	this.updated_at = null;
}
public int getBookmarks_id() {
	return bookmarks_id;
}
public void setBookmarks_id(int bookmarks_id) {
	this.bookmarks_id = bookmarks_id;
}
public int getLibraries_id() {
	return libraries_id;
}
public void setLibraries_id(int libraries_id) {
	this.libraries_id = libraries_id;
}
public int getUsers_id() {
	return users_id;
}
public void setUsers_id(int users_id) {
	this.users_id = users_id;
}
public String getBookmarks_remarks() {
	return bookmarks_remarks;
}
public void setBookmarks_remarks(String bookmarks_remarks) {
	this.bookmarks_remarks = bookmarks_remarks;
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
