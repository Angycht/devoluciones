package com.devoluciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String Controlador = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://192.168.100.73:3306/devoluciones";
	private static final String Usuario = "root";
	private static final String Contrasenia = "root";
	
	static {
		
		try {
			Class.forName(Controlador);
			System.out.println("Controlador cargado");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("Controlador no cargado");
		}
		
	}
	
	public Connection conectar() {
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(URL, Usuario,Contrasenia);
			System.out.println("Conexión cargada");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Coneión no cargada");
			
		}
		return conexion;
	}
	
}
