package visual.componentes;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modeloTp.Jugador;

public class PanelJuegoPerdidoConEmisionIncorrecta {
	
	private JPanel juegoPerdidoPanel = new JPanel();
	
	public PanelJuegoPerdidoConEmisionIncorrecta(JFrame unaVentana,Jugador unJugador){
		juegoPerdidoPanel.setLayout(null);
		
		JLabel juegoPerdidoTitulo = new JLabel("Has perdido la partida");
		juegoPerdidoTitulo.setFont(new Font("Arial",Font.BOLD,20));
		juegoPerdidoTitulo.setBounds(20,35,660,30);
		juegoPerdidoPanel.add(juegoPerdidoTitulo);
		
		JTextArea areaTexto = new JTextArea(
				"La orden de arresto emitida fue incorrecta, el ladron ha escapado y has perdido la partida."
				+ "\n"
				+ "\n"
				+ "Seleccione Siguiente para iniciar el siguiente caso, ¿estas prepardo/a?"
				);
		
		areaTexto.setOpaque(false);
		areaTexto.setFocusable(false);
		areaTexto.setFont(new Font("Arial",Font.BOLD,14));
		areaTexto.setLineWrap(true);
		areaTexto.setWrapStyleWord(true);
		areaTexto.setBounds(15,105,660,250);
		juegoPerdidoPanel.add(areaTexto);
		
		JButton botonComenzar = new JButton("Siguiente");
		botonComenzar.setBounds(296,370,100,30);
		botonComenzar.addActionListener(new CargarSiguienteCaso(unaVentana,unJugador.obtenerNombre(),unJugador.obtenerCantidadDeArrestos()));
		juegoPerdidoPanel.add(botonComenzar);
		
		ImageIcon imagen = new ImageIcon("src/visual/recursos/AlgoThieftPantallaBienvenida_img.jpg");
		JLabel fondo = new JLabel(imagen);
		fondo.setBounds(0,0,695,450);
		juegoPerdidoPanel.add(fondo);		
	}
	
	public JPanel obtenerPanel(){
		return juegoPerdidoPanel;
	}
}
