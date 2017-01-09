package es.rf.tienda.util;

import static org.junit.Assert.*;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.rf.tienda.exception.DAOException;
//import pruebas.Conexion;
//import pruebas.Lectura;

public class testConexion {
	private static Connection conn;
	private static Statement stm;
	
	final String inserta1="INSERT into categoria VALUES (1,'PrimeraCategoria','Descripcion de la pimera categoria')";
	final String select="Select * from categoria where id_categoria=1";
	final String delete1="Delete from categoria where id_categoria = 6";
	@Test
	public void testInsert() throws DAOException, SQLException{
		conn = Conexion.getConnection();
		
		stm=conn.createStatement();
		
		stm.executeUpdate(inserta1);
		
		//stm.close();

	}	
	@Test
	public void testGet() throws DAOException, SQLException{
		conn = Conexion.getConnection();
		
		stm=conn.createStatement();
		
		stm.executeUpdate(inserta1);
		
		ResultSet rs=stm.executeQuery(select);
		rs.next();
		assertEquals("1",rs.getString("id_categoria"));
		
	}
	@Test
	public void testDelete() throws DAOException, SQLException{
		conn = Conexion.getConnection();
		
		stm=conn.createStatement();
		
		stm.executeUpdate(delete1);
		
		
	}
	@AfterClass
	public void closeConexion()throws DAOException, SQLException{
		stm.close();
		conn.close();
	}
/*	@Before
	public void inicio() throws DAOException{
		conn = Conexion.getConnection();
	}

	@Test
	public void testCommit() throws  DAOException, SQLException {
		Statement stm = conn.createStatement();
		stm.executeUpdate("Update EMP set JOB = JOB");
		RFDataConnection.commit();
	}

	@Test
	public void testRollback() throws SQLException, DAOException {
		Statement stm = conn.createStatement();
		stm.executeUpdate("Update EMP set sal = sal + 10000 ");
		RFDataConnection.rollback();
	}

	@Test
	public void testCloseStatement() throws SQLException, DAOException {
		Statement stm = conn.createStatement();
		RFDataConnection.closeStatement(stm);
		assertTrue("Cerrar statment",stm.isClosed());
	}

	@Test
	public void testCloseResulSet() throws SQLException, DAOException {
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM EMP");
		RFDataConnection.closeResulSet(rs);
		
	}
*/
}
