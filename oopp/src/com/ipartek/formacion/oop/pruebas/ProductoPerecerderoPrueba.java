package com.ipartek.formacion.oop.pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.oop.pojos.Producto;
import com.ipartek.formacion.oop.pojos.ProductoPerecedero;

public class ProductoPerecerderoPrueba {

	public static void main(String[] args) {
		ProductoPerecedero pPerecedero = new ProductoPerecedero(1L, "Patata", new BigDecimal("7"),
				LocalDate.of(2026, 12, 22));

		System.out.println(pPerecedero);

		ProductoPerecedero p1 = new ProductoPerecedero(2L, "Patata2", BigDecimal.TEN, LocalDate.of(2026, 12, 22));
		ProductoPerecedero p2 = new ProductoPerecedero(3L, "Patata3", BigDecimal.TEN,
				LocalDate.of(2026, 12, 22).minusDays(1));

		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());

		Producto p = p1;
		// fijarse que en el if atras pone otroP, basicamente genera la variable para
		// que no tengas que escribir mas lineas.
		if (p instanceof ProductoPerecedero otroP) {
			System.out.println(otroP.getFechaCaducidad());
		} else {

			System.out.println("no es un producto perecedero");
		}
		System.out.println(p.toString());
		System.out.println(p1.toString());

		Producto nuevoProducto = new Producto();
		if (p instanceof ProductoPerecedero) {
			ProductoPerecedero nuevoProductoPerecedero = (ProductoPerecedero) nuevoProducto;
			System.out.println(nuevoProductoPerecedero.getFechaCaducidad());
		} else {
			System.out.println("no es un producto perecedero");
		}

	}

}
