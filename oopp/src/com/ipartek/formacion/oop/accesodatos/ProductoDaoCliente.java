package com.ipartek.formacion.oop.accesodatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static com.ipartek.formacion.oop.accesodatos.Configuracion.*;

import com.ipartek.formacion.oop.interfaces.ProductoInterfaceCliente;
import com.ipartek.formacion.oop.pojos.Cliente;

//source override implement methods
public class ProductoDaoCliente implements ProductoInterfaceCliente {

//	private static final String SQL_SELECT = "SELECT id, nombre, apellidos, nif FROM clientes";
//	private static final String SQL_SELECT_ID = "SELECT id, nombre, apellidos, nif FROM clientes WHERE id = ? ";
//	private static final String SQL_INSERT = "INSERT INTO clientes (nombre, apellidos, nif) VALUES(?,?,?)";
//	private static final String SQL_UPDATE = "UPDATE clientes SET nombre=?, apellidos=?, nif=? WHERE id = ?";
//	private static final String SQL_DELETE = "DELETE FROM clientes WHERE id = ?";
//	private static final String SQL_SELECT = "SELECT id, nombre, apellidos, nif FROM clientes";
//	private static final String SQL_SELECT_ID = "SELECT id, nombre, apellidos, nif FROM clientes WHERE id = ? ";
//	private static final String SQL_INSERT = "INSERT INTO clientes (nombre, apellidos, nif) VALUES(?,?,?)";
//	private static final String SQL_UPDATE = "UPDATE clientes SET nombre=?, apellidos=?, nif=? WHERE id = ?";
//	private static final String SQL_DELETE = "DELETE FROM clientes WHERE id = ?";

	//mapeador
	static class MapeadorCliente implements Mapeador<Cliente> {

		@Override
		public Cliente mapear(ResultSet rs) throws SQLException {
			return new Cliente(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellidos"),rs.getString("nif"));
		}

	}

	@Override
	public Iterable<Cliente> obtenerTodos() {
		return JDBC.ejecutarConsulta(SQL_SELECT, new MapeadorCliente());
	}

	@Override
	public Optional<Cliente> obtenerPorId(Long id) {
		return JDBC.ejecutarConsultaUno(SQL_SELECT_ID, new MapeadorCliente(), id);
	}

	@Override
	public Cliente insertarProducto(Cliente cliente) {
		cliente.setId(JDBC.ejecutarCambio(SQL_INSERT, cliente.getNombre(), cliente.getApellidos(), cliente.getNif()).get());
		return cliente;
	}

	@Override
	public Cliente modificarProducto(Cliente cliente) {
		JDBC.ejecutarCambio(SQL_UPDATE, cliente.getNombre(), cliente.getApellidos(), cliente.getNif());
		return cliente;
	}

	@Override
	public void eliminarProducto(Long id) {
		JDBC.ejecutarCambio(SQL_DELETE, id);
	}
}
