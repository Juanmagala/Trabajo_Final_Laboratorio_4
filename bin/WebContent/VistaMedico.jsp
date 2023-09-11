<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p> Hola : ::: <%= request.getAttribute("UsuarioMedico") %></p>
 <a href="cerrarSesion.jsp">Cerrar sesion </a><br>
<a>Turnos Asignados a: Felipe Gomez</a> <br>
<a>Especialidad: Pediatra</a> <br><br>


<a>Filtrar por dni: <input type="text" name="txtfiltroDni"></input> </a> <input type="submit" name="btnFiltrardni" value="Filtrar por dni" style="width: 102px; "></input> 
<br>  
<a>Filtrar por nombre <input type="text" name="txtFiltrarNombre"></a>
<input type="submit" name="btnFiltrarNombre" value="Filtrar por Nombre" style="width: 127px; "></input>
<table>
<tr>
<td>Codigo de turno</td>
<td>Nombre del Paciente</td>
<td style="width: 134px; ">Fecha y hora</td>
<td>Nombre del medico</td>
<td>Asistencia</td>
<td>motivo consulta</td>
<td>Historia clinica</td>
</tr> 
<tr>
<td>TP2301</td>
<td>Julian Alvarez</td>
<td>07/06/2023 16:00</td>
<td>Felipe Gomez</td>
<td><select name="ddlasistencia">
<option>--SELECCIONAR--</option>
<option>AUSENTE</option>
<option>PRESENTE</option>


</Select></td>
<td><input type="text" name="txtMotivo"></input></td>
<td><input type="submit" name="btnHC" value="Ver historia clinica"></td>
</tr>
<tr>
<td>TP2302</td>
<td>Jimena Morales</td>
<td>07/06/2023 17:00</td>
<td>Felipe Gomez</td>
<td><select name="ddlasistencia">
<option>--SELECCIONAR--</option>
<option>AUSENTE</option>
<option>PRESENTE</option>


</Select></td>
<td><input type="text" name="txtMotivo"></input></td>
<td><input type="submit" name="btnHC" value="Ver historia clinica"></td>
</tr>
<tr>
<td>TP2303</td>
<td>Lucas Jimenez</td>
<td>07/06/2023 18:00</td>
<td>Felipe Gomez</td>
<td><select name="ddlasistencia">
<option>--SELECCIONAR--</option>
<option>AUSENTE</option>
<option>PRESENTE</option>


</Select></td>
<td><input type="text" name="txtMotivo"></input></td>
<td><input type="submit" name="btnHC" value="Ver historia clinica"></td>
</tr>
</table>
<input type="submit" name="btnGuardarConsulta" value="Guardar Consulta"></input>

<br><br>
	<table id="tableTurnos" class="display">
	    <thead>
	        <tr>
	            <th>DNI</th>
	            <th>Nombre Paciente</th>
	            <th>Nombre Especialista</th>
	            <th>Especialidad</th>
	            <th>Fecha de Turno</th>
	            <th>Horario</th>
	            <th>Motivo consulta</th>
	        </tr>
	    </thead>
	    <tbody>
	        
	    </tbody>
	</table>
	<br><br>
</body>
</html>