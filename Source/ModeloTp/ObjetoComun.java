package modeloTp;

import org.w3c.dom.Element;

public class ObjetoComun extends ObjetoRobado {

	public ObjetoComun(String nombre, String tipo) {
		super(nombre, tipo);
	}

	public static ObjetoComun cargarEstado(Element elementoObjetoRobado){
		String nombre = elementoObjetoRobado.getAttribute("nombre");
		String tipoDeObjeto = elementoObjetoRobado.getAttribute("tipoDeObjeto");
		
		return new ObjetoComun(nombre, tipoDeObjeto);
	}
}
