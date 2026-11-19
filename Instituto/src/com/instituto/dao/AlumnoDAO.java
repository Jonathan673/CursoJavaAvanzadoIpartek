package com.instituto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.instituto.interfaces.AlumnoInterface;
import com.instituto.model.Alumn;

public class AlumnoDAO implements AlumnoInterface{

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
	            alumno.setNumeroExpediente(
	                    resultado.getString("numero_expediente"));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearAlumno(Alumn alumno) {
		// TODO Auto-generated method stub
		
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
