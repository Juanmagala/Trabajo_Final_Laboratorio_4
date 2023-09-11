package entidad;

public class Pacientes {
	private String DNI_Pacientes;
    private String Nombre_Pacientes;
    private String Apellido_Pacientes;
    private char Sexo_Pacientes;
    private String Fecha_Nacimiento_Pacientes;
    private String Telefono_Pacientes;
    private String Email_Pacientes;
    private String Nacionalidad_Pacientes;
    private String Direccion_Pacientes;
	private Localidad localidad = new Localidad();
	private Provincia provincia = new Provincia();
    private int Estado_Pacientes;
    
    //GETS Y SETS//
    public String getDNI_Pacientes() {
		return DNI_Pacientes;
	}

	public void setDNI_Pacientes(String dNI_Pacientes) {
		DNI_Pacientes = dNI_Pacientes;
	}

	public String getNombre_Pacientes() {
		return Nombre_Pacientes;
	}

	public void setNombre_Pacientes(String nombre_Pacientes) {
		Nombre_Pacientes = nombre_Pacientes;
	}

	public String getApellido_Pacientes() {
		return Apellido_Pacientes;
	}

	public void setApellido_Pacientes(String apellido_Pacientes) {
		Apellido_Pacientes = apellido_Pacientes;
	}

	public char getSexo_Pacientes() {
		return Sexo_Pacientes;
	}

	public void setSexo_Pacientes(char sexo_Pacientes) {
		Sexo_Pacientes = sexo_Pacientes;
	}

	public String getFecha_Nacimiento_Pacientes() {
		return Fecha_Nacimiento_Pacientes;
	}

	public void setFecha_Nacimiento_Pacientes(String fecha_Nacimiento_Pacientes) {
		Fecha_Nacimiento_Pacientes = fecha_Nacimiento_Pacientes;
	}

	public String getTelefono_Pacientes() {
		return Telefono_Pacientes;
	}

	public void setTelefono_Pacientes(String telefono_Pacientes) {
		Telefono_Pacientes = telefono_Pacientes;
	}

	public String getEmail_Pacientes() {
		return Email_Pacientes;
	}

	public void setEmail_Pacientes(String email_Pacientes) {
		Email_Pacientes = email_Pacientes;
	}

	public String getNacionalidad_Pacientes() {
		return Nacionalidad_Pacientes;
	}

	public void setNacionalidad_Pacientes(String nacionalidad_Pacientes) {
		Nacionalidad_Pacientes = nacionalidad_Pacientes;
	}

	public String getDireccion_Pacientes() {
		return Direccion_Pacientes;
	}

	public void setDireccion_Pacientes(String direccion_Pacientes) {
		Direccion_Pacientes = direccion_Pacientes;
	}

	public int getEstado_Pacientes() {
		return Estado_Pacientes;
	}

	public void setEstado_Pacientes(int estado_Pacientes) {
		Estado_Pacientes = estado_Pacientes;
	}
	
	
	//-- ------------------------------
	public String getLocalidad() {
		return localidad.getNombreLocalidad();
	}

	public void setLocalidad_nombreLocalidad(String nombreLocalidad) {
		this.localidad.setNombreLocalidad(nombreLocalidad);
	}

	
	//-----------------------------------------
	public String getProvincia() {
		return provincia.getNombreProvincia();
	}
	
	public void setProvincia_nombreProvincia(String nombreProvincia) {

		this.provincia.setNombreProvincia(nombreProvincia);
	}

	
	// ------------------------------------------
	
	//CONSTRUCTORES//
	
	public Pacientes() 
	{
		this.DNI_Pacientes = "-";
		this.Nombre_Pacientes = "-";
		this.Apellido_Pacientes = "-";
		this.Sexo_Pacientes = '-';
		this.Fecha_Nacimiento_Pacientes = "-";
		this.Telefono_Pacientes = "-";
		this.Email_Pacientes = "-";
		this.Nacionalidad_Pacientes = "-";
		this.Direccion_Pacientes = "-";
		this.localidad.setNombreLocalidad("-");
		this.provincia.setNombreProvincia("-");
		Estado_Pacientes = 0;
	}

	

