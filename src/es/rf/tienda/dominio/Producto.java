package es.rf.tienda.dominio;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.interfaces.daos.Validable;
import es.rf.tienda.util.Rutinas;
import es.rf.tienda.util.Validator;
@Entity
public class Producto  implements Validable {
	
	//isvalid para comprobar los obligatorios
	@Transient
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	@Transient
	Calendar today = Calendar.getInstance();
	
	//5 caracteres,letras y numeros
	@Id
	private String id_producto;
	//100 caracteres
	private String pro_descripcion;
	//2000 caracteres
	private String pro_desLarga;
	//2 decimales
	private double pro_precio;
	//entero
	private int pro_stock;
	//fecha>=actual
	private Calendar pro_fecRepos;
	//fecha>=actual
	private Calendar pro_fecActi;
	//fecha >=actual, si tiene fecha activacion > fecha activacion
	private Calendar pro_fecDesacti;
	//nombre de la unidad de venta de este producto
	private String pro_uniVenta;
	//unidades ultimas en unidad de venta(numero de conos o de sticks...
	private int pro_cantXUniventa;
	//nombre de la unidad ultimo nivel
	private String pro_uniUltNivel;
	//codigo del pais de origen
	private int id_pais;
	//texto 2000 caracteres acerca del uso del producto
	private String pro_usoRecomendado;
	
	//numero de articulos reservados por pedidos
	private int pro_stkReservado;
	//si el disponible esta por encima de estas unidades se indicara existencia alta
	//cuando este por debajo se indicara existencia medio
	private int pro_nStkAlto;
	//si el disponible está por debajo de estas unidades, se indicara existencia baja
	private int pro_nSkBajo;
	//A alta B baja
	private String pro_stat;
	
	/*@ManyToOne(targetEntity=Categoria.class,
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY)
	@JoinColumn(name="id_categoria")*/
	
	private int id_categoria;
	/**
	 * 
	 * @return id_producto
	 */
	public String getId_producto() {
		return id_producto;
	}
	
	/**
	 * 
	 * @param id_producto
	 * @return true if is empty false in other case
	 */
	public boolean isValid_id_producto(String id_producto){	
		return Validator.isVacio(id_producto);
	}
	
	/**
	 * Set an id product
	 * @param id_producto
	 * @throws DomainException
	 */
	public void setId_producto(String id_producto) throws DomainException{
		if(Validator.isAlfanumeric(id_producto) && Validator.cumpleLongitudMin(id_producto, 5)){
			this.id_producto = id_producto;
		
		}else{
			throw new DomainException("ERROR id_producto");
		}
	}
	
	/**
	 * 
	 * @return the product description
	 */
	public String getPro_descripcion() {
		return pro_descripcion;
	}
	
	/**
	 * 
	 * @param pro_descripcion
	 * @return true if is empty false in other case
	 */
	public boolean isValid_pro_descripcion(String pro_descripcion){	
		return Validator.isVacio(pro_descripcion);
	}
	
	/**
	 * Set the value of the  pro_description
	 * @param pro_descripcion
	 * @throws DomainException
	 */
	public void setPro_descripcion(String pro_descripcion)  throws DomainException{
		if(Validator.cumpleLongitudMax(pro_descripcion, 100))
			this.pro_descripcion = pro_descripcion;
		else throw new DomainException("ERROR pro_descripcion");
	}
	
	/**
	 * Get the pro_desLarga value
	 * @return
	 */
	public String getPro_desLarga() {
		return pro_desLarga;
	}
	
	/**
	 * Set the value of the pro_desLarga
	 * @param pro_desLarga
	 * @throws DomainException
	 */
	public void setPro_desLarga(String pro_desLarga) throws DomainException {
		if(Validator.cumpleLongitudMax(pro_descripcion, 2000))
			this.pro_desLarga = pro_desLarga;
		else throw new DomainException("ERROR pro_desLarga");
	}
	
	/**
	 * Get the pro_precio value
	 * @return
	 */
	public double getPro_precio() {
		return pro_precio;
	}
	
	/**
	 * 
	 * @param pro_precio
	 * @return true if is empty false in other case
	 */
	public boolean isValid_pro_precio(String pro_precio){	
		return Validator.isVacio(pro_precio);
	}
	
	/**
	 * Set the value of pro_precio variable
	 * @param pro_precio
	 * @throws DomainException
	 */
	public void setPro_precio(double pro_precio)  throws DomainException{
		if(Validator.cumpleRango(pro_precio, 0, 100))
			this.pro_precio = pro_precio;
		else throw new DomainException("ERROR pro_precio" + this.pro_precio);
	}
	
    /**
     * Get the value of the pro_stock variable
     * @return
     */
	public int getPro_stock() {
		return pro_stock;
	}
	
	/**
	 * Set the value of the pro_stock variable
	 * @param pro_stock
	 * @throws DomainException
	 */
	public void setPro_stock(int pro_stock) throws DomainException{
		if(Validator.cumpleRango(pro_stock, 0, 100))
			this.pro_stock = pro_stock;
		else throw new DomainException("ERROR pro_stock");
	}
	
