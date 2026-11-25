package com.ipartek.formacion.oop.interfaces;

import java.math.BigDecimal;

import com.ipartek.formacion.oop.exceptions.AccesoDatosException;
import com.ipartek.formacion.oop.pojos.Producto;

//Versión del profesor, con genéricos (Data access Object)
public interface ProductoInterfaceProfesor extends DaoInterface<Producto> {
	default Iterable<Producto> obtenerPorNombre(String texto) {
		throw new AccesoDatosException("No Implementado");
	}

	default Iterable<Producto> obtenerPorNombre(BigDecimal minimo, BigDecimal maximo) {
		throw new AccesoDatosException("No Implementado");
	}
}
