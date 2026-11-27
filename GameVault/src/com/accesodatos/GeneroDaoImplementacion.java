package com.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.excepciones.AccesoDatosException;
import com.interfaces.GeneroInterface;
import com.pojos.Genero;

public class GeneroDaoImplementacion implements GeneroInterface {
	private final static String SQL_SELECT_ALL = "SELECT * FROM generos";
	private final static String SQL_SELECT_ID = "SELECT nombre FROM generos WHERE id=?";
	private final static String SQL_INSERT = "INSERT INTO generos (nombre) VALUES(?)";
	private final static String SQL_UPDETE = "UPDATE generos SET nombre WHERE id = ?";
	private final static String SQL_DELETE = "DELETE FROM generos WHERE id = ?";

	@Override
	public Iterable<Genero> obtenerTodos() {
		try (Connection con = ConexionBBDD.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ALL);
				ResultSet rs = pst.executeQuery()) {
			ArrayList<Genero> generos = new ArrayList<>();
			while (rs.next()) {
				generos.add(new Genero(rs.getLong("id"), rs.getString("nombre")));
			}
			return generos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener los generos", e);
		}
	}

	@Override
	public Genero buscarGenero(Long id) {
		try (Connection con = ConexionBBDD.getConnection();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				ResultSet rs = pst.executeQuery()) {
			pst.setLong(1, id);
			Genero genero = null;
			while (rs.next()) {
//				genero = new Genero(null,rs.getString("nombre"));
//				genero = sentencia.setString(1, producto.getNombre());
			}
			return genero;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener los generos", e);
		}
	}

	@Override
	public Genero insertarGenero(Genero genero) {
		try (Connection conexion = ConexionBBDD.getConnection();
				PreparedStatement sentencia = conexion.prepareStatement(SQL_INSERT)) {

			sentencia.setString(1, genero.getNombre());

			sentencia.executeUpdate();

			IO.println("Se ha insertado el genero correctamente");
//			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar el genero: " + e.getMessage());
		}
		return genero;
	}

	@Override
	public Genero modificarGenero(Genero genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarGenero(Long id) {
		try (Connection conexion = ConexionBBDD.getConnection();
				PreparedStatement sentencia = conexion.prepareStatement(SQL_DELETE)) {

			sentencia.setLong(1, id);

			sentencia.executeUpdate();

			IO.println("Se ha eliminado el genero correctamente");
//			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error al eliminar el genero: " + e.getMessage());
		}
	}

}
