package com.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	private static final String url = "jdbc:mysql://localhost:3306/game_vault";
	private static final String user = "root";
	private static final String pass = "1234";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
}
