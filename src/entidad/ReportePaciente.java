package entidad;

public class ReportePaciente {
	private String Mes_Paciente_Turnos;
    private String Dni_Paciente_Turnos;
    private String Nombre_Paciente_Turnos;
    private String Nombre_Especialidad_Turnos;
    private int contador;
    
    //CONSTRUCTORES
	public ReportePaciente(String mes_Paciente_Turnos, String dni_Paciente_Turnos, 
			String nombre_Paciente_Turnos,
			String nombre_Especialidad_Turnos, int contador) 
	{
		Mes_Paciente_Turnos = mes_Paciente_Turnos;
		Dni_Paciente_Turnos = dni_Paciente_Turnos;
		Nombre_Paciente_Turnos = nombre_Paciente_Turnos;
		Nombre_Especialidad_Turnos = nombre_Especialidad_Turnos;
		this.contador = contador;
	}
	
	public ReportePaciente() 
	{
		Mes_Paciente_Turnos = "";
		Dni_Paciente_Turnos = "";
		Nombre_Paciente_Turnos = "";
		Nombre_Especialidad_Turnos = "";
		this.contador = 0;
	}


	//GETS Y SETS
	public String getMes_Paciente_Turnos() {
		return Mes_Paciente_Turnos;
	}

	public void setMes_Paciente_Turnos(String mes_Paciente_Turnos) {
		Mes_Paciente_Turnos = mes_Paciente_Turnos;
	}

	public String getDni_Paciente_Turnos() {
		return Dni_Paciente_Turnos;
	}

	public void setDni_Paciente_Turnos(String dni_Paciente_Turnos) {
		Dni_Paciente_Turnos = dni_Paciente_Turnos;
	}

	public String getNombre_Paciente_Turnos() {
		return Nombre_Paciente_Turnos;
	}

	public void setNombre_Paciente_Turnos(String nombre_Paciente_Turnos) {
		Nombre_Paciente_Turnos = nombre_Paciente_Turnos;
	}

	public String getNombre_Especialidad_Turnos() {
		return Nombre_Especialidad_Turnos;
	}

	public void setNombre_Especialidad_Turnos(String nombre_Especialidad_Turnos) {
		Nombre_Especialidad_Turnos = nombre_Especialidad_Turnos;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	//METODOS
	
	@Override
	public String toString() {
		return "ReportePaciente [Mes_Paciente_Turnos=" + Mes_Paciente_Turnos + ", Dni_Paciente_Turnos="
				+ Dni_Paciente_Turnos + ", Nombre_Paciente_Turnos=" + Nombre_Paciente_Turnos
				+ ", Nombre_Especialidad_Turnos=" + Nombre_Especialidad_Turnos + ", contador=" + contador + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Dni_Paciente_Turnos == null) ? 0 : Dni_Paciente_Turnos.hashCode());
		result = prime * result + ((Mes_Paciente_Turnos == null) ? 0 : Mes_Paciente_Turnos.hashCode());
		result = prime * result + ((Nombre_Especialidad_Turnos == null) ? 0 : Nombre_Especialidad_Turnos.hashCode());
		result = prime * result + ((Nombre_Paciente_Turnos == null) ? 0 : Nombre_Paciente_Turnos.hashCode());
		result = prime * result + contador;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportePaciente other = (ReportePaciente) obj;
		if (Dni_Paciente_Turnos == null) {
			if (other.Dni_Paciente_Turnos != null)
				return false;
		} else if (!Dni_Paciente_Turnos.equals(other.Dni_Paciente_Turnos))
			return false;
		if (Mes_Paciente_Turnos == null) {
			if (other.Mes_Paciente_Turnos != null)
				return false;
		} else if (!Mes_Paciente_Turnos.equals(other.Mes_Paciente_Turnos))
			return false;
		if (Nombre_Especialidad_Turnos == null) {
			if (other.Nombre_Especialidad_Turnos != null)
				return false;
		} else if (!Nombre_Especialidad_Turnos.equals(other.Nombre_Especialidad_Turnos))
			return false;
		if (Nombre_Paciente_Turnos == null) {
			if (other.Nombre_Paciente_Turnos != null)
				return false;
		} else if (!Nombre_Paciente_Turnos.equals(other.Nombre_Paciente_Turnos))
			return false;
		if (contador != other.contador)
			return false;
		return true;
	}
}
