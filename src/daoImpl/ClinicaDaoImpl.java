package daoImpl;

import java.util.List;
import com.mysql.jdbc.Statement;
import dao.ClinicaDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Types;
import entidad.Especialidad;
import entidad.Especialistas;
import entidad.ExDxH;
import entidad.Pacientes;
import entidad.Turnos;
import entidad.Usuarios;
import negocioImpl.EspecialidadesNegocioImpl;
import negocioImpl.EspecialistasNegocioImpl;
import negocioImpl.LocalidadesNegocioImpl;
import negocioImpl.PacientesNegocioImpl;
import negocioImpl.ProvinciasNegocioImpl;
import negocioImpl.ReporteMedicoNegocioImpl;
import negocioImpl.ReportePacienteNegocioImpl;
import negocioImpl.TurnosNegocioImpl;
import negocioImpl.UsuariosNegocioImpl;
import negocioImpl.ExDxHNegocioImpl;
import entidad.Provincia;
import entidad.ReporteMedico;
import entidad.ReportePaciente;
import entidad.Localidad;

public class ClinicaDaoImpl implements ClinicaDao{
	

//---------------------------------------CONSULTAS---------------------------------------//
	private static final String readallEspecialidad = "SELECT * FROM Especialidades";
	private static final String buscarAdmin = "SELECT * FROM Usuarios WHERE DNI_Usuarios = ? AND Estado_Usuarios = 1 AND Tipo_Usuarios = 'A'";
	private static final String modificarAdmin = "UPDATE Usuarios\r\n" + 
			"SET Usuario_Usuarios = ?, Email_Usuarios = ?, Contrasena_Usuarios = ?\r\n" + 
			"WHERE DNI_Usuarios = ? AND Tipo_Usuarios = 'A' AND Estado_Usuarios = 1\r\n";
	private static final String buscarUsuario = "SELECT * FROM Usuarios WHERE DNI_Usuarios = ? ";
	private static final String buscarPaciente = "SELECT * FROM Pacientes WHERE DNI_Pacientes = ? AND Estado_Pacientes = 1";

	private static final String buscarEspecialista = "select * from especialistas where DNI_Especialistas = ? and Estado_Especialistas = 1";
	private static final String buscarUsuarioEsp = "SELECT * FROM Usuarios WHERE DNI_Usuarios = ? AND Estado_Usuarios = 1 AND Tipo_Usuarios = 'E'";
	
	private static final String modificarPacientes = "UPDATE Pacientes\r\n" + 
			"SET Nombre_Pacientes = ?, Apellido_Pacientes = ?, Sexo_Pacientes = ?, Fecha_Nacimiento_Pacientes = ?, Telefono_Pacientes = ?, " + 
			"Email_Pacientes = ?, Nacionalidad_Pacientes = ?, Direccion_Pacientes = ?, Localidad_Pacientes = ?, Provincia_Pacientes = ?\r\n" + 
			"WHERE DNI_Pacientes = ? AND Estado_Pacientes = 1\r\n";
	
	private static final String modificarTurnos = "UPDATE Turnos\r\n" + 
			"SET Dni_Paciente_Turnos = ?, Asistencia_Turnos = ?\r\n"   + 
			"WHERE Cod_Turnos= ? AND Estado_Turnos = 1\r\n";
	private static final String modificarPwdTurnos = "UPDATE usuarios\r\n" + 
			"SET Contrasena_Usuarios = ? \r\n" + 
			"WHERE DNI_Usuarios =  ? AND Estado_Usuarios = 1;";
	
	private static final String modificarEspecialista = "UPDATE Especialistas\r\n" + 
            "SET Nombre_Especialistas = ?, Apellido_Especialistas = ?, Sexo_Especialistas = ?, FechaNac_Especialistas = ?, Telefono_Especialistas = ?, " + 
            "Email_Especialistas = ?, Nacionalidad_Especialistas = ?, Direccion_Especialistas = ?, Localidad_Especialistas = ?, Provincia_Especialistas = ?,"
            + " Cod_Especialidad_Especialistas = ? WHERE DNI_Especialistas = ? AND Estado_Especialistas = 1\r\n";

	private static final String buscarProvincia = "select * from Provincias where Cod_Provincias = ?";
	
	private static final String buscarLocalidad = "select * from Localidades where Cod_Localidades = ?";
	
	private static final String buscarEspecialidad = "select * from Especialidades where Cod_Especialidad = ? and Estado_Especialidad=1";
	
	private static final String modificarUsuario = "UPDATE Usuarios\r\n" + 
			"SET Usuario_Usuarios = ?, Email_Usuarios = ?, Contrasena_Usuarios = ?\r\n" + 
			"WHERE DNI_Usuarios = ? AND Tipo_Usuarios = 'E' AND Estado_Usuarios = 1\r\n";
	
//---------------------------------------VERIFICAR EXISTENCIA DE USUARIO LOGIN---------------------------------------//
	@Override
	public boolean VerificarNombreUsuario(String usuario){
		 try {
		        Conexion conexion = Conexion.getConexion();
		        Connection conn = conexion.getSQLConexion();

		        // Llamar al procedimiento almacenado
		        CallableStatement stmt = conn.prepareCall("{CALL SP_VerificarNombreUsuario(?)}");
		        stmt.setString(1, usuario);
		       
		        ResultSet rs = stmt.executeQuery();

		        if (rs.next()) {
		            int resultado = rs.getInt("resultado");
		            return resultado == 1;
		        }
		        else
		        {
		        	return false;
		        }        
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		    }
	}
	public boolean VerificarUsuarioPorDni(String dni) {
		
		UsuariosNegocioImpl usuneg = new UsuariosNegocioImpl(); /////////REVISAR ESTO
		List<Usuarios> usuariosList = usuneg.readAllUsuarios();
		for (Usuarios elemento : usuariosList) {
			if(elemento.getDni().equals(dni)) {
				System.out.println("se encontro un usuario coincidente");
			
				return true;
			}
			
		}
		return false;
	}
	
