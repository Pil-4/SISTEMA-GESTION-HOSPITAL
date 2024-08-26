<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Medico" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sistema de Gestion de Hospital</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<style>
	.imagen-cabecera {
		width: 50%;
		height: 50%;
		object-fit: cover;
		object-position: center;
	}
</style>
<body>
	<div class="container mt-5">
	<% 
		Medico medico = (Medico) request.getAttribute("medico");  
    %>
		<h2>Detalle de medico <%= medico.getNombres() %></h2>
		<img class="imagen-cabecera" src="<%= medico.getImagenUrl() %>">
		<div class="mt-4">
			<p class="mb-2"><b>Apellido Paterno:</b> <%= medico.getApellidoPaterno() %></p>
			<p class="mb-2"><b>Apellido Materno:</b> <%= medico.getApellidoMaterno() %></p>
			<p class="mb-2"><b>Especialidad: </b> <%= medico.getEspecialidad() %></p>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>