<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Administrador</title>
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
</head>
<body>
	<p> Hola admin : <%= request.getAttribute("UsuarioAdmin") %></p>
	<table class="tablaGrilla">
		<tr>
			<td class="columnaLateral_tablaGrilla"> <b>Bienvenido MostrarUsuario</b> </td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"> <a href="Inicio.jsp"> Cerrar Sesión </a>  </td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla">(vuelve a inicio al cerrar sesión)</td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"> <b>Redirigirse a:</b> </td>
			<td class="columnaCentral_tablaGrilla"> <a href="CrearModificarUsuarioAdmin.jsp"> Crear/Modificar Usuario Administrador </a> </td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"> <a href="CrearModificarUsuarioMedico.jsp"> Crear/Modificar Usuario Médico </a> </td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"> <a href="CrearModificarUsuarioPac.jsp"> Crear/Modificar Usuario Paciente </a> </td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"> <a href="servletUsuarioAdmin?Param=true"> Listar usuarios </a> </td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"> <a href="ServletsInsertarPacientes?Param=true"> Listar pacientes </a> </td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"> <a href="ServletsPedirTurno?Param=true"> Pedir Turnos </a> </td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"> <a href="EliminarTurnos.jsp"> Eliminar Turnos </a> </td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"> <a href="ReportesMedicos.jsp"> Reportes Médicos </a> </td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"> <a href="ReportesPacientes.jsp"> Reportes Pacientes </a> </td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
	</table>

</body>
</html>