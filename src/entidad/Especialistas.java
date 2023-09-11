package entidad;

public class Especialistas {
	private String DNI_Especialistas;
    private Especialidad especialidad = new Especialidad();
    private String Nombre_Especialistas;
    private String Apellido_Especialistas;
    private String Telefono_Especialistas;
    private String Email_Especialistas;
    private char Sexo_Especialistas;
    private String FechaNac_Especialistas;
    private String Nacionalidad_Especialistas;
    private String Direccion_Especialistas;
	private Localidad localidad = new Localidad();
	private Provincia provincia = new Provincia();
    private int Estado_Especialistas;
    
	//GETS Y SETS//
    public char getSexo_Especialistas() {
		return Sexo_Especialistas;
	}
	public void setSexo_Especialistas(char sexo_Especialistas) {
		Sexo_Especialistas = sexo_Especialistas;
	}
	public String getFechaNac_Especialistas() {
		return FechaNac_Especialistas;
	}
	public void setFechaNac_Especialistas(String fechaNac_Especialistas) {
		FechaNac_Especialistas = fechaNac_Especialistas;
	}
	public String getNacionalidad_Especialistas() {
		return Nacionalidad_Especialistas;
	}
	public void setNacionalidad_Especialistas(String nacionalidad_Especialistas) {
		Nacionalidad_Especialistas = nacionalidad_Especialistas;
	}
	public String getDireccion_Especialistas() {
		return Direccion_Especialistas;
	}
	public void setDireccion_Especialistas(String direccion_Especialistas) {
		Direccion_Especialistas = direccion_Especialistas;
	}
	public String getDNI_Especialistas() {
		return DNI_Especialistas;
	}
	public void setDNI_Especialistas(String dNI_Especialistas) {
		DNI_Especialistas = dNI_Especialistas;
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
	public String getTelefono_Especialistas() {
		return Telefono_Especialistas;
	}
	public void setTelefono_Especialistas(String telefono_Especialistas) {
		Telefono_Especialistas = telefono_Especialistas;
	}
	public String getEmail_Especialistas() {
		return Email_Especialistas;
	}
	public void setEmail_Especialistas(String email_Especialistas) {
		Email_Especialistas = email_Especialistas;
	}
	public int getEstado_Especialistas() {
		return Estado_Especialistas;
	}
	public void setEstado_Especialistas(int estado_Especialistas) {
		Estado_Especialistas = estado_Especialistas;
	}
	/*------------------------------------------------------------------*/
	public String getEspecialidadCodigo() {
		return especialidad.getCodEspecialidad();
	}

	public void setEspecialidadCodigo(String codEspecialidad) {
		this.especialidad.setCodEspecialidad(codEspecialidad);
	}

	/*------------------------------------------------------------------*/

	public String getnombreLocalidad_Especialistas() {
		return localidad.getNombreLocalidad();
	}
	public void setLocalidad_nombreLocalidad(String nombreLocalidad) {
		this.localidad.setNombreLocalidad(nombreLocalidad);
	}
	/*------------------------------------------------------------------*/
	
	public String getProvincia_Especialistas() {
		return provincia.getNombreProvincia();
	}

	public void setProvincia_nombreProvincia(String nombreProvincia) {
		this.provincia.setNombreProvincia(nombreProvincia);
	}
	/*------------------------------------------------------------------*/

		
	//CONSTRUCTORES
	public Especialistas() 
	{
		DNI_Especialistas = "";
		this.especialidad.setCodEspecialidad("-");
		Nombre_Especialistas = "";
		Apellido_Especialistas = "";
		Telefono_Especialistas = "";
		Email_Especialistas = "";
		Estado_Especialistas = 0;
		Sexo_Especialistas=' ';
	    FechaNac_Especialistas="01-01-1900";
	    Nacionalidad_Especialistas= "";
	    Direccion_Especialistas= "";
		this.localidad.setNombreLocalidad("-");
		this.provincia.setNombreProvincia("-");
	}

	
	public Especialistas(String dNI_Especialistas, String cod_Especialidad_Especialistas, String nombre_Especialistas,
			String apellido_Especialistas, String fechaNac_Especialistas, String nacionalidad_Especialistas, char sexo_Especialistas, String telefono_Especialistas,
			String direccion_Especialistas, String nombreLocalidad, String nombreProvincia, String email_Especialistas,int estado_Especialistas) 
	{
		DNI_Especialistas = dNI_Especialistas;
		this.especialidad.setCodEspecialidad(cod_Especialidad_Especialistas);
		Nombre_Especialistas = nombre_Especialistas;
		Apellido_Especialistas = apellido_Especialistas;
		Telefono_Especialistas = telefono_Especialistas;
		Sexo_Especialistas = sexo_Especialistas;
		FechaNac_Especialistas = fechaNac_Especialistas;
		Nacionalidad_Especialistas = nacionalidad_Especialistas;
		Direccion_Especialistas = direccion_Especialistas;
		this.localidad.setNombreLocalidad(nombreLocalidad);
		this.provincia.setNombreProvincia(nombreProvincia);
		Email_Especialistas = email_Especialistas;
		Estado_Especialistas = estado_Especialistas;
		
	}
	// METODOS
	@Override
	public String toString() {
		return "Especialistas [DNI_Especialistas=" + DNI_Especialistas + ", especialidad=" + especialidad
				+ ", Nombre_Especialistas=" + Nombre_Especialistas + ", Apellido_Especialistas="
				+ Apellido_Especialistas + ", Telefono_Especialistas=" + Telefono_Especialistas
				+ ", Email_Especialistas=" + Email_Especialistas + ", Sexo_Especialistas=" + Sexo_Especialistas
				+ ", FechaNac_Especialistas=" + FechaNac_Especialistas + ", Nacionalidad_Especialistas="
				+ Nacionalidad_Especialistas + ", Direccion_Especialistas=" + Direccion_Especialistas + ", localidad="
				+ localidad + ", provincia=" + provincia + ", Estado_Especialistas=" + Estado_Especialistas + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido_Especialistas == null) ? 0 : Apellido_Especialistas.hashCode());
		result = prime * result + ((DNI_Especialistas == null) ? 0 : DNI_Especialistas.hashCode());
		result = prime * result + ((Direccion_Especialistas == null) ? 0 : Direccion_Especialistas.hashCode());
		result = prime * result + ((Email_Especialistas == null) ? 0 : Email_Especialistas.hashCode());
		result = prime * result + Estado_Especialistas;
		result = prime * result + ((FechaNac_Especialistas == null) ? 0 : FechaNac_Especialistas.hashCode());
		result = prime * result + ((Nacionalidad_Especialistas == null) ? 0 : Nacionalidad_Especialistas.hashCode());
		result = prime * result + ((Nombre_Especialistas == null) ? 0 : Nombre_Especialistas.hashCode());
		result = prime * result + Sexo_Especialistas;
		result = prime * result + ((Telefono_Especialistas == null) ? 0 : Telefono_Especialistas.hashCode());
		result = prime * result + ((especialidad == null) ? 0 : especialidad.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
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
		Especialistas other = (Especialistas) obj;
		if (Apellido_Especialistas == null) {
			if (other.Apellido_Especialistas != null) {
				return false;
			}
		} else if (!Apellido_Especialistas.equals(other.Apellido_Especialistas)) {
			return false;
		}
		if (DNI_Especialistas == null) {
			if (other.DNI_Especialistas != null) {
				return false;
			}
		} else if (!DNI_Especialistas.equals(other.DNI_Especialistas)) {
			return false;
		}
		if (Direccion_Especialistas == null) {
			if (other.Direccion_Especialistas != null) {
				return false;
			}
		} else if (!Direccion_Especialistas.equals(other.Direccion_Especialistas)) {
			return false;
		}
		if (Email_Especialistas == null) {
			if (other.Email_Especialistas != null) {
				return false;
			}
		} else if (!Email_Especialistas.equals(other.Email_Especialistas)) {
			return false;
		}
		if (Estado_Especialistas != other.Estado_Especialistas) {
			return false;
		}
		if (FechaNac_Especialistas == null) {
			if (other.FechaNac_Especialistas != null) {
				return false;
			}
		} else if (!FechaNac_Especialistas.equals(other.FechaNac_Especialistas)) {
			return false;
		}
		if (Nacionalidad_Especialistas == null) {
			if (other.Nacionalidad_Especialistas != null) {
				return false;
			}
		} else if (!Nacionalidad_Especialistas.equals(other.Nacionalidad_Especialistas)) {
			return false;
		}
		if (Nombre_Especialistas == null) {
			if (other.Nombre_Especialistas != null) {
				return false;
			}
		} else if (!Nombre_Especialistas.equals(other.Nombre_Especialistas)) {
			return false;
		}
		if (Sexo_Especialistas != other.Sexo_Especialistas) {
			return false;
		}
		if (Telefono_Especialistas == null) {
			if (other.Telefono_Especialistas != null) {
				return false;
			}
		} else if (!Telefono_Especialistas.equals(other.Telefono_Especialistas)) {
			return false;
		}
		if (especialidad == null) {
			if (other.especialidad != null) {
				return false;
			}
		} else if (!especialidad.equals(other.especialidad)) {
			return false;
		}
		if (localidad == null) {
			if (other.localidad != null) {
				return false;
			}
		} else if (!localidad.equals(other.localidad)) {
			return false;
		}
		if (provincia == null) {
			if (other.provincia != null) {
				return false;
			}
		} else if (!provincia.equals(other.provincia)) {
			return false;
		}
		return true;
	}
	

	
	
	
	
}