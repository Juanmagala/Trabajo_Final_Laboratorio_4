package dao;

import java.util.List;

import entidad.Especialidad;
import entidad.Especialistas;
import entidad.ExDxH;
import entidad.Pacientes;
import entidad.Turnos;
import entidad.Usuarios;
import entidad.Provincia;
import entidad.Localidad;
import entidad.ReporteMedico;
import entidad.ReportePaciente;

public interface ClinicaDao {
	public boolean existeUsuario(Usuarios usuario);
	public Usuarios BuscarAdminPorDni(String DNI);
	public Pacientes BuscarPacientesPorDni(String DNI);
	public Especialistas BuscarEspecialistaPorDni(String DNI);
	public Usuarios BuscarUsuarioMedicoPorDni (String DNI);
	public boolean VerificarNombreUsuario(String usuario);
	public boolean VerificarUsuarioPorDni(String dni);
	public int  BuscarRegistroUsuarioPorDni(String dni);
	
	public boolean insertEspecialistas(Especialistas especialista);
	public boolean insertPacientes(Pacientes paciente);
	public boolean insertTurnos(Turnos turno);
	public boolean insertUsuarios(Usuarios usuario);
	public boolean insertHorarioEspecialista (Especialistas especialista, String dia, String horario);
	
	public boolean borrarEspecialistas(Especialistas especialista);
	public boolean borrarPacientes(Pacientes paciente);
	public boolean borrarTurnos(Turnos turno);
	public boolean borrarUsuarios(Usuarios usuario);
	
	public boolean ModificarAdminPorDni(Usuarios usuario);
	public boolean ModificarEstadoDeUsuario(String dni, String usuario, String email, String contrasena);
	public boolean ModificarPwdUsuario(String usuario, String pwd);
	public boolean ModificarPacientePorDni(Pacientes pacientes);
	public boolean ModificarMedicoPorDni(Especialistas especialista);
	public boolean ModificarTurnos(Turnos turnos);
	public boolean modificarTurno(String dni, int codTurno, String motivo, int estado);
	public boolean ModificarUsuarioMedPorDni(Usuarios usuario);
	
	public List<Especialistas> readAllEspecialistas(String codigoEspecialidad);
	public List<Pacientes> readAllPacientes();
	public List<Turnos> readAllTurnos();
	public List<Usuarios> readAllUsuarios();
	public List<Especialidad> readAllEspecialidad();

	public List<Provincia> readAllProvincias();
	public List<Localidad> readAllLocalidades(String codProvincia);

	public List<Especialistas> readEspecialistasByEspecialidadCodigo(String codigoEspecialidad);
	public List<Especialidad> readEspecialidadByEspecialidadCodigo(String codigoEspecialidad);
	public List<Turnos> readAllTurnosPorDniEspecialista(String usuario);
	public List<Turnos> readAllTurnosPorDniPaciente(String usuario);
	public List<ExDxH> readAllExDxHPorDniEspecialista(String dni);
	
	public List<ReporteMedico> filtrarReporteMedico(String mes , String codEspecialidad);
	public List<ReportePaciente> filtrarReportePaciente(String dni, String especialidad);
	
	public Provincia buscarNombreProvincia (String codProvincia);
	public Localidad buscarNombreLocalidad (String codLocalidad);
	public Especialidad buscarEspecialidadPorCodigo(String codEspecialidad);
	
}
