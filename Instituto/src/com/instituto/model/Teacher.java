package com.instituto.model;

public class Teacher extends User{
	private String especialidad;
	private String departamento;

	public Teacher() {
		super();

	}

	public Teacher(String especialidad, String departamento) {
		super();
		this.setEspecialidad(especialidad);
		this.setDepartamento(departamento);
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

}
