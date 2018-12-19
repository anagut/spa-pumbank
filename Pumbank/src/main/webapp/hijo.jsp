<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<link rel="stylesheet" href="./css/homepage_jr_style.css">

</head>

<body>
	<div>
		<header>
			<div>
				<a href="#">
					<div class="error">${error}</div>
					<h1 id="name">${unH.nombre}</h1>
				</a>
			</div>
		</header>

		<div id="cuentabloqueada"></div>

		<section>
			<div>
				<a href="#">Saldo      ${unH.saldo}€</a>
			</div>
			<div id="realizarpago">
				<a href="#">Realizar Pago</a>
			</div>
			<div id="pumbanking">
				<a href="#">Pumbanking</a>
			</div>
			<div id="transferencias">
				<a href="#">Transferencia</a>
			</div>
			<div>
				<a href="#">Ajustes</a>
			</div>
		</section>
	</div>


</body>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

</html>