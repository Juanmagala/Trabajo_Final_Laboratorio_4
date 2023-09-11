<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<%@ page import="entidad.Especialistas" %>
<%@ page import="entidad.Turnos" %>
<%@ page import="entidad.Pacientes"%>
<%@ page import="entidad.Especialidad"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pedir Turno</title>
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
<form action="ServletsPedirTurno" method="get">
	<table class="tablaGrilla">
		<tr>
			<td class="columnaLateral_tablaGrilla"> <b><a href="HomeAdmin.jsp"> Volver a Home </a></b> </td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"> <a href="Inicio.jsp"> Cerrar Sesion </a> </td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla">  <b></b></td>
			<td class="columnaCentral_tablaGrilla"><b>Pedir Turno</td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla">  </td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"><b>Ingrese  los Datos del Paciente:</b></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">DNI del paciente:</td>
			<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtDni">*</td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Especialidad:</td>
			<td class="columnaCentral_tablaGrilla">
			   <select name="DdlEspecialidad">
			        <% List<Especialidad> listarEspe = (List<Especialidad>) request.getAttribute("ListarEspecialidad");
			            if (listarEspe != null) {
			                for (Especialidad lista : listarEspe) {
			        %>
			        <option value="<%= lista.getCodEspecialidad() %>"><%= lista.getDescripcionEspecialidad() %></option>
			        <% 
			                }
			            }
			        %>
			    </select>*
			</td>
			<td class="columnaLateral_tablaGrilla"></td>

		</tr>
		<tr>
		    <td class="columnaLateral_tablaGrilla"></td>
		    <td class="columnaCentral_tablaGrilla">Especialista:</td>
		    <td class="columnaCentral_tablaGrilla">
		        <select name="Especialista">
		            <% 
		            List<Especialistas> listarEspec = (List<Especialistas>) request.getAttribute("listaEspecialistas");
		            if (listarEspec != null) {
		                for (Especialistas lista2 : listarEspec) {
		            %>
		            <option value="<%= lista2.getDNI_Especialistas()%>"><%= lista2.getNombre_Especialistas() + " " + lista2.getApellido_Especialistas() %></option>
		            <% 
		                }
		            }
		            %>
		        </select>*
		    </td>
		    <td class="columnaLateral_tablaGrilla"></td>
		</tr>

		
		
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Fecha del turno:</td>
			<td class="columnaCentral_tablaGrilla"><input type="date" id="start" name="trip-start"  min="1900-01-01" max="2023-06-29"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Horario:</td>
			<td class="columnaCentral_tablaGrilla"><select name = "Horario">
				<option>--SELECCIONAR--</option>
				<option value="1">08:00-09:00</option>
				<option value="2">09:00-10:00</option>
				<option value="3">10:00-11:00</option>
				<option value="4">11:00-12:00</option>
				<option value="5">12:00-13:00</option>
			</select>*</td>
			<td class="columnaLateral_tablaGrilla"></td>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">Dìa Turno:</td>
			<td class="columnaCentral_tablaGrilla"><select name = "ddlDias">
				<option>--SELECCIONAR--</option>
				<option value="1">Lunes</option>
				<option value="2">Martes</option>
				<option value="3">Miercoles</option>
				<option value="4">Jueves</option>
				<option value="5">Viernes</option>
				<option value="6">Sabado</option>
				<option value="0">Domingo</option>

			</select>*</td>
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
			<td class="columnaCentral_tablaGrilla"><input type="submit" value="Guardar turno" name="btnGuardarPac"></td>
			<td class="columnaCentral_tablaGrilla"><p name="pMensaje"></p> </td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
	</table>
	</form>
</body>
</html>