package com.ipartek.formacion.oop.presentacion.consola;

import com.ipartek.formacion.fabrica.Fabrica;
import com.ipartek.formacion.oop.interfaces.ProductoInterfaceCliente;
import com.ipartek.formacion.oop.pojos.Cliente;

public class ClienteConsola {

	public static void main(String[] args) {
//		ProductoInterfaceCliente dao = new ProductoDaoCliente();
		ProductoInterfaceCliente dao =  (ProductoInterfaceCliente) Fabrica.fabricar("dao.cliente");
		
		
//		System.out.println(dao.insertarProducto(new Cliente(null,"Paco","Jones","123456789")));
//		dao.modificarProducto(new Cliente(2L,"Pepe","pepaso","123456789"));
//		try {
//			dao.eliminarProducto(11L);
//		} catch (Exception e) {
//			System.out.println("No existe ese usuario para borrarlo");
//		}
		
		for(Cliente cliente:dao.obtenerTodos()) {
			System.out.println(cliente);
		}
		
		System.out.println(dao.obtenerPorId(1L));
	}

}
