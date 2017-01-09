package es.rf.tienda.objetos.daos;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
//import es.rf.tienda.util.RFDataConnection;

public class testCategoriaDao {
	static CategoriaDAO cDAO;
	static Categoria reg1;
	static Categoria reg2;
	static Categoria reg3;
	static Categoria reg4;
	static List<Categoria> lista;
	
	static String DESCRIPCION_1="Descripcion categoria";
	
	@BeforeClass
	public static void inicializar(){
		try {
			cDAO = new CategoriaDAO();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		reg1 = new Categoria();
		reg1.setId_categoria(1);
		reg1.setCat_nombre("Titulo A");
		reg1.setCat_descripcion("Descripcion categoria");
		
		reg2 = new Categoria();
		reg2.setId_categoria(2);
		reg2.setCat_nombre("Titulo 	B");
		reg2.setCat_descripcion("Descripcion categoria");
		
		reg3 = new Categoria();
		reg3.setId_categoria(3);
		reg3.setCat_nombre("Titulo 	C");
		reg3.setCat_descripcion("Descripcion categoria");
		
		reg4 = new Categoria();
		reg4.setId_categoria(1);
		reg4.setCat_nombre("Titulo 	D");
		reg4.setCat_descripcion("Descripcion ACTUALIZADO");
	}
	
	@Test
	public void testinsertRegistros()  {				
		int num;
		try {
			num = cDAO.insertarRegistro(reg1);
					
			int num2 = cDAO.insertarRegistro(reg2);			
			
			reg1.setId_categoria(num);
			reg2.setId_categoria(num2);
			
			cDAO.borrarRegistro(reg1);
			cDAO.borrarRegistro(reg2);
			cDAO.guardar();							
			
			assertEquals(" REGISTRO INSERTADO ",reg1.getId_categoria(),num);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test
	public void testLeerRegistro()  throws DAOException, SQLException {
		int num = cDAO.insertarRegistro(reg4);
		
		reg4.setId_categoria(num);
		
		lista=cDAO.leerRegistro(reg4);
			
		for (int i=0;i<lista.size();i++){
			System.out.println("LEYENDO UNA CATEGORIA Id:"+lista.get(i).getId_categoria() + " Descripcion:" + lista.get(i).getCat_descripcion());
				
		}
		assertTrue("Lista leer registro ", lista.size()>0);
			
		cDAO.borrarRegistro(reg4);
		cDAO.guardar();
	}
	
	@Test
	public void testLeerTodos()  {
		
		int num;
		try {
			num = cDAO.insertarRegistro(reg1);
		
			int num2 = cDAO.insertarRegistro(reg2);
			
			reg1.setId_categoria(num);
			reg2.setId_categoria(num2);
			
		    lista= cDAO.leerTodos();
		    
			for (int i=0;i<lista.size();i++){
				System.out.println("Id:"+lista.get(i).getId_categoria() + " Descripcion:" + lista.get(i).getCat_descripcion()+ " nombre "+lista.get(i).getCat_nombre());
				
			}
			assertTrue("Lista leer todos los registros ", lista.size()>0);
			
			cDAO.borrarRegistro(reg1);
			cDAO.borrarRegistro(reg2);
			cDAO.guardar();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testActualizarRegistro() {
		int num;
		try {
			num = cDAO.insertarRegistro(reg1);
			
			int num2 = cDAO.insertarRegistro(reg2);
			int num3 = cDAO.insertarRegistro(reg3);
			
			reg1.setId_categoria(num);
			reg2.setId_categoria(num2);
			reg3.setId_categoria(num3);
			
			reg4.setId_categoria(num);
			
			int num4 =cDAO.actualizarRegistro(reg4);
			
			cDAO.borrarRegistro(reg4);
			cDAO.borrarRegistro(reg2);
			cDAO.borrarRegistro(reg3);
			cDAO.guardar();
			assertEquals(" REGISTRO ACTUALIZADO ",1,num);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test 
	public void testBorrarRegistroVacio() {	
		int num2;
		try {
			num2 = cDAO.borrarRegistro(reg2);			
				
			cDAO.guardar();
			assertEquals(" REGISTRO BORRADO ",0,num2);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testBorrarRegistro()  {	
		int num;
		try {
			num = cDAO.insertarRegistro(reg1);
					
			reg1.setId_categoria(num);
			
			int num2 = cDAO.borrarRegistro(reg1);
				
			cDAO.guardar();
			assertEquals(" REGISTRO BORRADO ",1,num2);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public static void disconection(){
		try {
			cDAO.disconnect();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
