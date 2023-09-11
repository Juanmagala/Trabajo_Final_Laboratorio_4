package entidad;

public class Turnos {
	private int Cod_Turnos;
    private Especialidad Cod_Especialidad_Turnos = new Especialidad();
    private Pacientes Dni_Paciente_Turnos= new Pacientes();
    private Especialistas Especialista_Turnos= new Especialistas();
    private String Dni_Especialista_Turnos;
    private int Asistencia_Turnos;
    private String Motivo_Consulta_Turnos;
    private String Fecha_Turnos;
    private int Id_Dia_Turnos;
    private int Id_Hora_Turnos;
    private String Horario_Turnos;
    private String Dia_Turnos;
    private int Estado_Turnos;
    
    //GETS Y SETS// 
	public int getCod_Turnos() {
		return Cod_Turnos;
	}
	public void setCod_Turnos(int cod_Turnos) {
		Cod_Turnos = cod_Turnos;
	}
	public String getDni_Especialista_Turnos() {
		return Especialista_Turnos.getDNI_Especialistas();
	}
	public void setDni_Especialista_Turnos(String dni_Especialista_Turnos) {
		this.Especialista_Turnos.setDNI_Especialistas(dni_Especialista_Turnos);
	}
	public String getCod_Especialidad_Turnos() {
		return Especialista_Turnos.getEspecialidadCodigo();
	}
	public void setCod_Especialidad_Turnos(String cod_Especialidad_Turnos) {
		this.Especialista_Turnos.setEspecialidadCodigo(cod_Especialidad_Turnos);
	}
	public String getDni_Paciente_Turnos() {
		return Dni_Paciente_Turnos.getDNI_Pacientes();
	}
	public void setDni_Paciente_Turnos(String dni_Paciente_Turnos) {
		this.Dni_Paciente_Turnos.setDNI_Pacientes(dni_Paciente_Turnos);
	}
	public int getAsistencia_Turnos() {
		return Asistencia_Turnos;
	}
	public void setAsistencia_Turnos(int asistencia_Turnos) {
		Asistencia_Turnos = asistencia_Turnos;
	}
	public String getMotivo_Consulta_Turnos() {
		return Motivo_Consulta_Turnos;
	}
	public void setMotivo_Consulta_Turnos(String motivo_Consulta_Turnos) {
		Motivo_Consulta_Turnos = motivo_Consulta_Turnos;
	}
	public String getFecha_Turnos() {
		return Fecha_Turnos;
	}
	public void setFecha_Turnos(String fecha_Turnos) {
		Fecha_Turnos = fecha_Turnos;
	}
	public int getId_Dia_Turnos() {
		return Id_Dia_Turnos;
	}
	public void setId_Dia_Turnos(int id_Dia_Turnos) {
		Id_Dia_Turnos = id_Dia_Turnos;
	}
	public int getId_Hora_Turnos() {
		return Id_Hora_Turnos;
	}
	public void setId_Hora_Turnos(int id_Hora_Turnos) {
		Id_Hora_Turnos = id_Hora_Turnos;
	}
	public String getHorario_Turnos() {
		return Horario_Turnos;
	}
	public void setHorario_Turnos(String horario_Turnos) {
		Horario_Turnos = horario_Turnos;
	}
	public String getDia_Turnos() {
		return Dia_Turnos;
	}
	public void setDia_Turnos(String dia_Turnos) {
		Dia_Turnos = dia_Turnos;
	}
	public int getEstado_Turnos() {
		return Estado_Turnos;
	}
	public void setEstado_Turnos(int estado_Turnos) {
		Estado_Turnos = estado_Turnos;
	}
    
	//CONSTRUCTORES//
    public Turnos()
    {
        this.Especialista_Turnos.setDNI_Especialistas("-");
        this.Especialista_Turnos.setEspecialidadCodigo("-");
        this.Dni_Paciente_Turnos.setDNI_Pacientes("-");
        Asistencia_Turnos=0;
        Motivo_Consulta_Turnos="-";
        Fecha_Turnos="-";
        Id_Dia_Turnos=0;
        Id_Hora_Turnos=0;
        Horario_Turnos="-";
        Dia_Turnos="-";
        Estado_Turnos=0;
    }
    
