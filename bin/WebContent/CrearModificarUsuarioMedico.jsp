<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<form action="servletCreaModEspecialista" method="post">
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
				<td class="columnaCentral_tablaGrilla">  <b>Modificar Datos Médico</b></td>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaLateral_tablaGrilla">  </td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Ingrese el DNI:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtUsuario"></td>
				<td class="columnaLateral_tablaGrilla"><input type="submit" value="Buscar" name="btnBuscarMed"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"><b>Ingrese/Modifique los Datos del Médico</b></td>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">DNI:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtDni"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Nombre:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtNombre"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Apellido:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtApellido"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Sexo:</td>
				<td class="columnaCentral_tablaGrilla"> 
					<input type="radio" name="rdBtnSexo" value="Femenino"><label for="Femenino">Femenino</label>
					<input type="radio" name="rdBtnSexo" value="Masculino" checked="checked"><label for="Masculino">Masculino</label>
				 </td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Nacionalidad:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtNacionalidad"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Fecha de Nacimiento:</td>
				<td class="columnaCentral_tablaGrilla"><input type="date" id="start" name="dateFechaNac" value="2023-06-29" min="1900-01-01" max="2023-06-29"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Dirección:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtDireccion"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Localidad:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtLocalidad"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Provincia:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtProvincia"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Correo Electrónico:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtEmail"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Teléfono:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtTelefono"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Días de atención:</td>
				<td class="columnaCentral_tablaGrilla">
					<input type="checkbox" id="Lunes" name="Lunes"><label for="Lunes">Lunes</label>
					<input type="checkbox" id="Martes" name="Martes"><label for="Martes">Martes</label>
					<input type="checkbox" id="Miercoles" name="Miercoles"><label for="Miercoles">Miércoles</label>
					<input type="checkbox" id="Jueves" name="Jueves"><label for="Jueves">Jueves</label>
					<input type="checkbox" id="Viernes" name="Viernes"><label for="Viernes">Viernes</label>				
				</td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>	
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Horario de atención:</td>
				<td class="columnaCentral_tablaGrilla">
					<input type="checkbox" id="9" name="9"><label for="9">9:00</label>
					<input type="checkbox" id="10" name="10"><label for="10">10:00</label>
					<input type="checkbox" id="11" name="11"><label for="11">11:00</label>
					<input type="checkbox" id="12" name="12"><label for="12">12:00</label>
					<input type="checkbox" id="13" name="13"><label for="13">13:00</label>
				</td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Especialidad:</td>
				<td class="columnaCentral_tablaGrilla">
					<select id="Especialidades" name="Especialidades" onchange="cargarEspecialidades()">
				      <option value="Clinico">Clínico</option>
				    </select>
				</td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Contraseña:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtContrasenia"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
			<tr>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla">Confirmar Contraseña:</td>
				<td class="columnaCentral_tablaGrilla"><input type= "text" name="txtConfContrasenia"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>				
			<tr>
				<td class="columnaLateral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla"></td>
				<td class="columnaCentral_tablaGrilla"><input type="submit" value="Guardar" name="btnGuardarMed"><input type="submit" value="Eliminar" name="btnEliminarMed"></td>
				<td class="columnaLateral_tablaGrilla"></td>
			</tr>
		</table>
	</form>
</body>
</html>