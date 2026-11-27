package com.ipartek.formacion.oop.accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.ipartek.formacion.oop.accesodatos.Configuracion.*;

import com.ipartek.formacion.oop.interfaces.ProductoInterfaceProfesor;
import com.ipartek.formacion.oop.pojos.Producto;

//source override implement methods
public class ProductoDaoProfesor implements ProductoInterfaceProfesor {
//	private static final String PASS = "1234";
//	private static final String USER = "root";
//	private static final String URL = "jdbc:mysql://localhost:3306/2993_basico";
//
//	private JDBCHelper jdbc = new JDBCHelper(URL, USER, PASS);

	private static final String SQL_SELECT = "SELECT id_productos, nombre, precio FROM productos";
	private static final String SQL_SELECT_ID = "SELECT id_productos, nombre, precio FROM productos WHERE id_productos = ? ";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio) VALUES(?,?)";
	private static final String SQL_UPDATE = "UPDATE  productos SET nombre=?, precio=? WHERE id_productos = ?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id_productos = ?";

	//mapeador
	static class MapeadorProducto implements Mapeador<Producto> {

		@Override
		public Producto mapear(ResultSet rs) throws SQLException {
			return new Producto(rs.getLong("id_productos"), rs.getString("nombre"), rs.getBigDecimal("precio"));
		}

	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return JDBC.ejecutarConsulta(SQL_SELECT, new MapeadorProducto());
	}

	@Override
	public Optional<Producto> obtenerPorId(Long id) {
		return JDBC.ejecutarConsultaUno(SQL_SELECT_ID, new MapeadorProducto(), id);
	}

	@Override
	public Producto insertarProducto(Producto producto) {
		producto.setId(JDBC.ejecutarCambio(SQL_INSERT, producto.getNombre(), producto.getPrecio()).get());
		return producto;
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		JDBC.ejecutarCambio(SQL_UPDATE, producto.getNombre(), producto.getPrecio(), producto.getId());
		return producto;
	}

	@Override
	public void eliminarProducto(Long id) {
		JDBC.ejecutarCambio(SQL_DELETE, id);
	}
}
