package excepciones;

public class CamposIncompletos extends Exception {

	
	
	public CamposIncompletos() {
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No se han completado todos los campos requeridos.";
	}
	
	
	
}
