package es.rf.tienda.objetos.daos.Hibernate;

import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.Rutinas;

public class UsuarioDAOH extends InterfacesDAO<Usuario> {

	
	public UsuarioDAOH(String t) {
		setNombreTabla(t);
	}
	public String obtenWhere(Usuario clase) {

		String salida = obtenLista(clase, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		return salida;
	}

	public String obtenLista(Usuario clase, String separador) {
		String salida = "";
		if (clase.getId_usuario() > 0) {
			salida = Rutinas.addSalida(salida, "id_usuario", clase.getId_usuario(), separador);
		}
		if (clase.getUser_nombre() != null && clase.getUser_nombre().compareTo("") != 0) {
			salida = Rutinas.addSalida(salida, "CATNOMBRE", clase.getUser_nombre(), separador);
		}
		return salida;
	}
	

	@Override
	public List<Usuario> leerRegistro(Usuario clase) throws DAOException {
		String where = obtenWhere(clase);
		List<Usuario> lista = null;
		try {
			iniciaOperacion();
			lista = sesion.createQuery("from Usuario " + where).list();
		} finally {
			sesion.close();
		}
		return lista;
	}


}
