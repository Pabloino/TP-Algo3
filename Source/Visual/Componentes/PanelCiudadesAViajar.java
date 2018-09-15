package visual.componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JuegoPorConsola.GeneradorDePartidas;
import modeloTp.Jugador;

public class PanelCiudadesAViajar implements ActionListener{
	
	private JPanel panelCiudades = new JPanel();
	private JFrame ventana;
	
	public PanelCiudadesAViajar(JFrame unaVentana, GeneradorDePartidas generador, Jugador unJugador, Calendario calendario, int arrestos){
		Random generadorNumeros = new Random();
		int valor;
		ArrayList<Integer> listaValores = new ArrayList<Integer>();
		for (int i=0; i < 3; i++){
			listaValores.add(i);
		}
		
		panelCiudades.setLayout(null);
				
		JLabel fecha = new JLabel(calendario.obtenerDiaActual()+", "+calendario.obtenerHora()+":00 hs");
		fecha.setBounds(480,33,200,40);
		fecha.setFont(new Font("Arial",Font.BOLD,21));
		fecha.setForeground(Color.WHITE);
		panelCiudades.add(fecha);
		
		JLabel ciudades = new JLabel("Ciudades a viajar:");
		ciudades.setBounds(279,95,230,40);
		ciudades.setFont(new Font("Arial",Font.BOLD,16));
		panelCiudades.add(ciudades);
		
		JLabel nombreCiudadActual = new JLabel(unJugador.obtenerCiudadActual().obtenerNombre());
		nombreCiudadActual.setBounds(30,33,330,40);
		nombreCiudadActual.setFont(new Font("Arial",Font.BOLD,21));
		nombreCiudadActual.setForeground(Color.WHITE);
		panelCiudades.add(nombreCiudadActual);
		
		ImageIcon imagenBotonCiudades = new ImageIcon("src/visual/recursos/AlgoThieftBotonCiudadViajar_img.jpg");
		
		valor = generadorNumeros.nextInt(listaValores.size());
		JButton botonCiudadUno = new JButton(unJugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(listaValores.get(valor)).obtenerNombre());
		botonCiudadUno.setIcon(imagenBotonCiudades);
		botonCiudadUno.setHorizontalTextPosition(JButton.CENTER);
		botonCiudadUno.setVerticalTextPosition(JButton.CENTER);
		botonCiudadUno.setFont(new Font("Arial",Font.BOLD,16));
		botonCiudadUno.setForeground(Color.WHITE);
		botonCiudadUno.setBounds(60,185,171,74);
		botonCiudadUno.addActionListener(new CargarNuevaCiudad(listaValores.get(valor),unaVentana,generador,unJugador,calendario, arrestos));
		listaValores.remove(valor);
		panelCiudades.add(botonCiudadUno);
		
		valor = generadorNumeros.nextInt(listaValores.size());
		JButton botonCiudadDos = new JButton(unJugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(listaValores.get(valor)).obtenerNombre());
		botonCiudadDos.setIcon(imagenBotonCiudades);
		botonCiudadDos.setHorizontalTextPosition(JButton.CENTER);
		botonCiudadDos.setVerticalTextPosition(JButton.CENTER);
		botonCiudadDos.setFont(new Font("Arial",Font.BOLD,16));
		botonCiudadDos.setForeground(Color.WHITE);
		botonCiudadDos.setBounds(260,185,171,74);
		botonCiudadDos.addActionListener(new CargarNuevaCiudad(listaValores.get(valor),unaVentana,generador,unJugador,calendario, arrestos));
		listaValores.remove(valor);
		panelCiudades.add(botonCiudadDos);
		
		valor = generadorNumeros.nextInt(listaValores.size());
		JButton botonCiudadTres = new JButton(unJugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(listaValores.get(valor)).obtenerNombre());
		botonCiudadTres.setIcon(imagenBotonCiudades);
		botonCiudadTres.setHorizontalTextPosition(JButton.CENTER);
		botonCiudadTres.setVerticalTextPosition(JButton.CENTER);
		botonCiudadTres.setFont(new Font("Arial",Font.BOLD,16));
		botonCiudadTres.setForeground(Color.WHITE);
		botonCiudadTres.setBounds(460,185,171,74);
		botonCiudadTres.addActionListener(new CargarNuevaCiudad(listaValores.get(valor),unaVentana,generador,unJugador,calendario, arrestos));
		listaValores.remove(valor);
		panelCiudades.add(botonCiudadTres);
		
		ImageIcon imagenBotonSalida = new ImageIcon("src/visual/recursos/AlgoThieftBotonSalida_img.jpg");
		JButton botonSalida = new JButton(imagenBotonSalida);
		botonSalida.setBounds(39,380,179,49);
		botonSalida.setEnabled(false);
		panelCiudades.add(botonSalida);
		
		ImageIcon imagenBotonInvestigar = new ImageIcon("src/visual/recursos/AlgoThieftBotonInvestigar_img.jpg");
		JButton botonInvestigar = new JButton(imagenBotonInvestigar);
		botonInvestigar.setBounds(258,380,179,49);
		botonInvestigar.addActionListener(new CargadorPantallaLugares(unaVentana,generador,unJugador,calendario, arrestos));
		panelCiudades.add(botonInvestigar);
		
		ImageIcon imagenBotonComputadora = new ImageIcon("src/visual/recursos/AlgoThieftBotonComputadora_img.jpg");
		JButton botonComputadora = new JButton(imagenBotonComputadora);
		botonComputadora.setBounds(477,380,179,49);
		botonComputadora.addActionListener(new CargarComputadora(unaVentana,generador,unJugador,calendario, arrestos));
		panelCiudades.add(botonComputadora);
		
		ImageIcon imagenFondo = new ImageIcon("src/visual/recursos/AlgoThieftPantallaViajar_img.jpg");
		JLabel fondo = new JLabel(imagenFondo);
		fondo.setBounds(0,0,695,450);
		panelCiudades.add(fondo);
		
		this.ventana = unaVentana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ventana.getContentPane().removeAll();
		ventana.getContentPane().add(panelCiudades);
		ventana.revalidate();	
	}
}
