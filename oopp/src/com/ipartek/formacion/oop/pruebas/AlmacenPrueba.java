package com.ipartek.formacion.oop.pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.oop.pojos.Almacen;
import com.ipartek.formacion.oop.pojos.Persona;
import com.ipartek.formacion.oop.pojos.Producto;

public class AlmacenPrueba {

	public static void main(String[] args) {
		Almacen almacen = new Almacen(1L, "Barakaldo", new Persona(null, "Paco", "Jones", LocalDate.of(2000,1,2)));

		almacen.guardarProducto(new Producto("Portatil", new BigDecimal("18723.23")));
		almacen.guardarProducto(new Producto("Teclado", new BigDecimal("123.00")));
		almacen.guardarProducto(new Producto("Ratón", new BigDecimal("123.23")));
//		almacen.guardarProducto(null);

		System.out.println(almacen);
		for (Producto producto : almacen.getProductos()) {
			System.out.println(producto);
			System.out.println(producto.getPrecioIvaIncluido());
		}
	}
}
