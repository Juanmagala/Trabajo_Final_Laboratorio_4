package excepciones;

public class ErrorEliminacion extends Exception {

		public ErrorEliminacion() {
				
		}

		@Override
		public String getMessage() {
			// TODO Auto-generated method stub
			return "Error en el proceso de eliminacion.";
		}
		
		
}