    public Turnos(String Dni_Especialista_Turnos, String Cod_Especialidad_Turnos, String Dni_Paciente_Turnos, int Asistencia_Turnos, String Motivo_Consulta_Turnos,
    		String Fecha_Turnos, int Id_Dia_Turnos, int Id_Hora_Turnos, String Horario_Turnos, String Dia_Turnos, int Estado_Turnos)
    {
        this.Especialista_Turnos.setDNI_Especialistas(Dni_Especialista_Turnos);
        this.Especialista_Turnos.setEspecialidadCodigo(Cod_Especialidad_Turnos);
        this.Dni_Paciente_Turnos.setDNI_Pacientes(Dni_Paciente_Turnos);
        this.Asistencia_Turnos=Asistencia_Turnos;
        this.Motivo_Consulta_Turnos=Motivo_Consulta_Turnos;
        this.Fecha_Turnos=Fecha_Turnos;
        this.Id_Dia_Turnos=Id_Dia_Turnos;
        this.Id_Hora_Turnos=Id_Hora_Turnos;
        this.Horario_Turnos=Horario_Turnos;
        this.Dia_Turnos=Dia_Turnos;
        this.Estado_Turnos=Estado_Turnos;
    }
  //METODOS//
	@Override
	public String toString() {
		return "Turnos [Cod_Turnos=" + Cod_Turnos + ", Cod_Especialidad_Turnos=" + Cod_Especialidad_Turnos
				+ ", Dni_Paciente_Turnos=" + Dni_Paciente_Turnos + ", Especialista_Turnos=" + Especialista_Turnos
				+ ", Dni_Especialista_Turnos=" + Dni_Especialista_Turnos + ", Asistencia_Turnos=" + Asistencia_Turnos
				+ ", Motivo_Consulta_Turnos=" + Motivo_Consulta_Turnos + ", Fecha_Turnos=" + Fecha_Turnos
				+ ", Id_Dia_Turnos=" + Id_Dia_Turnos + ", Id_Hora_Turnos=" + Id_Hora_Turnos + ", Horario_Turnos="
				+ Horario_Turnos + ", Dia_Turnos=" + Dia_Turnos + ", Estado_Turnos=" + Estado_Turnos + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Asistencia_Turnos;
		result = prime * result + ((Cod_Especialidad_Turnos == null) ? 0 : Cod_Especialidad_Turnos.hashCode());
		result = prime * result + Cod_Turnos;
		result = prime * result + ((Dia_Turnos == null) ? 0 : Dia_Turnos.hashCode());
		result = prime * result + ((Dni_Especialista_Turnos == null) ? 0 : Dni_Especialista_Turnos.hashCode());
		result = prime * result + ((Dni_Paciente_Turnos == null) ? 0 : Dni_Paciente_Turnos.hashCode());
		result = prime * result + ((Especialista_Turnos == null) ? 0 : Especialista_Turnos.hashCode());
		result = prime * result + Estado_Turnos;
		result = prime * result + ((Fecha_Turnos == null) ? 0 : Fecha_Turnos.hashCode());
		result = prime * result + ((Horario_Turnos == null) ? 0 : Horario_Turnos.hashCode());
		result = prime * result + Id_Dia_Turnos;
		result = prime * result + Id_Hora_Turnos;
		result = prime * result + ((Motivo_Consulta_Turnos == null) ? 0 : Motivo_Consulta_Turnos.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Turnos other = (Turnos) obj;
		if (Asistencia_Turnos != other.Asistencia_Turnos) {
			return false;
		}
		if (Cod_Especialidad_Turnos == null) {
			if (other.Cod_Especialidad_Turnos != null) {
				return false;
			}
		} else if (!Cod_Especialidad_Turnos.equals(other.Cod_Especialidad_Turnos)) {
			return false;
		}
		if (Cod_Turnos != other.Cod_Turnos) {
			return false;
		}
		if (Dia_Turnos == null) {
			if (other.Dia_Turnos != null) {
				return false;
			}
		} else if (!Dia_Turnos.equals(other.Dia_Turnos)) {
			return false;
		}
		if (Dni_Especialista_Turnos == null) {
			if (other.Dni_Especialista_Turnos != null) {
				return false;
			}
		} else if (!Dni_Especialista_Turnos.equals(other.Dni_Especialista_Turnos)) {
			return false;
		}
		if (Dni_Paciente_Turnos == null) {
			if (other.Dni_Paciente_Turnos != null) {
				return false;
			}
		} else if (!Dni_Paciente_Turnos.equals(other.Dni_Paciente_Turnos)) {
			return false;
		}
		if (Especialista_Turnos == null) {
			if (other.Especialista_Turnos != null) {
				return false;
			}
		} else if (!Especialista_Turnos.equals(other.Especialista_Turnos)) {
			return false;
		}
		if (Estado_Turnos != other.Estado_Turnos) {
			return false;
		}
		if (Fecha_Turnos == null) {
			if (other.Fecha_Turnos != null) {
				return false;
			}
		} else if (!Fecha_Turnos.equals(other.Fecha_Turnos)) {
			return false;
		}
		if (Horario_Turnos == null) {
			if (other.Horario_Turnos != null) {
				return false;
			}
		} else if (!Horario_Turnos.equals(other.Horario_Turnos)) {
			return false;
		}
		if (Id_Dia_Turnos != other.Id_Dia_Turnos) {
			return false;
		}
		if (Id_Hora_Turnos != other.Id_Hora_Turnos) {
			return false;
		}
		if (Motivo_Consulta_Turnos == null) {
			if (other.Motivo_Consulta_Turnos != null) {
				return false;
			}
		} else if (!Motivo_Consulta_Turnos.equals(other.Motivo_Consulta_Turnos)) {
			return false;
		}
		return true;
	}
    
    
    
}
