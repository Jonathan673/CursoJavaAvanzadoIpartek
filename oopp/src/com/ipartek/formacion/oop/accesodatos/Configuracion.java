package com.ipartek.formacion.oop.accesodatos;

import java.io.IOException;
import java.util.Properties;

import com.ipartek.formacion.oop.exceptions.AccesoDatosException;
import com.ipartek.formacion.oop.interfaces.ProductoInterfaceCliente;

public class Configuracion {
	private static final String PASS;
	private static final String USER;
	private static final String URL;

	static final JDBCHelper JDBC;
	
	//consultas sql
	static final String SQL_SELECT;
	static final String SQL_SELECT_ID;
	static final String SQL_INSERT;
	static final String SQL_UPDATE;
	static final String SQL_DELETE;

	public static final Properties PROPS = new Properties();

	//Static para la conexion
	static {
		try {
			PROPS.load(Configuracion.class.getClassLoader().getResourceAsStream("oop.properties"));
			URL = PROPS.getProperty("dao.url");
			USER = PROPS.getProperty("dao.user");
			PASS = PROPS.getProperty("dao.pass");
			
			JDBC = new JDBCHelper(URL, USER, PASS);

			//CONSULTAS
			SQL_SELECT = PROPS.getProperty("SQL_SELECT");			
			SQL_SELECT_ID = PROPS.getProperty("SQL_SELECT_ID");			
			SQL_INSERT = PROPS.getProperty("SQL_INSERT");			
			SQL_UPDATE = PROPS.getProperty("SQL_UPDATE");			
			SQL_DELETE = PROPS.getProperty("SQL_DELETE");		
			
		} catch (IOException e) {
			throw new AccesoDatosException("Error al leer el fichero de configuración", e);
		}
		
	}
	
	 public static ProductoInterfaceCliente getClienteDao() {
	        return new ProductoDaoCliente();
	    }
}
