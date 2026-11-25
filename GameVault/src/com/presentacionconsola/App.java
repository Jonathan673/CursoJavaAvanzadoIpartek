package com.presentacionconsola;

import java.sql.SQLException;

import com.accesodatos.GeneroDaoImplementacion;

public class App {

	public static void main(String[] args) throws SQLException {
		IO.println("pruebas");
		GeneroDaoImplementacion dao = new GeneroDaoImplementacion();

		dao.obtenerTodos().forEach(System.out::println);
	}

}
