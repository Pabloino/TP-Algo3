package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Pista {
	
	private String contenido;
	
	public Pista(String unTexto) {
		this.contenido = unTexto;
	}

	public String obtenerContenido() {
		return this.contenido;
	}

	public Node serializar(Document doc) {
		Element elementoPista = doc.createElement("Pista");
		elementoPista.setAttribute("contenido", this.contenido);
		return elementoPista;
	}

	public static Pista cargarEstado(Node elementoPista) {
		String contenido = ((Element)elementoPista).getAttribute("contenido");
		Pista nuevaPista = new Pista(contenido);
		return nuevaPista;
	}

	public void agregarContenido(String contenidoAAgregar) {
		
		this.contenido = this.contenido + contenidoAAgregar;
		
	}
	
}
