<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>HOLA FORMULARIOS</title>
<style type="text/css" media="screen">
      /*la directiva include copia el contenido de un archivo y lo incrusta en la pagina*/
     <%@ include file="css/style.css" %>
</style>
</head>
<body>
  <h2 align="center">
 <% if (request.getParameter("var")!=null) { %>
 		<form action="inicio?idvar=<%=request.getParameter("idvar")%>&var=<%out.print(request.getParameter("var"));%>" method="post">
 <% } else { %>
 
	<form action="inicio" method="post">

 <% } %>
    Nombre:
    <% if (request.getParameter("var")!=null) { %>
    <input type="text" name="nombre" value=<%out.print(request.getParameter("var"));%>>
    
    <% } else { %>
    	 <input type="text" name="nombre">
    <% } %>
    <br/>
    Descripcion:
    <textarea rows="5" cols="100" name="descripcion"> </textarea>
    <br/>
  
   <!-- <br/>
    Lenguaje preferido:
    <select name="lenguaje">
      <option value="java">java
      <option value="jsp" selected>jsp
      <option value="php">php
     
    </select>
    <br/>
    Me gusta el:
    <br/>
    <input type="Radio" name="preferencia" value= "Diseño"checked>Diseño
    <br/>
    <input type="Radio" name= "preferencia"value="Programacion">Programacion
    <br/>
    <input type="Radio" name= "preferencia"value="Modelado">Modelado
    <br/>
    <input type="Radio" name= "preferencia"value="Gerencia">Gerencia de proyectos
    <br/>   -->
 
 	
    <p><input type="submit" value="Enviar"></p>
      
</form>
 	<button onclick=location.href='inicio'> ATRAS </button>
 	
 	</h2>
</body>
</html>