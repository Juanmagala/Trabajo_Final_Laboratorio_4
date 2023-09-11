<%@ page import="java.util.List" %>
<%@ page import="entidad.Pacientes" %> 

<!DOCTYPE html>
<html>
<head>
    <title>Tabla de Pacientes</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
    <a href="HomeAdmin.jsp">Volver a Home</a>
    <table>
        <caption>Pacientes</caption>
        <thead>
            <tr>
                <th>DNI</th>
                <th>Nombre</th>
                <th>Sexo</th>
                <th>Nacionalidad</th>
                <th>Fecha de Nacimiento</th>
                <th>Direccion</th>
                <th>Localidad</th>
                <th>Provincia</th>
                <th>Email</th>
                <th>Telefono</th>
            </tr>
        </thead>
        <tbody>
            <% 
            List<Pacientes> listaPacientes = (List<Pacientes>) request.getAttribute("listaPacientes");
            if (listaPacientes != null) {
                for (Pacientes paciente : listaPacientes) {
            %>
            <tr>
                <td><%= paciente.getDNI_Pacientes() %></td>
                <td><%= paciente.getApellido_Pacientes() + " " + paciente.getNombre_Pacientes() %></td>
                <td><%= paciente.getSexo_Pacientes() %></td>
                <td><%= paciente.getNacionalidad_Pacientes() %></td>
                <td><%= paciente.getFecha_Nacimiento_Pacientes() %></td>
                <td><%= paciente.getDireccion_Pacientes() %></td>
                <td><%= paciente.getLocalidad_Pacientes() %></td>
                <td><%= paciente.getProvincia_Pacientes() %></td>
                <td><%= paciente.getEmail_Pacientes() %></td>
                <td><%= paciente.getTelefono_Pacientes() %></td>
                </tr>
            <% 
                }
            }
            %>
        </tbody>
    </table>
</body>
</html>
