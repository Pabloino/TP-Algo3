package visual.componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JuegoPorConsola.GeneradorDePartidas;
import modeloTp.Jugador;

public class PanelLugares implements ActionListener{
	
	private JPanel panelLugares = new JPanel();
	private JFrame ventana;
	
	public PanelLugares(JFrame unaVentana, GeneradorDePartidas generador, Jugador unJugador, Calendario calendario, int arrestos){
		panelLugares.setLayout(null);
		
		JLabel durmiendo = new JLabel("Durmiendo (+8 hs),");
		durmiendo.setBounds(280, 33, 195, 40);
		durmiendo.setFont(new Font("Arial",Font.BOLD,21));
		durmiendo.setForeground(Color.WHITE);
		durmiendo.setVisible(false);
		panelLugares.add(durmiendo);
		
		calendario.sumarTiempo(unJugador.obtenerTiempoRestante(),durmiendo);
		
		JLabel fecha = new JLabel(calendario.obtenerDiaActual()+", "+calendario.obtenerHora()+":00 hs");
		fecha.setBounds(480,33,200,40);
		fecha.setFont(new Font("Arial",Font.BOLD,21));
		fecha.setForeground(Color.WHITE);
		panelLugares.add(fecha);
		
		JLabel lugares = new JLabel("Lugares a investigar:");
		lugares.setBounds(268,95,230,40);
		lugares.setFont(new Font("Arial",Font.BOLD,16));
		panelLugares.add(lugares);
		
		JLabel nombreCiudadActual = new JLabel(unJugador.obtenerCiudadActual().obtenerNombre());
		nombreCiudadActual.setBounds(30,33,330,40);
		nombreCiudadActual.setFont(new Font("Arial",Font.BOLD,21));
		nombreCiudadActual.setForeground(Color.WHITE);
		panelLugares.add(nombreCiudadActual);
		
		ImageIcon imagenBotonLugarUno = new ImageIcon("src/visual/recursos/AlgoThieftBotonLugar"+unJugador.obtenerCiudadActual().obtenerLugares().get(0).obtenerNombre()+"_img.jpg");
		JButton botonLugarUno = new JButton(imagenBotonLugarUno);
		botonLugarUno.setBounds(70,150,153,152);
		botonLugarUno.addActionListener(new CargarPista(0,unaVentana,generador,unJugador,calendario,arrestos));
		panelLugares.add(botonLugarUno);
		
		ImageIcon imagenBotonLugarDos = new ImageIcon("src/visual/recursos/AlgoThieftBotonLugar"+unJugador.obtenerCiudadActual().obtenerLugares().get(1).obtenerNombre()+"_img.jpg");
		JButton botonLugarDos = new JButton(imagenBotonLugarDos);
		botonLugarDos.setBounds(270,150,153,152);
		botonLugarDos.addActionListener(new CargarPista(1,unaVentana,generador,unJugador,calendario,arrestos));
		panelLugares.add(botonLugarDos);
		
		ImageIcon imagenBotonLugarTres = new ImageIcon("src/visual/recursos/AlgoThieftBotonLugar"+unJugador.obtenerCiudadActual().obtenerLugares().get(2).obtenerNombre()+"_img.jpg");
		JButton botonLugarTres = new JButton(imagenBotonLugarTres);
		botonLugarTres.setBounds(470,150,153,152);
		botonLugarTres.addActionListener(new CargarPista(2,unaVentana,generador,unJugador,calendario,arrestos));
		panelLugares.add(botonLugarTres);
		
		ImageIcon imagenBotonSalida = new ImageIcon("src/visual/recursos/AlgoThieftBotonSalida_img.jpg");
		JButton botonSalida = new JButton(imagenBotonSalida);
		botonSalida.setBounds(39,380,179,49);
		botonSalida.addActionListener(new PanelCiudadesAViajar(unaVentana,generador,unJugador,calendario,arrestos));
		panelLugares.add(botonSalida);
		
		ImageIcon imagenBotonInvestigar = new ImageIcon("src/visual/recursos/AlgoThieftBotonInvestigar_img.jpg");
		JButton botonInvestigar = new JButton(imagenBotonInvestigar);
		botonInvestigar.setBounds(258,380,179,49);
		botonInvestigar.setEnabled(false);
		panelLugares.add(botonInvestigar);
		
		ImageIcon imagenBotonComputadora = new ImageIcon("src/visual/recursos/AlgoThieftBotonComputadora_img.jpg");
		JButton botonComputadora = new JButton(imagenBotonComputadora);
		botonComputadora.setBounds(477,380,179,49);
		botonComputadora.addActionListener(new CargarComputadora(unaVentana,generador,unJugador,calendario,arrestos));
		panelLugares.add(botonComputadora);
		
		ImageIcon imagenFondo = new ImageIcon("src/visual/recursos/AlgoThieftPantallaLugares_img.jpg");
		JLabel fondo = new JLabel(imagenFondo);
		fondo.setBounds(0,0,695,450);
		panelLugares.add(fondo);
		
		this.ventana = unaVentana;
	}
	
	public JPanel obtenerPanel(){
		return panelLugares;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panelLugares);
		ventana.revalidate();
	}
}
