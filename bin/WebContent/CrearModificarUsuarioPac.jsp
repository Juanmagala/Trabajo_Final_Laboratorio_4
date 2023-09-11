<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear/Modificar Paciente</title>
<style type="text/css">	
        .tablaGrilla {
            width: 100%;
        }
        .columnaLateral_tablaGrilla {
            width: 25%;
        }
        .columnaCentral_tablaGrilla {
            width: 25%;
        }
</style>
</head>
<body>
<form action="ServletsInsertarPacientes" method="get">
	<table class="tablaGrilla">
		<tr>
			<td class="columnaLateral_tablaGrilla"> <b><a href="HomeAdmin.jsp"> Volver a Home </a></b> </td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"> <a href="Inicio.jsp"> Cerrar Sesión </a> </td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla">Usuario:</td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla">  <b>Modificar Paciente</b></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla">  </td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Ingrese el DNI:</td>
			<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtDniUsuario"></td>
			<td class="columnaLateral_tablaGrilla"><input type="submit" value="Buscar" name="btnBuscarPac"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"><b>Ingrese/Modifique los Datos del Paciente</b></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">DNI:</td>
			<td class="columnaCentral_tablaGrilla">
			<input type="text" name="txtDni" value="<%= (request.getParameter("btnBuscarPac") != null) ? request.getAttribute("dni") : "" %>"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Nombre:</td>
			<td class="columnaCentral_tablaGrilla">
			<input type="text" name="txtNombre" value="<%= (request.getParameter("btnBuscarPac") != null) ? request.getAttribute("nombre") : "" %>"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Apellido:</td>
			<td class="columnaCentral_tablaGrilla">
			<input type="text" name="txtApellido" value="<%= (request.getParameter("btnBuscarPac") != null) ? request.getAttribute("apellido") : "" %>"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Sexo:</td>
			<td class="columnaCentral_tablaGrilla"> 
				<input type="radio" id="FM" name="FemeninoMasculino" value='F'><label for="Femenino">Femenino</label>
				<input type="radio" id="FM" name="FemeninoMasculino" value='M' checked="checked"><label for="Masculino">Masculino</label>
			 </td>
			<td class="columnaLateral_tablaGrilla"><input type="text" name="txtSexo" value="<%= (request.getParameter("btnBuscarPac") != null) ? request.getAttribute("sexo") : "" %>"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Nacionalidad:</td>
			<td class="columnaCentral_tablaGrilla">
			<input type="text" name="txtNacionalidad" value="<%= (request.getParameter("btnBuscarPac") != null) ? request.getAttribute("nacionalidad") : "" %>"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Fecha de Nacimiento:</td>
			<td class="columnaCentral_tablaGrilla">
			<input type="date" id="start" name="trip-start" value="<%= (request.getParameter("btnBuscarPac") != null) ? request.getAttribute("fecha_nac") : "" %>" min="1900-01-01" max="2023-06-29"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Dirección:</td>
			<td class="columnaCentral_tablaGrilla">
			<input type= "text" name="txtDireccion" value="<%= (request.getParameter("btnBuscarPac") != null) ? request.getAttribute("direccion") : "" %>"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Localidad:</td>
			<td class="columnaCentral_tablaGrilla">
			<input type= "text" name="txtLocalidad" value="<%= (request.getParameter("btnBuscarPac") != null) ? request.getAttribute("localidad") : "" %>"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Provincia:</td>
			<td class="columnaCentral_tablaGrilla">
			<input type= "text" name="txtProvincia" value="<%= (request.getParameter("btnBuscarPac") != null) ? request.getAttribute("provincia") : "" %>"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Correo Electrónico:</td>
			<td class="columnaCentral_tablaGrilla">
			<input type= "text" name="txtEmail" value="<%= (request.getParameter("btnBuscarPac") != null) ? request.getAttribute("email") : "" %>"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Teléfono:</td>
			<td class="columnaCentral_tablaGrilla">
			<input type= "text" name="txtTelefono" value="<%= (request.getParameter("btnBuscarPac") != null) ? request.getAttribute("telefono") : "" %>"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>		
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"><input type="submit" value="Guardar" name="btnGuardarPac"></td>
			<td class="columnaCentral_tablaGrilla"><input type="submit" value="Modificar" name="btnModificarPac"></td>
			<td class="columnaLateral_tablaGrilla"><input type="submit" value="Eliminar" name="btnEliminarPac"></td>
		</tr>
	</table>
</form>
<%
boolean agregado = false;
Object agregoAttr = request.getAttribute("Agrego");
if (agregoAttr != null) {
    agregado = (boolean) agregoAttr;
}
%>

<%
if (agregado) {
        	out.println("<p>Nuevo Paciente agregado</p>");
        }
        else
        {
        	out.println("<p>Error al agregar, llene todos los campos, o ese DNI ya existe</p>");
        }
%>

<%
boolean borrado = false;
Object borroAttr = request.getAttribute("Borro");
if (borroAttr != null) {
    borrado = (boolean) borroAttr;
}
%>

<%
if (request.getParameter("btnEliminarPac") != null) {
        if (borrado) {
        	out.println("<p>Registro Paciente Eliminado</p>");
        }
        else
        {
        	out.println("<p>Error al eliminar, ese DNI no existe</p>");
        }
    }
%>

<%
boolean modificado = false;
Object modificadoAttr = request.getAttribute("Modifico");
if (modificadoAttr != null) {
    modificado = (boolean) modificadoAttr;
}
%>

<%
if (request.getParameter("btnModificarPac") != null) {
    if (modificado) {
        	out.println("<p>Registro Paciente modificado</p>");
        }
        else
        {
        	out.println("<p>Error al modificar, llene todos los campos, o ese DNI no existe</p>");
        }
}
%>
</body>
</html>