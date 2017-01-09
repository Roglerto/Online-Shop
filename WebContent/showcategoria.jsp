<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.ArrayList,es.rf.tienda.dominio.Categoria"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#b5eeee">
<h1 align="center"> CATEGORIAS </h1>
 <%  ArrayList<Categoria> cate = (ArrayList<Categoria>) request.getAttribute("servletName");
 %>
<h2 align="center"> <% out.print(cate.size()); %> </h2>
     <h2 align="center">
		<table border="1">
		 <%  for(int i=0;i<cate.size();i++){ %>		    	
		    	<tr> <td> <% out.print(cate.get(i).getId_categoria()); %></td>
		    	 <td><% out.print(cate.get(i).getCat_nombre()); %></td>
		    	 <td><% out.print(cate.get(i).getCat_descripcion()); %></td>
		    	 <td><button id="añadircategoria" onclick=location.href="form.jsp?idvar=<%=cate.get(i).getId_categoria() %>&var=<%out.print(cate.get(i).getCat_nombre()); %>"> actualizar </button></td>
		    	 <td><button id="borrarcategoria" onclick=location.href="delete?idvar=<%=cate.get(i).getId_categoria()%>"> borrar </button></td>
		    	 </tr>
	    	 <% }  %>
	    	 
	    	
	    	 
		</table>
		
	    <button id="listacategorias" onclick=location.href="index.jsp"> ATRAS </button>
	    <button id="añadircategoria" onclick=location.href="form.jsp"> AÑADIR CATEGORIA </button>
	    </h2>
</body>
</html>