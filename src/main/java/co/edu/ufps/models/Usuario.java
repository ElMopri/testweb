package co.edu.ufps.models;

import java.util.Date;

import lombok.Data;

@Data
public class Usuario {
	
	private String username;
	private String name;
	private String email;
	private Date dateCreated;
	private String state;
	
	public Usuario() {
		this(null,null,null,null,null);
	}

	public Usuario(String string, String string2, String string3, Date date, String string4) {
		this.username = string;
		this.name = string2;
		this.email = string3;
		this.dateCreated = date;
		this.state = string4;
	}

}
