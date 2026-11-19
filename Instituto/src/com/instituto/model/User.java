package com.instituto.model;

public abstract class User {
	
	
	private Long id;
	private String nombre;
	private String apellidos;
	private String email;

	
	//constructores
	public User() {
	}

	public User(Long id, String name, String apellidos, String email) {
		this.id = id;
		this.nombre = name;
		this.apellidos = apellidos;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = name;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
