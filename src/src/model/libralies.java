package model;

import java.security.Timestamp;

public class libralies {
private int libraries_id;
private String libraries_name;
private String libraries_genre;
private String libraries_kind;
private double libraries_alcon;
private String libraries_from;
private String libraries_remarks;
private boolean libraries_public;
private Timestamp created_at;
private Timestamp updated_at;


public libralies(int libraries_id, String libraries_name, String libraries_genre, String libraries_kind,
		double libraries_alcon, String libraries_from, String libraries_remarks, boolean libraries_public,
		Timestamp created_at, Timestamp updated_at) {
	super();
	this.libraries_id = libraries_id;
	this.libraries_name = libraries_name;
	this.libraries_genre = libraries_genre;
	this.libraries_kind = libraries_kind;
	this.libraries_alcon = libraries_alcon;
	this.libraries_from = libraries_from;
	this.libraries_remarks = libraries_remarks;
	this.libraries_public = libraries_public;
	this.created_at = created_at;
	this.updated_at = updated_at;
}
public libralies() {
	super();
	this.libraries_id = 0;
	this.libraries_name = "";
	this.libraries_genre = "";
	this.libraries_kind ="";
	this.libraries_alcon = 0;
	this.libraries_from = "";
	this.libraries_remarks = "";
	this.libraries_public = false;
	this.created_at =null;
	this.updated_at =null;
}
public int getLibraries_id() {
	return libraries_id;
}
public void setLibraries_id(int libraries_id) {
	this.libraries_id = libraries_id;
}
public String getLibraries_name() {
	return libraries_name;
}
public void setLibraries_name(String libraries_name) {
	this.libraries_name = libraries_name;
}
public String getLibraries_genre() {
	return libraries_genre;
}
public void setLibraries_genre(String libraries_genre) {
	this.libraries_genre = libraries_genre;
}
public String getLibraries_kind() {
	return libraries_kind;
}
public void setLibraries_kind(String libraries_kind) {
	this.libraries_kind = libraries_kind;
}
public double getLibraries_alcon() {
	return libraries_alcon;
}
public void setLibraries_alcon(double libraries_alcon) {
	this.libraries_alcon = libraries_alcon;
}
public String getLibraries_from() {
	return libraries_from;
}
public void setLibraries_from(String libraries_from) {
	this.libraries_from = libraries_from;
}
public String getLibraries_remarks() {
	return libraries_remarks;
}
public void setLibraries_remarks(String libraries_remarks) {
	this.libraries_remarks = libraries_remarks;
}
public boolean isLibraries_public() {
	return libraries_public;
}
public void setLibraries_public(boolean libraries_public) {
	this.libraries_public = libraries_public;
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
