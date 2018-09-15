package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Lugar implements ILugar{
	
	private String nombre;
	private Pista pistaFacil;
	private Pista pistaMedia;
	private Pista pistaDificil;
	
	public Lugar(String nombre, Pista pistaFacil, Pista pistaMedia, Pista pistaDificil){
		
		this.nombre = nombre;
		this.pistaFacil = pistaFacil;
		this.pistaMedia = pistaMedia;
		this.pistaDificil = pistaDificil;

	}
	
	public void registarSiEstaElLadron(Jugador jugador){
		jugador.restarTiempoPorEntrarALugar();
	}
	
	public Pista verPistaSegunRango(Novato rango) {
		
		return this.pistaFacil;
	}

	
	public Pista verPistaSegunRango(Detective rango) {
		
		return this.pistaMedia;
	}
	
	public Pista verPistaSegunRango(Investigador rango) {
		
		return this.pistaMedia;
	}
	
	public Pista verPistaSegunRango(Sargento rango) {
	
		return this.pistaDificil;
	}
	
	
	public String obtenerNombre() {
		
		return this.nombre;
	}

	public Node serializar(Document doc) {
		Element elementoLugar = doc.createElement("Lugar");
		elementoLugar.setAttribute("nombre",this.nombre);
		
		Element elementoPistas = doc.createElement("Pistas");
		elementoLugar.appendChild(elementoPistas);
		elementoPistas.appendChild(pistaFacil.serializar(doc));
		elementoPistas.appendChild(pistaMedia.serializar(doc));
		elementoPistas.appendChild(pistaDificil.serializar(doc));
		
		return elementoLugar;
	}

	public static Lugar cargarEstado(Element elementoLugar) {
		String nombre = elementoLugar.getAttribute("nombre");
		
		Element elementoPistas = (Element)elementoLugar.getElementsByTagName("Pistas").item(0);
		Pista pistaFacil = Pista.cargarEstado(elementoPistas.getChildNodes().item(0));
		Pista pistaMedia = Pista.cargarEstado(elementoPistas.getChildNodes().item(1));
		Pista pistaDificil = Pista.cargarEstado(elementoPistas.getChildNodes().item(2));
		
		return new Lugar(nombre,pistaFacil,pistaMedia,pistaDificil);
	}

	public void reemplazarPistas(Pista pistaAReemplazar) {
		this.pistaFacil = pistaAReemplazar;
		this.pistaMedia = pistaAReemplazar;
		this.pistaDificil = pistaAReemplazar;
	}
	
}
