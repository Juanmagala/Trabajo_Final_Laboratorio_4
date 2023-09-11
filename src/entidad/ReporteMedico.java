package entidad;

public class ReporteMedico {
	private String Dni_Especialista_Turnos;
    private String Nombre_Especialistas;
    private String Apellido_Especialistas;
    private String Cod_Especialidad_Turnos;
    private int contados;

	public String getDni_Especialista_Turnos() {
		return Dni_Especialista_Turnos;
	}

	public void setDni_Especialista_Turnos(String dni_Especialista_Turnos) {
		Dni_Especialista_Turnos = dni_Especialista_Turnos;
	}

	public String getNombre_Especialistas() {
		return Nombre_Especialistas;
	}

	public void setNombre_Especialistas(String nombre_Especialistas) {
		Nombre_Especialistas = nombre_Especialistas;
	}

	public String getApellido_Especialistas() {
		return Apellido_Especialistas;
	}

	public void setApellido_Especialistas(String apellido_Especialistas) {
		Apellido_Especialistas = apellido_Especialistas;
	}

	public String getCod_Especialidad_Turnos() {
		return Cod_Especialidad_Turnos;
	}

	public void setCod_Especialidad_Turnos(String cod_Especialidad_Turnos) {
		Cod_Especialidad_Turnos = cod_Especialidad_Turnos;
	}

	public int getContados() {
		return contados;
	}

	public void setContados(int contados) {
		this.contados = contados;
	}
	
	public ReporteMedico() {
		super();
		Dni_Especialista_Turnos = "";
		Nombre_Especialistas = "";
		Apellido_Especialistas = "";
		Cod_Especialidad_Turnos = "";
		this.contados = 0;
	}
	
	public ReporteMedico(String dni_Especialista_Turnos, String nombre_Especialistas, String apellido_Especialistas,
			String cod_Especialidad_Turnos, int contados) {
		super();
		Dni_Especialista_Turnos = dni_Especialista_Turnos;
		Nombre_Especialistas = nombre_Especialistas;
		Apellido_Especialistas = apellido_Especialistas;
		Cod_Especialidad_Turnos = cod_Especialidad_Turnos;
		this.contados = contados;
	}
	
	@Override
	public String toString() {
		return "ReporteMedico [Dni_Especialista_Turnos=" + Dni_Especialista_Turnos + ", Nombre_Especialistas="
				+ Nombre_Especialistas + ", Apellido_Especialistas=" + Apellido_Especialistas
				+ ", Cod_Especialidad_Turnos=" + Cod_Especialidad_Turnos + ", contados=" + contados + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido_Especialistas == null) ? 0 : Apellido_Especialistas.hashCode());
		result = prime * result + ((Cod_Especialidad_Turnos == null) ? 0 : Cod_Especialidad_Turnos.hashCode());
		result = prime * result + ((Dni_Especialista_Turnos == null) ? 0 : Dni_Especialista_Turnos.hashCode());
		result = prime * result + ((Nombre_Especialistas == null) ? 0 : Nombre_Especialistas.hashCode());
		result = prime * result + contados;
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
		ReporteMedico other = (ReporteMedico) obj;
		if (Apellido_Especialistas == null) {
			if (other.Apellido_Especialistas != null)
				return false;
		} else if (!Apellido_Especialistas.equals(other.Apellido_Especialistas))
			return false;
		if (Cod_Especialidad_Turnos == null) {
			if (other.Cod_Especialidad_Turnos != null)
				return false;
		} else if (!Cod_Especialidad_Turnos.equals(other.Cod_Especialidad_Turnos))
			return false;
		if (Dni_Especialista_Turnos == null) {
			if (other.Dni_Especialista_Turnos != null)
				return false;
		} else if (!Dni_Especialista_Turnos.equals(other.Dni_Especialista_Turnos))
			return false;
		if (Nombre_Especialistas == null) {
			if (other.Nombre_Especialistas != null)
				return false;
		} else if (!Nombre_Especialistas.equals(other.Nombre_Especialistas))
			return false;
		if (contados != other.contados)
			return false;
		return true;
	}
   
}
