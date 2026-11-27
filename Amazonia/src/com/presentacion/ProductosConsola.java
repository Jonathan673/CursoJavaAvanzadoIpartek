package com.presentacion;

import java.math.BigDecimal;

import com.interfaces.DaoProductoInterface;
import com.pojos.Producto;

import fabrica.Fabrica;

public class ProductosConsola {

	public static void main(String[] args) {
//		ProductoInterfaceCliente dao = new ProductoDaoCliente();
		DaoProductoInterface dao =  (DaoProductoInterface) Fabrica.fabricar("dao.producto");
		
		
		System.out.println(dao.insertar(new Producto(null,"hsgh",new BigDecimal("1200.2"))));
//		dao.modificar(new Producto(10L,"ksfakgafkdj",new BigDecimal("1453.2")));
//		try {
//			dao.eliminar(6L);
//		} catch (Exception e) {
//			System.out.println("No existe ese usuario para borrarlo");
//		}
		
		for(Producto producto :dao.obtenerTodos()) {
			System.out.println(producto);
		}
		
		System.out.println(dao.obtenerPorId(1L));
	}

	

}
