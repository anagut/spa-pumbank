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

<!-- <link rel="stylesheet" href="./css/transferencias_style.css"> -->
<link rel="stylesheet" href="./css/admin-paga_style.css">

</head>

<body>
	<div>
		<header>
			<div id="menulateral">
				<!-- aqui esta el boton de la bellota -->
				<div class="btn-group dropright">
					<button type="button" class="btn-btn-secondary-dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<img class="bellota" src="./imgs/Bellota-Kawaii-83631.gif" alt="">
					</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="#">Pumbanking</a> <a
							class="dropdown-item" href="#">Control parental</a> <a
							class="dropdown-item" href="#">Paga</a> <a class="dropdown-item"
							href="#">Transferencia</a> <a class="dropdown-item" href="#">Ajustes</a>
					</div>
					<div class="dropdown-menu">Dropdown menu links</div>
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

				<h1 name="hid">Transferencia</h1>

				<form method="POST" action="#">

					<div>
						<label>Usuario</label> <input name="nombre" id="nombre"
							value="${unH.nombre}" required readonly="readonly">
					</div>

					<div class="row" id=money>
						<label>Cantidad</label> <input class="col-4" type="number"
							min="0.1" max="50" step="0.1" name="saldo" required> <label>€</label>
					</div>

					<div class="row">
						<div id="datosbancarios">
							<label for="datosbancarios">Datos bancarios</label>
						</div>
						<div class="row">
							<div>
								<label class="col-5" for="tarjeta">Nº de tarjeta</label> <input
									id="datosbanc" class="col-4" type="text" minlength="16"
									maxlength="18" name="datosbanc" required
									value="${elPadre.tarjeta_credito}" readonly="readonly">

							</div>
							<div>
								<label for="CVV" class="col-5">CVV</label> <input id="CVV"
									name="CVV" class="noflechas" type="password" minlength="3"
									maxlength="3" required value="${elPadre.cvv}"
									readonly="readonly">

							</div>

							<div id="caducidad">


								<label>Caducidad</label> <input id="mes" name="mes"
									class="noflechas" type="number" required
									value="${elPadre.mes_caducidad}" readonly="readonly"> <input
									id="year" name="year" type="number" class="noflechas"
									value="${elPadre.año_caducidad}" readonly="readonly">


							</div>


							<div class="botones">
								<button id="accederbtn">Confirmar</button>
								<button id="cancelarbtn">Cancelar</button>
							</div>
				</form>
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