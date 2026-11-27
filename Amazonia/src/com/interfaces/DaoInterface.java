package com.interfaces;

import java.util.Optional;

import com.excepciones.AccesoDatosException;


public interface DaoInterface <T>{
	default Optional<T> obtenerPorId(Long id) {
		throw new AccesoDatosException("No Implementado");
	}
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("No Implementado");
	}
	default T insertar(T objeto) {
		throw new AccesoDatosException("No Implementado");
	}
	default T modificar(T objeto) {
		throw new AccesoDatosException("No Implementado");
	}
	default void eliminar(Long id) {
		throw new AccesoDatosException("No Implementado");
	}
}
