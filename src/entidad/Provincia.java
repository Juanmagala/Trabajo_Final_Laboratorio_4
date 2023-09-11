package entidad;

public class Provincia {

	private String codProvincia;
	private String NombreProvincia;
	private int Estado_Provincias;
	
	public String getCodProvincia() {
		return codProvincia;
	}
	
	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}
	
	public String getNombreProvincia() {
		return NombreProvincia;
	}
	
	public void setNombreProvincia(String nombreProvincia) {
		NombreProvincia = nombreProvincia;
	}
		
	public int getEstado_Provincias() {
		return Estado_Provincias;
	}

	public void setEstado_Provincias(int estado_Provincias) {
		Estado_Provincias = estado_Provincias;
	}

	public Provincia() {
		codProvincia = "";
		NombreProvincia = "";
	}

	public Provincia(String codProvincia, String nombreProvincia, int estado_Provincias) {
		super();
		this.codProvincia = codProvincia;
		NombreProvincia = nombreProvincia;
		Estado_Provincias = estado_Provincias;
	}

	@Override
	public String toString() {
		return "Provincia [codProvincia=" + codProvincia + ", NombreProvincia=" + NombreProvincia
				+ ", Estado_Provincias=" + Estado_Provincias + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Estado_Provincias;
		result = prime * result + ((NombreProvincia == null) ? 0 : NombreProvincia.hashCode());
		result = prime * result + ((codProvincia == null) ? 0 : codProvincia.hashCode());
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
		Provincia other = (Provincia) obj;
		if (Estado_Provincias != other.Estado_Provincias)
			return false;
		if (NombreProvincia == null) {
			if (other.NombreProvincia != null)
				return false;
		} else if (!NombreProvincia.equals(other.NombreProvincia))
			return false;
		if (codProvincia == null) {
			if (other.codProvincia != null)
				return false;
		} else if (!codProvincia.equals(other.codProvincia))
			return false;
		return true;
	}
	
}
