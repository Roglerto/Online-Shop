package es.rf.tienda.util;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	// JDBC driver name and database URL
	private final static String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
	
	private final static String URL="jdbc:oracle:thin:@localhost:1521:xe";
	
	//  Database credentials
	private final static String USUARIO="alumno";
	
	private final static String PASSWORD="Curso201604";
	
	//private 
	private static Connection conn = null;
	private static Statement stmt = null;
	public static Connection getConnection(){
		
		//STEP 2: Register JDBC driver
	      try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      try {
			conn = DriverManager.getConnection(URL,USUARIO,PASSWORD);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      return conn;
	}
	
	private static void disconnect(){
		//stmt.close();
	    try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
