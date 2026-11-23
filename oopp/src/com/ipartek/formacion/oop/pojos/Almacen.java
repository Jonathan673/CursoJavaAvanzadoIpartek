package com.ipartek.formacion.oop.pojos;

import java.util.ArrayList;
import java.util.Objects;

public class Almacen {

	private Long id;
	private String ubicacion;
	private Persona encargado;

	private ArrayList<Producto> productos = new ArrayList<>();

	public Almacen(Long id, String ubicacion, Persona encargado) {
		setId(id);
		setUbicacion(ubicacion);
		setEncargado(encargado);
	}

	public Persona getEncargado() {
		return encargado;
	}

	public void setEncargado(Persona encargado) {
		this.encargado = encargado;
	}

	public Almacen() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	// no estamos metiendo el setter setProductos
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	// Método de instancia(acción especifica de esta clase)
	public void guardarProducto(Producto producto) {
		if (producto == null) {
			throw new IllegalArgumentException("No me pases un objeto null");
		}
		productos.add(producto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(encargado, id, productos, ubicacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Almacen other = (Almacen) obj;
		return Objects.equals(encargado, other.encargado) && Objects.equals(id, other.id)
				&& Objects.equals(ubicacion, other.ubicacion);
	}

	@Override
	public String toString() {
		return "Almacen [id=" + id + ", ubicacion=" + ubicacion + ", encargado=" + encargado + "]";
	}

}
