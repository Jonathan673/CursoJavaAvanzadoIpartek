package com.ipartek.formacion.oop.accesodatos;

import java.time.LocalDate;
import java.util.Collection;
import java.util.TreeMap;

import com.ipartek.formacion.oop.pojos.Persona;

// DAO es Data Access Object, esto implementa lo que llamamos CRU
public class PersonaDao {
	private static final TreeMap<Long, Persona> personas = new TreeMap<>();
	
	static {
		personas.put(1L, new Persona(1L, "Paco", "Jones", LocalDate.now()));
		personas.put(2L, new Persona(2L, "Paca", "Senoj", LocalDate.now()));
		personas.put(3L, new Persona(3L, "PuesNoSePatata", "apellido", LocalDate.now()));
	}

	// list all records
	public static Collection<Persona> obtenerTodos() {
		return personas.values();
	}
	// list by ID
	public static Persona obtenerPorId(Long id) {
		return personas.get(id);
	}
	// insert
	public static Persona insertar(Persona persona) {
		Long id = personas.isEmpty() ? 1L : personas.lastKey() + 1L;
		Persona personaInsert = new Persona(id, persona.nombre(), persona.apellidos(), persona.fechaNacimiento());
		personas.put(personaInsert.id(), personaInsert);
		return personaInsert;
	}
	//modify
	public static Persona modificar(Persona persona) {
		personas.put(persona.id(), persona);
		return persona;
	}
	//remove
	public static void eliminar(Long id) {
		personas.remove(id);
	}
}
