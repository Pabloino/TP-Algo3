package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public interface ILugar {
	
	public void registarSiEstaElLadron(Jugador jugador);
	
	public Pista verPistaSegunRango(Novato rango);
	
	public Pista verPistaSegunRango(Detective rango);
	
	public Pista verPistaSegunRango(Investigador rango);
	
	public Pista verPistaSegunRango(Sargento rango);
	
	public Node serializar(Document doc);
	
	public String obtenerNombre();
}
