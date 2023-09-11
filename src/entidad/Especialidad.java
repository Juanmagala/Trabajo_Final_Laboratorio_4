package entidad;

public class Especialidad {
	 
	private String codEspecialidad;
	private String DescripcionEspecialidad;
	private int EstadoEspecialidad;
 
 public Especialidad() {
	 this.codEspecialidad="";
	 this.DescripcionEspecialidad="";
	 this.EstadoEspecialidad=0;
	 	 
 }
 
 public Especialidad(String cod, String Descrip, int Estado) {
	 this.codEspecialidad=cod;
	 this.DescripcionEspecialidad=Descrip;
	 this.EstadoEspecialidad=Estado;
	 
 }

public String getCodEspecialidad() {
	return codEspecialidad;
}

public void setCodEspecialidad(String codEspecialidad) {
	this.codEspecialidad = codEspecialidad;
}

public String getDescripcionEspecialidad() {
	return DescripcionEspecialidad;
}

public void setDescripcionEspecialidad(String descripcionEspecialidad) {
	DescripcionEspecialidad = descripcionEspecialidad;
}

public int getEstadoEspecialidad() {
	return EstadoEspecialidad;
}

public void setEstadoEspecialidad(int estadoEspecialidad) {
	EstadoEspecialidad = estadoEspecialidad;
}

@Override
public String toString() {
	return "Especialidad [codEspecialidad=" + codEspecialidad + ", DescripcionEspecialidad=" + DescripcionEspecialidad
			+ ", EstadoEspecialidad=" + EstadoEspecialidad + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((DescripcionEspecialidad == null) ? 0 : DescripcionEspecialidad.hashCode());
	result = prime * result + EstadoEspecialidad;
	result = prime * result + ((codEspecialidad == null) ? 0 : codEspecialidad.hashCode());
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
	Especialidad other = (Especialidad) obj;
	if (DescripcionEspecialidad == null) {
		if (other.DescripcionEspecialidad != null)
			return false;
	} else if (!DescripcionEspecialidad.equals(other.DescripcionEspecialidad))
		return false;
	if (EstadoEspecialidad != other.EstadoEspecialidad)
		return false;
	if (codEspecialidad == null) {
		if (other.codEspecialidad != null)
			return false;
	} else if (!codEspecialidad.equals(other.codEspecialidad))
		return false;
	return true;
}
 
 
 
 
}
