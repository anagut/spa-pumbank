<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="https://fonts.googleapis.com/css?family=Original+Surfer"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet" href="./css/homepage_sr_style.css">
<title>Insert title here</title>
</head>
<body>
	<div id="fondo" class="row">
		<header>
			<div id="boton">
				<!-- aqui esta el boton de la bellota -->
				<div class="btn-group dropright">
					<button type="button" class="btn-btn-secondary-dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<img class="bellota" src="./imgs/Bellota-Kawaii-83631.gif" alt="">

					</button>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="./pumbanking.html">Pumbanking</a> <a
							class="dropdown-item" href="./control_parental.html">Control
							parental</a> <a class="dropdown-item" href="./paga-global.html">Paga</a>
						<a class="dropdown-item" href="./transferencia-global.html">Transferencia</a>
						<a class="dropdown-item" href="#">Ajustes</a>
					</div>
					<div class="dropdown-menu">
						<!-- Dropdown menu links -->
					</div>
				</div>
			</div>
			<div id="logo">
				<div class="error">${error}</div>
				<h1 id=name>${unP.nombre}</h1>
			</div>
		</header>

		<ul id="list">
			<c:forEach var="unHijo" items="${unP.hijos}">
				<li>
					<div id="nombre_hijo">${unHijo.nombre}</div>
					<div id="saldo_hijo">Saldo: ${unHijo.saldo} €</div>

					<div class="btn-group" role="group" aria-label="Basic example">
						<div id="yellow" type="button" class="btn btn-group" role="group"
							aria-label="Basic example">
							<a href="./paga?hid=${unHijo.hid}&&pid=${unP.pid}">Paga</a>
						</div>
						<div id="green" type="button" class="btn btn-group" role="group"
							aria-label="Basic example">
							<a href="./transferencia?hid=${unHijo.hid}&&pid=${unP.pid}">Transferencia</a>
						</div>
						<div id="blue" type="button" class="btn btn-group" role="group"
							aria-label="Basic example">
							<a href="./congelar?hid=${unHijo.hid}&&pid=${unP.pid}">Congelar</a>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	

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
</body>
</html>