package com.ipartek.formacion.oop.pojos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPrueba {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/2993_basico";
		String user = "root";
		String pass = "1234";
		 Connection con = DriverManager.getConnection(url,user,pass);
		 Statement st = con.createStatement();
		 
		 int numeroResultados = st.executeUpdate("UPDATE productos SET nombre='portatil perfecto',precio=5555.5 WHERE id_productos=1");
		 
		 
		 System.out.println(numeroResultados);
		 
		 ResultSet rs = st.executeQuery("Select * from productos");
		 
		 
		 while(rs.next()) {
			 System.out.printf("%1s\t%-20s\t%10s \n",rs.getLong("id_productos"),rs.getString("nombre"),rs.getBigDecimal("precio"));
		 }
	}
}