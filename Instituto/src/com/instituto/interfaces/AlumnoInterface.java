package com.instituto.interfaces;

import java.util.List;

import com.instituto.model.Alumn;

public interface AlumnoInterface {
	List<Alumn>listarAlumnos();
	Alumn buscarAlumno(Long id);
	void crearAlumno(Alumn alumno);
	void modificarAlumno(Alumn alumno);
	void eliminarAlumno(Long id);
}
