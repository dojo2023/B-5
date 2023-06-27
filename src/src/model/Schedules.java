package model;

import java.sql.Timestamp;

public class Schedules {
	private int schedules_id;
	private String schedules_name;
	private Timestamp schedules_dt;
	private String schedules_date;
	private String schedules_time;
	private int users_id;
	private Timestamp created_at;
	private Timestamp updated_at;

	public Schedules(int schedules_id, String schedules_name, Timestamp schedules_dt, int users_id,
			Timestamp created_at,
			Timestamp updated_at) {
		super();
		this.schedules_id = schedules_id;
		this.schedules_name = schedules_name;
		this.schedules_dt = schedules_dt;
		this.users_id = users_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Schedules(int schedules_id, String schedules_name, Timestamp schedules_dt, String schedules_date, String schedules_time, int users_id) {
		super();
		this.schedules_id = schedules_id;
		this.schedules_name = schedules_name;
		this.schedules_dt = schedules_dt;
		this.schedules_date = schedules_date;
		this.schedules_time = schedules_time;
		this.users_id = users_id;
	}

	public Schedules() {
		super();
		this.schedules_id = 0;
		this.schedules_name = "";
		this.schedules_dt = null;
		this.users_id = 0;
		this.created_at = null;
		this.updated_at = null;

	}

	public int getSchedules_id() {
		return schedules_id;
	}

	public void setSchedules_id(int schedules_id) {
		this.schedules_id = schedules_id;
	}

	public String getSchedules_name() {
		return schedules_name;
	}

	public void setSchedules_name(String schedules_name) {
		this.schedules_name = schedules_name;
	}

	public Timestamp getSchedules_dt() {
		return schedules_dt;
	}

	public void setSchedules_dt(Timestamp schedules_dt) {
		this.schedules_dt = schedules_dt;
	}

	public String getSchedules_date() {
		return schedules_date;
	}

	public void setSchedules_date(String schedules_date) {
		this.schedules_date = schedules_date;
	}

	public String getSchedules_time() {
		return schedules_time;
	}

	public void setSchedules_time(String schedules_time) {
		this.schedules_time = schedules_time;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
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
