<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" >    
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href=" http://localhost:8080/PracticaServJSPyJDBC/diseno/css/diseno.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Google Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
    <title>Usuario Normal</title>
    <STYLE type="text/css">
  		H2 { text-align: center}
  		P { text-align: center}
  		/*A { padding-left: 1150px}*/
 	</STYLE>

</head>
<body style="background-color: #575757;">

    <header style="background-color: rgb(42,42,42);" class="container-fluid" id="cabecera">
        <div class="row" >
            <div class="col-xs-11">
                <img style="height: 80px; width: 350px; margin-bottom: 10px; margin-top: 10px;" src="http://localhost:8080/JPA-PRACTICA/diseno/imagenes/l1.png"  id="logo">
            </div>        
        </div>
    </header>
    
	<div class="container-fluid">
		<div class="row">
			<div class=col-xs-4>
				<img style="height: 150px; width: 200px; padding-bottom: 20px;" alt="" src="http://localhost:8080/JPA-PRACTICA/diseno/imagenes/usu.png">
				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    	<small style = "font-size: 15px" >PRODUCTOS</small>
				  	</button>
				  	<div  class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				    	<a style = "font-size: 15px" class="dropdown-item" href="http://localhost:8080/JPA-PRACTICA/RealizarCompra?correo=<%=request.getParameter("correo") %>&contra=<%=request.getParameter("contra")%>">Realizar Pedido</a>
				    	<a style = "font-size: 15px" class="dropdown-item" href="http://localhost:8080/JPA-PRACTICA/ComprasUsuario?correo=<%=request.getParameter("correo") %>&contra=<%=request.getParameter("contra")%>">Visualizar Compras</a>
				    	<a style = "font-size: 15px" class="dropdown-item" href="http://localhost:8080/JPA-PRACTICA/ServletDestroy">Cerrar Sesion</a>
				  	</div>
				</div>
			</div>
		</div>		
	</div>   
    
    <c:set var="correo" scope="request" value="${param.correo}" />
	<c:set var="contra" scope="request" value="${param.contra}" />
    <c:set var="nombre" scope="request" value="${param.nombre}"/>
    <c:set var="apellido" scope="request" value="${param.apellido}"/>
    <c:set var="cedula" scope="request" value="${param.cedula}"/>
    
    <h2 style="color: white; font-size: 35px;">Hola ${nombre}, bienvenid@ a nuestro sitio web</h2>

	<!-- AQUI VA LA IMAGEN -->
	<br>
	<p style="color: white; font-size: 20px;" id="label"><strong style="color: rgb(236,72,113);">Nombre:</strong> ${nombre}</p>
	<p style="color: white; font-size: 20px;" id="label"><strong style="color: rgb(236,72,113);">Apellido:</strong> ${apellido}</p>
	<p style="color: white; font-size: 20px;" id="label"><strong style="color: rgb(236,72,113);">Cedula:</strong> ${cedula}</p>
	<p style="color: white; font-size: 20px;" id="label"><strong style="color: rgb(236,72,113);">Correo Electronico:</strong> ${correo}</p>
	
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script type="text/javascript" src="diseno/js/ControladorAdmin.js"></script>
    
</body>

<!-- <div style="height: 590px">
	<h2></h2>
</div>-->

<footer class="page-footer font-small  darken-3 s" style="background-color: #393939; padding-top: 1opx;">

    <div class="container">  
    	<div class="row">
        	<div class="col-md-12 py-5">
          		<div class="mb-5 flex-center">
          			<!-- Facebook -->
            		<a class="fb-ic">
              			<i class="fab fa-facebook-f fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
            		</a>
            		<!-- Twitter -->
            		<a class="tw-ic">
              			<i class="fab fa-twitter fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
            		</a>
            		<!-- Google +-->
            		<a class="gplus-ic">
              			<i class="fab fa-google-plus-g fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
            		</a>
            		<!--Linkedin -->
            		<a class="li-ic">
              			<i class="fab fa-linkedin-in fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
            		</a>
            		<!--Instagram-->
            		<a class="ins-ic">
              			<i class="fab fa-instagram fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
            		</a>
            		<!--Pinterest-->
            		<a class="pin-ic">
              			<i class="fab fa-pinterest fa-lg white-text fa-2x"> </i>
            		</a>
          		</div>
        	</div>
      	</div>
	</div>
    
    <div class="footer-copyright text-center py-3" style="background-color: #1E1E1E;">� 2020 Copyright:
    	<a href="https://www.ups.edu.ec/">Universidad Politecnica Salesiana</a>
    </div>
  
  </footer>
</html>