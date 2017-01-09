package es.rf.tienda.objetos.daos;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.junit.BeforeClass;
import org.junit.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.objetos.daos.Hibernate.CategoriaDAOH;

public class TestCategoriaDAOH {

	static CategoriaDAOH cDAOH;

	static Categoria reg1;
	static Categoria reg2;
	static Categoria reg3;
	static Categoria reg4;
	static List<Categoria> lista;

	@BeforeClass
	public static void inicializar(){
		cDAOH = new CategoriaDAOH("Categoria");
	
		
		reg1 = new Categoria();
		reg1.setId_categoria(69);
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
			System.out.println(" ID before-> "+reg1.getId_categoria());
			
			num = cDAOH.insertarRegistro(reg1);
							
			System.out.println(" ID after-> "+reg1.getId_categoria());
						
			cDAOH.borrarRegistro(reg1);
			
			assertEquals(" REGISTRO INSERTADO ",reg1.getId_categoria(),num);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test
	public void testactualizarRegistros()  {				
		int num;
		try {
			
			num = cDAOH.insertarRegistro(reg1);						
			
			reg1.setCat_descripcion(" ACTUALIZADA DESCRIPCION ");
			num = cDAOH.actualizarRegistro(reg1);
												
			
			assertEquals(" REGISTRO ACTUALIZADO ",1,num);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Test
	public void testborrarRegistros()  {				
		int num;
		try {

			num = cDAOH.insertarRegistro(reg1);
									
			num=cDAOH.borrarRegistro(reg1);
			
			assertEquals(" REGISTRO borrado ",1,num);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test (expected=HibernateException.class)
	public void testborrarRegistroVacio()  {				
		int num;
		try {
												
			num=cDAOH.borrarRegistro(reg1);
			
			assertEquals(" REGISTRO vacio borrado ",1,num);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testLeerRegistro()  throws DAOException, SQLException {
		int num = cDAOH.insertarRegistro(reg4);
						
		lista=cDAOH.leerRegistro(reg4);
			
		for (int i=0;i<lista.size();i++){
			System.out.println("LEYENDO UNA CATEGORIA Id:"+lista.get(i).getId_categoria() + " Descripcion:" + lista.get(i).getCat_descripcion());
				
		}
		assertTrue("Lista leer registro ", lista.size()>0);
			
		cDAOH.borrarRegistro(reg4);
		
	}
	
	@Test
	public void testLeerTodos()  {
		
		int num;
		try {
			num = cDAOH.insertarRegistro(reg1);
		
			int num2 = cDAOH.insertarRegistro(reg2);
			
		    lista= cDAOH.leerTodos();
		    
			for (int i=0;i<lista.size();i++){
				System.out.println("Id:"+lista.get(i).getId_categoria() + " Descripcion:" + lista.get(i).getCat_descripcion()+ " nombre "+lista.get(i).getCat_nombre());
				
			}
			assertTrue("Lista leer todos los registros ", lista.size()>0);
			
			cDAOH.borrarRegistro(reg1);
			cDAOH.borrarRegistro(reg2);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
