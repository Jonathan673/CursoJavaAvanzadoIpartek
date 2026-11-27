package com.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import com.excepciones.AccesoDatosException;

public class BibliotecaDAO {
	private final String url; // "jdbc:mysql://localhost:3306/amazonia_2993";
	private final String user; // "root";
	private final String pass; // "1234";

	private Connection con;
	private PreparedStatement pst;

	public BibliotecaDAO(String url, String user, String pass) {
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	public PreparedStatement crearPreparedStatement(String sql) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			return pst;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al crear la sentencia" + sql, e);
		}
	}

	public void cerrarConexion() {
		try {
			if (pst != null) {
				pst.close();
			}
			if (pst != null) {
				con.close();
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al cerrar la conexión", e);
		}
	}

	public <T> Iterable<T> ejecutarConsulta(String sql, Mapeador<T> mapeador, Object... args) {
		// try with resources
		try {
			PreparedStatement pst = crearPreparedStatement(sql);
			int pos = 1;
			for (Object arg : args) {
				pst.setObject(pos++, arg);
			}
			try (ResultSet rs = pst.executeQuery()) {
				ArrayList<T> objetos = new ArrayList<>();

				while (rs.next()) {
					objetos.add(mapeador.mapear(rs));
				}
				return objetos;
			}
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener los productos", e);
		} finally {
			cerrarConexion();
		}

	}

	public <T> Optional<T> ejecutarConsultaUno(String sql, Mapeador<T> mapeador, Object... args) {
		Iterable<T> objetos = ejecutarConsulta(sql, mapeador, args);

		if (objetos.iterator().hasNext()) {
			return Optional.of(objetos.iterator().next());
		}
		return Optional.empty();
	}

//	public Optional<Long> ejecutarCambio(String sql, Object... args) {
//		// try with resources, usaremos ademas prepared statement
//		try {
//			PreparedStatement pst = crearPreparedStatement(sql);
//
//			int pos = 1;
//			for (Object arg : args) {
//				pst.setObject(pos++, arg);
//			}
//
//			regAfectados(pst.executeUpdate());
//
//			ResultSet rs = pst.getGeneratedKeys();
//			rs.next();
//			Long id = rs.getLong(1);
//			return Optional.of(id);
//		} catch (SQLException e) {
//			throw new AccesoDatosException("Error al obtener el producto", e);
//		} finally {
//			cerrarConexion();
//		}
//	}
	public Optional<Long> ejecutarCambio(String sql, Object... args) {
	    try {
	        PreparedStatement pst = crearPreparedStatement(sql);

	        int pos = 1;
	        for (Object arg : args) {
	            pst.setObject(pos++, arg);
	        }

	        regAfectados(pst.executeUpdate());

	        ResultSet rs = pst.getGeneratedKeys();

	        if (rs.next()) {
	            return Optional.of(rs.getLong(1));
	        }

	        return Optional.empty();

	    } catch (SQLException e) {
	        throw new AccesoDatosException("Error al ejecutar el cambio", e);
	    } finally {
	        cerrarConexion();
	    }
	}

	public void regAfectados(int numeroRegistrosModificados) {
		if (numeroRegistrosModificados != 1) {
			throw new AccesoDatosException("¡Se han cambiado %s registros!" + numeroRegistrosModificados);
		}
	}
}
