package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LugarConLadron implements ILugar{

	private Ladron ladronEscondido;
	private String nombre;
	private Pista juegoGanado;
	private Pista ordenDeArrestoNoEmitida;
	private Pista ordenDeArrestoIncorrecta;
	private Pista pistaSobreSituacion;
	
	public LugarConLadron(String unNombre, Ladron ladron, Pista juegoGanado, Pista ordenDeArrestoIncorrecta, Pista ordenDeArrestoNoEmitida){
		this.ladronEscondido = ladron;
		this.nombre = unNombre;
		this.juegoGanado = juegoGanado;
		this.ordenDeArrestoNoEmitida = ordenDeArrestoNoEmitida;
		this.ordenDeArrestoIncorrecta = ordenDeArrestoIncorrecta;
		this.pistaSobreSituacion = null;
	}
	
	public void registarSiEstaElLadron(Jugador jugador){
		if ( jugador.seEmitioOrdenDeArresto() ){
			String nombreDeLadronBuscado = jugador.obtenerNombreDeLadronBuscado();
			if ( nombreDeLadronBuscado.equals(ladronEscondido.obtenerNombre() ) ){
				this.pistaSobreSituacion = this.juegoGanado;
				
			}else{
				this.pistaSobreSituacion = this.ordenDeArrestoIncorrecta;
			}
		} else {
			this.pistaSobreSituacion = this.ordenDeArrestoNoEmitida;
		}
	}
	
	public Pista verPistaSegunRango(Novato rango) {
		
		return this.pistaSobreSituacion;
	}
		
	public Pista verPistaSegunRango(Detective rango) {
		
		return this.pistaSobreSituacion;
	}

	public Pista verPistaSegunRango(Investigador rango) {
		
		return this.pistaSobreSituacion;
	}
	
	public Pista verPistaSegunRango(Sargento rango) {
		
		return this.pistaSobreSituacion;
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
