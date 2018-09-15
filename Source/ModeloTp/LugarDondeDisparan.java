package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LugarDondeDisparan implements ILugar{
	
	private String nombre;
	private Pista avisoDisparo;
	
	public LugarDondeDisparan(String unNombre){
		this.nombre = unNombre;
		this.avisoDisparo = new Pista( "Has recibido un disparo, en este lugar no esta el ladron" );

	}

	public void registarSiEstaElLadron(Jugador jugador){
		
		jugador.recibirBalazo();
	}
	
	public Pista verPistaSegunRango(Novato rango) {
		
		return this.avisoDisparo;
	}
		
	public Pista verPistaSegunRango(Detective rango) {
	;
		return this.avisoDisparo;
	}

	public Pista verPistaSegunRango(Investigador rango) {

		return this.avisoDisparo;
	}

	public Pista verPistaSegunRango(Sargento rango) {

		return this.avisoDisparo;
	}

	
	@Override
	public Node serializar(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String obtenerNombre(){
		
		return this.nombre;
	}
	
}
