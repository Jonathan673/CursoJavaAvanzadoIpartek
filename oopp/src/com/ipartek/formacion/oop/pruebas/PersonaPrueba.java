package com.ipartek.formacion.oop.pruebas;

import java.time.LocalDate;

import com.ipartek.formacion.oop.pojos.Persona;

public class PersonaPrueba {

	public static void main(String[] args) {
		Persona persona = new Persona(1L, "Jose", "Gomez", LocalDate.of(1998, 2, 4));
		Persona persona2 = new Persona(2L, "paco", "Gomez", LocalDate.of(1998, 2, 4));
		
		
		System.out.println(persona.equals(persona2));
		
		
		System.out.println(persona.nombre());
		System.out.println(persona);
	}

}
