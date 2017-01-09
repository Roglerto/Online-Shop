package es.rf.tienda.util;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;


public class ValidatorTest {
	Calendar cal1,cal2,cal3;
	
	final String ALFANUMERICO="1234abcD";
	final String ALFANUMERICO2="12ad";
	final String ALFANUMERICO3="12a*^^%";
	
	@Before
	public void start(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		cal1 = new GregorianCalendar(2013,1,28,13,24,56);	
		cal2 = new GregorianCalendar(2013,1,28,13,24,56);	
		cal3 = new GregorianCalendar(2013,1,28,13,24,56);	

		//update a date
		cal1.set(Calendar.YEAR, 2007);
		cal1.set(Calendar.MONTH, 02);
		cal1.set(Calendar.MINUTE, 10);
		//update a date
		cal2.set(Calendar.YEAR, 2009);
		cal2.set(Calendar.MONTH, 02);
		cal2.set(Calendar.MINUTE, 10);
	}
	
	@Test
	public void testIsAlfanumeric() {
		assertEquals("Es alfanumerico",true,Validator.isAlfanumeric(ALFANUMERICO));
		assertEquals("No es alfanumerico, <5",false,Validator.isAlfanumeric(ALFANUMERICO2));
		assertEquals("No es alfanumerico",false,Validator.isAlfanumeric( ALFANUMERICO3));
	}
	
	@Test
	public void testisVacio(){
		assertEquals("Esta vacio",true,Validator.isVacio(""));
		assertEquals("No esta vacio",false,Validator.isVacio("hola world"));
	}
	
	@Test
	public void testcumplePhoneNumber(){
		assertEquals("Numero de telefono correcto",true,Validator.cumplePhoneNumber("6177565328"));
		assertEquals("Numero de telefono INcorrecto",false,Validator.cumplePhoneNumber("617755328"));

	}
	
	@Test
	public void testisEmailValido(){
		assertEquals("Email Valido",true,Validator.isEmailValido("tre@ter.tr"));
		assertEquals("Email No valido",false,Validator.isEmailValido("tr.uyyete.tr"));	
		
	}
	@Test
	public void testcumpleDNI(){
		assertEquals("DNI No valido",false,Validator.cumpleDNI("456g"));
		assertEquals("DNI Valido",true,Validator.cumpleDNI("45.868.674-G"));
	}
	@Test
	public void testcumpleRango(){
		assertEquals("Cumple rango",true,Validator.cumpleRango(5, 1, 6));
		assertEquals("No Cumple rango",false,Validator.cumpleRango(5, 1, 4));
	}
	@Test
	public void testcumpleRangoDouble(){
		assertEquals("Cumple rango",true,Validator.cumpleRango(5.0, 1, 6));
		assertEquals("No Cumple rango",false,Validator.cumpleRango(9.5, 10, 3));
	}
	
	@Test
	public void testcumpleLongitudMin(){
		assertEquals("texto mayor que longitud minima",true,Validator.cumpleLongitudMin("hola", 1));
		assertEquals("texto menor que longitud minima",false,Validator.cumpleLongitudMin("hola", 7));
		
	}
	@Test
	public void testcumpleLongitudMax(){
		assertEquals("texto menor que longitud maxima",true,Validator.cumpleLongitudMax("hola", 7));
		assertEquals("texto mayor que longitud maxima",false,Validator.cumpleLongitudMax("hola", 1));	
	}
	@Test
	public void testcumpleLongitudMinMax(){
		assertEquals("texto entre la longitudes",true,Validator.cumpleLongitud("hola", 1,7));
		assertEquals("texto No esta entre las longitudes",false,Validator.cumpleLongitud("hola", 7,1));
		
	}
	@Test
	public void testvalDateMin(){
		assertEquals("fecha menor",true,Validator.valDateMin(cal1, cal2));
		assertEquals("fecha No es menor",false,Validator.valDateMin(cal2, cal1));
	}
	@Test
	public void testvalDateMax(){
		assertEquals("fecha mayor",true,Validator.valDateMax(cal2, cal1));
		assertEquals("fecha No es mayor",false,Validator.valDateMax(cal1, cal2));
	}
	@Test
	public void testesFechaValida(){
		assertEquals("fecha valida",true,Validator.esFechaValida("23/01/2010"));
		assertEquals("No es fecha valida",false,Validator.esFechaValida("23/21/2010"));
	}
	@Test
	public void testesPasswordValida(){
		assertEquals("Password No valida ",false,Validator.esPasswordValida("123acbc@#"));
		assertEquals("Password  valida ",true,Validator.esPasswordValida("ioac34bcMD@#"));

	}
}
