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
		 ResultSet rs = st.executeQuery("Select * from productos");
		 
		 
		 while(rs.next()) {
			 System.out.printf("%1s\t%-20s\t%10s \n",rs.getLong("id_productos"),rs.getString("nombre"),rs.getBigDecimal("precio"));
		 }
	}
}