package modeloTp;

import org.w3c.dom.Element;

public class ObjetoValioso extends ObjetoRobado{

	public ObjetoValioso(String nombre, String tipo) {
		super(nombre, tipo);
	}

	public static ObjetoValioso cargarEstado(Element elementoObjetoRobado){
		String nombre = elementoObjetoRobado.getAttribute("nombre");
		String tipoDeObjeto = elementoObjetoRobado.getAttribute("tipoDeObjeto");
		
		return new ObjetoValioso(nombre, tipoDeObjeto);
	}
}
