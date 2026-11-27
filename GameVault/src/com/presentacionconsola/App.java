package com.presentacionconsola;

import java.sql.SQLException;

import com.accesodatos.GeneroDaoImplementacion;
import com.interfaces.GeneroInterface;
import com.pojos.Genero;

public class App {

	public static void main(String[] args) throws SQLException {
		IO.println("pruebas");
		GeneroInterface dao = new GeneroDaoImplementacion();

//		dao.insertarGenero(new Genero(null, IO.readln("dime el nombre del nuevo genero: ")));		
		dao.obtenerTodos().forEach(System.out::println);
		dao.buscarGenero(Long.parseLong(IO.readln("dime el id del genero que quieres encontrar: ")));
		
//		dao.eliminarGenero(Long.parseLong(IO.readln("dime el id del genero que quieres eliminar: ")));
	}

}
