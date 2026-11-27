package com.interfaces;

public interface DaoInterface<T>{
	Iterable <T> obtenerTodos();
	T buscarGenero(Long id);
	T insertarGenero(T object);
	T modificarGenero(T object);
	void eliminarGenero(Long id);
}
