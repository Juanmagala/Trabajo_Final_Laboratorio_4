package excepciones;

public class ErrorEnDatos extends Exception {

	public ErrorEnDatos(){
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Los datos no son correspondientes a la base de datos.";
	}
	
	
}
