package model;
import java.io.Serializable;

public class Id implements Serializable {
	private String id;	// ID

	public Id(String id) {
		this.id = id;
	}
	public Id() {
		this.id = "";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
