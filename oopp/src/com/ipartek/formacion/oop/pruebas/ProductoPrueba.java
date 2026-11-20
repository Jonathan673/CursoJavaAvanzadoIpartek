package com.ipartek.formacion.oop.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.oop.pojos.Producto;

public class ProductoPrueba {

	public static void main(String[] args) {
		Producto producto = new Producto();

		try {
			producto.setId(5L);
			producto.setNombre("Paca");
			producto.setPrecio(new BigDecimal("234"));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
		IO.println(producto);

		Producto producto2 = new Producto(1L, "Paco", new BigDecimal("1234"));
		IO.println(producto2);

		Producto p3 = new Producto(producto);

		System.out.println(p3.hashCode());
		System.out.println(producto.hashCode());
	}

}
