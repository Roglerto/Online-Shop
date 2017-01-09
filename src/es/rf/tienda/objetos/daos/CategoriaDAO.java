package es.rf.tienda.objetos.daos;

import static org.junit.Assert.assertEquals;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfaces.daos.InterfacesDAO;
import es.rf.tienda.util.Conexion;
import es.rf.tienda.util.Rutinas;

public class CategoriaDAO extends InterfacesDAO<Categoria> {
//res.-> categoria
	private final String SELECT="SELECT * FROM categoria";
	private final String INSERT="INSERT into categoria VALUES ";
	private final String DELETEREGISTRO="Delete from categoria";
	private final String UPDATE=" UPDATE categoria SET ";
	private final String FINDREGISTER="SELECT MAX(id_categoria) FROM categoria ";
	private final String VACIO="SELECT * FROM categoria WHERE id_categoria=";
	private final String EMPTYCATEGORIA="SELECT * FROM categoria";
	
	private String ID_CATEGORIA="id_categoria";
	private String CAT_DESCRIPCION="cat_descripcion";
	private String CAT_NOMBRE="cat_nombre";
	
	private static Connection conn = null;
	private Statement stmt = null;
	
	private ArrayList<Categoria> listaCategoria;
	
	CategoriaDAO()  throws DAOException{
		
		listaCategoria=new ArrayList<Categoria>();
		
		conn=Conexion.getConnection();
		try {
			stmt= conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(" ERROR en borrado");
		}
	}
	
	public  void disconnect()  throws DAOException{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DAOException(" ERROR en borrado");
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
	
	
	public int borraRegistro(String consulta,int i) throws DAOException{					
				
			try {
				ResultSet rs;	
					
				rs = stmt.executeQuery(EMPTYCATEGORIA);
				if(!rs.next()){
					return 0;
				}
				else{ 	
					stmt.executeUpdate(consulta);
					return 1;				
				}
				
			} catch (SQLException e) {
				throw new DAOException(" ERROR en borrado");
			}						
								
	}
	
	public List<Categoria> montaLista(String consulta) throws DAOException{				
				
		ResultSet rs;
		try {
			rs = ((java.sql.Statement) stmt).executeQuery(consulta);
		} catch (SQLException e) {
			throw new DAOException(" ERROR en monta lista");
		}
		
		try {
			while(rs.next()){
				Categoria catego=new Categoria();
				
				catego.setCat_descripcion(rs.getString("cat_descripcion"));
				catego.setCat_nombre(rs.getString("cat_nombre"));
				catego.setId_categoria(Integer.parseInt(rs.getString("id_categoria")));
				
				listaCategoria.add(catego);
			}
		} catch (NumberFormatException e) {
			throw new DAOException(" ERROR en montalista");
		} catch (SQLException e) {
			throw new DAOException(" ERROR en montalista");
		}	
		return listaCategoria;
	}
	
	public int insert(String consulta) throws DAOException{
		
		try {
			stmt.executeUpdate(consulta);
			
		} catch (SQLException e) {			
			throw new DAOException(" ERROR en insert registro");
		}			
		
		return 1;	
	}
	public int actualiza(String consulta) throws DAOException{
		
		try {
			stmt.executeUpdate(consulta);
			
		} catch (SQLException e) {
			throw new DAOException(" ERROR en insert registro");
		}			
		
		return 1;	
	}
	@Override
	public List leerTodos() throws DAOException {
		String sql=SELECT;
		return montaLista(sql);
	}

	@Override
	public List leerRegistro(Categoria catego) throws DAOException {
		String sql=SELECT;

		if((Integer)catego.getId_categoria()!=null){
			sql=Rutinas.addSalida(sql,ID_CATEGORIA, catego.getId_categoria(), "WHERE");
			return montaLista(sql);
		}else return null;
	}

	@Override
	public int actualizarRegistro(Categoria catego) throws DAOException {
		String sql=UPDATE;
		String sql2=FINDREGISTER;
		if((Integer)catego.getId_categoria()!=null){		
			//ResultSet rs= stmt.executeQuery(FINDREGISTER);
			//rs.next();
			//int max_id=Integer.parseInt(rs.getString(1));
			sql+="CAT_NOMBRE= "+"'"+catego.getCat_nombre()+"'"+","+" CAT_DESCRIPCION= "+"'"+catego.getCat_descripcion()+"'" +" WHERE ID_CATEGORIA="+"'"+catego.getId_categoria()+"'";

			return actualiza(sql);
		}else return 0;
	}
	
	@Override
	public int insertarRegistro(Categoria catego) throws DAOException {
		String sql=INSERT;		
		int id;
		
		if((Integer)catego.getId_categoria()!=null){
			sql+="("+catego.getId_categoria()+","+"'"+catego.getCat_nombre()+"'"+","+"'"+catego.getCat_descripcion()+"'"+")";
					
			try {
				insert(sql);
			} catch (DAOException e) {
				throw new DAOException(" ERROR en INSERT registro");
			}
				
			ResultSet rs;
			try {
				rs = stmt.executeQuery(FINDREGISTER);
				rs.next();
				id=Integer.parseInt(rs.getString(1));
				return id;
			} catch (SQLException e) {
				throw new DAOException(" ERROR en INSERT registro");
			}					
				
				
		}else return 0;
	}

	@Override
	public int borrarRegistro(Categoria catego) throws DAOException {
		String sql=DELETEREGISTRO;

		if((Integer)catego.getId_categoria()!=null){
			sql=Rutinas.addSalida(sql,ID_CATEGORIA, catego.getId_categoria(), "WHERE");	
			
			return borraRegistro(sql,catego.getId_categoria());

		}else return 0;
	}

	@Override
	public String obtenWhere(Categoria clase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String obtenLista(Categoria clase, String separador) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
