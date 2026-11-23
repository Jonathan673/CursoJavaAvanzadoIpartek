
package com.instituto.main;

import java.util.List;

import com.instituto.dao.AlumnoDAO;
import com.instituto.model.Alumn;

public class TestConexion {

	public static void main(String[] args) {

		int opcion;

		IO.println("""

				Menú:
				----
				1- Ver lista de alumnos.
				2- Buscar alumno.
				3- Dar de alta a un alumno.
				4- Modificar datos de un alumno.
				5- Dar de baja a un alumno.

				0- Salir del programa.

				""");

		opcion = Integer
				.parseInt(IO.readln("Selecciona una opción entre 1 y 5. \nPulsa 0 si quieres salir del programa"));

		switch (opcion) {
		case 1 -> listaAlumnos();
		case 2 -> buscarAlumnos();
		case 3 -> AltaAlumnos();
//		case 4 -> modificarAlumnos();
//		case 5 -> eliminarAlumno();
		default -> IO.println("Respuesta no válida");
		}

	}

	private static void AltaAlumnos() {
		AlumnoDAO alumnoDAO = new AlumnoDAO();

		Alumn alumno = new Alumn();

		alumno.setName(IO.readln("Introduce el nombre: "));
		alumno.setApellidos(IO.readln("Introduce los apellidos: "));
		alumno.setEmail(IO.readln("Introduce el email: "));
		alumno.setNumeroExpediente(IO.readln("Introduce el expediente: "));
		alumno.setCurso(IO.readln("Introduce el curso: "));

		alumnoDAO.crearAlumno(alumno);

		System.out.println("Alumno dado de alta correctamente, Bienvenido "+ alumno.getName());
	}

	private static void buscarAlumnos() {
		// TODO Auto-generated method stub
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		Long idRecibido = Long.parseLong(IO.readln("Introduce el id del alumno: "));
		Alumn alumno = alumnoDAO.buscarAlumno(idRecibido);
		System.out.println("----------------------------");
		System.out.println("ID: " + alumno.getId());
		System.out.println("Nombre: " + alumno.getName());
		System.out.println("Apellidos: " + alumno.getApellidos());
		System.out.println("Email: " + alumno.getEmail());
		System.out.println("Expediente: " + alumno.getNumeroExpediente());
		System.out.println("Curso: " + alumno.getCurso());
	}

	public static void listaAlumnos() {
		// Creamos el DAO
		AlumnoDAO alumnoDAO = new AlumnoDAO();

		// Obtenemos todos los alumnos
		List<Alumn> alumnos = alumnoDAO.listarAlumnos();

		// Mostramos los resultados
		System.out.println("===== LISTADO DE ALUMNOS =====");

		if (alumnos.isEmpty()) {

			System.out.println("No hay alumnos registrados.");

		} else {

			for (Alumn alumno : alumnos) {

				System.out.println("----------------------------");
				System.out.println("ID: " + alumno.getId());
				System.out.println("Nombre: " + alumno.getName());
				System.out.println("Apellidos: " + alumno.getApellidos());
				System.out.println("Email: " + alumno.getEmail());
				System.out.println("Expediente: " + alumno.getNumeroExpediente());
				System.out.println("Curso: " + alumno.getCurso());
			}
		}

		System.out.println("==============================");
	}
}
