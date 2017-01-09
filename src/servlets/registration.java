package servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.objetos.daos.Hibernate.UsuarioDAOH;
import es.rf.tienda.util.Rutinas;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Usuario user;
	private UsuarioDAOH  uDAOH;
	private int user_tipo=0;
	//private Calendar user_fecAlta,user_fecConfirmacion;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
        super();
        user=new Usuario();
        uDAOH=new UsuarioDAOH("Usuario");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		
		 String user_nombre=request.getParameter("user_nombre");
	     String user_email=request.getParameter("user_email");
	     String user_pass=request.getParameter("user_pass");
	    //int user_tipo=Integer.parseInt(request.getParameter("use_tipo"));
	     user_tipo++;
	     //int user_tipo=request.getParameter("use_tipo");
	     String user_dni=request.getParameter("user_dni");
	     String user_fecAlta=request.getParameter("user_fecAlta");
	     String user_fecConfirmacion=request.getParameter("user_fecConfirmacion");
		
	     try {
	    	user.setUser_nombre(user_nombre);
	    	user.setUser_email(user_email);
	    	user.setUser_pass(user_pass);
	    	user.setUser_tipo(user_tipo);
			user.setUser_dni(user_dni);
			
			user.setUser_fecAlta(user_fecAlta);
			user.setUser_fecConfirmacion(user_fecConfirmacion);
			
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// request.setAttribute("error", 39);
		     //request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	     
	     try {
			uDAOH.insertarRegistro(user);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     System.out.println(" ID USUARIO " +user.getId_usuario());
	     int numid=user.getId_usuario();
	     request.setAttribute("idu", numid);
	     request.getRequestDispatcher("index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
