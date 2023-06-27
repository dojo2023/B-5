package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class PostCounts implements Serializable {
	//集計投稿用フィールド
	private int all_member;
	private int users_member;

	private ArrayList<String> name_list;
	private ArrayList<String> birthday_list;
	private ArrayList<String> counts_list;
	
	private Timestamp created_at;
	private Timestamp updated_at;
	
	
	public PostCounts() {
		super();
		
	}
	//ゲッターセッター


	public int getAll_member() {
		return all_member;
	}


	public void setAll_member(int all_member) {
		this.all_member = all_member;
	}


	public int getUsers_member() {
		return users_member;
	}


	public void setUsers_member(int users_member) {
		this.users_member = users_member;
	}


	public ArrayList<String> getName_list() {
		return name_list;
	}


	public void setName_list(ArrayList<String> name_list) {
		this.name_list = name_list;
	}


	public ArrayList<String> getBirthday_list() {
		return birthday_list;
	}


	public void setBirthday_list(ArrayList<String> birthday_list) {
		this.birthday_list = birthday_list;
	}


	public ArrayList<String> getCounts_list() {
		return counts_list;
	}


	public void setCounts_list(ArrayList<String> counts_list) {
		this.counts_list = counts_list;
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
