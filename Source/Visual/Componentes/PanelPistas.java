package visual.componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import JuegoPorConsola.GeneradorDePartidas;
import modeloTp.Jugador;
import modeloTp.Pista;

public class PanelPistas{
	
	private JPanel panelPistas = new JPanel();
	private Pista pistaObtenida;
	
	public PanelPistas(int numeroDeLugar, JFrame unaVentana, GeneradorDePartidas generador, Jugador unJugador, Calendario calendario, int arrestos){
		panelPistas.setLayout(null);
		
		JLabel lugares = new JLabel(unJugador.obtenerCiudadActual().obtenerLugares().get(numeroDeLugar).obtenerNombre());
		lugares.setBounds(30,95,230,40);
		lugares.setFont(new Font("Arial",Font.BOLD,16));
		panelPistas.add(lugares);
		
		pistaObtenida = unJugador.visitar(unJugador.obtenerCiudadActual().obtenerLugares().get(numeroDeLugar));
		
		JTextArea contenidoPista = new JTextArea(pistaObtenida.obtenerContenido());
		contenidoPista.setOpaque(false);
		contenidoPista.setFocusable(false);
		contenidoPista.setFont(new Font("Arial",Font.BOLD,14));
		contenidoPista.setBounds(30,140,630,200);
		contenidoPista.setLineWrap(true);
		contenidoPista.setWrapStyleWord(true);
		panelPistas.add(contenidoPista);
		
		JLabel durmiendo = new JLabel("Durmiendo (+8 hs),");
		durmiendo.setBounds(280, 33, 195, 40);
		durmiendo.setFont(new Font("Arial",Font.BOLD,21));
		durmiendo.setForeground(Color.WHITE);
		durmiendo.setVisible(false);
		panelPistas.add(durmiendo);
		
		calendario.sumarTiempo(unJugador.obtenerTiempoRestante(),durmiendo);
		
		JLabel fecha = new JLabel(calendario.obtenerDiaActual()+", "+calendario.obtenerHora()+":00 hs");
		fecha.setBounds(480,33,200,40);
		fecha.setFont(new Font("Arial",Font.BOLD,21));
		fecha.setForeground(Color.WHITE);
		panelPistas.add(fecha);
		
		JLabel nombreCiudadActual = new JLabel(unJugador.obtenerCiudadActual().obtenerNombre());
		nombreCiudadActual.setBounds(30,33,330,40);
		nombreCiudadActual.setFont(new Font("Arial",Font.BOLD,21));
		nombreCiudadActual.setForeground(Color.WHITE);
		panelPistas.add(nombreCiudadActual);
		
		ImageIcon imagenBotonSalida = new ImageIcon("src/visual/recursos/AlgoThieftBotonSalida_img.jpg");
		JButton botonSalida = new JButton(imagenBotonSalida);
		botonSalida.setBounds(39,380,179,49);
		botonSalida.addActionListener(new PanelCiudadesAViajar(unaVentana,generador,unJugador,calendario,arrestos));
		panelPistas.add(botonSalida);
		
		ImageIcon imagenBotonInvestigar = new ImageIcon("src/visual/recursos/AlgoThieftBotonInvestigar_img.jpg");
		JButton botonInvestigar = new JButton(imagenBotonInvestigar);
		botonInvestigar.setBounds(258,380,179,49);
		botonInvestigar.addActionListener(new CargadorPantallaLugares(unaVentana,generador,unJugador,calendario,arrestos));
		panelPistas.add(botonInvestigar);
		
		ImageIcon imagenBotonComputadora = new ImageIcon("src/visual/recursos/AlgoThieftBotonComputadora_img.jpg");
		JButton botonComputadora = new JButton(imagenBotonComputadora);
		botonComputadora.setBounds(477,380,179,49);
		botonComputadora.addActionListener(new CargarComputadora(unaVentana,generador,unJugador,calendario,arrestos));
		panelPistas.add(botonComputadora);
		
		ImageIcon imagenFondo = new ImageIcon("src/visual/recursos/AlgoThieftPantallaLugares_img.jpg");
		JLabel fondo = new JLabel(imagenFondo);
		fondo.setBounds(0,0,695,450);
		panelPistas.add(fondo);
	}
	
	public JPanel obtenerPanel(){
		return panelPistas;
	}
	
	public Pista obtenerPistaActual(){
		return pistaObtenida;
	}
	
}
