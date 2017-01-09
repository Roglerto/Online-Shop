package es.rf.tienda.dominio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.Entity;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.interfaces.daos.Validable;
import es.rf.tienda.util.Validator;
@Entity
public class PedidoCarrito  implements Validable{
	private int pedido;
	private int id_usuario;
	private String id_producto;
	private int car_cantidad;
	private double car_precio;
	private String car_envio;
	private String car_pago;
	private String car_tarjeta;
	private Calendar car_feCadud;
	private int car_ccv;
	private String car_nombre;
	private int car_stat;
	private ArrayList<Calendar> car_feCambio;
	private ArrayList<Producto> lista_productos;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar today = Calendar.getInstance();
	
	PedidoCarrito(){
		car_feCambio=new ArrayList<Calendar>();
		lista_productos=new ArrayList<Producto>();
	}

	public int getPedido() {
		return pedido;
	}

	public void setPedido(int pedido) {
		this.pedido = pedido;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public boolean isValid_id_usuario(int id_usuario){	
		return Validator.isVacio( id_usuario);
	}
	//COMPROBACION BASE DE DATOS
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getId_producto() {
		return id_producto;
	}

	public boolean isValid_id_producto(String id_producto){	
		return Validator.isVacio( id_producto);
	}
	
	public void setId_producto(String id_producto) {
		this.id_producto = id_producto;
	}

	public int getCar_cantidad() {
		return car_cantidad;
	}

	public boolean isValid_car_cantidad(int car_cantidad){	
		return Validator.isVacio(  car_cantidad);
	}
	
	public void setCar_cantidad(int car_cantidad) {
		this.car_cantidad = car_cantidad;
	}

	public double getCar_precio() {
		return car_precio;
	}

	public void setCar_precio(double car_precio) {
		this.car_precio = car_precio;
	}

	public String getCar_envio() {
		return car_envio;
	}

	public void setCar_envio(String car_envio) {
		this.car_envio = car_envio;
	}

	public String getCar_pago() {
		return car_pago;
	}

	public void setCar_pago(String car_pago) {
		this.car_pago = car_pago;
	}

	public String getCar_tarjeta() {
		return car_tarjeta;
	}

	public void setCar_tarjeta(String car_tarjeta) {
		this.car_tarjeta = car_tarjeta;
	}

	public Calendar getCar_feCadud() {
		return car_feCadud;
	}

	public void setCar_feCadud(Calendar car_feCadud) throws DomainException {
		if(Validator.valDateMax(car_feCadud, today))
			this.car_feCadud = car_feCadud;
		else throw new DomainException("ERROR car_feCadud");
	}

	public int getCar_ccv() {
		return car_ccv;
	}

	public void setCar_ccv(int car_ccv) {
		this.car_ccv = car_ccv;
	}

	public String getCar_nombre() {
		return car_nombre;
	}

	public void setCar_nombre(String car_nombre) {
		this.car_nombre = car_nombre;
	}

	public int getCar_stat() {
		return car_stat;
	}

	public void setCar_stat(int car_stat) {
		this.car_stat = car_stat;
	}

	public ArrayList<Calendar> getCar_feCambio() {
		return car_feCambio;
	}

	public void setCar_feCambio(ArrayList<Calendar> car_feCambio) {
		this.car_feCambio = car_feCambio;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
