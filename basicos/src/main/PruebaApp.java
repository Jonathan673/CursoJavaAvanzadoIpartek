package main;

import java.util.ArrayList;
import java.util.Scanner;

import clases.User;

/**
 * Clase de prueba de la aplicación, estos comentarios son para el javadoc
 */
public class PruebaApp {
	/**
	 * Método que ejecuta un Hola mundo, y nos da un tip para comentar código
	 * 
	 * @param args Argumentos recibidos
	 */
	public static void main(String[] args) {
//		System.out.println("Hola Mundo, para comentar, el shortcut es crtl + /");
		// User[] users = new User[2];

//		for (int i = 0; i <= 1; i++) {
//			String name = "Jose" + i;
//			Integer age = 25 + i;
//
//			CrearUser(name, age, users);
//
//		}
//		ListarUsuarios(users);
//		CompararUsuarios(users);
		MainMenu();

	}

	public static void MainMenu() {
		Scanner textoRecibido = new Scanner(System.in);
		ArrayList<User> users = new ArrayList<>();
		Integer decision = 0;

		do {

			System.out.println("""
					Elige una opción:

					1º Listar usuarios.
					2º Crear usuarios.
					3º Comparar usuarios.

					Elige entre 1 y 3. 
					Mete 0 si quieres salir del programa.
					""");

			while (!textoRecibido.hasNextInt()) {
				System.out.println("ERROR: Debes introducir un número entero.");
				textoRecibido.next(); // Elimina la entrada incorrecta

				System.out.println("Inténtalo de nuevo:");
			}
			decision = textoRecibido.nextInt();

			switch (decision) {
			case 1: {
				ListarUsuarios(users);
				break;
			}
			case 2: {
				CrearUser(textoRecibido, users);
				break;
			}
			case 3: {

				CompararUsuarios(users);
				break;
			}
			}

		} while (decision != 0);

	}

	public static void CrearUser(Scanner textoRecibido, ArrayList<User> usuarios) {

		Integer crearMasUsuarios = 1;
		String name = "";
		Integer age = 0;

		do {
			IO.println("¿Cuál es el nombre del usuario?");
			name = textoRecibido.next();
			IO.println("¿Cuál es la edad del usuario?");
			age = textoRecibido.nextInt();

			User user = new User();
			user.setNombre(name);
			user.setEdad(age);
			usuarios.add(user);

			IO.println(
					"¿Quiere introducir a más usuarios? introduzca 0 si no desea continuar, introduzca cualquier número si desea introducir más usuarios");

			while (!textoRecibido.hasNextInt()) {
				System.out.println("ERROR: Debes introducir un número entero.");
				textoRecibido.next(); // Elimina la entrada incorrecta

				System.out.println("Inténtalo de nuevo:");
			}
			crearMasUsuarios = textoRecibido.nextInt();

		} while (crearMasUsuarios != 0);

	}

	public static void ListarUsuarios(ArrayList<User> usuarios) {
		System.out.println("\n\n\nLa lista contiene un total de " + usuarios.size() + " elementos.");
		if (usuarios.size() == 0) {
			IO.println("Introduzca algún usuario.\n");
		} else {

			System.out.println("\n\nLista de todos los usuarios de la lista:\n");
			for (User us : usuarios) {
				System.out.println(us.toString());
			}
//		System.out.println(usuarios);
		}
	}

	public static void CompararUsuarios(ArrayList<User> usuarios) {
		User usuario1 = usuarios.get(0);
		User usuario2 = usuarios.get(1);

		System.out.println("\n\n\nLista de los dos primeros usuarios de la lista y comprobación de si son iguales:\n");
		System.out.println(usuario1.toString());
		System.out.println(usuario2.toString());

		IO.println(usuario1.equals(usuario2) ? "Ambos usuarios son iguales" : "No son iguales");

	}
}
