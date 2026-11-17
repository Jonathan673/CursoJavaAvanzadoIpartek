package main;

import java.util.ArrayList;

import clases.User;

/**
 * Clase de prueba de la aplicación
 */
public class PruebaApp {
	/**
	 * Método que ejecuta un Hola mundo, y nos da un tip para comentar código
	 * 
	 * @param args Argumentos recibidos
	 */
	public static void main(String[] args) {
		System.out.println("Hola Mundo, para comentar, el shortcut es crtl + /");

		// User[] users = new User[2];
		ArrayList<User> users = new ArrayList<>();

		for (int i = 0; i <= 1; i++) {
			String name = "Jose" + i;
			Integer age = 25 + i;

			CrearUser(name, age, users);

		}
		ListarUsuarios(users);
		CompararUsuarios(users);
	}

	public static void CrearUser(String nombre, Integer edad, ArrayList<User> usuarios) {
		User user = new User();
		user.setNombre(nombre);
		user.setEdad(edad);
		usuarios.add(user);
	}

	public static void ListarUsuarios(ArrayList<User> usuarios) {
		System.out.println("\n\n\nLa lista contiene un total de "+usuarios.size()+" elementos.");
		System.out.println("\n\nLista de todos los usuarios de la lista:\n");
		for (User us : usuarios) {
			System.out.println(us.toString());
		}
//		System.out.println(usuarios);
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
