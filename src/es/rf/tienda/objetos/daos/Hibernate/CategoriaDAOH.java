package es.rf.tienda.objetos.daos.Hibernate;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.HibernateUtil;
//import es.rf.tienda.util.RFDataConnection;
import es.rf.tienda.util.Rutinas;

public class CategoriaDAOH extends InterfacesDAO<Categoria> {

	
	public CategoriaDAOH(String t) {
		setNombreTabla(t);
	}
	public String obtenWhere(Categoria clase) {

		String salida = obtenLista(clase, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		return salida;
	}

	public String obtenLista(Categoria clase, String separador) {
		String salida = "";
		if (clase.getId_categoria() > 0) {
			salida = Rutinas.addSalida(salida, "id_categoria", clase.getId_categoria(), separador);
		}
		if (clase.getCat_nombre() != null && clase.getCat_nombre().compareTo("") != 0) {
			salida = Rutinas.addSalida(salida, "CATNOMBRE", clase.getCat_nombre(), separador);
		}
		return salida;
	}
	

	@Override
	public List<Categoria> leerRegistro(Categoria clase) throws DAOException {
		String where = obtenWhere(clase);
		List<Categoria> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery("from Categoria " + where).list();
		} finally {
			sesion.close();
		}
		return lista;
	}
/*
	@Override
	public Categoria leerRegistro(Categoria clase) throws DAOException {
		List<Categoria> lista = leerRegistros(clase);
		if (lista.size() == 1) {
			return lista.get(0);
		} else
			throw new DAOException("Demasiados registros en Categorias");
	}*/


	

	
}


