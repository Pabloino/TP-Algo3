package visual.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class CapturadorDeNombre implements ActionListener {
	
	private JTextField campo;
	private JFrame ventana;
	
	public CapturadorDeNombre(JFrame unaVentana, JTextField unCampo){
		this.ventana = unaVentana;
		this.campo = unCampo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		PanelBienvenidaJugador panelBienvenida = null;
		try {
			panelBienvenida = new PanelBienvenidaJugador(ventana,campo);
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
		ventana.getContentPane().add(panelBienvenida.obtenerPanel());
		ventana.revalidate();
		
	}
}
