<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		 <link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	</head>
	<body>
	
	
	<!-- CABECERA -->
	<header><div id=logo><img src="pictures/t.jpg"  alt="Logo"/></div>
	<header> HOME</header>
	  <section id="display"> <div id=logo2><img src="pictures/p.jpg" alt="Logo"/></div> 
	  </section></header>
		
	 <!-- FIN CABECERA -->
	<!-- registrarse -->
	<div>		
	<hr/>
	
	<% if(request.getAttribute("error")!=null){ %>
		<script type="text/javascript">
   			 var msg = "ERROR AL INTRODUCIR DATOS";
    	alert(msg);
		</script>
	<% } %>
	
	<% if(request.getAttribute("idu")!=null){ %>
	
		<div id=logo><img src="pictures/s.jpg"  alt="Logo"/></div>
		
	    <ul class="menuVert2">
		<li><a href="desconexion">DESCONECTAR</a></li>
		</ul>
	
	<% } else{ %>
	
		 <ul class="menuVert3">
		<li><a href="register.jsp">INICIAR SESION</a></li>
		</ul> 
		 <ul class="menuVert2">
		<li><a href="register.jsp">REGISTRO</a></li>
		</ul>
	<%} %>
	
	
	</div>
	<!-- FIN MENU -->
	
	<!-- MENU -->
	<div>		
	<hr/>
	 <ul class="menuVert1">
	<li><a href=inicio>CATEGORIA</a></li>
	</ul>
	</div>
	<!-- FIN MENU -->
	
	<!--<%=request.getRemotePort() %>-->
	

	</body>
</html>