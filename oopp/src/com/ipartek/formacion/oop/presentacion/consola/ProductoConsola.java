package com.ipartek.formacion.oop.presentacion.consola;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ipartek.formacion.oop.accesodatos.ProductoDao;
import com.ipartek.formacion.oop.pojos.Producto;

public class ProductoConsola {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//		String url = "jdbc:mysql://localhost:3306/2993_basico";
//		String user = "root";
//		String pass = "1234";
//		Connection con = DriverManager.getConnection(url, user, pass);
//		Statement st = con.createStatement();
//
//		int insertHecho = st
//				.executeUpdate("INSERT INTO 2993_basico.productos (nombre, precio) VALUES ('prueba', 234)");
		//// int updateHecho = st / .executeUpdate("UPDATE productos SET
		/// nombre='portatil perfecto',precio=5555.5 WHERE id_productos=1"); / int
		/// deleteHecho = st / .executeUpdate("DELETE FROM productos
		/// WHERE id_productos=3");
//
//
//		ResultSet rs = st.executeQuery("Select * from productos");
//
//		while (rs.next()) {
//			System.out.printf("%1s\t%-20s\t%10s \n", rs.getLong("id_productos"), rs.getString("nombre"),
//					rs.getBigDecimal("precio"));
//		}

		int opcion;

		IO.println("""

				Menú:
				----
				1- Ver la lista de productos.
				2- Buscar producto.
				3- Nuevo producto.
				4- Modificar producto.
				5- Eliminar producto.

				0- Salir del programa.

				""");

		opcion = Integer
				.parseInt(IO.readln("Selecciona una opción entre 1 y 5. \nPulsa 0 si quieres salir del programa"));

		switch (opcion) {
		case 1 -> listaProductos();
		case 2 -> buscarProducto();
		case 3 -> nuevoProducto();
		case 4 -> modificarProducto();
		case 5 -> eliminarProducto();
		default -> IO.println("Respuesta no válida");
		}

	}

	private static void listaProductos() {
		ProductoDao productos = new ProductoDao();

		for (Producto producto : productos.listarProductos()) {
			IO.println("\nId: " + producto.getId());
			IO.println("Nombre: " + producto.getNombre());
			IO.println("Descripción: " + producto.getPrecio() + "\n");
		}
	}

	private static void buscarProducto() {
		ProductoDao producto = new ProductoDao();

		Producto productoEncontrado = producto
				.buscarProducto(Long.parseLong(IO.readln("Introduce el id del producto: ")));
		// meter un control por si no mete el numero esperado
		IO.println("\nNombre: " + productoEncontrado.getNombre());
		IO.println("Descripción: " + productoEncontrado.getPrecio() + "\n");

	}

	private static void nuevoProducto() {
		ProductoDao productoDao = new ProductoDao();
		Producto producto = new Producto();
		producto.setNombre(IO.readln("Introduce el nombre del producto: "));
		producto.setPrecio(new BigDecimal(IO.readln("Introduce el precio del producto: ")));
		productoDao.insertarProducto(producto);
	}

	private static void modificarProducto() {
		ProductoDao productoDao = new ProductoDao();
		Producto producto = new Producto();

		producto.setId(Long.parseLong(IO.readln("Introduce el ID del producto que quieres modificar: ")));

		producto.setNombre(IO.readln("Introduce el nuevo nombre: "));

		producto.setPrecio(new BigDecimal(IO.readln("Introduce el nuevo precio: ")));

		productoDao.modificarProducto(producto);
	}

	private static void eliminarProducto() {
		ProductoDao productoDao = new ProductoDao();
		productoDao.eliminarProducto(Long.parseLong(IO.readln("Introduce el id del producto que quieres eliminar: ")));
	}

}
