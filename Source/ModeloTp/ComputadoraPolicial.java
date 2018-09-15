package modeloTp;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ComputadoraPolicial {

	private ArrayList<Ladron> sospechosos;
	
	public ComputadoraPolicial(ArrayList<Ladron> sospechosos){
	
		this.sospechosos = sospechosos;
	}

	public ArrayList<Ladron> buscarPosiblesLadrones(String sexo, String hobby, String cabello, String senia, String vehiculo) {
		
		ArrayList<Ladron> posiblesLadrones = new ArrayList<Ladron>();
				
		for(Ladron sospechoso: this.sospechosos){
	          
			if ( (sexo == null) || ( sexo.equals(sospechoso.obtenerSexo())  ) || (sexo.equals("vacio") )){
				if( (hobby == null) || ( hobby.equals(sospechoso.obtenerHobby() )) || (hobby.equals("vacio") ) ){
					if( (cabello == null) || ( cabello.equals(sospechoso.obtenerCabello() )) || (cabello.equals("vacio") ) ){
						if( (senia == null) || ( senia.equals(sospechoso.obtenerSenia() ) )|| (senia.equals("vacio") ) ){
							if( (vehiculo == null) || ( vehiculo.equals(sospechoso.obtenerVehiculo() ) )|| (vehiculo.equals("vacio") ) ){
								
								posiblesLadrones.add(sospechoso);
							}
						}
					}
				}	
			}				
		}
		return posiblesLadrones;
		
	}

	public Node serializar(Document doc) {
		Element elementoComputadora = doc.createElement("ComputadoraPolicial");
		Element elementoLadrones = doc.createElement("Ladrones");
		
		elementoComputadora.appendChild(elementoLadrones);
		for (int i=0; i < sospechosos.size(); i++) {
			elementoLadrones.appendChild(sospechosos.get(i).serializar(doc));
		}
		
		return elementoComputadora;
	}

	public static ComputadoraPolicial cargarEstado(Element elementoComputadora) {
		Element elementoLadrones = (Element) elementoComputadora.getElementsByTagName("Ladrones").item(0);
		ArrayList<Ladron> listaSospechosos = new ArrayList<Ladron>();
		for (int i=0; i < elementoLadrones.getChildNodes().getLength(); i++){
			Ladron unLadron = Ladron.cargarEstado((Element) elementoLadrones.getChildNodes().item(i));	
			listaSospechosos.add(unLadron);
		}
		
		ComputadoraPolicial unaComputadora = new ComputadoraPolicial(listaSospechosos);
		
		return unaComputadora;
	}

}
