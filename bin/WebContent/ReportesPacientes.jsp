<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reportes Pacientes</title>
</head>
<style>
  #usuario {
    position: absolute;
    top: 0;
    right: 10px;
    margin-top: 10px;
    margin-right: 10px;
    text-align: right;
  }
</style>
<body>
	<div id="usuario">
  		<a href="#">Cerrar sesión</a>
  		<br>
    	<label for="usuario">Usuario:</label>
  	</div>
  <form>
    
    <label for="mes">Mes:</label>
    <select id="mes" name="mes" onchange="actualizarTurnos()">
      <option value="enero">Enero</option>
      <option value="febrero">Febrero</option>
      <option value="marzo">Marzo</option>
    </select>
    
    <input type="submit" value="Filtrar" name="btnFiltrar">
  </form>

<table>
  <thead>
    <tr>
      <th>Mes</th>
      <th>DNI</th>
      <th>Nombre</th>
      <th>Especialidad</th>
      <th>Asistencias</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Enero</td>
      <td>12345678</td>
      <td>Marta González</td>
      <td>Especialidad 1</td>
      <td>4</td>
    </tr>
    <tr>
      <td>Febrero</td>
      <td>87654321</td>
      <td>Pedro Rodríguez</td>
      <td>Especialidad 2</td>
      <td>2</td>
    </tr>
    <tr>
      <td>Enero</td>
      <td>56789012</td>
      <td>Laura Ramírez</td>
      <td>Especialidad 1</td>
      <td>3</td>
    </tr>
    <tr>
      <td>Marzo</td>
      <td>23456789</td>
      <td>Juan López</td>
      <td>Especialidad 3</td>
      <td>1</td>
    </tr>
  </tbody>
</table>
</body>
</html>