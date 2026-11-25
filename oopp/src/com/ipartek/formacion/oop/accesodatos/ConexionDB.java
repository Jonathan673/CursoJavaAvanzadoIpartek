package com.ipartek.formacion.oop.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	private static final String url = "jdbc:mysql://localhost:3306/2993_basico";
	private static final String user = "root";
	private static final String pass = "1234";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
//	public static PreparedStatement getPts(String sql) throws SQLException {
//		Connection con = getConnection();
//		return con.prepareStatement(sql);
//	}

}
