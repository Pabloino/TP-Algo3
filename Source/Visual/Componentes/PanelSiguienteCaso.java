package visual.componentes;

import java.awt.Font;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import modeloTp.ComputadoraPolicial;
import modeloTp.Pista;
import JuegoPorConsola.GeneradorDePartidas;
import modeloTp.Jugador;

import org.xml.sax.SAXException;

public class PanelSiguienteCaso{

private JPanel siguienteCasoJugador = new JPanel();
	
	public PanelSiguienteCaso(JFrame unaVentana, String nombre, int arrestos) throws ParserConfigurationException, TransformerException, SAXException, IOException{
		GeneradorDePartidas juego = new GeneradorDePartidas(
				new Pista("Has atrapado al ladron, has ganado la partida"),
				new Pista("La orden de arresto emitida fue incorrecta, el ladron ha escapado y has perdido la partida"),
				new Pista("No se ha emitido ninguna orden de arresto, el ladron ha escapado y has perdido la partida"));
		ComputadoraPolicial computadora = new ComputadoraPolicial(juego.generarListaDeLadrones());
		Jugador jugador = new Jugador(nombre, juego.obtenerRecorridoLadron().get(0), computadora);
		
		//El jugador asciende al rango que tenia
		for(int i=0; i < arrestos; i++){
			jugador.agregarArresto();
		}
		
		Calendario calendario = new Calendario(jugador.obtenerTiempoRestante(),jugador);
		
		siguienteCasoJugador.setLayout(null);
		JLabel bienvenido = new JLabel("Bienvenido al siguiente caso, " + nombre);
		bienvenido.setFont(new Font("Arial",Font.BOLD,20));
		bienvenido.setBounds(20,35,660,30);
		siguienteCasoJugador.add(bienvenido);
		
		JTextArea areaTexto = new JTextArea(
				"Has sido identificado/a " + nombre + "."
				+ "\n"
				+ "\n"
				+ "Tu graduacion actual es: " + jugador.obtenerRango().obtenerNombre() + "."
				+ "\n"
				+ "\n"
				+ "NOTICIAS"
				+ "\n"
				+ "Tesoro nacional robado en " + juego.obtenerRecorridoLadron().get(0).obtenerNombre() + "."
				+ "\n"
				+ "El objeto robado ha sido identificado como: " + juego.obtenerObjetoRobado().obtenerNombre() + "."
				+ "\n"
				+ "Un sospechoso de sexo " + juego.obtenerLadronBuscado().obtenerSexo() + " ha sido visto en el lugar del crimen."
				+ "\n"
				+ "\n"
				+ "Tu mision:"
				+ "\n"
				+ "Perseguir al ladron desde " + juego.obtenerRecorridoLadron().get(0).obtenerNombre() + " hasta su escondite y arrestarlo."
				+ "\n"
				+ "Tienes que arrestar al ladron antes del domingo a las 17 hs."
				+ "\n"
				+ "\n"
				+ "Buena suerte, " + nombre + "."
				);
		areaTexto.setOpaque(false);
		areaTexto.setFocusable(false);
		areaTexto.setFont(new Font("Arial",Font.BOLD,14));
		areaTexto.setLineWrap(true);
		areaTexto.setWrapStyleWord(true);
		areaTexto.setBounds(15,105,660,250);
		siguienteCasoJugador.add(areaTexto);
		
		JButton botonComenzar = new JButton("Comenzar");
		botonComenzar.setBounds(296,370,100,30);
		botonComenzar.addActionListener(new CargadorPantallaLugares(unaVentana,juego,jugador,calendario,arrestos));
		siguienteCasoJugador.add(botonComenzar);
		
		ImageIcon imagen = new ImageIcon("src/visual/recursos/AlgoThieftPantallaBienvenida_img.jpg");
		JLabel fondo = new JLabel(imagen);
		fondo.setBounds(0,0,695,450);
		siguienteCasoJugador.add(fondo);
	}

	public JPanel obtenerPanel(){
		return siguienteCasoJugador;
	}
}
