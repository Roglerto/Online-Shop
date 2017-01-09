package es.rf.tienda.dominio;

import java.util.Calendar;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.interfaces.daos.Validable;
import es.rf.tienda.util.Validator;
@Entity
public class Usuario  implements Validable {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id_usuario;
	
	private String user_nombre;
	private String user_email;
	private String user_pass;
	private  int user_tipo;
	private String user_dni;
	private String user_fecAlta;
	private String user_fecConfirmacion;
	
	/* añadir cuando la conexion funcione
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name="dir_nombre",column=@Column(name="nombreEnvio")),
		@AttributeOverride(name="dir_direccion",column=@Column(name="direccionEnvio")),
		@AttributeOverride(name="dir_poblacion",column=@Column(name="poblacionEnvio")),
		@AttributeOverride(name="dir_cPostal",column=@Column(name="cPostalEnvio")),
		@AttributeOverride(name="dir_provincia",column=@Column(name="provinciaEnvio")),
		@AttributeOverride(name="dir_correo",column=@Column(name="correoEnvio")),
		@AttributeOverride(name="dir_pais",column=@Column(name="paisEnvio")), })
	private Direccion user_envio;
		
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name="dir_nombre",column=@Column(name="nombreFactura")),
		@AttributeOverride(name="dir_direccion",column=@Column(name="direccionFactura")),
		@AttributeOverride(name="dir_poblacion",column=@Column(name="poblacionFactura")),
		@AttributeOverride(name="dir_cPostal",column=@Column(name="cPostalFactura")),
		@AttributeOverride(name="dir_provincia",column=@Column(name="provinciaFactura")),
		@AttributeOverride(name="dir_correo",column=@Column(name="correoFactura")),
		@AttributeOverride(name="dir_pais",column=@Column(name="paisFactura")), })
	private Direccion user_pago;	
	*/
	
	public boolean isValid_id_usuario(int id_usuario){	
		return Validator.isVacio( id_usuario);
	}
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getUser_nombre() {
		return user_nombre;
	}
	public boolean isValid_user_nombre(String user_nombre){	
		return Validator.isVacio( user_nombre);
	}
	public void setUser_nombre(String user_nombre)  throws DomainException {
		if(Validator.cumpleLongitud(user_nombre, 5, 100))
				this.user_nombre = user_nombre;		
		else throw new DomainException("ERROR user_nombre");
	}
	public String getUser_email() {
		return user_email;
	}
	public boolean isValid_user_email(String user_email){	
		return Validator.isVacio( user_email);
	}
	public void setUser_email(String user_email) throws DomainException {
		if(Validator.isEmailValido(user_email) && Validator.cumpleLongitud(user_email, 6, 100)){
				this.user_email = user_email;
		
				//System.out.println(" BORRAR PELIGRO "+user_email);
		
		}else throw new DomainException("ERROR user_email");
	}
	public String getUser_pass() {
		return user_pass;
	}
	public boolean isValid_user_pass(String user_pass){	
		return Validator.isVacio( user_pass);
	}
	public void setUser_pass(String user_pass) throws DomainException{
		if(Validator.esPasswordValida(user_pass) && Validator.cumpleLongitud(user_pass, 8, 20))
			this.user_pass = user_pass;
		else throw new DomainException("ERROR user_pass");
	}
	public int getUser_tipo() {
		return user_tipo;
	}
	public void setUser_tipo(int user_tipo) {
		this.user_tipo = user_tipo;
	}
	public String getUser_dni() {
		return user_dni;
	}
	public void setUser_dni(String user_dni) throws DomainException{
		if(Validator.cumpleDNI(user_dni))
			this.user_dni = user_dni;
		else throw new DomainException("ERROR user_dni");
	}
	/*
	public Calendar getUser_fecAlta() {
		return user_fecAlta;
	}
	public void setUser_fecAlta(Calendar user_fecAlta) {
		this.user_fecAlta = user_fecAlta;
		
	}
	public Calendar getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}
	public void setUser_fecConfirmacion(Calendar user_fecConfirmacion) {
		this.user_fecConfirmacion = user_fecConfirmacion;
	}*/

	public String getUser_fecAlta() {
		return user_fecAlta;
	}
	public void setUser_fecAlta(String user_fecAlta) {
		this.user_fecAlta = user_fecAlta;
		
	}
	public String getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}
	public void setUser_fecConfirmacion(String user_fecConfirmacion) {
		this.user_fecConfirmacion = user_fecConfirmacion;
	}
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
