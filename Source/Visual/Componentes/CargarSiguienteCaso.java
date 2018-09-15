package visual.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class CargarSiguienteCaso implements ActionListener{
	
	private JFrame ventana;
	private String nombre;
	private int arrestos;
	
	public CargarSiguienteCaso(JFrame unaVentana, String unNombre, int arrestos){
		this.ventana = unaVentana;
		this.nombre = unNombre;
		this.arrestos = arrestos;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PanelSiguienteCaso panel = null;
		try {
			panel = new PanelSiguienteCaso(ventana,nombre,arrestos);
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panel.obtenerPanel());
		ventana.revalidate();
	}
}
