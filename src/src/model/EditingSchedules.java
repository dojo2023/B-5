package model;

import java.io.Serializable;

public class EditingSchedules implements Serializable {
	// スケジュール編集用フィールド
	private int editing_schedules_id;
	private String editing_schedules_name;
	private String editing_schedules_dt;
	private int editing_schedules_users_id;

	// スケジュール追加用セッションスコープ格納
			public EditingSchedules(String editing_schedules_name, String editing_schedules_schedules_dt,
					int editing_schedules_users_id) {
				super();
				this.editing_schedules_name = editing_schedules_name;
				this.editing_schedules_dt = editing_schedules_schedules_dt;
				this.editing_schedules_users_id = editing_schedules_users_id;
			}
		// スケジュール編集用セッションスコープ格納
			public EditingSchedules(int editing_schedules_id, String editing_schedules_name,
					String editing_schedules_dt) {
				super();
				this.editing_schedules_id = editing_schedules_id;
				this.editing_schedules_name = editing_schedules_name;
				this.editing_schedules_dt = editing_schedules_dt;
			}

	public int getEditing_schedules_id() {
		return editing_schedules_id;
	}
	public void setEditing_schedules_id(int editing_schedules_id) {
		this.editing_schedules_id = editing_schedules_id;
	}
	public String getEditing_schedules_name() {
		return editing_schedules_name;
	}
	public void setEditing_schedules_name(String editing_schedules_name) {
		this.editing_schedules_name = editing_schedules_name;
	}
	public String getEditing_schedules_dt() {
		return editing_schedules_dt;
	}
	public void setEditing_schedules_dt(String editing_schedules_dt) {
		this.editing_schedules_dt = editing_schedules_dt;
	}
	public int getEditing_schedules_users_id() {
		return editing_schedules_users_id;
	}
	public void setEditing_schedules_users_id(int editing_schedules_users_id) {
		this.editing_schedules_users_id = editing_schedules_users_id;
	}

}