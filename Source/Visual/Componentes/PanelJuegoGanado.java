package visual.componentes;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modeloTp.Jugador;

public class PanelJuegoGanado {
	
	private JPanel juegoGanadoPanel = new JPanel();
	
	public PanelJuegoGanado(JFrame unaVentana,Jugador unJugador){
		juegoGanadoPanel.setLayout(null);
		
		JLabel juegoGanadoTitulo = new JLabel("Has ganado la partida");
		juegoGanadoTitulo.setFont(new Font("Arial",Font.BOLD,20));
		juegoGanadoTitulo.setBounds(20,35,660,30);
		juegoGanadoPanel.add(juegoGanadoTitulo);
		
		int arrestos = unJugador.obtenerCantidadDeArrestos()+1;
		
		//El jugador asciende al rango que tenia
		for(int i=0; i < arrestos; i++){
			unJugador.agregarArresto();
		}
		
		JTextArea areaTexto = new JTextArea(
				"Felicidades, "+unJugador.obtenerNombre()+"! Has atrapado al ladron y has ganado la partida."
				+ "\n"
				+ "Hasta ahora tienes "+arrestos+" arrestos. Sigue acumulando arrestos para ir ascendiendo de rango."
				+ "\n"
				+ "\n"
				+ "Tu graduacion actual es: " + unJugador.obtenerRango().obtenerNombre() + "."
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
		juegoGanadoPanel.add(areaTexto);
		
		JButton botonComenzar = new JButton("Siguiente");
		botonComenzar.setBounds(296,370,100,30);
		botonComenzar.addActionListener(new CargarSiguienteCaso(unaVentana,unJugador.obtenerNombre(),arrestos));
		juegoGanadoPanel.add(botonComenzar);
		
		ImageIcon imagen = new ImageIcon("src/visual/recursos/AlgoThieftPantallaBienvenida_img.jpg");
		JLabel fondo = new JLabel(imagen);
		fondo.setBounds(0,0,695,450);
		juegoGanadoPanel.add(fondo);
	}
	
	public JPanel obtenerPanel(){
		return juegoGanadoPanel;
	}
}
