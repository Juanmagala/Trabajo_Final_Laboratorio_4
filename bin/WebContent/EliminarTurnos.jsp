<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ver/Eliminar Turnos</title>
</head>
<style type="text/css">	
        .tablaGrilla {
            width: 100%;
        }
        .columnaLateral_tablaGrilla {
            width: 20%;
        }
        .columnaCentral_tablaGrilla {
            width: 30%;
        }
</style>
<body>

	<table class="tablaGrilla">
		<tr>
			<td class="columnaLateral_tablaGrilla"> <b>Bienvenido MostrarUsuario</b> </td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"> <a href="Inicio.jsp"> Cerrar Sesión </a>  </td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla">Filtrar por DNI</td>
			<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtDni"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla">Filtrar por especialidad</td>
			<td class="columnaCentral_tablaGrilla"> 
				<select name="ddlEspecialidades">
		    
				</select> 
			</td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla">Filtrar por Especialista</td>
			<td class="columnaCentral_tablaGrilla">
				<select name="ddlEspecialistas">
		    
				</select>
			</td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"><input type="submit" value="Buscar Turnos" name="btnBuscarTurnos"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		
	</table>
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
	        </tr>
	    </thead>
	    <tbody>
	        
	    </tbody>
	</table>
	<br>
	<input type="submit" value="Eliminar Turno Seleccionado" name="btnEliminarTurnos">
</body>
</html>