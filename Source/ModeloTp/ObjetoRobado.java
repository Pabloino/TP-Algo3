package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ObjetoRobado {

	private String nombre;
	private String tipoDeObjeto;
	
	public ObjetoRobado(String nombre, String tipo){
		this.nombre = nombre;
		this.tipoDeObjeto = tipo;
		
	}
	
	public String obtenerTipoDeObjeto(){
		return this.tipoDeObjeto;
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}
	
	public Node serializar(Document doc) {
		Element elementoObjetoRobado = doc.createElement("ObjetoRobado");
		elementoObjetoRobado.setAttribute("nombre",this.nombre);
		elementoObjetoRobado.setAttribute("tipoDeObjeto",this.tipoDeObjeto);
				
		return elementoObjetoRobado;
	}

}
