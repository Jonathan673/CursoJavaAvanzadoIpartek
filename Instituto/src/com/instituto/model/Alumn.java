package com.instituto.model;

public class Alumn extends User{
	private String numeroExpediente;
	private String curso;

	// constructores
	public Alumn() {
		super();
	}

	public Alumn(String numeroExpediente, String curso) {
		super();
		this.setNumeroExpediente(numeroExpediente);
		this.setCurso(curso);
	}

	public String getNumeroExpediente() {
		return numeroExpediente;
	}

	public void setNumeroExpediente(String string) {
		this.numeroExpediente = string;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
