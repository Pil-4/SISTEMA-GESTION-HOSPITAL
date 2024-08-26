<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.Medico" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de Medicos</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
	<link rel="stylesheet" href="views/css/style.css">

</head>
<body>
	<div class="container mt-5">
		<h2>Listado de Medicos</h2>
		<div class="row">
			<%
			List<Medico> listaMedico = (List<Medico>) request.getAttribute("medicos");
			if (listaMedico != null && !listaMedico.isEmpty()) {
				for (Medico medico : listaMedico) {
			%>
				<div class="col-md-3 mt-4">
					<a href="medicos-detalle/<%=medico.getIdMedico() %>">
						<div class="card medico-card">
	                        <img class="circle rounded-circle d-block mx-auto mt-3 shadow" src="<%= medico.getImagenUrl() %>" alt="Imagen del medico">
	                        <div class="card-body">
	                            <h5 class="card-title text-center"><%= medico.getNombres() %> <%= medico.getApellidoPaterno() %> <%= medico.getApellidoMaterno() %></h5>
	                            <p class="card-text text-center">
								    <% if ("M".equals(medico.getSexo())) { %>
								        <i class="bi bi-gender-male"></i>
								    <% } else if ("F".equals(medico.getSexo())) { %>
								        <i class="bi bi-gender-female"></i>
								    <% } %>
								    <%= medico.getSexo() %>
								</p>
	                         <p class="especialidad text-center p-1 rounded-pill  d-block mx-auto"><%= medico.getEspecialidad() %></p>
	                            <!--  a href="sucursales/reservas/ sucursal.getId() " class="btn btn-primary">Hacer Reserva</a-->
	                        </div>
	                    </div>	
					</a>
                </div>
			<%
				}
			} else {
			%>
			<div class="col">
				<p>No se encontraron medicos.</p>
			</div>
			<%
			}
			%>
		</div>
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>