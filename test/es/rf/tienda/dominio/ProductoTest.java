package es.rf.tienda.dominio;
import es.rf.tienda.exception.DomainException;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class ProductoTest {
	Producto producto;
	final String descri="Texto para descripcion";
	
	
	@Before
	public void iniciar(){
		producto=new Producto();
	}
	
	//Probar menos de 5 posiciones
	@Test(expected=DomainException.class)
	public void setId_producto1() throws DomainException{
			producto.setPro_descripcion("abcddddddddfdfdfdfdfdfdfdfddfdfdfdfdfdfdfdfdf"
					+ "dfdfdfdfdfdfdfdfdfdfdfdffdffdfdfdfdddfdddfdfdfd"
					+ "fdfdfdfdfdfdddfdfdfdfdfdffffffdfdfdfdfdfdfdfdfd"
					+ "dfdfdfdfdfdfdfdfdfdfdfdfddfdfdfdfdfdfdfdfdfdf"
					+ "dfdfdfdfdfddfdfdfdfdf");
	}
	
	//Probar mas de 5 posiciones
	@Test 
	public void setId_producto2() throws DomainException{
			producto.setId_producto("abcdef");
	}
	
	//Probar 5 caracteres no alfanumericos
	@Test (expected=DomainException.class)
	public void setId_producto3() throws DomainException{
			producto.setId_producto("ab.de");
	}
	//Probar 5 caracteres alfanumericos
	@Test 
	public void setId_producto4() throws DomainException{
		producto.setId_producto("abcdef");
		assertEquals("setId_producto", "abcdef",producto.getId_producto());
	}
	@Test
	public void testsetPro_descripcion() throws DomainException {
		final String descri="Texto para descripcion";
		producto.setPro_descripcion(descri);
		assertEquals("Descripcion",descri, producto.getPro_descripcion());
	}
	//Comprobar entrada no numerica - no ha lugar
	
	//Comprobar entrada numerica con decimal/verificar igualdad
	@Test
	public void testSetPrecio1() throws DomainException {
		producto.setPro_precio(23.34);
		assertEquals("Precio con decimales",23.34,producto.getPro_precio(),0);
	}
	
	//Comprobar entrada numerica =0
	@Test (expected=DomainException.class)
	public void testSetPrecio2() throws DomainException{
		producto.setPro_precio(0d);
	}
	
	//Comprobar entrada numerica < 0
	@Test (expected=DomainException.class)
	public void testSetPrecio3() throws DomainException{
		producto.setPro_precio(-100);
	}


	@Test (expected=DomainException.class)
	public void testSetFecActivacion() throws DomainException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
		
		//update a date
		calendar.set(Calendar.YEAR, 2000);
		calendar.set(Calendar.MONTH, 02);
		calendar.set(Calendar.MINUTE, 10);
		
		producto.setPro_fecActi(calendar);
	}

	@Test 
	public void testSetFecActivacion2() throws DomainException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
		
		//update a date
		calendar.set(Calendar.YEAR, 2020);
		calendar.set(Calendar.MONTH, 02);
		calendar.set(Calendar.MINUTE, 10);
		
		producto.setPro_fecActi(calendar);
	}
	@Test
	public void testSetFecDesactivacion() {
	}

	@Test
	public void testSetCantidadStock()  throws DomainException {
		producto.setPro_stock(23);
		assertEquals("Cantidad Stock",23,producto.getPro_stock(),0);
	}

	@Test (expected=DomainException.class)
	public void testSetCantidadStock2()  throws DomainException {
		producto.setPro_stock(200);
		
	}
	
}
