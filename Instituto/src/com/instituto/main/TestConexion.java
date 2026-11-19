
package com.instituto.main;

import java.util.List;

import com.instituto.dao.AlumnoDAO;
import com.instituto.model.Alumn;

public class TestConexion {

    public static void main(String[] args) {

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