	@Override
	public boolean existeUsuario(Usuarios usuario) {
	    try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();

	        // Llamar al procedimiento almacenado
	        CallableStatement stmt = conn.prepareCall("{CALL SP_VerificarUsuario(?,?)}");
	        stmt.setString(1, usuario.getUsuario());
	        stmt.setString(2, usuario.getContrasena_Usuarios());
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            int resultado = rs.getInt("resultado");
	            return resultado == 1;
	        }
	        else
	        {
	        	return false;
	        }        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	@Override
	public int  BuscarRegistroUsuarioPorDni(String dni) {
		PreparedStatement statement;
		Usuarios usu = new Usuarios();
		ResultSet resultSet;
		
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(buscarUsuario);
			statement.setString(1, dni);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				
				if(resultSet.getString("Estado_Usuarios").equals("1")) {
					//usuario activado
					return 1; 
				}
				if(resultSet.getString("Estado_Usuarios").equals("0")) {
					//si el registro del usuario existe pero esta desactivado
					return 0; 
				}
	
			}else {
				//no existe registro de usuario
				return 2;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return 2;
	}
	
//---------------------------------------INSERTAR---------------------------------------//
	
	@Override
	public boolean insertUsuarios(Usuarios usuario)  
	{
		 try {
			 	Conexion conexion = Conexion.getConexion();
		        Connection conn = conexion.getSQLConexion();
	            String sql = "CALL spInsertarUsuario(?, ?, ?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setString(1, usuario.getDni());
	            statement.setString(2, usuario.getUsuario());
	            statement.setString(3, usuario.getEmail_Usuarios());
	            statement.setString(4, usuario.getContrasena_Usuarios());
	            statement.setString(5, String.valueOf(usuario.getTipo_Usuarios()));
	            statement.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	 }

	@Override
	public boolean insertPacientes(Pacientes paciente) 
	{
		try {
            Conexion conexion = Conexion.getConexion();
            Connection conn = conexion.getSQLConexion();
            
            String sql = "CALL spInsertarPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, paciente.getDNI_Pacientes());
            statement.setString(2, paciente.getNombre_Pacientes());
            statement.setString(3, paciente.getApellido_Pacientes());
            statement.setString(4, String.valueOf(paciente.getSexo_Pacientes()));
            statement.setString(5, paciente.getFecha_Nacimiento_Pacientes());
            statement.setString(6, paciente.getTelefono_Pacientes());
            statement.setString(7, paciente.getEmail_Pacientes());
            statement.setString(8, paciente.getNacionalidad_Pacientes());
            statement.setString(9, paciente.getDireccion_Pacientes());
            statement.setString(10, paciente.getLocalidad());
            statement.setString(11, paciente.getProvincia());
            statement.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

	@Override
	public boolean insertTurnos(Turnos turno) 
	{
		try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();
	        
	        String sql = "CALL spInsertarTurno(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, turno.getDni_Especialista_Turnos());
	        statement.setString(2, turno.getCod_Especialidad_Turnos());
	        statement.setString(3, turno.getDni_Paciente_Turnos());
	        statement.setInt(4, turno.getAsistencia_Turnos());
	        statement.setString(5, turno.getMotivo_Consulta_Turnos());
	        statement.setString(6, turno.getFecha_Turnos());
	        statement.setInt(7, turno.getId_Dia_Turnos());
	        statement.setInt(8, turno.getId_Hora_Turnos());
	        statement.setString(9, turno.getHorario_Turnos());
	        statement.setString(10, turno.getDia_Turnos());
	        
	        statement.executeUpdate();
	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean insertEspecialistas(Especialistas especialista) 
	{
		try{
			Conexion conexion = Conexion.getConexion();
            Connection conn = conexion.getSQLConexion();
            String query = "{CALL spInsertarEspecialista(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            CallableStatement stmt = conn.prepareCall(query);
            stmt.setString(1, especialista.getDNI_Especialistas());
            stmt.setString(2, especialista.getEspecialidadCodigo());
            stmt.setString(3, especialista.getNombre_Especialistas());
            stmt.setString(4, especialista.getApellido_Especialistas());
            stmt.setString(5, especialista.getTelefono_Especialistas());
            stmt.setString(6, especialista.getEmail_Especialistas());
            stmt.setString(7, String.valueOf(especialista.getSexo_Especialistas()));
            stmt.setString(8, especialista.getFechaNac_Especialistas());
            stmt.setString(9, especialista.getNacionalidad_Especialistas());
            stmt.setString(10, especialista.getDireccion_Especialistas());
            stmt.setString(11, especialista.getnombreLocalidad_Especialistas());
            stmt.setString(12, especialista.getProvincia_Especialistas());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	@Override
	public boolean insertHorarioEspecialista (Especialistas especialista, String dia, String horario) 
	{
		try{
			Conexion conexion = Conexion.getConexion();
            Connection conn = conexion.getSQLConexion();
            String query = "{CALL spInsertarHorario(?, ?, ?, ?)}";

            CallableStatement stmt = conn.prepareCall(query);
            stmt.setString(1, especialista.getDNI_Especialistas());
            stmt.setString(2, especialista. getEspecialidadCodigo());
            stmt.setString(3, dia);
            stmt.setString(4, horario);

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}

//---------------------------------------LISTAR---------------------------------------//
	
	@Override
	public List<Especialistas> readAllEspecialistas(String codigoEspecialidad) {
	    List<Especialistas> listaEspecialistas = new ArrayList<>();
	    try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();

	        CallableStatement cs = conn.prepareCall("{CALL ListarEspecialistas(?)}");
	        if (codigoEspecialidad != null) {
	            cs.setString(1, codigoEspecialidad);
	        } else {
	        	cs.setNull(1, Types.CHAR);// Pasar una cadena vacía para representar el valor nulo
	        }

	        ResultSet rs = cs.executeQuery();

	        while (rs.next()) {
	            Especialistas especialista = new Especialistas();
	            especialista.setDNI_Especialistas(rs.getString("DNI_Especialistas"));
	            especialista.setEspecialidadCodigo(rs.getString("Cod_Especialidad_Especialistas"));
	            especialista.setNombre_Especialistas(rs.getString("Nombre_Especialistas"));
	            especialista.setApellido_Especialistas(rs.getString("Apellido_Especialistas"));
	            especialista.setTelefono_Especialistas(rs.getString("Telefono_Especialistas"));
	            especialista.setEmail_Especialistas(rs.getString("Email_Especialistas"));
	            especialista.setSexo_Especialistas(rs.getString("Sexo_Especialistas").charAt(0));
	            especialista.setFechaNac_Especialistas(rs.getString("FechaNac_Especialistas"));
	            especialista.setNacionalidad_Especialistas(rs.getString("Nacionalidad_Especialistas"));
	            especialista.setDireccion_Especialistas(rs.getString("Direccion_Especialistas"));
	            especialista.setLocalidad_nombreLocalidad(rs.getString("Localidad_Especialistas"));
	            especialista.setProvincia_nombreProvincia(rs.getString("Provincia_Especialistas"));;
	            listaEspecialistas.add(especialista);
	        }

	        return listaEspecialistas;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}


	@Override
	public List<Pacientes> readAllPacientes() {
		List<Pacientes> listaPacientes = new ArrayList<>();
        try {
        	Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();        
            CallableStatement cstmt = conn.prepareCall("{CALL ListarPacientes()}");
            ResultSet rs = cstmt.executeQuery();

            while (rs.next()) {
                Pacientes paciente = new Pacientes();
                paciente.setDNI_Pacientes(rs.getString("DNI_Pacientes"));
                paciente.setNombre_Pacientes(rs.getString("Nombre_Pacientes"));
                paciente.setApellido_Pacientes(rs.getString("Apellido_Pacientes"));
                paciente.setSexo_Pacientes((rs.getString("Sexo_Pacientes")).charAt(0));
                paciente.setNacionalidad_Pacientes(rs.getString("Nacionalidad_Pacientes"));
                paciente.setFecha_Nacimiento_Pacientes(rs.getString("Fecha_Nacimiento_Pacientes"));
                paciente.setDireccion_Pacientes(rs.getString("Direccion_Pacientes"));
                paciente.setLocalidad_nombreLocalidad(rs.getString("Localidad_Pacientes"));;
                paciente.setProvincia_nombreProvincia(rs.getString("Provincia_Pacientes"));
                paciente.setEmail_Pacientes(rs.getString("Email_Pacientes"));
                paciente.setTelefono_Pacientes(rs.getString("Telefono_Pacientes"));
                listaPacientes.add(paciente);
            }
            return listaPacientes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public List<Turnos> readAllTurnos() {
        List<Turnos> turnosList = new ArrayList<>();
	    try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();
	        
	        String query = "{ CALL ListarTurnos() }";
	        CallableStatement stmt = conn.prepareCall(query);
	        
	        ResultSet rs = stmt.executeQuery();
	
	        while (rs.next()) {
	            Turnos turnos = new Turnos();
	            turnos.setCod_Turnos(rs.getInt("Cod_Turnos"));
	            turnos.setDni_Especialista_Turnos(rs.getString("Nombre_Especialistas"));
	            turnos.setCod_Especialidad_Turnos(rs.getString("Descripcion_Especialidad"));
	            turnos.setDni_Paciente_Turnos(rs.getString("Nombre_Pacientes"));
	            turnos.setAsistencia_Turnos(rs.getInt("Asistencia_Turnos"));
	            turnos.setMotivo_Consulta_Turnos(rs.getString("Motivo_Consulta_Turnos"));
	            turnos.setFecha_Turnos(rs.getString("Fecha_Turnos"));
	            turnos.setHorario_Turnos(rs.getString("Horario_Turnos"));
	            turnos.setDia_Turnos(rs.getString("Dia_Turnos"));
	            
	            turnosList.add(turnos);
	        }
	        
	        return turnosList;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public List<Turnos> readAllTurnosPorDniEspecialista(String usuario) {
		List<Turnos> turnosList = new ArrayList<>();
	    try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();
	        
	        String query = "{ CALL ListarTurnosPorDni(?) }";
	        CallableStatement stmt = conn.prepareCall(query);
	        stmt.setString(1, usuario);
	        ResultSet rs = stmt.executeQuery();
	
	        while (rs.next()) {
	            Turnos turnos = new Turnos();
	            turnos.setCod_Turnos(rs.getInt("Cod_Turnos"));
	            turnos.setDni_Especialista_Turnos(rs.getString("Dni_Especialista_Turnos"));
	            turnos.setCod_Especialidad_Turnos(rs.getString("Descripcion_Especialidad"));
	            turnos.setDni_Paciente_Turnos(rs.getString("Dni_Paciente_Turnos"));
	            turnos.setAsistencia_Turnos(rs.getInt("Asistencia_Turnos"));
	            turnos.setMotivo_Consulta_Turnos(rs.getString("Motivo_Consulta_Turnos"));
	            turnos.setFecha_Turnos(rs.getString("Fecha_Turnos"));
	            turnos.setHorario_Turnos(rs.getString("Horario_Turnos"));
	            turnos.setDia_Turnos(rs.getString("Dia_Turnos"));
	            
	            turnosList.add(turnos);
	        }
	        
	        return turnosList;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	@Override
	public List<Turnos> readAllTurnosPorDniPaciente(String usuario) {
		List<Turnos> turnosList = new ArrayList<>();
	    try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();
	        
	        String query = "{ CALL ListarTurnosPorPaciente(?) }";
	        CallableStatement stmt = conn.prepareCall(query);
	        stmt.setString(1, usuario);
	        ResultSet rs = stmt.executeQuery();
	
	        while (rs.next()) {
	            Turnos turnos = new Turnos();
	            turnos.setCod_Turnos(rs.getInt("Cod_Turnos"));
	            turnos.setDni_Especialista_Turnos(rs.getString("Dni_Especialista_Turnos"));
	            turnos.setCod_Especialidad_Turnos(rs.getString("Descripcion_Especialidad"));
	            turnos.setDni_Paciente_Turnos(rs.getString("Dni_Paciente_Turnos"));
	            turnos.setAsistencia_Turnos(rs.getInt("Asistencia_Turnos"));
	            turnos.setMotivo_Consulta_Turnos(rs.getString("Motivo_Consulta_Turnos"));
	            turnos.setFecha_Turnos(rs.getString("Fecha_Turnos"));
	            turnos.setHorario_Turnos(rs.getString("Horario_Turnos"));
	            turnos.setDia_Turnos(rs.getString("Dia_Turnos"));
	            
	            turnosList.add(turnos);
	        }
	        
	        return turnosList;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public List<Usuarios> readAllUsuarios() {
		List<Usuarios> usuariosList = new ArrayList<>();
	    try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();

	        String sql = "{CALL ListarUsuarios()}";
	        CallableStatement stmt = conn.prepareCall(sql);
	        ResultSet rs = stmt.executeQuery();

	        
	        while (rs.next()) {
	            Usuarios usuario = new Usuarios();
	            usuario.setDni(rs.getString("DNI_Usuarios"));
	            usuario.setUsuario(rs.getString("Usuario_Usuarios"));
	            usuario.setEmail_Usuarios(rs.getString("Email_Usuarios"));
	            usuario.setTipo_Usuarios(rs.getString("Tipo_Usuarios").charAt(0));
	            usuario.setContrasena_Usuarios(rs.getString("Contrasena_Usuarios"));
	            usuariosList.add(usuario);
	        }

	        return usuariosList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public List<Especialidad> readAllEspecialidad()
	{
	
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Especialidad> especialidadList = new ArrayList<Especialidad>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readallEspecialidad);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Especialidad especialidad = new Especialidad();
	            especialidad.setCodEspecialidad(resultSet.getString("Cod_Especialidad"));
	            especialidad.setDescripcionEspecialidad(resultSet.getString("Descripcion_Especialidad"));
	            especialidad.setEstadoEspecialidad(resultSet.getInt("Estado_Especialidad"));
	            especialidadList.add(especialidad);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return especialidadList;
	}

	public List<Especialidad> readEspecialidadByEspecialidadCodigo(String codigoEspecialidad) {
		ArrayList<Especialidad> especialidadList = new ArrayList<Especialidad>();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    Conexion conn = Conexion.getConexion();

	    try {
	        String sql = "SELECT * FROM  Especialidades WHERE  Cod_Especialidad =";
	        stmt = conn.getSQLConexion().prepareStatement(sql);
	        stmt.setString(1, codigoEspecialidad);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	        	Especialidad especialidad = new Especialidad();
	            especialidad.setCodEspecialidad(rs.getString("Cod_Especialidad"));
	            especialidad.setDescripcionEspecialidad(rs.getString("Descripcion_Especialidad"));
	            especialidad.setEstadoEspecialidad(rs.getInt("Estado_Especialidad"));
	            especialidadList.add(especialidad);
	            

	           
	        }
	    } catch (SQLException e) {
	        
	        e.printStackTrace();
	   
	    }

	    return especialidadList;
	}
	
	public List<Especialistas> readEspecialistasByEspecialidadCodigo(String codigoEspecialidad) {
	    List<Especialistas> especialistas = new ArrayList<>();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    Conexion conn = Conexion.getConexion();

	    try {
	        String sql = "SELECT * FROM Especialistas WHERE Cod_Especialidad_Especialistas= ?";
	        stmt = conn.getSQLConexion().prepareStatement(sql);
	        stmt.setString(1, codigoEspecialidad);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            Especialistas especialista = new Especialistas();
	            especialista.setDNI_Especialistas(rs.getString("DNI_Especialistas"));
	            especialista.setEspecialidadCodigo(rs.getString("Cod_Especialidad_Especialistas"));;
	            especialista.setNombre_Especialistas(rs.getString("Nombre_Especialistas"));
	            especialista.setApellido_Especialistas(rs.getString("Apellido_Especialistas"));
	            especialista.setTelefono_Especialistas(rs.getString("Telefono_Especialistas"));
	            especialista.setEmail_Especialistas(rs.getString("Email_Especialistas"));
	            especialista.setSexo_Especialistas(rs.getString("Sexo_Especialistas").charAt(0));
	            especialista.setFechaNac_Especialistas(rs.getString("FechaNac_Especialistas"));
	            especialista.setNacionalidad_Especialistas(rs.getString("Nacionalidad_Especialistas"));
	            especialista.setDireccion_Especialistas(rs.getString("Direccion_Especialistas"));
	            especialista.setLocalidad_nombreLocalidad(rs.getString("Localidad_Especialistas"));
	            especialista.setProvincia_nombreProvincia(rs.getString("Provincia_Especialistas"));
	            

	            especialistas.add(especialista);
	        }
	    } catch (SQLException e) {
	        
	        e.printStackTrace();
	   
	    }

	    return especialistas;
	}

	@Override
	public List<Provincia> readAllProvincias() {
		
		List<Provincia> provinciaList = new ArrayList<>();
	    try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();
	        
	        String query = "{ CALL ListarProvincias() }";
	        CallableStatement stmt = conn.prepareCall(query);
	        
	        ResultSet rs = stmt.executeQuery();
	
	        while (rs.next()) {
	        	Provincia prov = new Provincia();
	            prov.setCodProvincia(rs.getString("Cod_Provincias"));
	            prov.setNombreProvincia(rs.getString("Nombre_Provincias"));
	            
	            provinciaList.add(prov);
	        }
	        
	        return provinciaList;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}


	@Override
	public List<Localidad> readAllLocalidades(String codProvincia) {
		
		List<Localidad> localidadList = new ArrayList<>();
	    
		try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();
	        
	        CallableStatement stmt = conn.prepareCall("{ CALL ListarLocalidades(?) }");
	        
	        if (codProvincia != null) {
	        	stmt.setString(1, codProvincia);
	        } else {
	        	stmt.setNull(1, Types.CHAR);// Pasar una cadena vacía para representar el valor nulo
	        }
	        
	        ResultSet rs = stmt.executeQuery();
	
	        while (rs.next()) {
	        	Localidad loc = new Localidad();
	        	loc.setCodLocalidad(rs.getString("Cod_Localidades"));
	        	loc.setCodProvincia(rs.getString("Cod_Provincia_Localidades"));
	        	loc.setNombreLocalidad(rs.getString("Nombre_Localidades"));
	            
	            localidadList.add(loc);
	        }
	        
	        return localidadList;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	
	@Override
	public List<ExDxH> readAllExDxHPorDniEspecialista(String dni) {
		List<ExDxH> ExDxHList = new ArrayList<>();
	    try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();
	        
	        String query = "{ CALL ListarExDxHPorDni(?) }";
	        CallableStatement stmt = conn.prepareCall(query);
	        stmt.setString(1, dni);
	        ResultSet rs = stmt.executeQuery();
	
	        while (rs.next()) {
	        	ExDxH turnos = new ExDxH();
	            turnos.setId_Dias_EXDXH(rs.getInt("Id_Dias_EXDXH"));
	            turnos.setId_Horas_EXDXH(rs.getInt("Id_Horas_EXDXH"));
	            turnos.setEspecialistas(rs.getString("DNI_Especialistas_EXDXH"));
	            turnos.setEspecialidad(rs.getString("Cod_Especialidad_EXDXH"));
	            turnos.setCantidad_Turnos_EXDXH(rs.getInt("Cantidad_Turnos_EXDXH"));
	            turnos.setEstado_EXDXH(rs.getInt("Estado_EXDXH"));
	            
	            ExDxHList.add(turnos);
	        }
	        
	        return ExDxHList;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}



	//---------------------------------------BORRAR---------------------------------------//
	@Override
	public boolean borrarEspecialistas(Especialistas especialista) 
	{
		try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();

	        // Paso 1: Preparar la llamada al stored procedure
	        String sql = "{CALL spEliminarEspecialista(?)}";
	        CallableStatement stmt = conn.prepareCall(sql);

	        // Paso 2: Establecer los parámetros del stored procedure
	        stmt.setString(1, especialista.getDNI_Especialistas());

	        // Paso 3: Ejecutar el stored procedure
	        stmt.execute();

	        // El stored procedure se ha ejecutado correctamente
	        System.out.println("Especialista eliminado correctamente.");

	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean borrarPacientes(Pacientes paciente) {
		try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();

	        // Paso 1: Preparar la llamada al stored procedure
	        String sql = "{CALL spEliminarPaciente(?)}";
	        CallableStatement stmt = conn.prepareCall(sql);

	        // Paso 2: Establecer los parámetros del stored procedure
	        stmt.setString(1, paciente.getDNI_Pacientes());

	        // Paso 3: Ejecutar el stored procedure
	        stmt.execute();

	        // El stored procedure se ha ejecutado correctamente
	        System.out.println("Paciente eliminado correctamente.");

	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean borrarTurnos(Turnos turno) {
	    try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();

	        // Paso 1: Preparar la llamada al stored procedure
	        String sql = "{CALL spEliminarTurno(?)}";
	        CallableStatement stmt = conn.prepareCall(sql);

	        // Paso 2: Establecer los parámetros del stored procedure
	        stmt.setInt(1, turno.getCod_Turnos());

	        // Paso 3: Ejecutar el stored procedure
	        stmt.execute();

	        // El stored procedure se ha ejecutado correctamente
	        System.out.println("Turno eliminado correctamente.");

	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	    
	}

	@Override
	public boolean borrarUsuarios(Usuarios usuario) {
		try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();

	        // Paso 1: Preparar la llamada al stored procedure
	        String sql = "{CALL spEliminarUsuarios(?)}";
	        CallableStatement stmt = conn.prepareCall(sql);

	        // Paso 2: Establecer los parámetros del stored procedure
	        stmt.setString(1, usuario.getDni());

	        // Paso 3: Ejecutar el stored procedure
	        stmt.execute();

	        // El stored procedure se ha ejecutado correctamente
	        System.out.println("Usuario eliminado correctamente.");

	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	//---------------------------------------MODIFICAR---------------------------------------//
	@Override
	public boolean ModificarEstadoDeUsuario(String dni, String usuario, String email, String contrasena) {
		
	
		try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();
	        
	        CallableStatement stmt = conn.prepareCall("{ CALL ActivarUsuarioDesactivado(?,?,?,?) }");
	        stmt.setString(1, dni);
	        stmt.setString(2, usuario);
	        stmt.setString(3, email);
	        stmt.setString(4, contrasena);
	        
	        ResultSet rs = stmt.executeQuery();
	
	        while (rs.next()) {
	        	return true;
	        }
	        
	        return false;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	       
	    }
		return false;
	}
	
	public boolean ModificarPwdUsuario(String usuario, String pwd){
		UsuariosNegocioImpl usuneg = new UsuariosNegocioImpl(); /////////REVISAR ESTO
		List<Usuarios> usuariosList = usuneg.readAllUsuarios();
		for (Usuarios elemento : usuariosList) {
			if(elemento.getUsuario().equals(usuario)) {
				System.out.println("se encontro un usuario coincidente");
				
				PreparedStatement statement;
//				ResultSet resultSet;
				
				Conexion conexion = Conexion.getConexion();
				try {
			        statement = conexion.getSQLConexion().prepareStatement(modificarPwdTurnos);
			        statement.setString(1, pwd);
			        System.out.println(elemento.getDni());
			        statement.setString(2, elemento.getDni());
			  

			        int filasActualizadas = statement.executeUpdate();
			        System.out.println("filas actualizadas" + filasActualizadas);
			        if (filasActualizadas > 0) {
			            return true;
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
				
			}
			
		}
		return false;
	}
	public boolean ModificarAdminPorDni(Usuarios usuario)
	{
		PreparedStatement statement;
		Usuarios usu = new Usuarios();
		ResultSet resultSet;
		
		Conexion conexion = Conexion.getConexion();
		try {
	        statement = conexion.getSQLConexion().prepareStatement(modificarAdmin);
	        statement.setString(1, usuario.getUsuario());
	        statement.setString(2, usuario.getEmail_Usuarios());
	        statement.setString(3, usuario.getContrasena_Usuarios());
	        statement.setString(4, usuario.getDni());

	        int filasActualizadas = statement.executeUpdate();
	        if (filasActualizadas > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}
	
	
	public boolean ModificarPacientePorDni(Pacientes paciente)
	{
		PreparedStatement statement;
		
		Conexion conexion = Conexion.getConexion();
		try {
	        statement = conexion.getSQLConexion().prepareStatement(modificarPacientes);	        
	        statement.setString(1, paciente.getNombre_Pacientes());
            statement.setString(2, paciente.getApellido_Pacientes());
            statement.setString(3, String.valueOf(paciente.getSexo_Pacientes()));
            statement.setString(4, paciente.getFecha_Nacimiento_Pacientes());
            statement.setString(5, paciente.getTelefono_Pacientes());
            statement.setString(6, paciente.getEmail_Pacientes());
            statement.setString(7, paciente.getNacionalidad_Pacientes());
            statement.setString(8, paciente.getDireccion_Pacientes());
            statement.setString(9, paciente.getLocalidad());
            statement.setString(10, paciente.getProvincia());
            statement.setString(11, paciente.getDNI_Pacientes());
	        
	        int filasActualizadas = statement.executeUpdate();
	        if (filasActualizadas > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}
	
	
	public boolean ModificarMedicoPorDni(Especialistas especialista)
    {
        PreparedStatement statement;

        Conexion conexion = Conexion.getConexion();
        try {
            statement = conexion.getSQLConexion().prepareStatement(modificarEspecialista);
            statement.setString(1, especialista.getNombre_Especialistas());
            statement.setString(2, especialista.getApellido_Especialistas());
            statement.setString(3, String.valueOf(especialista.getSexo_Especialistas()));
            statement.setString(4, especialista.getFechaNac_Especialistas());
            statement.setString(5, especialista.getTelefono_Especialistas());
            statement.setString(6, especialista.getEmail_Especialistas());
            statement.setString(7, especialista.getNacionalidad_Especialistas());
            statement.setString(8, especialista.getDireccion_Especialistas());
            statement.setString(9, especialista.getnombreLocalidad_Especialistas());
            statement.setString(10, especialista.getProvincia_Especialistas());
            statement.setString(11, especialista.getEspecialidadCodigo());
            statement.setString(12, especialista.getDNI_Especialistas());

            

            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	public boolean ModificarTurnos(Turnos turnos)
	{ 
		System.out.println("entramos a la funcion");
		PreparedStatement statement;
		
		Conexion conexion = Conexion.getConexion();
		
		try {
			System.out.println("dentro del try");
	        statement = conexion.getSQLConexion().prepareStatement(modificarTurnos);
	        statement.setString(1, turnos.getDni_Paciente_Turnos());
	        statement.setInt(2, turnos.getAsistencia_Turnos());
	        statement.setInt(3, turnos.getCod_Turnos());
	       

	        int filasActualizadas = statement.executeUpdate();
	        System.out.println("filas"+filasActualizadas);
	        if (filasActualizadas > 0) {
	            return true;
	            
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}
	
	@Override
	public boolean modificarTurno(String dni, int codTurno, String motivo, int estado) {
		try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();

	        // Paso 1: Preparar la llamada al stored procedure
	        String sql = "{CALL ModificarTurno(?, ?, ?, ?)}";
	        CallableStatement stmt = conn.prepareCall(sql);

	        // Paso 2: Establecer los parámetros del stored procedure
	        stmt.setInt(1, codTurno);
	        stmt.setString(2, dni);
	        stmt.setInt(3, estado);
	        stmt.setString(4, motivo);

	        // Paso 3: Ejecutar el stored procedure
	        stmt.execute();

	        return true;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	@Override
	public boolean ModificarUsuarioMedPorDni(Usuarios usuario) {
		PreparedStatement statement;
		Usuarios usu = new Usuarios();
		ResultSet resultSet;
		
		Conexion conexion = Conexion.getConexion();
		try {
	        statement = conexion.getSQLConexion().prepareStatement(modificarUsuario);
	        statement.setString(1, usuario.getUsuario());
	        statement.setString(2, usuario.getEmail_Usuarios());
	        statement.setString(3, usuario.getContrasena_Usuarios());
	        statement.setString(4, usuario.getDni());

	        int filasActualizadas = statement.executeUpdate();
	        if (filasActualizadas > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}
	
	//---------------------------------------BUSCAR---------------------------------------//

	
	public Especialistas BuscarEspecialistaPorDni(String DNI)
	{
		PreparedStatement statement;
		Especialistas esp = new Especialistas();
		ResultSet resultSet;
		
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(buscarEspecialista);
			statement.setString(1, DNI);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {	
				esp.setDNI_Especialistas(resultSet.getString("DNI_Especialistas"));
				esp.setEspecialidadCodigo(resultSet.getString("Cod_Especialidad_Especialistas"));
				esp.setNombre_Especialistas(resultSet.getString("Nombre_Especialistas"));
				esp.setApellido_Especialistas(resultSet.getString("Apellido_Especialistas"));
				esp.setFechaNac_Especialistas(resultSet.getString("FechaNac_Especialistas"));
				esp.setNacionalidad_Especialistas(resultSet.getString("Nacionalidad_Especialistas"));
				esp.setSexo_Especialistas(resultSet.getString("Sexo_Especialistas").charAt(0));
				esp.setTelefono_Especialistas(resultSet.getString("Telefono_Especialistas"));
				esp.setDireccion_Especialistas(resultSet.getString("Direccion_Especialistas"));
				esp.setLocalidad_nombreLocalidad(resultSet.getString("Localidad_Especialistas"));
				esp.setProvincia_nombreProvincia(resultSet.getString("Provincia_Especialistas"));
				esp.setEmail_Especialistas(resultSet.getString("Email_Especialistas"));
			}
			
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return esp;
	}

	
	public Usuarios BuscarAdminPorDni(String DNI)
	{
		PreparedStatement statement;
		Usuarios usu = new Usuarios();
		ResultSet resultSet;
		
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(buscarAdmin);
			statement.setString(1, DNI);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
			    usu.setDni(resultSet.getString("DNI_Usuarios"));
			    usu.setUsuario(resultSet.getString("Usuario_Usuarios"));
			    usu.setEmail_Usuarios((resultSet.getString("Email_Usuarios")));
			    usu.setContrasena_Usuarios(resultSet.getString("Contrasena_Usuarios"));
			    usu.setTipo_Usuarios(resultSet.getString("Tipo_Usuarios").charAt(0));
			    usu.setEstado_Usuarios(resultSet.getInt("Estado_Usuarios"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return usu;
	}
	
	
	public Pacientes BuscarPacientesPorDni(String DNI)
	{
		PreparedStatement statement;
		Pacientes pac = new Pacientes();
		ResultSet resultSet;
		 System.out.println(DNI);
		
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(buscarPaciente);
			statement.setString(1, DNI);
		
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				pac.setDNI_Pacientes(resultSet.getString("DNI_Pacientes"));
				pac.setNombre_Pacientes(resultSet.getString("Nombre_Pacientes"));
				pac.setApellido_Pacientes((resultSet.getString("Apellido_Pacientes")));
				pac.setSexo_Pacientes(resultSet.getString("Sexo_Pacientes").charAt(0));
				pac.setNacionalidad_Pacientes(resultSet.getString("Nacionalidad_Pacientes"));
				pac.setDireccion_Pacientes(resultSet.getString("Direccion_Pacientes"));
				pac.setFecha_Nacimiento_Pacientes(resultSet.getString("Fecha_Nacimiento_Pacientes"));
				pac.setTelefono_Pacientes(resultSet.getString("Telefono_Pacientes"));
				pac.setEmail_Pacientes(resultSet.getString("Email_Pacientes"));
				pac.setEstado_Pacientes(resultSet.getInt("Estado_Pacientes"));
				pac.setLocalidad_nombreLocalidad(resultSet.getString("Localidad_Pacientes"));
				pac.setProvincia_nombreProvincia(resultSet.getString("Provincia_Pacientes"));
				return pac;

			
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}



	public Usuarios BuscarUsuarioMedicoPorDni (String DNI)
    {
        PreparedStatement statement;
        Usuarios usu = new Usuarios();
        ResultSet resultSet;

        Conexion conexion = Conexion.getConexion();
        try 
        {
            statement = conexion.getSQLConexion().prepareStatement(buscarUsuarioEsp);
            statement.setString(1, DNI);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                usu.setDni(resultSet.getString("DNI_Usuarios"));
                usu.setUsuario(resultSet.getString("Usuario_Usuarios"));
                usu.setEmail_Usuarios((resultSet.getString("Email_Usuarios")));
                usu.setContrasena_Usuarios(resultSet.getString("Contrasena_Usuarios"));
                usu.setTipo_Usuarios(resultSet.getString("Tipo_Usuarios").charAt(0));
                usu.setEstado_Usuarios(resultSet.getInt("Estado_Usuarios"));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return usu;
    }
	

	//---------------------------------------Reportes---------------------------------------//

	@Override
	public List<ReporteMedico> filtrarReporteMedico(String mes, String codEspecialidad) {
		
		List<ReporteMedico> rmList = new ArrayList<>();
	    
		try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();

	        String sql = "{CALL spReportesMedico(?,?)}";
	        CallableStatement stmt = conn.prepareCall(sql);
	        //setteo parametros
	        stmt.setString(1, mes);
	        stmt.setString(2, codEspecialidad);
	        
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	ReporteMedico rm = new ReporteMedico();
	        	rm.setDni_Especialista_Turnos(rs.getString("Dni_Especialista_Turnos"));
	        	rm.setNombre_Especialistas(rs.getString("Nombre_Especialistas"));
	        	rm.setApellido_Especialistas(rs.getString("Apellido_Especialistas"));
	        	rm.setCod_Especialidad_Turnos(rs.getString("Cod_Especialidad_Turnos"));
	        	rm.setContados(rs.getInt("count(turnos.Dni_Especialista_Turnos)"));
	        	
	        	rmList.add(rm);
	        }

	        return rmList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	@Override
	public List<ReportePaciente> filtrarReportePaciente(String dni, String especialidad) {
	    List<ReportePaciente> rpList = new ArrayList<>();

	    try {
	        Conexion conexion = Conexion.getConexion();
	        Connection conn = conexion.getSQLConexion();

	        String sql = "{CALL spReportesPacientes(?, ?)}";
	        CallableStatement stmt = conn.prepareCall(sql);
	        // Setteo el parámetro
	        stmt.setString(1, dni);
	        stmt.setString(2,especialidad);

	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            ReportePaciente rp = new ReportePaciente();
	            rp.setMes_Paciente_Turnos(rs.getString("Mes_Paciente_Turnos"));
	            rp.setDni_Paciente_Turnos(rs.getString("Dni_Paciente_Turnos"));
	            rp.setNombre_Paciente_Turnos(rs.getString("NombreCompleto_Paciente"));
	            rp.setNombre_Especialidad_Turnos(rs.getString("Descripcion_Especialidad"));
	            rp.setContador(rs.getInt("contador"));

	            rpList.add(rp);
	        }

	        return rpList;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

	@Override
	public Provincia buscarNombreProvincia(String codProvincia) {
		
		PreparedStatement statement;
		Provincia prov = new Provincia();
        ResultSet resultSet;

        Conexion conexion = Conexion.getConexion();
        try 
        {
            statement = conexion.getSQLConexion().prepareStatement(buscarProvincia);
            statement.setString(1, codProvincia);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	prov.setCodProvincia(resultSet.getString("Cod_Provincias"));
            	prov.setNombreProvincia(resultSet.getString("Nombre_Provincias"));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return prov;
	}

	@Override
	public Localidad buscarNombreLocalidad(String codLocalidad) {
		PreparedStatement statement;
		Localidad loc = new Localidad();
        ResultSet resultSet;

        Conexion conexion = Conexion.getConexion();
        try 
        {
            statement = conexion.getSQLConexion().prepareStatement(buscarLocalidad);
            statement.setString(1, codLocalidad);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	
            	loc.setCodLocalidad(resultSet.getString("Cod_Localidades"));
            	loc.setNombreLocalidad(resultSet.getString("Nombre_Localidades"));
            	loc.setCodProvincia(resultSet.getString("Cod_Provincia_Localidades"));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return loc;
	}

	@Override
	public Especialidad buscarEspecialidadPorCodigo(String codEspecialidad) {
		PreparedStatement statement;
		Especialidad espe = new Especialidad();
        ResultSet resultSet;

        Conexion conexion = Conexion.getConexion();
        try 
        {
            statement = conexion.getSQLConexion().prepareStatement(buscarEspecialidad);
            statement.setString(1, codEspecialidad);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
            	
            	espe.setCodEspecialidad(resultSet.getString("Cod_Especialidad"));
            	espe.setDescripcionEspecialidad(resultSet.getString("Descripcion_Especialidad"));

            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return espe;
	}
	
	
	
	

}


