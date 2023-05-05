<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de Sesion</title>
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Agregar enlaces de Bootstrap 5.3 CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert2/10.16.11/sweetalert2.min.css" integrity="sha512-/D4S05MnQx/q7V0+15CCVZIeJcV+Z+ejL1ZgkAcXE1KZxTE4cYDvu+Fz+cQO9GopKrDzMNNgGK+dbuqza54jgw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert2/10.16.11/sweetalert2.min.js" integrity="sha512-20JhbH7IY5gxE+xRzfwM6LyPRjUNhAUCE3T/9na1aAsUyTN1ZL8fmXlsC2vrzkeXsTwVT/cu2PuDPY/oEbFZ0A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="${pageContext.request.contextPath}/js/webshop.js"></script>

</head>
<body>
	<div class="container">
		<div class="row ">
			<div class="col-12 d-flex justify-content-center ">
				<div class=" col-12 col-md-9 col-lg-5 col-xl-5 mx-3 my-5 border border-dark rounded-3 d-flex justify-content-center">
					<% if (request.getAttribute("error") != null) { %>
  
  <script>
    showError("<%= request.getAttribute("error") %>");
  </script>
<% } %>
					<form class="col-9 my-4" id="loginForm" name="loginForm" action="${pageContext.request.contextPath}/loginForm" method="post">

						<legend>Login</legend>
						<div class="mb-3">
							<label for="email" class="form-label mb-3">Email</label> <input
								type="email" class="form-control mb-3" id="email" name="email"
								aria-describedby="emailHelp" placeholder="correo@dominio.com">
							<!--  <div id="emailHelp" class="form-text">compruebe el formato AAA@aa.aa</div>-->
						</div>
						<div class="mb-3">
							<label for="password" class="form-label mb-3">Password</label>
							<input type="password" class="form-control mb-3" name="password"
								id="password">
						</div>
						<div class="mb-3 form-check">
						  <input type="checkbox" class="form-check-input" id="rememberMe" name="rememberMe" value="true">  
						  <label class="form-check-label" for="rememberMe">Recuérdame</label>
						</div>
						<button type="submit" class="btn btn-primary">Iniciar</button>

					</form>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0-alpha3/js/bootstrap.min.js"
		integrity="sha512-wOLiP6uL5tNrV1FiutKtAyQGGJ1CWAsqQ6Kp2XZ12/CvZxw8MvNJfdhh0yTwjPIir4SWag2/MHrseR7PRmNtvA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.11.7/umd/popper.min.js"
		integrity="sha512-uaZ0UXmB7NHxAxQawA8Ow2wWjdsedpRu7nJRSoI2mjnwtY8V5YiCWavoIpo1AhWPMLiW5iEeavmA3JJ2+1idUg=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0-alpha3/js/bootstrap.min.js"
		integrity="sha512-wOLiP6uL5tNrV1FiutKtAyQGGJ1CWAsqQ6Kp2XZ12/CvZxw8MvNJfdhh0yTwjPIir4SWag2/MHrseR7PRmNtvA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
		integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	
	


</body>
</html>