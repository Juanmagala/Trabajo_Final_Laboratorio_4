<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reportes M�dico</title>
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
  		<a href="#">Cerrar sesi�n</a>
  		<br>
    	<label for="usuario">Usuario:</label>
  	</div>
  <form>
    <label for="especialidad">Especialidad:</label>
    <select id="especialidad" name="especialidad">
      <option value="opcion1">Opci�n 1</option>
      <option value="opcion2">Opci�n 2</option>
      <option value="opcion3">Opci�n 3</option>
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
        <td>Juan P�rez</td>
        <td>Opci�n 1</td>
        <td id="mes1">Enero</td>
        <td>7</td>
      </tr>
      <tr>
        <td>22222222</td>
        <td>Mar�a L�pez</td>
        <td>Opci�n 1</td>
        <td id="mes2">Enero</td>
        <td>4</td>
      </tr>
      <tr>
        <td>33333333</td>
        <td>Carlos G�mez</td>
        <td>Opci�n 1</td>
        <td id="mes3">Enero</td>
        <td>8</td>
      </tr>
    </tbody>
  </table>
</body>
</html>