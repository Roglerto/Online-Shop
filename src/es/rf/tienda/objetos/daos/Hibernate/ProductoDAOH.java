package es.rf.tienda.objetos.daos.Hibernate;

import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Producto;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.Rutinas;

public class ProductoDAOH extends InterfacesDAO<Producto>{

	@Override
	public String obtenWhere(Producto clase) {

		String salida = obtenLista(clase, "AND");
		if (salida.length() > 0)
			salida = "WHERE " + salida;
		return salida;
	}

	@Override
	public String obtenLista(Producto clase, String separador) {
		String salida = "";
		if (clase.getId_categoria() > 0) {
			salida = Rutinas.addSalida(salida, "id_producto", clase.getId_producto(), separador);
		}
		if (clase.getId_producto() != null ) {
			salida = Rutinas.addSalida(salida, "pro_descripcion", clase.getPro_descripcion(), separador);
		}
		return salida;
	}
	

	


}
