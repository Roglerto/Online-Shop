package es.rf.tienda.objetos.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Producto;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.Conexion;
import es.rf.tienda.util.Rutinas;

public class ProductosDAO extends InterfacesDAO<Producto>{

	private final String SELECT="SELECT * FROM producto";
	private final String INSERT="INSERT into producto VALUES ";
	private final String DELETEREGISTRO="Delete from producto";
	private final String UPDATE=" UPDATE producto SET ";
	private final String FINDREGISTER="SELECT MAX(id_producto) FROM producto ";
	private final String VACIO="SELECT * FROM producto WHERE id_producto=";
	
	
	private String ID_PRODUCTO="id_producto";
	private String CAT_DESCRIPCION="cat_descripcion";
	private String CAT_NOMBRE="cat_nombre";
	
	private static Connection conn = null;
	private Statement stmt = null;
	
	private ArrayList<Producto> listaProducto;
	
	ProductosDAO(){
		
		listaProducto=new ArrayList<Producto>();
		
		conn=Conexion.getConnection();
		try {
			stmt= conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void guardar()  throws DAOException{
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(" ERROR en borrado");
		}
	}
	

	@Override
	public List<Producto> leerRegistro(Producto clase) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int actualizarRegistro(Producto clase) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String obtenWhere(Producto clase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String obtenLista(Producto clase, String separador) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public int insertarRegistro(Producto prod) throws DAOException {
		String sql=INSERT;		
		int id;
		
		sql+="("+"'"+prod.getId_producto()+"'"+","+prod.getId_pais()+","+prod.getPro_cantXUniventa()+","+"'"+prod.getPro_descripcion()+"'"+","+"'"+prod.getPro_desLarga()+"'"+
				","+"'"+prod.getPro_fecActi()+"'"+","+"'"+prod.getPro_fecDesacti()+"'"+","+"'"+prod.getPro_fecRepos()+"'"+","+prod.getPro_nSkBajo()+","+prod.getPro_nStkAlto()+","+prod.getPro_precio()+","+"'"+prod.getPro_stat()+"'"+","+prod.getPro_stkReservado()+","+prod.getPro_stock()+
				","+"'"+prod.getPro_uniUltNivel()+"'"+","+"'"+prod.getPro_uniVenta()+"'"+","+"'"+prod.getPro_usoRecomendado()+"'"+")";
					
			try {
				stmt.executeUpdate(sql);
				System.out.println(sql);
				return 1;
			} catch (SQLException ee) {
				throw new DAOException(" ERROR en INSERT registro");
				
			}
			
	}*/



	/*@Override
	public int borrarRegistro(Producto prod) throws DAOException {
		String sql=DELETEREGISTRO;

		sql=Rutinas.addSalida(sql,ID_PRODUCTO, prod.getId_categoria(), "WHERE");	
			
			return borraRegistro(sql,prod.getId_categoria());

		
	}*/
	



}
