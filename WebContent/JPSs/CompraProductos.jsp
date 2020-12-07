<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Comprar Productos</title>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body style="background-color: #575757;">
	<c:set var="lista" scope="request" value="${productos}" />
	<header class="container-fluid" id="cabecera">
        <div class="row" >
            <div class="col-xs-11">
                <img src="http://localhost:8080/PracticaServJSPyJDBC/diseno/imagenes/l1.png"  id="logo">
            </div>
        </div>
    </header>
	
	<div class="row" style="color: white;">
		<div class="col align-self-start"></div>
		<div>
			<h2 style="font-size: 30px">Comprar Productos</h2>
			<div style="width: 30px;"></div>
			<table class="table" style="color: white;">
				<tr>
					<td scope="col" style="font-size: 25px"><strong>Id</strong></td>
					<td scope="col" style="font-size: 25px"><strong>Nombre</strong></td>
					<td scope="col" style="font-size: 25px"><strong>Precio</strong></td>
					<td scope="col" style="font-size: 25px"><strong>Descripcion</strong></td>
				</tr>
				<c:forEach var="p" items="${lista}">
					<tr scope="row">
						<td style="font-size: 18px">${p.id}</td>
						<td style="font-size: 18px">${p.nombre}</td>
						<td style="font-size: 18px">${p.precio}</td>
						<td style="font-size: 18px">${p.descripcion}</td>
					</tr>
				</c:forEach>
			</table>
			<div id="resultado" style="font-size: 18px"></div>
	
			<div id="array" style="font-size: 18px"></div>
				
			<form name="mandar">
				<button style="font-size: 18px" name="comprar" type="button" class="btn btn-primary mb-2" onclick="enviarParametros()">Comprar</button>
			</form>
		</div>
		<div class="col align-self-end"></div>
	</div>
	
	
	<script>
	var colores = [];
		$(function(){
			$('table tr td').click(function(){
				var contenido = $(this).html();
				//$('#resultado').html('Contenido: '+contenido);
				colores.push(contenido);
				$('#array').html('Carrito: ' + colores);
			});
		});
		function enviarParametros() {
			//const valores = window.location.search;
			//const urlParams = new URLSearchParams(valores);
			//var correo = urlParams.keys();
			var email = parametroURL('correo');
			$('#resultado').html('Contenido: '+ email);
			window.location.assign('http://localhost:8080/PracticaServJSPyJDBC/ProcesarCompra?carrito='+colores+"&correo="+email);
		}
		function parametroURL(_par) {
			  var _p = null;
			  if (location.search) location.search.substr(1).split("&").forEach(function(pllv) {
			  	var s = pllv.split("="), //separamos llave/valor
			    ll = s[0],
			    v = s[1] && decodeURIComponent(s[1]); //valor hacemos encode para prevenir url encode
			    if (ll == _par) { //solo nos interesa si es el nombre del parametro a buscar
			      	if(_p==null){
			      		_p=v; //si es nula, quiere decir que no tiene valor, solo textual
			      	}else if(Array.isArray(_p)){
			      		_p.push(v); //si ya es arreglo, agregamos este valor
			      	}else{
			      		_p=[_p,v]; //si no es arreglo, lo convertimos y agregamos este valor
			      	}
			    }
			});
			return _p;
		}
	</script>
 <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script type="text/javascript" src="diseno/js/ControladorAdmin.js"></script>



</body>


<div style="height: 230px">
				<h2></h2>
</div>



<!-- Footer -->
<footer class="page-footer font-small  darken-3 s" style="background-color: #393939; padding-top: 1opx;">

    <!-- Footer Elements -->
    <div class="container">
  
      <!-- Grid row-->
      <div class="row">
  
        <!-- Grid column -->
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
        <!-- Grid column -->
  
      </div>
      <!-- Grid row-->
  
    </div>
    <!-- Footer Elements -->
  
    <!-- Copyright -->
    <div class="footer-copyright text-center py-3" style="background-color: #1E1E1E;">� 2020 Copyright:
      <a href="https://www.ups.edu.ec/"> ups.edu.ec</a>
    </div>
    <!-- Copyright -->
  
  </footer>
</html>