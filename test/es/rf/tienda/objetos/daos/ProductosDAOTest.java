package es.rf.tienda.objetos.daos;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Producto;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;

public class ProductosDAOTest {

	static ProductosDAO pDAO;
	static Producto prod1;
	static Calendar fecacti;
	static Calendar fecdesacti;
	static Calendar fecrepos;
	
	static String DESCRIPCION_1="Descripcion categoria";
	
	@BeforeClass
	public static void inicializar(){
		
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
		Calendar fecacti = new GregorianCalendar(2013,1,28,13,24,56);	
		Calendar fecdesacti = new GregorianCalendar(2013,1,28,13,24,56);	
		Calendar fecrepos = new GregorianCalendar(2013,1,28,13,24,56);	
		//update a date
		fecacti.set(Calendar.YEAR, 2018);
		fecacti.set(Calendar.MONTH, 02);
		fecacti.set(Calendar.MINUTE, 10);
		
		//update a date
		fecdesacti.set(Calendar.YEAR, 2018);
		fecdesacti.set(Calendar.MONTH, 02);
		fecdesacti.set(Calendar.MINUTE, 10);
		
		//update a date
		fecrepos.set(Calendar.YEAR, 2018);
		fecrepos.set(Calendar.MONTH, 02);
		fecrepos.set(Calendar.MINUTE, 10);
				
		pDAO = new ProductosDAO();
	
		
		prod1 = new Producto();
		
		try {
			
			prod1.setId_producto("357Nd");		
			prod1.setId_pais(1);
			prod1.setPro_cantXUniventa(10);
			prod1.setPro_descripcion(" Whisky del señorito yo ");
			prod1.setPro_desLarga(" whisky del señorito yo elaborado con carbon del Congo");
			prod1.setPro_fecActi(fecacti);
			prod1.setPro_fecDesacti(fecdesacti);
			prod1.setPro_fecRepos(fecrepos);
			prod1.setPro_nSkBajo(10);
			prod1.setPro_nStkAlto(100);
			prod1.setPro_precio(1.25);
			prod1.setPro_stat("A");
			prod1.setPro_stkReservado(22);
			prod1.setPro_stock(25);
			prod1.setPro_uniUltNivel("BOTELLA");
			prod1.setPro_uniVenta("caja");
			prod1.setPro_usoRecomendado("beber antes de que se caliente");
			
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	@Test
	public void insertProducto(){
		try {
			int num=pDAO.insertarRegistro(prod1);
			
			
			pDAO.guardar();
			assertEquals("Lista leer todos los registros ", 1,num);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
