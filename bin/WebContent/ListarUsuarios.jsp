<%@ page import="java.util.List" %>
<%@ page import="entidad.Usuarios" %> 

<!DOCTYPE html>
<html>
<head>
    <title>Tabla de Usuarios</title>
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
        <caption>Usuarios</caption>
        <thead>
            <tr>
                <th>DNI</th>
                <th>Nombre de Usuario</th>
                <th>Email</th>
                <th>Tipo de Usuario</th>
            </tr>
        </thead>
        <tbody>
            <% 
            List<Usuarios> listaUsuarios = (List<Usuarios>) request.getAttribute("listaUsuarios");
            if (listaUsuarios != null) {
                for (Usuarios usuario : listaUsuarios) {
            %>
            <tr>
                <td><%= usuario.getDni() %></td>
                <td><%= usuario.getUsuario() %></td>
                <td><%= usuario.getEmail_Usuarios() %></td>
                <td><%= usuario.getTipo_Usuarios() %></td>
            </tr>
            <% 
                }
            }
            %>
        </tbody>
    </table>
</body>
</html>