	public Pacientes(String dNI_Pacientes, String nombre_Pacientes,
			String apellido_Pacientes, char sexo_Pacientes, String fecha_Nacimiento_Paciente,
			String telefono_Pacientes, String email_Pacientes, String nacionalidad_Pacientes, String direccion_Pacientes,
			String nomLocalidad, String nomProvincia, int estado_Pacientes) 
	{
		DNI_Pacientes = dNI_Pacientes;
		Nombre_Pacientes = nombre_Pacientes;
		Apellido_Pacientes = apellido_Pacientes;
		Sexo_Pacientes = sexo_Pacientes;
		Fecha_Nacimiento_Pacientes = fecha_Nacimiento_Paciente;
		Telefono_Pacientes = telefono_Pacientes;
		Email_Pacientes = email_Pacientes;
		Nacionalidad_Pacientes = nacionalidad_Pacientes;
		Direccion_Pacientes = direccion_Pacientes;
		this.localidad.setNombreLocalidad(nomLocalidad);
		this.provincia.setNombreProvincia(nomProvincia);
		Estado_Pacientes = estado_Pacientes;
	}


    //METODOS//

	@Override
	public String toString() {
		return "Pacientes [DNI_Pacientes=" + DNI_Pacientes + ", Nombre_Pacientes=" + Nombre_Pacientes
				+ ", Apellido_Pacientes=" + Apellido_Pacientes + ", Sexo_Pacientes=" + Sexo_Pacientes
				+ ", Fecha_Nacimiento_Pacientes=" + Fecha_Nacimiento_Pacientes + ", Telefono_Pacientes="
				+ Telefono_Pacientes + ", Email_Pacientes=" + Email_Pacientes + ", Nacionalidad_Pacientes="
				+ Nacionalidad_Pacientes + ", Direccion_Pacientes=" + Direccion_Pacientes + ", localidad=" + localidad
				+ ", provincia=" + provincia + ", Estado_Pacientes=" + Estado_Pacientes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido_Pacientes == null) ? 0 : Apellido_Pacientes.hashCode());
		result = prime * result + ((DNI_Pacientes == null) ? 0 : DNI_Pacientes.hashCode());
		result = prime * result + ((Direccion_Pacientes == null) ? 0 : Direccion_Pacientes.hashCode());
		result = prime * result + ((Email_Pacientes == null) ? 0 : Email_Pacientes.hashCode());
		result = prime * result + Estado_Pacientes;
		result = prime * result + ((Fecha_Nacimiento_Pacientes == null) ? 0 : Fecha_Nacimiento_Pacientes.hashCode());
		result = prime * result + ((Nacionalidad_Pacientes == null) ? 0 : Nacionalidad_Pacientes.hashCode());
		result = prime * result + ((Nombre_Pacientes == null) ? 0 : Nombre_Pacientes.hashCode());
		result = prime * result + Sexo_Pacientes;
		result = prime * result + ((Telefono_Pacientes == null) ? 0 : Telefono_Pacientes.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
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
		Pacientes other = (Pacientes) obj;
		if (Apellido_Pacientes == null) {
			if (other.Apellido_Pacientes != null)
				return false;
		} else if (!Apellido_Pacientes.equals(other.Apellido_Pacientes))
			return false;
		if (DNI_Pacientes == null) {
			if (other.DNI_Pacientes != null)
				return false;
		} else if (!DNI_Pacientes.equals(other.DNI_Pacientes))
			return false;
		if (Direccion_Pacientes == null) {
			if (other.Direccion_Pacientes != null)
				return false;
		} else if (!Direccion_Pacientes.equals(other.Direccion_Pacientes))
			return false;
		if (Email_Pacientes == null) {
			if (other.Email_Pacientes != null)
				return false;
		} else if (!Email_Pacientes.equals(other.Email_Pacientes))
			return false;
		if (Estado_Pacientes != other.Estado_Pacientes)
			return false;
		if (Fecha_Nacimiento_Pacientes == null) {
			if (other.Fecha_Nacimiento_Pacientes != null)
				return false;
		} else if (!Fecha_Nacimiento_Pacientes.equals(other.Fecha_Nacimiento_Pacientes))
			return false;
		if (Nacionalidad_Pacientes == null) {
			if (other.Nacionalidad_Pacientes != null)
				return false;
		} else if (!Nacionalidad_Pacientes.equals(other.Nacionalidad_Pacientes))
			return false;
		if (Nombre_Pacientes == null) {
			if (other.Nombre_Pacientes != null)
				return false;
		} else if (!Nombre_Pacientes.equals(other.Nombre_Pacientes))
			return false;
		if (Sexo_Pacientes != other.Sexo_Pacientes)
			return false;
		if (Telefono_Pacientes == null) {
			if (other.Telefono_Pacientes != null)
				return false;
		} else if (!Telefono_Pacientes.equals(other.Telefono_Pacientes))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}
	
	
}
