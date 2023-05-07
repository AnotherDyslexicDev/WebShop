<header>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/"><img
				src="${pageContext.request.contextPath}/img/logo.webp"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${pageContext.request.contextPath}/">Inicio</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle text-light" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false">Productos </a>

						<ul class="dropdown-menu bg-dark">
							<li class="nav-item"><a class="nav-link text-light"
								href="${pageContext.request.contextPath}/">Categoria A</a></li>
							<li class="nav-item"><a class="nav-link text-light"
								href="${pageContext.request.contextPath}/">Categoria B</a></li>
							<li class="nav-item"><a class="nav-link text-light"
								href="${pageContext.request.contextPath}/">Categoria C</a></li>
							<li class="nav-item"><a class="nav-link text-light"
								href="${pageContext.request.contextPath}/">Categoria D</a></li>
						</ul></li>
				</ul>
	<form class="d-flex" role="search">
	
	<% if (session.getAttribute("usuario") != null) { %>
		<div class="dropdown me-2">
			<button class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
				<i class="bi bi-person"></i>
			</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href="${pageContext.request.contextPath}/perfil">Perfil</a></li>
				<li><a class="dropdown-item" href="${pageContext.request.contextPath}/newPassword">Cambio Contraseña</a></li>
				<li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Cerrar Sesión</a></li>
			</ul>
		</div>
		<a href="${pageContext.request.contextPath}/carrito/ver" class="btn btn-outline-light me-2">
			<i class="bi bi-cart"></i>
		</a>
	<% } else { %>
		<a href="${pageContext.request.contextPath}/login" class="btn btn-outline-light mx-2">
			<i class="bi bi-person"></i>
		</a>
		<a href="${pageContext.request.contextPath}/carrito" class="btn btn-outline-light me-2">
			<i class="bi bi-cart"></i>
		</a>
	<% } %>
			
    <input class="form-control me-2" type="search" placeholder="Buscar productos" aria-label="Buscar">
    <button class="btn btn-outline-light" type="submit">Buscar</button>
</form>

			</div>
		</div>
	</nav>
</header>