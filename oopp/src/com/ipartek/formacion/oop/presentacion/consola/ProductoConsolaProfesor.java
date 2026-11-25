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
		dao.insertarProducto(new Producto("mesa",new BigDecimal("1234.5")));
//		dao.modificarProducto(new Producto(12L,"nuevo2",new BigDecimal("1234.5")));
		dao.eliminarProducto(22L);
		
		for(Producto producto:dao.obtenerTodos()) {
			System.out.println(producto);
		}
		
		System.out.println(dao.obtenerPorId(2L));
	}

}
