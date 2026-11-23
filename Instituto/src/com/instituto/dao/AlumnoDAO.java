package com.instituto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.instituto.interfaces.AlumnoInterface;
import com.instituto.model.Alumn;

public class AlumnoDAO implements AlumnoInterface {

	@Override
	public List<Alumn> listarAlumnos() {
		List<Alumn> listaAlumnos = new ArrayList<>();

		String sql = """
				SELECT u.id, u.nombre, u.apellidos, u.email,
				       a.numero_expediente, a.curso
				FROM usuarios u
				INNER JOIN alumnos a ON u.id = a.usuario_id
				ORDER BY u.id
				""";

		try (Connection conexion = ConexionDB.getConnection();
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				ResultSet resultado = sentencia.executeQuery()) {

			while (resultado.next()) {

				Alumn alumno = new Alumn();

				alumno.setId(resultado.getLong("id"));
				alumno.setName(resultado.getString("nombre"));
				alumno.setApellidos(resultado.getString("apellidos"));
				alumno.setEmail(resultado.getString("email"));
				alumno.setNumeroExpediente(resultado.getString("numero_expediente"));
				alumno.setCurso(resultado.getString("curso"));

				listaAlumnos.add(alumno);
			}

		} catch (SQLException e) {
			System.out.println("Error al listar alumnos: " + e.getMessage());
		}

		return listaAlumnos;
	}

	@Override
	public Alumn buscarAlumno(Long id) {
		String sqlId = "SELECT * FROM usuarios u INNER JOIN alumnos a ON u.id = a.usuario_id where usuario_id = ?";
		Alumn alumno = null;
		try (Connection conexion = ConexionDB.getConnection();
				PreparedStatement sentencia = conexion.prepareStatement(sqlId)) {

			sentencia.setLong(1, id);

			try (ResultSet resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					alumno = new Alumn();
					alumno.setId(resultado.getLong("id"));
					alumno.setName(resultado.getString("nombre"));
					alumno.setApellidos(resultado.getString("apellidos"));
					alumno.setEmail(resultado.getString("email"));
					alumno.setNumeroExpediente(resultado.getString("numero_expediente"));
					alumno.setCurso(resultado.getString("curso"));
				}
			}
		} catch (SQLException e) {
			System.out.println("Error al buscar al alumno: " + e.getMessage());
		}
		return alumno;

	}

	@Override
	public void crearAlumno(Alumn alumno) {
		// TODO Auto-generated method stub

	    String sqlUsuario = """
	            INSERT INTO usuarios (nombre, apellidos, email)
	            VALUES (?, ?, ?)
	            """;

	    String sqlAlumno = """
	            INSERT INTO alumnos (usuario_id, numero_expediente, curso)
	            VALUES (?, ?, ?)
	            """;

	    Connection conexion = null;

	    try {
	        conexion = ConexionDB.getConnection();
	        conexion.setAutoCommit(false);

	        // 1. Insertamos el usuario
	        try (PreparedStatement sentenciaUsuario =
	                conexion.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS)) {

	            sentenciaUsuario.setString(1, alumno.getName());
	            sentenciaUsuario.setString(2, alumno.getApellidos());
	            sentenciaUsuario.setString(3, alumno.getEmail());

	            sentenciaUsuario.executeUpdate();

	            // Recuperamos el ID generado
	            try (ResultSet resultado = sentenciaUsuario.getGeneratedKeys()) {

	                if (resultado.next()) {
	                    long idUsuario = resultado.getLong(1);

	                    // 2. Insertamos el alumno con el ID del usuario
	                    try (PreparedStatement sentenciaAlumno =
	                            conexion.prepareStatement(sqlAlumno)) {

	                        sentenciaAlumno.setLong(1, idUsuario);
	                        sentenciaAlumno.setString(2, alumno.getNumeroExpediente());
	                        sentenciaAlumno.setString(3, alumno.getCurso());

	                        sentenciaAlumno.executeUpdate();
	                    }

	                } else {
	                    throw new SQLException("No se pudo recuperar el ID del usuario");
	                }
	            }
	        }

	        // 3. Confirmamos ambas operaciones
	        conexion.commit();

	        System.out.println("Alumno creado correctamente");

	    } catch (SQLException e) {

	        System.out.println("Error al crear alumno: " + e.getMessage());

	        if (conexion != null) {
	            try {
	                conexion.rollback();
	            } catch (SQLException ex) {
	                System.out.println("Error al hacer rollback: " + ex.getMessage());
	            }
	        }

	    } finally {
	        if (conexion != null) {
	            try {
	                conexion.setAutoCommit(true);
	                conexion.close();
	            } catch (SQLException e) {
	                System.out.println("Error al cerrar conexión: " + e.getMessage());
	            }
	        }
	    }
	}

	@Override
	public void modificarAlumno(Alumn alumno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarAlumno(Long id) {
		// TODO Auto-generated method stub

	}

}
