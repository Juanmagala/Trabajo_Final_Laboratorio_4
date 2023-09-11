<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reportes Médico</title>
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
    <label for="especialidad">Especialidad:</label>
    <select id="especialidad" name="especialidad">
      <option value="opcion1">Opción 1</option>
      <option value="opcion2">Opción 2</option>
      <option value="opcion3">Opción 3</option>
    </select>
    
    
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
        <th>DNI</th>
        <th>Nombre</th>
        <th>Especialidad</th>
        <th>Mes</th>
        <th>Cantidad de Turnos</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>11111111</td>
        <td>Juan Pérez</td>
        <td>Opción 1</td>
        <td id="mes1">Enero</td>
        <td>7</td>
      </tr>
      <tr>
        <td>22222222</td>
        <td>María López</td>
        <td>Opción 1</td>
        <td id="mes2">Enero</td>
        <td>4</td>
      </tr>
      <tr>
        <td>33333333</td>
        <td>Carlos Gómez</td>
        <td>Opción 1</td>
        <td id="mes3">Enero</td>
        <td>8</td>
      </tr>
    </tbody>
  </table>
</body>
</html>