package modeloTp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Ladron {
	
	private int cantPaisesAEscaparPorRobarObjetoComun = 4;
	private int cantPaisesAEscaparPorRobarObjetoValioso = 5;
	private int cantPaisesAEscaparPorRobarObjetoMuyValioso = 7 ;
	private String nombre;
	private String sexo;
	private String cabello;
	private String hobby;
	private String senia;
	private String vehiculo;
		
	public Ladron(String nombre, String sexo, String hobby, String cabello, String senia, String vehiculo){
		this.nombre = nombre;
		this.sexo = sexo;
		this.cabello = cabello;
		this.hobby = hobby;
		this.senia = senia;
		this.vehiculo = vehiculo;
	}

	public String obtenerNombre() {
		
		return this.nombre;
	}
	
	public String obtenerSexo() {
		
		return this.sexo;
	}

	public String obtenerHobby() {
		
		return this.hobby;
	}

	public String obtenerCabello() {
		
		return this.cabello;
	}

	public String obtenerSenia() {
		
		return this.senia;
	}

	public String obtenerVehiculo() {
		
		return this.vehiculo;
	}
	
	public int decidirCantidadDeCiudadesAEscapar(ObjetoValioso objeto){
		
		return this.cantPaisesAEscaparPorRobarObjetoValioso;
	}
	
	public int decidirCantidadDeCiudadesAEscapar(ObjetoMuyValioso objeto){
		
		return this.cantPaisesAEscaparPorRobarObjetoMuyValioso;
	}
	
	public int decidirCantidadDeCiudadesAEscapar(ObjetoComun objeto){
		
		return this.cantPaisesAEscaparPorRobarObjetoComun;
	}
	
	public Node serializar(Document doc) {
		Element elementoLadron = doc.createElement("Ladron");
		elementoLadron.setAttribute("nombre", this.nombre);
		elementoLadron.setAttribute("sexo", this.sexo);
		elementoLadron.setAttribute("hobby", this.hobby);
		elementoLadron.setAttribute("cabello", this.cabello);
		elementoLadron.setAttribute("senia", this.senia);
		elementoLadron.setAttribute("vehiculo", this.vehiculo);
		
		return elementoLadron;
	}

	public static Ladron cargarEstado(Element elementoLadron) {
		String nombre = elementoLadron.getAttribute("nombre");
		String sexo = elementoLadron.getAttribute("sexo");
		String hobby = elementoLadron.getAttribute("hobby");
		String cabello = elementoLadron.getAttribute("cabello");
		String senia = elementoLadron.getAttribute("senia");
		String vehiculo = elementoLadron.getAttribute("vehiculo");
		
		Ladron unLadron = new Ladron(nombre,sexo,hobby,cabello,senia,vehiculo);
		
		return unLadron;
	}

}
