package entidad;

public class Usuarios {
	private String Dni;
	private String Usuario;
    private String Email_Usuarios;
    private String Contrasena_Usuarios;
    private char Tipo_Usuarios;
    private int Estado_Usuarios;
    
    //GETS Y SETS//
	public String getUsuario() {
		return Usuario;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getEmail_Usuarios() {
		return Email_Usuarios;
	}
	public void setEmail_Usuarios(String email_Usuarios) {
		Email_Usuarios = email_Usuarios;
	}
	public String getContrasena_Usuarios() {
		return Contrasena_Usuarios;
	}
	public void setContrasena_Usuarios(String contrasena_Usuarios) {
		Contrasena_Usuarios = contrasena_Usuarios;
	}
	public char getTipo_Usuarios() {
		return Tipo_Usuarios;
	}
	public void setTipo_Usuarios(char tipo_Usuarios) {
		Tipo_Usuarios = tipo_Usuarios;
	}
	public int getEstado_Usuarios() {
		return Estado_Usuarios;
	}
	public void setEstado_Usuarios(int estado_Usuarios) {
		Estado_Usuarios = estado_Usuarios;
	}
	
	
	//CONSTRUCTORES//
	public Usuarios() 
	{
		Dni="";
		Usuario = "";
		Email_Usuarios = "";
		Contrasena_Usuarios = "";
		Tipo_Usuarios = 0;
		Estado_Usuarios = 0;
	}
    
	
	public Usuarios(String dni, String usuario, String email_Usuarios, String contrasena_Usuarios, char tipo_Usuarios,
			int estado_Usuarios) 
	{
		Dni=dni;
		Usuario = usuario;
		Email_Usuarios = email_Usuarios;
		Contrasena_Usuarios = contrasena_Usuarios;
		Tipo_Usuarios = tipo_Usuarios;
		Estado_Usuarios = estado_Usuarios;
	}
	
	
	//METODOS//
	@Override
	public String toString() {
		return "Usuarios [Dni=" + Dni + ", Usuario=" + Usuario + ", Email_Usuarios=" + Email_Usuarios
				+ ", Contrasena_Usuarios=" + Contrasena_Usuarios + ", Tipo_Usuarios=" + Tipo_Usuarios
				+ ", Estado_Usuarios=" + Estado_Usuarios + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Contrasena_Usuarios == null) ? 0 : Contrasena_Usuarios.hashCode());
		result = prime * result + ((Dni == null) ? 0 : Dni.hashCode());
		result = prime * result + ((Email_Usuarios == null) ? 0 : Email_Usuarios.hashCode());
		result = prime * result + Estado_Usuarios;
		result = prime * result + Tipo_Usuarios;
		result = prime * result + ((Usuario == null) ? 0 : Usuario.hashCode());
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
		Usuarios other = (Usuarios) obj;
		if (Contrasena_Usuarios == null) {
			if (other.Contrasena_Usuarios != null)
				return false;
		} else if (!Contrasena_Usuarios.equals(other.Contrasena_Usuarios))
			return false;
		if (Dni == null) {
			if (other.Dni != null)
				return false;
		} else if (!Dni.equals(other.Dni))
			return false;
		if (Email_Usuarios == null) {
			if (other.Email_Usuarios != null)
				return false;
		} else if (!Email_Usuarios.equals(other.Email_Usuarios))
			return false;
		if (Estado_Usuarios != other.Estado_Usuarios)
			return false;
		if (Tipo_Usuarios != other.Tipo_Usuarios)
			return false;
		if (Usuario == null) {
			if (other.Usuario != null)
				return false;
		} else if (!Usuario.equals(other.Usuario))
			return false;
		return true;
	}
	
	
}
