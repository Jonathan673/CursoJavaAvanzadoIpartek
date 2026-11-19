package com.ipartek.formacion.oop.presentacion.consola;

import static com.ipartek.formacion.bibliotecas.consola.BibliotecaConsola.pl;
import static com.ipartek.formacion.bibliotecas.consola.BibliotecaConsola.rInt;
import static com.ipartek.formacion.bibliotecas.consola.BibliotecaConsola.rLocalDate;
import static com.ipartek.formacion.bibliotecas.consola.BibliotecaConsola.rString;

import java.time.LocalDate;

import com.ipartek.formacion.oop.accesodatos.PersonaDao;
import com.ipartek.formacion.oop.pojos.Persona;

public class PersonaConsola {
	private static final int SALIR = 0;

	public static void main(String[] args) {
//		int entero = rInt("dame un entero: ");
//		pl(entero);
//
//		String texto = rString("Dame un String: ");
//		pl(texto);
//
//		LocalDate fecha = rLocalDate("Dame una fecha con el siguiente formato: 03 04 1999: ");
//		pl(fecha);
		int opcion;

		do {
			mostrarMenu();

			opcion = rInt("Selecciona una opción");

			procesarOpcion(opcion);
		} while (opcion != SALIR);
	}

	private static void mostrarMenu() {
		pl("""

				MENU
				====
				1. Listado
				2. Obtener por id

				3. Alta
				4. Modificación
				5. Baja

				0. Salir

				""");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1 -> listado();
		case 2 -> buscarPersona();
		case 3 -> alta();
		case 4 -> modificar();
		case 5 -> baja();
		case 0 -> salir();
		default -> pl("Error en la opción");
		}
	}

	private static void listado() {
		pl("Listado: ");

		for (Persona persona : PersonaDao.obtenerTodos()) {
			pl(persona);
		}
	}

	private static void buscarPersona() {
		Long id = Long.parseLong(rString("Introdizca el ID de la persona que esta buscando: "));
		Persona personaEncontrada = PersonaDao.obtenerPorId(id);
		pl(personaEncontrada);
	}

	private static void alta() {
		pl("Alta: ");

		String nombre = rString("Nombre");
		String apellidos = rString("Apellidos");
		LocalDate fechaNacimiento = rLocalDate("Fecha de nacimiento");

		Persona persona = new Persona(null, nombre, apellidos, fechaNacimiento);

		pl(PersonaDao.insertar(persona));
	}

	private static void modificar() {
		Long id = Long.parseLong(rString("Introdizca el ID de la persona a la que quiere modificar: "));
		Persona personaEncontrada = PersonaDao.obtenerPorId(id);

		if (personaEncontrada != null) {
			pl("Persona encontrada: " + personaEncontrada.toString());
			String nombre = personaEncontrada.nombre();
			String apellidos = personaEncontrada.apellidos();
			LocalDate fechaNacimiento = personaEncontrada.fechaNacimiento();

			int opcion;
			boolean modificado = false;

			do {
				pl("""

						¿Qué desea modificar?
						====

						1. Nombre
						2. Apellidos
						3. Fecha de nacimiento

						0. Salir

						""");
				opcion = rInt("Introduzca una opción");
				switch (opcion) {
				case 1 -> {
					nombre = rString("Nombre");
					modificado = true;
				}
				case 2 -> {
					apellidos = rString("Apellidos");
					modificado = true;
				}
				case 3 -> {
					fechaNacimiento = rLocalDate("Fecha de nacimiento");
					modificado = true;
				}
				default -> pl("Opción no válida");
				}
			} while (opcion != SALIR);

			if (modificado) {
				Persona persona = new Persona(id, nombre, apellidos, fechaNacimiento);
				pl(PersonaDao.modificar(persona));
			} else {
				IO.println("No se ha modificado nada");
			}
		} else {
			System.out.println("No se ha encontrado al individuo");
		}

	}

	private static void baja() {
		Long id = Long.parseLong(rString("Introdizca el ID de la persona a al que quiere eliminar sin piedad: "));
		PersonaDao.eliminar(id);
		pl("Se ha eliminado el registro de la lista.");
	}

	private static void salir() {
		pl("Gracias por usar esta aplicación");
	}

}
