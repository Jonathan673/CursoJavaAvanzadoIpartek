package clases;

import java.util.Objects;

public class User {
	private String nombre = "";
	private Integer edad = 0;

	// constructores vacio y con fields
	public User() {

	}

	public User(String nombre, Integer edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	// getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	// Methods
	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(edad, other.edad) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Este usuario tiene como nombre: " + nombre + "\nCon una edad de de: " + edad + "\n";
	}
}
