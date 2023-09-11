package excepciones;

public class DniNoencontrado extends Exception {

	public DniNoencontrado() {
		
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "El DNI ingresado no pertenece a la base de datos.";
	}
	
}
