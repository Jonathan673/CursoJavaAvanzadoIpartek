package com.ipartek.formacion.oop.pojos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class ProductoPerecedero extends Producto {
	private LocalDate fechaCaducidad;

	public ProductoPerecedero(Long id, String nombre, BigDecimal precio, LocalDate fechaCaducidad) {
		super(id, nombre, precio);
		setFechaCaducidad(fechaCaducidad);
	}

	public ProductoPerecedero() {
		this(null, SIN_NOMBRE, PRECIO_POR_DEFECTO, LocalDate.now());
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

//	@Override
//	public BigDecimal getDecimal() {
//		if (fechaCaducidad.isBefore(LocalDate.now())) {
//			
//			return super.getPrecio().divide(BigDecimal.TWO);
//		}
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fechaCaducidad);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoPerecedero other = (ProductoPerecedero) obj;
		return Objects.equals(fechaCaducidad, other.fechaCaducidad);
	}

	@Override
	public String toString() {
//		return super.toString() +"ProductoPerecedero [fechaCaducidad=" + fechaCaducidad + "]";
		return String.format(super.toString() + fechaCaducidad);
	}

}
