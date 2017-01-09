package es.rf.tienda.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Rutinas {

	
	/**
	 * Recibe una fecha en formato String, la devuelve como
	 * Calendar
	 * 
	 * @param fecha string
	 * @eturn fecha Calendar
	 * 
	 * Si hay problemas, devuelve NULL
	 * 
	 */
	public static Calendar convierteACalendar(String fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar cal  = Calendar.getInstance();
		
		try {
			sdf.setLenient(false);
			cal.setTime(sdf.parse(fecha));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return cal;
	}
	public static Boolean compruebaFecha(String fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal  = Calendar.getInstance();
		boolean correcto=false;
		
		try {
			sdf.setLenient(false);
			cal.setTime(sdf.parse(fecha));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return correcto;
	}
	/**
	 * Recibe una fecha en formato calendar y la devuelve como string
	 * 
	 * @param fecha Calendar
	 * @return fecha string con formato dd/mm/yyy
	 */
	public static String convierteAString(Calendar fecha){
		String strdate = null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		if (fecha != null) {
		strdate = sdf.format(fecha.getTime());
		}
		
		return strdate;
	}
	
	/**
	 * Completa SQL Añadiendo el nombre del campo y su valor (si se pasa)
	 * Pensando para INSERT, UPDATES y Where
	 * 
	 * @param salida 		String con la parte que se lleva construida
	 * @param nombreCampo 	String con el nombre de un campo
	 * @param valor			 Contenido del campo, puede ser int,double,long o String
	 * @param separador 	String con el contenido que ha de separar esta entrada de las precedentes
	 * @return Devuelve		 una string con los calores añadidos
	 */
	public static String addSalida(String salida,String nombreCampo,int valor,String separador){
		return  addSalidaSencilla( salida,nombreCampo,""+valor,separador);
	}
	public static String addSalida(String salida,String nombreCampo,double valor,String separador){
		return  addSalidaSencilla( salida,nombreCampo,""+valor,separador);
	}
	public static String addSalida(String salida,String nombreCampo,long valor,String separador){
		return  addSalidaSencilla( salida,nombreCampo,""+valor,separador);
	}
	public static String addSalida(String salida,String nombreCampo,String valor,String separador){
		return  addSalidaSencilla( salida,nombreCampo,"'"+valor+"'",separador);
	}
	
	public static String addSalidaSencilla(String salida,String nombreCampo,String valor,String separador){
		if(salida.length()>0) 
			salida += " " + separador + " ";
		if(nombreCampo!=null && nombreCampo.compareTo("")>0)
			salida +=nombreCampo + " = ";
		salida +=valor;
		
		return salida;
	}
	
	/**
	 * completa la sentencia sql para añadir una consulta insert
	 * @return
	 */
	public static String addInsert(){
		return "";
	}

}
