package modeloTp;

import org.w3c.dom.Element;

public class ObjetoMuyValioso extends ObjetoRobado{

	public ObjetoMuyValioso(String nombre, String tipo) {
		super(nombre, tipo);
	}

	public static ObjetoMuyValioso cargarEstado(Element elementoObjetoRobado){
		String nombre = elementoObjetoRobado.getAttribute("nombre");
		String tipoDeObjeto = elementoObjetoRobado.getAttribute("tipoDeObjeto");
		
		return new ObjetoMuyValioso(nombre, tipoDeObjeto);
	}
}
