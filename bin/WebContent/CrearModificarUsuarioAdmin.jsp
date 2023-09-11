<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear/Modificar Usuario Admin</title>
<style type="text/css">	
        .tablaGrilla {
            width: 100%;
        }
        .columnaLateral_tablaGrilla {
            width: 10%;
        }
        .columnaCentral_tablaGrilla {
            width: 30%;
        }
</style>
</head>
<body>
<form action="servletUsuarioAdmin" method="get" onsubmit="return confirmacion()">
	<table class="tablaGrilla">
		<tr>
			<td class="columnaCentral_tablaGrilla"> <b><a href="HomeAdmin.jsp"> Volver a Home </a></b> </td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"> <a href="Inicio.jsp"> Cerrar Sesión </a> </td>
		</tr>
		<tr>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla">Usuario:</td>
		</tr>
		<tr>
			<td class="columnaCentral_tablaGrilla">  <b>Modificar o Eliminar Admin</b></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla">  </td>
		</tr>
		<tr>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Ingrese el DNI:</td>
			<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtDniUsuario"></td>
			<td class="columnaLateral_tablaGrilla"><input type="submit" value="Buscar" name="btnBuscarAdm"></td>
		</tr>
		<tr>
			<td class="columnaCentral_tablaGrilla"><b>Ingrese/Modifique los Datos del Admin</b></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
		    <td class="columnaCentral_tablaGrilla"></td>
		    <td class="columnaCentral_tablaGrilla">DNI:</td>
		    <td class="columnaCentral_tablaGrilla">
		        <input type="text" name="txtDni" value="<%= (request.getParameter("btnBuscarAdm") != null) ? request.getAttribute("dni") : "" %>">
		    </td>
		    <td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
		    <td class="columnaCentral_tablaGrilla"></td>
		    <td class="columnaCentral_tablaGrilla">Nombre de usuario:</td>
		    <td class="columnaCentral_tablaGrilla">
		        <input type="text" name="txtNombre" value="<%= (request.getParameter("btnBuscarAdm") != null) ? request.getAttribute("nombre") : "" %>">
		    </td>
		    <td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
		    <td class="columnaCentral_tablaGrilla"></td>
		    <td class="columnaCentral_tablaGrilla">Email:</td>
		    <td class="columnaCentral_tablaGrilla">
		        <input type="text" name="txtEmail" value="<%= (request.getParameter("btnBuscarAdm") != null) ? request.getAttribute("email") : "" %>">
		    </td>
		    <td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
		    <td class="columnaCentral_tablaGrilla"></td>
		    <td class="columnaCentral_tablaGrilla">Contraseña:</td>
		    <td class="columnaCentral_tablaGrilla">
		        <input type="text" name="txtContrasenia" value="<%= (request.getParameter("btnBuscarAdm") != null) ? request.getAttribute("contrasenia") : "" %>">
		    </td>
		    <td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
		    <td class="columnaCentral_tablaGrilla"></td>
		    <td class="columnaCentral_tablaGrilla">Confirmar Contraseña:</td>
		    <td class="columnaCentral_tablaGrilla">
		        <input type="text" name="txtConfContrasenia" value="<%= (request.getParameter("btnBuscarAdm") != null) ? request.getAttribute("contrasenia") : "" %>">
		    </td>
		    <td class="columnaLateral_tablaGrilla"></td>
		</tr>	
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"><input type="submit" value="Guardar" name="btnGuardarAdm"></td>
			<td class="columnaCentral_tablaGrilla"><input type="submit" value="Modificar" name="btnModificarAdm"></td>
			<td class="columnaCentral_tablaGrilla"><input type="submit" value="Eliminar" name="btnEliminarAdm"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
	</table>
</form>

<script>
function validarContraseñas() {
    var contrasenia = document.getElementById("txtContrasenia").value;
    var confContrasenia = document.getElementById("txtConfContrasenia").value;
    
    if (contrasenia !== confContrasenia) {
        alert("Las contraseñas no coinciden. Por favor, verifique.");
        return false; // Detiene el envío del formulario
    }
    
    return true; // Permite el envío del formulario
}
</script>

<%
boolean agregado = false;
Object agregoAttr = request.getAttribute("Agrego");
if (agregoAttr != null) {
    agregado = (boolean) agregoAttr;
}
%>

<%
if (request.getParameter("btnGuardarAdm") != null) {
    String contrasenia = request.getParameter("txtContrasenia");
    String confContrasenia = request.getParameter("txtConfContrasenia");
    
    if (!contrasenia.equals(confContrasenia) && agregado==false) {
        out.println("<p>Las contraseñas no coinciden. Por favor, verifique.</p>");
    } else {
        if (agregado) {
        	out.println("<p>Usuario Administrador agregado</p>");
        }
        else
        {
        	out.println("<p>Error al agregar, llene todos los campos, o ese DNI ya existe</p>");
        }
    }
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
if (request.getParameter("btnEliminarAdm") != null) {
        if (borrado) {
        	out.println("<p>Usuario Administrador Eliminado</p>");
        }
        else
        {
        	out.println("<p>Error al eliminar ese DNI no existe</p>");
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
if (request.getParameter("btnModificarAdm") != null) {
    String contrasenia = request.getParameter("txtContrasenia");
    String confContrasenia = request.getParameter("txtConfContrasenia");
    
    if (!contrasenia.equals(confContrasenia) && agregado==false) {
        out.println("<p>Las contraseñas no coinciden. Por favor, verifique.</p>");
    } else {
        if (modificado) {
        	out.println("<p>Usuario Administrador modificado</p>");
        }
        else
        {
        	out.println("<p>Error al modificar, llene todos los campos, o ese DNI no existe</p>");
        }
    }
}
%>

<script>
function confirmacion() {
    return confirm("¿Está seguro que desea realizar esta acción?");
}
</script>

</body>
</html>