	/**
	 * Get the value of the pro_fecRepos variable
	 * @return pro_fecRepos
	 */
	public String getPro_fecRepos() {
		return Rutinas.convierteAString(pro_fecRepos);
	}
	
	/**
	 * Set the value of the pro_fecRepos
	 * @param pro_fecRepos
	 * @throws DomainException
	 */
	public void setPro_fecRepos(Calendar pro_fecRepos) throws DomainException {
		if(Validator.valDateMax(pro_fecRepos, today))
				this.pro_fecRepos = pro_fecRepos;
		else throw new DomainException("ERROR pro_fecRepos");
	}
	/**
	 * Get the value of the pro_fecActi variable
	 * @return pro_fecActi
	 */
	public String getPro_fecActi() {
		return Rutinas.convierteAString(pro_fecActi);
	}
	
	/**
	 * Set the value of the pro_fecActi variable
	 * @param pro_fecActi
	 * @throws DomainException
	 */
	public void setPro_fecActi(Calendar pro_fecActi) throws DomainException{
		if(Validator.valDateMax(pro_fecActi, today))
			this.pro_fecActi = pro_fecActi;
		else throw new DomainException("ERROR pro_fecActi");
	}
	
	/**
	 * Get the value of the pro_fecDesacti variable
	 * @return pro_fecDesacti
	 */
	public String getPro_fecDesacti() {
		return Rutinas.convierteAString(pro_fecDesacti);
	}
	
	/**
	 * Set the value of the pro_fecDesacti variable
	 * @param pro_fecDesacti
	 * @throws DomainException
	 */
	public void setPro_fecDesacti(Calendar pro_fecDesacti) throws DomainException{
		if(Validator.valDateMax(pro_fecDesacti, today)){
			if(pro_fecActi!=null && Validator.valDateMax(pro_fecDesacti, today) )
					 this.pro_fecDesacti = pro_fecDesacti;
			if(pro_fecActi==null)
				this.pro_fecDesacti = pro_fecDesacti;
		}else throw new DomainException("ERROR pro_fecDesacti");
	}
	
	/**
	 * Get the value of the pro_uniVenta variable
	 * @return pro_uniVenta
	 */
	public String getPro_uniVenta() {
		return pro_uniVenta;
	}
	
	/**
	 * Check if the value of pro_uniVenta is empty
	 * @param pro_uniVenta
	 * @return true if is empty false in other case
	 */
	public boolean isValid_pro_uniVenta(String  pro_uniVenta){	
		return Validator.isVacio( pro_uniVenta);
	}
	
	/**
	 * Set the value of the pro_uniVenta variable
	 * @param pro_uniVenta
	 * @throws DomainException
	 */
	public void setPro_uniVenta(String pro_uniVenta) throws DomainException{
		if(Validator.cumpleLongitud(pro_uniVenta, 1, 10))
				this.pro_uniVenta = pro_uniVenta;
		else throw new DomainException("ERROR pro_uniVenta");
	}
	
	/**
	 * Get the value of the variable pro_cantXUniventa
	 * @return pro_cantXuniventa
	 */
	public int getPro_cantXUniventa() {
		return pro_cantXUniventa;
	}
	
	/**
	 * Set the value of the variable pro_cantXUniventa
	 * @param pro_cantXUniventa
	 * @throws DomainException
	 */
	public void setPro_cantXUniventa(int pro_cantXUniventa) throws DomainException{
		if(Validator.cumpleRango(pro_cantXUniventa, 0, 100))
			this.pro_cantXUniventa = pro_cantXUniventa;
		else throw new DomainException("ERROR pro_cantXUniventa");
	}
	
	/**
	 * Get the value of the pro_uniUltNivel
	 * @return pro_uniUltNivel
	 */
	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}
	
	/**
	 * Set the value of the pro_uniUltNivel variable
	 * @param pro_uniUltNivel
	 * @throws DomainException
	 */
	public void setPro_uniUltNivel(String pro_uniUltNivel) throws DomainException {
		if(Validator.isAlfanumeric(pro_uniUltNivel))
			this.pro_uniUltNivel = pro_uniUltNivel;
		else throw new DomainException("ERROR pro_uniUltNivel");
	}
	/**
	 * Get the value of the id_pais variable
	 * @return id_pais
	 */
	public int getId_pais() {
		return id_pais;
	}
	//COMPROBACION CON BASE DE DATOS
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}
	public void setPro_usoRecomendado(String pro_usoRecomendado)throws DomainException {
		if( Validator.cumpleLongitud(pro_usoRecomendado, 0, 2000))
			this.pro_usoRecomendado = pro_usoRecomendado;
		else throw new DomainException("ERROR pro_usoRecomendado");
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public int getPro_stkReservado() {
		return pro_stkReservado;
	}
	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}
	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}
	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}
	public int getPro_nSkBajo() {
		return pro_nSkBajo;
	}
	public void setPro_nSkBajo(int pro_nSkBajo) {
		this.pro_nSkBajo = pro_nSkBajo;
	}
	public String getPro_stat() {
		return pro_stat;
	}
	public void setPro_stat(String pro_stat) {
		this.pro_stat = pro_stat;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
