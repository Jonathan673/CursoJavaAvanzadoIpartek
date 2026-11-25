package com.ipartek.formacion.oop.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import com.ipartek.formacion.oop.exceptions.AccesoDatosException;
import com.ipartek.formacion.oop.interfaces.ProductoInterfaceProfesor;
import com.ipartek.formacion.oop.pojos.Producto;

//source override implement methods
public class ProductoDaoProfesor implements ProductoInterfaceProfesor {
	private static final String jdbc_url = "jdbc:mysql://localhost:3306/2993_basico";
	private static final String jdbc_user = "root";
	private static final String jdbc_pass = "1234";

	private static final String SQL_SELECT = "SELECT id_productos, nombre, precio FROM productos";
	private static final String SQL_SELECT_ID = "SELECT id_productos, nombre, precio FROM productos WHERE id_productos = ? ";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio) VALUES(?,?)";
	private static final String SQL_UPDATE = "UPDATE  productos SET nombre=?, precio=? WHERE id_productos = ?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id_productos = ?";

	@Override
	public Iterable<Producto> obtenerTodos() {
		// try with resources
		try (Connection con = DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_pass);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT)) {
			ArrayList<Producto> productos = new ArrayList<>();

			while (rs.next()) {
				productos.add(
						new Producto(rs.getLong("id_productos"), rs.getString("nombre"), rs.getBigDecimal("precio")));
			}
			return productos;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener los productos", e);
		}

	}

	@Override
	public Optional<Producto> obtenerPorId(Long id) {
		// try with resources, usaremos ademas prepared statement
		try (Connection con = DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_pass);
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {

			// metemos el dato en la primera interrogacion de la query
			pst.setLong(1, id);
			// ejecutamos
			ResultSet rs = pst.executeQuery();
			// si hay un registro...
			if (rs.next()) {
				// si hay algo le envio el optional lleno
				return Optional.of(
						new Producto(rs.getLong("id_productos"), rs.getString("nombre"), rs.getBigDecimal("precio")));
			}
			// si no hay nada le envio el optional vacio
			return Optional.empty();

		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener el producto", e);
		}
	}

	@Override
	public Producto insertarProducto(Producto producto) {
		// try with resources, usaremos ademas prepared statement
		try (Connection con = DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_pass);
				PreparedStatement pst = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {

			// metemos el dato en la primera interrogacion de la query
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			// ejecutamos
			int numeroRegistrosModificados = pst.executeUpdate();

			if (numeroRegistrosModificados != 1) {
				throw new AccesoDatosException("¡Se han modificado %s registros!" + numeroRegistrosModificados);
			}
			//obtenemos la key
			ResultSet rs = pst.getGeneratedKeys();
			rs.next();
			Long id = rs.getLong(1);
			producto.setId(id);
			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener el producto", e);
		}
	}
	@Override
	public Producto modificarProducto(Producto producto) {
		// try with resources, usaremos ademas prepared statement
		try (Connection con = DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_pass);
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			
			// metemos el dato en la primera interrogacion de la query
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setLong(3, producto.getId());
			// ejecutamos
			int numeroRegistrosModificados = pst.executeUpdate();
			
			if (numeroRegistrosModificados != 1) {
				throw new AccesoDatosException("¡Se han modificado %s registros!" + numeroRegistrosModificados);
			}

			return producto;
		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener el producto", e);
		}
	}
	@Override
	public void eliminarProducto(Long id) {
		// try with resources, usaremos ademas prepared statement
		try (Connection con = DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_pass);
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

			pst.setLong(1, id);
			// ejecutamos
			int numeroRegistrosModificados = pst.executeUpdate();
			
			if (numeroRegistrosModificados != 1) {
				throw new AccesoDatosException("¡Se han modificado %s registros!" + numeroRegistrosModificados);
			}

		} catch (SQLException e) {
			throw new AccesoDatosException("Error al obtener el producto", e);
		}
	}

}
