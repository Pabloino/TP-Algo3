package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LugarDondeAcuchillan implements ILugar{

	private String nombre;
	private Pista avisoCuchillazo;
	
	public LugarDondeAcuchillan(String unNombre){
		this.nombre = unNombre;
		this.avisoCuchillazo = new Pista( "Has recibido un cuchillazo, el ladron no ha pasado por aqui" );
	}
	
	public void registarSiEstaElLadron(Jugador jugador){
	
		jugador.recibirCuchillazo();
	}
	
	public Pista verPistaSegunRango(Novato rango) {
		
		return this.avisoCuchillazo;
	}
		
	public Pista verPistaSegunRango(Detective rango) {
	;
		return this.avisoCuchillazo;
	}

	public Pista verPistaSegunRango(Investigador rango) {

		return this.avisoCuchillazo;
	}

	public Pista verPistaSegunRango(Sargento rango) {

		return this.avisoCuchillazo;
	}

	@Override
	public Node serializar(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String obtenerNombre() {
		
		return this.nombre;
	}
		
}
