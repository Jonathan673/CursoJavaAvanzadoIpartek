package com.ipartek.formacion.oop.presentacion.consola;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.ipartek.formacion.oop.accesodatos.ProductoDaoProfesor;
import com.ipartek.formacion.oop.interfaces.ProductoInterfaceProfesor;
import com.ipartek.formacion.oop.pojos.Producto;

public class ProductoConsolaProfesor {

	public static void main(String[] args) throws SQLException {
//		ProductoInterfaceProfesor dao = new DaoProductoTreeMap();
		ProductoInterfaceProfesor dao = new ProductoDaoProfesor();
		
		
//		System.out.println(dao.insertarProducto(new Producto("mesa",new BigDecimal("1234.5"))));
		dao.insertarProducto(new Producto("mesa656",new BigDecimal("1234.5")));
//		dao.modificarProducto(new Producto(24L,"nuevokl2",new BigDecimal("1234.5")));
		try {
			dao.eliminarProducto(28L);
		} catch (Exception e) {
			System.out.println("No existe ese usuario para borrarlo");
		}
		
		for(Producto producto:dao.obtenerTodos()) {
			System.out.println(producto);
		}
		
		System.out.println(dao.obtenerPorId(2L));
	}

}
