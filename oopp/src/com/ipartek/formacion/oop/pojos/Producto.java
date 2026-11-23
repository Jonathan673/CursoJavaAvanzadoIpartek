package com.ipartek.formacion.oop.pojos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Producto {
	private static final RoundingMode REDONDEO = RoundingMode.HALF_UP;
	private static final int NUMERO_DECIMALES = 2;
	private static final String IVA = "0.21";
	//constantes (static final)
	private static final String SIN_NOMBRE = "Sin Nombre";
	private static final BigDecimal PRECIO_POR_DEFECTO = BigDecimal.ZERO;

	// variables de instancia
	private Long id;
	private String nombre;
	private BigDecimal precio;

	//constructores
	public Producto(Long id, String nombre, BigDecimal precio) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
	}

	// este constructor puede usarse cuando el id es autogenerado
	public Producto(String nombre, BigDecimal precio) {
		this(null, nombre, precio);
	}

	public Producto() {
		this(null, SIN_NOMBRE, PRECIO_POR_DEFECTO);

	}

	// constructor de copia
	public Producto(Producto producto) {
		this(producto.id, producto.nombre, producto.precio);
	}

	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws IllegalArgumentException {
		if (nombre == null || nombre.isBlank()) {
			throw new IllegalArgumentException("El precio es obligatorio.");
		}
		this.nombre = nombre.trim();
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) throws IllegalArgumentException {
		if (precio.compareTo(PRECIO_POR_DEFECTO) < 0) {
			throw new IllegalArgumentException("El precio debe ser superior a 0.");
		}
		this.precio = precio.setScale(NUMERO_DECIMALES, REDONDEO);
	}

	
	public BigDecimal getIva() {
		return precio.multiply(new BigDecimal(IVA).setScale(NUMERO_DECIMALES, REDONDEO));
	}
	public BigDecimal getPrecioIvaIncluido() {
		return precio.add(getIva());
	}
	//methods
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
