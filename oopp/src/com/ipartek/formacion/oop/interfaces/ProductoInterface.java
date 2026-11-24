package com.ipartek.formacion.oop.interfaces;

import java.util.List;

import com.ipartek.formacion.oop.pojos.Producto;

public interface ProductoInterface {
	List<Producto> listarProductos();
	Producto buscarProducto(Long id);
	void insertarProducto(Producto producto);
	void modificarProducto(Producto producto);
	void eliminarProducto(Long id);
}
