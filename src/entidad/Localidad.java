package entidad;

public class Localidad extends Provincia{
	
	private String codLocalidad;
	private String nombreLocalidad;
	private int Estado_Localidades;
	
	public String getCodLocalidad() {
		return codLocalidad;
	}
	public void setCodLocalidad(String codLocalidad) {
		this.codLocalidad = codLocalidad;
	}
	public String getNombreLocalidad() {
		return nombreLocalidad;
	}
	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}
	public int getEstado_Localidades() {
		return Estado_Localidades;
	}
	public void setEstado_Localidades(int estado_Localidades) {
		Estado_Localidades = estado_Localidades;
	}
	
	public Localidad(String codLocalidad, String nombreLocalidad) {
		super();
		this.codLocalidad = codLocalidad;
		this.nombreLocalidad = nombreLocalidad;
	}

	public Localidad() {
		this.codLocalidad = "";
		this.nombreLocalidad = "";
		Estado_Localidades = 1;
	}
	
	@Override
	public String toString() {
		return "Localidad [codLocalidad=" + codLocalidad + ", nombreLocalidad=" + nombreLocalidad
				+ ", Estado_Localidades=" + Estado_Localidades + ", getCodProvincia()=" + getCodProvincia()
				+ ", getNombreProvincia()=" + getNombreProvincia() + ", getEstado_Provincias()="
				+ getEstado_Provincias() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}
	
	
}
