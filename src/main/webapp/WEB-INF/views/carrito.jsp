<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Shop</title>
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/img/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Agregar enlaces de Bootstrap 5.3 CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
	<!-- Incrusta header -->
	<jsp:include page="/WEB-INF/views/partials/header.jsp" />

	<div class="container mt-3">
		<div class="carrito">
			<h2>Detalles del Carrito</h2>
			<c:if test="${mensaje != null}">
				<div>${mensaje}</div>
			</c:if>
			<c:if test="${mensaje == null}">
				<table class="table table-striped-columns">
					<thead>
						<tr>
							<th>Producto</th>
							<th>Cantidad</th>
							<th>Precio</th>
							<th>subtotal</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${carrito.getDetallesCarrito()}"
							var="detalle">
							<tr>
								<td>${detalle.getProducto().getNombreProducto()}</td>
								<td>${detalle.getCantidad()}</td>
								<td>${detalle.getProducto().getPrecio()}</td>
								<td>${detalle.getSubTotal()} </td>
							</tr>
							
						</c:forEach>
						<tr><td></td><td></td><td></td><td><h3>Total</h3></td></tr>
						<tr><td></td><td></td><td></td><td>${carrito.getTotal()}</td></tr>
					</tbody>
				</table>
			</c:if>
		</div>
		<!-- Footer -->
		<footer class="bg-light text-center text-lg-start">
		<div class="container p-4">
			<div class="row">
				<div class="col-lg-6 col-md-12 mb-4 mb-md-0">
					<h5 class="text-uppercase">Tienda en línea</h5>
					<p>Una tienda en línea creada con Spring MVC, Hibernate y
						Bootstrap.</p>
				</div>
				<div class="col-lg-3 col-md-6 mb-4 mb-md-0">
					<h5 class="text-uppercase">Links</h5>
					<ul class="list-unstyled mb-0">
						<li><a href="#!" class="text-dark">Inicio</a></li>
						<li><a href="#!" class="text-dark">Productos</a></li>
					</ul>
				</div>
				<div class="col-lg-3 col-md-6 mb-4 mb-md-0">
					<h5 class="text-uppercase">Contacto</h5>
					<ul class="list-unstyled mb-0">
						<li><a href="#!" class="text-dark">Dirección: Calle Falsa
								123</a></li>
						<li><a href="#!" class="text-dark">Teléfono: +1234567890</a>
						</li>
						<li><a href="#!" class="text-dark">Correo electrónico:
								contacto@fullstackdavid.com</a></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="text-center p-3"
			style="background-color: rgba(0, 0, 0, 0.2);">© 2023 Tienda en
			línea</div>
		</footer>
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
