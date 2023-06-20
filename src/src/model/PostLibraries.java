package model;

import java.io.Serializable;

public class PostLibraries implements Serializable {
	// 図鑑投稿用フィールド
	private String post_description;
	private String post_genre;
	private String post_kind;
	private String post_alcon;
	private String post_from;
	private String post_remarks;

	// 図鑑の投稿機能のセッションスコープ格納
	public PostLibraries(String post_description, String post_genre, String post_kind,
			String post_alcon, String post_from, String post_remarks) {
		super();
		this.post_description = post_description;
		this.post_genre = post_genre;
		this.post_kind = post_kind;
		this.post_alcon = post_alcon;
		this.post_from = post_from;
		this.post_remarks = post_remarks;
	}

	// 図鑑投稿用セッターゲッター

	public String getPost_description() {
		return post_description;
	}

	public void setPost_description(String post_description) {
		this.post_description = post_description;
	}

	public String getPost_genre() {
		return post_genre;
	}

	public void setPost_genre(String post_genre) {
		this.post_genre = post_genre;
	}

	public String getPost_kind() {
		return post_kind;
	}

	public void setPost_kind(String post_kind) {
		this.post_kind = post_kind;
	}

	public String getPost_alcon() {
		return post_alcon;
	}

	public void setPost_alcon(String post_alcon) {
		this.post_alcon = post_alcon;
	}

	public String getPost_from() {
		return post_from;
	}

	public void setPost_from(String post_from) {
		this.post_from = post_from;
	}

	public String getPost_remarks() {
		return post_remarks;
	}

	public void setPost_remarks(String post_remarks) {
		this.post_remarks = post_remarks;
	}


}
