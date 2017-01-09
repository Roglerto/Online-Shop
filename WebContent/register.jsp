<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
 
	<form action="registration" method="post">

    Nombre:
    <input type="text" name="user_nombre">
    <br/>
    
    Email:
    <input type="text" name="user_email">
    <br/>
 	
 	Pass:
    <input type="text" name="user_pass">
    <br/>
    
    Tipo (numero):
    <input type="text" name="user_tipo">
    <br/>
    
    DNI:
    <input type="text" name="user_dni">
    <br/>
    
    Fecha Alta:
    <input type="date"  name="user_fecAlta"  >
    <br/>
    
    Fecha Confirmacion:
    <input type="date" name="user_fec"  >
    <br/>
      
    
    <br/>
    <p><input type="submit" value="Enviar"></p>
      
</form>
 	<button onclick=location.href="index.jsp"> ATRAS </button>
 	
 	</h2>
</body>
</html>