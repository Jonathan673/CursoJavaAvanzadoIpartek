package com.ipartek.formacion.oop.interfaces;

import java.util.Optional;

import com.ipartek.formacion.oop.exceptions.AccesoDatosException;

//Versión del profesor, con genéricos (Data access Object)
public interface DaoInterface<T> {
	// puede devolver o no un resultado
	default Optional<T> obtenerPorId(Long id) {
		throw new AccesoDatosException("No Implementado");
	}
	// usamos iterable, ya que es el mas generico y nos permite implementar como
	// queramos mas adelante
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("No Implementado");
	}

	default T insertarProducto(T objeto) {
		throw new AccesoDatosException("No Implementado");
	}

	default T modificarProducto(T objeto) {
		throw new AccesoDatosException("No Implementado");
	}

	default void eliminarProducto(Long id) {
		throw new AccesoDatosException("No Implementado");
	}
}
