<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Template</title>

<link href="https://fonts.googleapis.com/css?family=Original+Surfer"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet" href="./css/congelar_style.css">

</head>

<body>
	<div id="fondo" class="row">
		<header>
			<div id="boton">
				<!-- aqui esta el boton de la bellota -->
				<div class="btn-group dropright">
					<button type="button" class="btn-btn-secondary-dropdown-toggle"
						data-toggle="dropdown" id="dropdownMenuButton"
						aria-haspopup="true" aria-expanded="false">
						<img class="bellota" src="./imgs/Bellota-Kawaii-83631.gif" alt="">

					</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="./pumbanking.html">Pumbanking</a> <a
							class="dropdown-item" href="./control_parental.html">Control
							parental</a> <a class="dropdown-item" href="#">Paga</a> <a
							class="dropdown-item" href="#">Transferencia</a> <a
							class="dropdown-item" href="#">Ajustes</a>
					</div>
					<div class="dropdown-menu">
						<!-- Dropdown menu links -->
					</div>
				</div>
			</div>
			<div id="logo">
				<a href="./padre?pid=${elPadre.pid}">
					<h1 id=name>${elPadre.nombre}</h1>
				</a>
			</div>

		</header>
		<section>
		
			<c:if test="${error}">
				<div id="errorConexion">${error}</div>
			</c:if>
			
			<c:if test="${mensaje}">
			<div>${mensaje}</div>
			</c:if>
			
			<div>
				<a href="#">Saldo
					<p class="derecha">${unH.saldo}€</p>
				</a>
				<div id="congelar">
					<div>
						<h2 id="tituloseccion">Congelar cuenta</h2>
					</div>
					<div>
						<form action="" method="POST" id="congelarniño" novalidate>
							
							<div>
								<label>Usuario</label>
								<input id="nombre" name="nombre" readonly="readonly" value="${unH.nombre}">
							</div>

							<div>
								<label for="fecha_inicio">Desde</label> <input id="fecha_inicio"
									type="date" class="noflechas" name="fecha_inicio" required>

							</div>

							<div>
								<label for="fecha_fin">Hasta</label> <input id="fecha_fin"
									type="date" class="noflechas" name="fecha_fin" required>

							</div>

							<div class="botones">
								<button type="submit" id="confirmar_congelar"><a href="./padre?pid=${elPadre.pid}">Confirmar</a></button>
								<button id="cancelarbtn">Cancelar</button>
							</div>

						</form>


					</div>

				</div>
		</section>
	</div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<script src="./js/script.js"></script>

</html>