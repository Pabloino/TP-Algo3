package visual.componentes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import JuegoPorConsola.GeneradorDePartidas;
import modeloTp.Jugador;

public class PanelComputadora{
	
	private JPanel panelComputadora = new JPanel();
	
	public PanelComputadora(JFrame unaVentana, GeneradorDePartidas generador, Jugador unJugador, Calendario calendario, int arrestos){
		panelComputadora.setLayout(null);
		
		JLabel durmiendo = new JLabel("Durmiendo (+8 hs),");
		durmiendo.setBounds(280, 33, 195, 40);
		durmiendo.setFont(new Font("Arial",Font.BOLD,21));
		durmiendo.setForeground(Color.WHITE);
		durmiendo.setVisible(false);
		panelComputadora.add(durmiendo);
		
		JLabel fecha = new JLabel(calendario.obtenerDiaActual()+", "+calendario.obtenerHora()+":00 hs");
		fecha.setBounds(480,33,200,40);
		fecha.setFont(new Font("Arial",Font.BOLD,21));
		fecha.setForeground(Color.WHITE);
		panelComputadora.add(fecha);
		
		JLabel nombreCiudadActual = new JLabel(unJugador.obtenerCiudadActual().obtenerNombre());
		nombreCiudadActual.setBounds(30,33,330,40);
		nombreCiudadActual.setFont(new Font("Arial",Font.BOLD,21));
		nombreCiudadActual.setForeground(Color.WHITE);
		panelComputadora.add(nombreCiudadActual);
		
		JLabel nombreSexo = new JLabel("Sexo:");
		nombreSexo.setBounds(40,99,80,40);
		nombreSexo.setFont(new Font("Arial",Font.PLAIN,18));
		panelComputadora.add(nombreSexo);
		
		JComboBox<String> opcionesSexo = new JComboBox<String>();
		opcionesSexo.addItem("masculino");
		opcionesSexo.addItem("femenino");
		opcionesSexo.setSelectedIndex(-1);
		opcionesSexo.setBounds(120,105,180,28);
		panelComputadora.add(opcionesSexo);
		
		JLabel nombreHobby = new JLabel("Hobby:");
		nombreHobby.setBounds(40,149,80,40);
		nombreHobby.setFont(new Font("Arial",Font.PLAIN,18));
		panelComputadora.add(nombreHobby);
		
		JComboBox<String> opcionesHobby = new JComboBox<String>();
		opcionesHobby.addItem("tenis");
		opcionesHobby.addItem("musica");
		opcionesHobby.addItem("alpinismo");
		opcionesHobby.addItem("paracaidismo");
		opcionesHobby.addItem("natacion");
		opcionesHobby.addItem("croquet");
		opcionesHobby.setSelectedIndex(-1);
		opcionesHobby.setBounds(120,155,180,28);
		panelComputadora.add(opcionesHobby);
		
		JLabel nombrePelo = new JLabel("Pelo:");
		nombrePelo.setBounds(40,199,80,40);
		nombrePelo.setFont(new Font("Arial",Font.PLAIN,18));
		panelComputadora.add(nombrePelo);
		
		JComboBox<String> opcionesPelo = new JComboBox<String>();
		opcionesPelo.addItem("castanio");
		opcionesPelo.addItem("rubio");
		opcionesPelo.addItem("rojo");
		opcionesPelo.addItem("negro");
		opcionesPelo.setSelectedIndex(-1);
		opcionesPelo.setBounds(120,205,180,28);
		panelComputadora.add(opcionesPelo);
		
		JLabel nombreSenias = new JLabel("Senias:");
		nombreSenias.setBounds(40,249,80,40);
		nombreSenias.setFont(new Font("Arial",Font.PLAIN,18));
		panelComputadora.add(nombreSenias);
		
		JComboBox<String> opcionesSenias = new JComboBox<String>();
		opcionesSenias.addItem("cojera");
		opcionesSenias.addItem("anillo");
		opcionesSenias.addItem("tatuaje");
		opcionesSenias.addItem("cicatriz");
		opcionesSenias.addItem("joyas");
		opcionesSenias.setSelectedIndex(-1);
		opcionesSenias.setBounds(120,255,180,28);
		panelComputadora.add(opcionesSenias);
		
		JLabel nombreCoche = new JLabel("Coche:");
		nombreCoche.setBounds(40,299,80,40);
		nombreCoche.setFont(new Font("Arial",Font.PLAIN,18));
		panelComputadora.add(nombreCoche);
		
		JComboBox<String> opcionesCoche = new JComboBox<String>();
		opcionesCoche.addItem("descapotable");
		opcionesCoche.addItem("limusina");
		opcionesCoche.addItem("deportivo");
		opcionesCoche.addItem("moto");
		opcionesCoche.setSelectedIndex(-1);
		opcionesCoche.setBounds(120,305,180,28);
		panelComputadora.add(opcionesCoche);
		
		JTextArea pantalla = new JTextArea("Listo,");
		Border border = BorderFactory.createLineBorder(Color.GRAY);
		pantalla.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10,10,10,10)));
		pantalla.setBackground(Color.BLACK);
		pantalla.setForeground(Color.WHITE);
		pantalla.setFont(new Font("Arial",Font.PLAIN,14));
		pantalla.setBounds(350,105,300,180);
		pantalla.setLineWrap(true);
		pantalla.setWrapStyleWord(true);
		pantalla.setFocusable(false);
		panelComputadora.add(pantalla);
		
		JButton botonBuscar = new JButton("Buscar");
		botonBuscar.setBounds(350,305,300,28);
		botonBuscar.addActionListener(new BuscadorSospechosos(unaVentana,unJugador,pantalla,fecha,durmiendo,calendario,opcionesSexo,opcionesHobby,opcionesPelo,opcionesSenias,opcionesCoche));
		panelComputadora.add(botonBuscar);
		
		ImageIcon imagenBotonSalida = new ImageIcon("src/visual/recursos/AlgoThieftBotonSalida_img.jpg");
		JButton botonSalida = new JButton(imagenBotonSalida);
		botonSalida.setBounds(39,380,179,49);
		botonSalida.addActionListener(new PanelCiudadesAViajar(unaVentana,generador,unJugador,calendario,arrestos));
		panelComputadora.add(botonSalida);
		
		ImageIcon imagenBotonInvestigar = new ImageIcon("src/visual/recursos/AlgoThieftBotonInvestigar_img.jpg");
		JButton botonInvestigar = new JButton(imagenBotonInvestigar);
		botonInvestigar.setBounds(258,380,179,49);
		botonInvestigar.addActionListener(new CargadorPantallaLugares(unaVentana,generador,unJugador,calendario,arrestos));
		panelComputadora.add(botonInvestigar);
		
		ImageIcon imagenBotonComputadora = new ImageIcon("src/visual/recursos/AlgoThieftBotonComputadora_img.jpg");
		JButton botonComputadora = new JButton(imagenBotonComputadora);
		botonComputadora.setBounds(477,380,179,49);
		botonComputadora.setEnabled(false);
		panelComputadora.add(botonComputadora);
		
		ImageIcon imagenFondo = new ImageIcon("src/visual/recursos/AlgoThieftPantallaLugares_img.jpg");
		JLabel fondo = new JLabel(imagenFondo);
		fondo.setBounds(0,0,695,450);
		panelComputadora.add(fondo);		
	}
	
	public JPanel obtenerPanel(){
		return panelComputadora;
	}
}
