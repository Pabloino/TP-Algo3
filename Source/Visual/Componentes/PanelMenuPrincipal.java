package visual.componentes;

import java.awt.Font;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class PanelMenuPrincipal {
	
	private JPanel menuPrincipal = new JPanel();
	private JFrame ventana;
	
	public PanelMenuPrincipal(JFrame unaVentana) throws ParserConfigurationException, TransformerException, SAXException, IOException {
		this.ventana = unaVentana;
		menuPrincipal.setLayout(null);
		JLabel texto = new JLabel("Policia al teclado, por favor, identificate:");
		texto.setFont(new Font("Arial",Font.BOLD,16));
		texto.setBounds(30,150,310,30);
		menuPrincipal.add(texto);
		
		JTextField campoDeTexto = new JTextField();
		campoDeTexto.setBounds(53,200,250,30);
		menuPrincipal.add(campoDeTexto);
		
		JButton botonSiguiente = new JButton("Siguiente");
		botonSiguiente.addActionListener(new CapturadorDeNombre(ventana,campoDeTexto));
		botonSiguiente.setBounds(130,255,100,30);
		menuPrincipal.add(botonSiguiente);
		
		ImageIcon imagen = new ImageIcon("src/visual/recursos/AlgoThieftMenuPrincipal_img.jpg");
		JLabel fondo = new JLabel(imagen);
		menuPrincipal.add(fondo);
		
		fondo.setBounds(0,0,695,450);
	}
	
	public JPanel obtenerPanel(){
		return menuPrincipal;
	}
}
