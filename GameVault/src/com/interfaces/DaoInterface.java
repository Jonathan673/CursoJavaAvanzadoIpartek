package com.interfaces;

public interface DaoInterface<T>{
	Iterable <T> obtenerTodos();
	T buscarGenero(Long id);
	T insertarGenero(Object object);
	T modificarGenero(Object object);
	void eliminarGenero(Long id);
}
