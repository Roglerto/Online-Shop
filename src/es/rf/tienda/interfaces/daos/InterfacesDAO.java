package es.rf.tienda.interfaces.daos;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Producto;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.util.HibernateUtil;
import es.rf.tienda.util.Rutinas;

public abstract class InterfacesDAO<T> {
	
	protected Session sesion;
	protected Transaction tx;
	private String nombreTabla;
	
	
	public void setNombreTabla(String t){
		nombreTabla=t;	
	}
	public String getNombreTabla(String t){
		return nombreTabla;
	}
	
	/** 
	 * Muestra todas las categorias
	 * @return devuelve la lista de objetos T consultados
	 */
	public List<T> leerTodos() throws DAOException {
		List<T> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery("from Categoria").list();
		} finally {
			sesion.close();
		}
		return lista;
	}
	public abstract String obtenWhere(T clase) ;
	public abstract String obtenLista(T clase, String separador) ;
	
	public List<T> leerRegistro(T clase) throws DAOException {
		String where = obtenWhere(clase);
		List<T> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery("from  " + where).list();
		} finally {
			sesion.close();
		}
		return lista;
	}
	/**
	 * actualiza el registro con un nuevo valor devuelve un int con numero de registros a
	 * afectados
	 * @param clase
	 * @return
	 * @throws DAOException
	 */
	public int actualizarRegistro(T clase) throws DAOException {
		try {
			iniciaOperacion();
			sesion.update(clase);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
		return 1;
	}
	
	/**
	 * inseta en la base de datos el registro que se le pasa, modificandolo con el id
	 * con el que se ha grabado en la bdd
	 * @param clase
	 * @return el numero de registros afectados que sera 1
	 * @throws DAOException
	 */
	public int insertarRegistro(T clase) throws DAOException {
		long id = 0;

		try {
			iniciaOperacion();
			sesion.save(clase);
			tx.commit();
		//	clase.setId_categoria((int) id);
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			if (sesion!=null)
				sesion.close();
		}
		return 1;
	}
	
	
	public int borrarRegistro(T clase) throws DAOException {
		try {
			iniciaOperacion();
			sesion.delete(clase);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			sesion.close();
		}
		return 1;
	}
	


	protected void iniciaOperacion() throws HibernateException {
		sesion = HibernateUtil.getSession();
		tx = sesion.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
	}
	
	
}
