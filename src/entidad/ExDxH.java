package entidad;

public class ExDxH {
	private int Id_Dias_EXDXH;
	private int Id_Horas_EXDXH;
	private Especialistas dniEspecialistas = new Especialistas();
    private Especialidad codEspecialidad = new Especialidad();
    private int Cantidad_Turnos_EXDXH;
    private int Estado_EXDXH;
	    
    
    //GETS Y SETS//
    public int getId_Dias_EXDXH() {
		return Id_Dias_EXDXH;
	}
	public void setId_Dias_EXDXH(int id_Dias_EXDXH) {
		Id_Dias_EXDXH = id_Dias_EXDXH;
	}
	public int getId_Horas_EXDXH() {
		return Id_Horas_EXDXH;
	}
	public void setId_Horas_EXDXH(int id_Horas_EXDXH) {
		Id_Horas_EXDXH = id_Horas_EXDXH;
	}
	public String getEspecialistas() {
		return dniEspecialistas.getDNI_Especialistas();
	}
	public void setEspecialistas(String dniEspecialistas) {
		this.dniEspecialistas.setDNI_Especialistas(dniEspecialistas);
	}
	public String getEspecialidad() {
		return codEspecialidad.getCodEspecialidad();
	}
	public void setEspecialidad(String codEspecialidad) {
		this.codEspecialidad.setCodEspecialidad(codEspecialidad);
	}
	public int getCantidad_Turnos_EXDXH() {
		return Cantidad_Turnos_EXDXH;
	}
	public void setCantidad_Turnos_EXDXH(int cantidad_Turnos_EXDXH) {
		Cantidad_Turnos_EXDXH = cantidad_Turnos_EXDXH;
	}
	public int getEstado_EXDXH() {
		return Estado_EXDXH;
	}
	public void setEstado_EXDXH(int estado_EXDXH) {
		Estado_EXDXH = estado_EXDXH;
	}
	
	
	//METODOS
	@Override
	public String toString() {
		return "ExDxH [Id_Dias_EXDXH=" + Id_Dias_EXDXH + ", Id_Horas_EXDXH=" + Id_Horas_EXDXH + ", dniEspecialistas="
				+ dniEspecialistas + ", codEspecialidad=" + codEspecialidad + ", Cantidad_Turnos_EXDXH="
				+ Cantidad_Turnos_EXDXH + ", Estado_EXDXH=" + Estado_EXDXH + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Cantidad_Turnos_EXDXH;
		result = prime * result + Estado_EXDXH;
		result = prime * result + Id_Dias_EXDXH;
		result = prime * result + Id_Horas_EXDXH;
		result = prime * result + ((codEspecialidad == null) ? 0 : codEspecialidad.hashCode());
		result = prime * result + ((dniEspecialistas == null) ? 0 : dniEspecialistas.hashCode());
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
		ExDxH other = (ExDxH) obj;
		if (Cantidad_Turnos_EXDXH != other.Cantidad_Turnos_EXDXH)
			return false;
		if (Estado_EXDXH != other.Estado_EXDXH)
			return false;
		if (Id_Dias_EXDXH != other.Id_Dias_EXDXH)
			return false;
		if (Id_Horas_EXDXH != other.Id_Horas_EXDXH)
			return false;
		if (codEspecialidad == null) {
			if (other.codEspecialidad != null)
				return false;
		} else if (!codEspecialidad.equals(other.codEspecialidad))
			return false;
		if (dniEspecialistas == null) {
			if (other.dniEspecialistas != null)
				return false;
		} else if (!dniEspecialistas.equals(other.dniEspecialistas))
			return false;
		return true;
	} 
	
}
