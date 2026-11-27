package com.pojos;

import java.math.BigDecimal;
import java.util.Objects;

public class Videojuego {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private Genero genero;
	
	
	public Videojuego(Long id, String nombre, BigDecimal precio, Genero genero) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setGenero(genero);
	}
	
	public Videojuego() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genero, id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return Objects.equals(genero, other.genero) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", genero=" + genero + "]";
	}
	
	
	
}
