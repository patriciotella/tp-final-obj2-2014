package sistema;

public class PresentacionNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PresentacionNotFoundException(){
		super();
	}
	
	public PresentacionNotFoundException(String unMensaje){
		super(unMensaje);
	}
	
}
