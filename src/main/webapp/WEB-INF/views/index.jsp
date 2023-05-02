<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Shop</title>
<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/favicon.ico">
<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Agregar enlaces de Bootstrap 5.3 CDN -->
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
			crossorigin="anonymous">
</head>
<body>
			<!-- Incrusta header -->
		<jsp:include page="/WEB-INF/views/partials/header.jsp" />
	
	<div class="container mt-3">
		<!-- Slider -->
		<div id="carouselExampleControls" class="carousel slide"
			data-bs-ride="carousel">
			<div class="carousel-inner">
<c:forEach var="slider" items="${sliders}" varStatus="loop">
    <div class="carousel-item${loop.first ? ' active' : ''}">
        <img src="${pageContext.request.contextPath}${slider.imagenSlider}"
            class="d-block w-100" alt="Destacados ${loop.index + 1}">
    </div>
</c:forEach>
			</div>
			<button class="carousel-control-prev" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleControls" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">next</span>
			</button>
		</div>
		<!-- Productos más vendidos -->
		<div class="container my-5">
			<h2 class="text-center">Productos más vendidos</h2>
			<div class="row row-cols-1 row-cols-md-3 g-4">
<c:forEach var="producto" items="${productos}">
  <div class="col">
    <div class="card">
      <img src="${pageContext.request.contextPath}${producto.imagen}" class="card-img-top" alt="${producto.nombreProducto}">
      <div class="card-body">
        <h5 class="card-title">${producto.nombreProducto}</h5>
        <p class="card-text">${producto.descripcion}</p>
        <p class="card-text"><strong>Precio: ${producto.precio}</strong></p>
        <form method="post" action="CarritoController">
          <input type="hidden" name="idProducto" value="${producto.idProducto}">
          <button type="submit" class="btn btn-primary">Agregar al carrito</button>
        </form>
      </div>
    </div>
  </div>
</c:forEach>
			</div>
		</div>

		<!-- Footer -->
		<footer class="bg-light text-center text-lg-start">
		<div class="container p-4">
			<div class="row">
				<div class="col-lg-6 col-md-12 mb-4 mb-md-0">
					<h5 class="text-uppercase">Tienda en línea</h5>
					<p>Una tienda en línea creada con Spring MVC y Bootstrap.</p>
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
