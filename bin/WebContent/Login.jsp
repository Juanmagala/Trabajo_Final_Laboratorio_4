<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="entidad.Usuarios" %>
<%@ page import="negocioImpl.ClinicaNegocioImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">	
		
        .tablaGrilla {
            width: 100%;
        }
        .columnaLateral_tablaGrilla {
            width: 30%;
        }
        .columnaCentral_tablaGrilla {
            width: 20%;
        }
</style>
</head>
<body>
<form method="get" action="ServletLogin" >
	<table class="tablaGrilla">
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"> <b >Login</b> </td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">
				<b>Usuario: </b>
			</td>
			<td class="columnaCentral_tablaGrilla">
				<input type= "text" name="txtUsuario">
			</td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">
				<b>Contraseña: </b>	
			</td>
			<td class="columnaCentral_tablaGrilla">
				<input type= "text" name="txtPwd">
			</td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla">
				<input type="submit" value="Ingresar" name="btnIngresar">
			</td>
			<td class="columnaLateral_tablaGrilla"></td>
		</tr>

		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"> <a href="ResetPwd.jsp"> ¿olvidó su contraseña? </a> </td>
			<td class="columnaLateral_tablaGrilla"></td>
			
		</tr>
		<% 
			String Mensaje = ""; 
		if(request.getAttribute("MensajeServeletLogin")!=null){
		Mensaje= request.getAttribute("MensajeServeletLogin").toString() ;
		}
	%>
		<tr>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaLateral_tablaGrilla"></td>
			<td class="columnaCentral_tablaGrilla"><%=Mensaje%></td>
			<td class="columnaLateral_tablaGrilla"></td>
			
		</tr>
		
	</table>
	

</form>


	

 



</body>
</html>