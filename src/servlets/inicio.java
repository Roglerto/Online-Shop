package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.objetos.daos.Hibernate.CategoriaDAOH;

/**
 * Servlet implementation class inicio
 */
@WebServlet("/inicio")
public class inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int hitCount; 
	private Map<String,Integer>nombres;
	private List<Categoria> categoria;
	static CategoriaDAOH cDAOH;
	private String lista;
	private Categoria reg1;
	private String actualizar;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public inicio() {		
		super();
		hitCount = 0;
		nombres=new HashMap<String,Integer>();
		categoria=new ArrayList<Categoria>();
		cDAOH = new CategoriaDAOH("Categoria");
		reg1 = new Categoria();
		actualizar="";
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lista="";
		int veces=0;
		int id=0;
		/*// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("Bienvenido a mi Mundo...o es Supermundo?");
		out.println("</BODY></HTML>");*/
		// Set response content type
	      response.setContentType("text/html");
	      // This method executes whenever the servlet is hit 
	      // increment hitCount 
	      hitCount++; 
	      String nombre=request.getParameter("nombre");
	      String descripcion=request.getParameter("descripcion");
	      
	      if(request.getParameter("idvar")!=null){
	    	   id =Integer.parseInt(request.getParameter("idvar"));
	      }
	      actualizar=request.getParameter("var");
	      
	      reg1.setCat_nombre(nombre);
		  reg1.setCat_descripcion(descripcion);
	      
		  if(actualizar!=null){
			 
				  try {
					reg1.setId_categoria(id);
					cDAOH.actualizarRegistro(reg1);
				} catch (DAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     
			  
		  }else{ 
		     try {
		    	 if(nombre!=null){
			    	 if(nombre!="" ){
			    		 int num = cDAOH.insertarRegistro(reg1);
			    	 }
		    	 }
				
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	     
		  try {
			categoria= cDAOH.leerTodos();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	     request.setAttribute("servletName", categoria); //categorylist is an arraylist      contains object of class category  
	     request.getRequestDispatcher("showcategoria.jsp").forward(request,response);
	     /*
	      PrintWriter out = response.getWriter();
	      String title = " CATEGORIES";
	      String docType =
	      "<!doctype html public \"-//w3c//dtd html 4.0 " +
	      "transitional//en\">\n";
	   
	    	out.println("<html>"); 
	    	out.println("<head><title>" + title + "</title></head>");
	    	out.println("<body bgcolor=\"#f0f0f0\">" );
	    	out.println("<h1 align=\"center\">" + title + "</h1>\n" +
	        "<h2 align=\"center\">" + categoria.size() + "</h2>\n");
	    	
	    	out.println("<table border='1'>");
	    	
	    	for(int i=0;i<categoria.size();i++){
		    	 lista+=" - "+ categoria.get(i).getCat_descripcion();
		    	
		    	 out.println("<tr> <td>"+ categoria.get(i).getId_categoria()+"</td>");
		    	 out.println( "<td>"+ categoria.get(i).getCat_nombre()+"</td>");
		    	 out.println( "<td>"+ categoria.get(i).getCat_descripcion()+"</td>");
		    	  out.println( "</tr>");
	    	}
	    	out.println("</table>");
	    	out.println("<button id='listacategorias' onclick=location.href='index.jsp'> ATRAS </button>");
	    	out.println("<button id='añadircategoria' onclick=location.href='form.jsp'> AÑADIR CATEGORIA </button>");

	    	out.println( "</body></html>");*/
	      
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
