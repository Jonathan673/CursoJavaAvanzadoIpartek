package com.accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.accesodatos.Configuracion.*;

import com.interfaces.DaoProductoInterface;
import com.pojos.Producto;

public class DaoProductosImplementacion implements DaoProductoInterface{
//	private static final String SQL_SELECT = "SELECT id, nombre, precio FROM productos";
//	private static final String SQL_SELECT_ID = "SELECT id, nombre, precio FROM productos WHERE id = ? ";
//	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio) VALUES(?,?)";
//	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=? WHERE id = ?";
//	private static final String SQL_DELETE = "DELETE FROM productos WHERE id = ?";
	
	//mapeador
	static class MapeadorProducto implements Mapeador<Producto> {
		
		@Override
		public Producto mapear(ResultSet rs) throws SQLException {
			return new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"));
		}
		
	}

	@Override
	public Optional<Producto> obtenerPorId(Long id) {
		return JDBC.ejecutarConsultaUno(SQL_SELECT_ID, new MapeadorProducto(), id);
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return JDBC.ejecutarConsulta(SQL_SELECT, new MapeadorProducto());
	}

	@Override
	public Producto insertar(Producto producto) {
		producto.setId(JDBC.ejecutarCambio(SQL_INSERT, producto.getNombre(), producto.getPrecio()).get());
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		JDBC.ejecutarCambio(SQL_UPDATE, producto.getNombre(), producto.getPrecio(), producto.getId());
		return producto;
	}

	@Override
	public void eliminar(Long id) {
		JDBC.ejecutarCambio(SQL_DELETE, id);
	}

}
