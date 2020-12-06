<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width,user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href=" http://localhost:8080/JPA-PRACTICA/diseno/css/diseno.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<!-- Google Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
	<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet">
	<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css"
	rel="stylesheet">
<title>Buscar Productos</title>

</head>
<body style="background-color: #575757;">
	<c:set var="p" scope="request" value="${producto}" />


	<header class="container-fluid" id="cabecera">
		<div class="row">
			<div class="col-xs-11">
				<img
					src=" http://localhost:8080/JPA-PRACTICA/diseno/imagenes/logos2.png"
					id="logo">
			</div>

		</div>

	</header>

	<!-- Default dropright button -->
	<div class="container-fluid">
		<div class="row">
			<!-- SECCION DE LOS BOTONES DE NAVEGACION -->
			<div class=col-xs-3>
				<img style="height: 150px; width: 200px; padding-bottom: 20px;"
					alt=""
					src="http://localhost:8080/JPA-PRACTICA/diseno/imagenes/adm.png">
				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<small style="font-size: 15px">PRODUCTOS</small>
					</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a style="font-size: 15px" class="dropdown-item"
							href="http://localhost:8080/JPA-PRACTICA/AnadirProductos?eid=<%=request.getParameter("eid") %>">Agregar
							Productos</a> <a style="font-size: 15px" class="dropdown-item"
							href="http://localhost:8080/JPA-PRACTICA/EliminarProducto?eid=<%=request.getParameter("eid") %>">Eliminar
							Producto</a> <a style="font-size: 15px" class="dropdown-item"
							href="http://localhost:8080/JPA-PRACTICA/EditarProducto?eid=<%=request.getParameter("eid") %>">Editar
							Producto</a> <a style="font-size: 15px" class="dropdown-item"
							href="http://localhost:8080/JPA-PRACTICA/BuscarProducto?eid=<%=request.getParameter("eid") %>">Buscar
							Productos</a> <a style="font-size: 15px" class="dropdown-item"
							href="http://localhost:8080/JPA-PRACTICA/ListarProductos?eid=<%=request.getParameter("eid") %>">Listar
							Producto</a>
					</div>
				</div>
				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						id="dropdownMenuButton" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<small style="font-size: 15px">Mi Empresa</small>
					</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a style="font-size: 15px" class="dropdown-item"
							href="http://localhost:8080/JPA-PRACTICA/ListarReq?eid=<%=request.getParameter("eid") %>">Listar
							Ordenes</a> <a style="font-size: 15px" class="dropdown-item"
							href="http://localhost:8080/JPA-PRACTICA/Despachar?eid=<%=request.getParameter("eid") %>&cabecera=n&bandera=0">Atender
							Ordenes</a>
					</div>
				</div>
				<!--
				<div class="dropdown">
				  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    <small style = "font-size: 15px" >PRODUCTOS</small>
				  </button>
				  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				    <a style = "font-size: 15px" class="dropdown-item" href="#">Action</a>
				    <a style = "font-size: 15px" class="dropdown-item" href="#">Another action</a>
				    <a style = "font-size: 15px" class="dropdown-item" href="#">Something else here</a>
				  </div>
				</div>
				-->



			</div>

			<div class=col-xs-4>
				<h2 style="color: white; font-size: 30px">Datos del Producto</h2>
				<div style="height: 30px"></div>
				<form>
					<div class="form-group">
						<label style="color: white; font-size: 22px" for="nombre">Nombre
							del Producto</label> <input style="font-size: 18px" type="text"
							class="form-control" id="nombre" name="nombre"
							aria-describedby="emailHelp" placeholder="Nombre: ${p.nombre}">
					</div>
					<div class="form-group">
						<label style="color: white; font-size: 22px" for="descripcion">Descripcion</label>
						<input style="font-size: 18px" type="text" class="form-control"
							id="descripcion" name="descripcion"
							placeholder="${p.descripcion}">
					</div>
					<div class="form-group">
						<label style="color: white; font-size: 22px" for="precio">Precio</label>
						<input style="font-size: 18px" type="text" class="form-control"
							id="precio" name="precio" placeholder="${p.precio}">
					</div>
				</form>
			</div>
		</div>





		<!-- Latest compiled and minified JavaScript -->
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
			integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
			crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
			integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
			crossorigin="anonymous"></script>
		<script type="text/javascript" src="diseno/js/ControladorAdmin.js"></script>
</body>

<div style="height: 50px;"></div>




<!-- Footer -->
<footer class="page-footer font-small  darken-3 s"
	style="background-color: #393939; padding-top: 1opx;">

	<!-- Footer Elements -->
	<div class="container">

		<!-- Grid row-->
		<div class="row">

			<!-- Grid column -->
			<div class="col-md-12 py-5">
				<div class="mb-5 flex-center">

					<!-- Facebook -->
					<a class="fb-ic"> <i
						class="fab fa-facebook-f fa-lg white-text mr-md-5 mr-3 fa-2x">
					</i>
					</a>
					<!-- Twitter -->
					<a class="tw-ic"> <i
						class="fab fa-twitter fa-lg white-text mr-md-5 mr-3 fa-2x"> </i>
					</a>
					<!-- Google +-->
					<a class="gplus-ic"> <i
						class="fab fa-google-plus-g fa-lg white-text mr-md-5 mr-3 fa-2x">
					</i>
					</a>
					<!--Linkedin -->
					<a class="li-ic"> <i
						class="fab fa-linkedin-in fa-lg white-text mr-md-5 mr-3 fa-2x">
					</i>
					</a>
					<!--Instagram-->
					<a class="ins-ic"> <i
						class="fab fa-instagram fa-lg white-text mr-md-5 mr-3 fa-2x">
					</i>
					</a>
					<!--Pinterest-->
					<a class="pin-ic"> <i
						class="fab fa-pinterest fa-lg white-text fa-2x"> </i>
					</a>
				</div>
			</div>
			<!-- Grid column -->

		</div>
		<!-- Grid row-->

	</div>
	<!-- Footer Elements -->

	<!-- Copyright -->
	<div class="footer-copyright text-center py-3"
		style="background-color: #1E1E1E;">
		© 2020 Copyright: <a href="https://www.ups.edu.ec/"> ups.edu.ec</a>
	</div>
	<!-- Copyright -->

</footer>
</html>