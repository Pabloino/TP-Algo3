package visual.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import modeloTp.Jugador;

public class BuscadorSospechosos implements ActionListener{
	
	private JFrame ventana;
	private Jugador jugador;
	private JTextArea pantalla;
	private JLabel fecha;
	private JLabel durmiendo;
	private Calendario calendario;
	private JComboBox<String> sexo;
	private JComboBox<String> hobby;
	private JComboBox<String> pelo;
	private JComboBox<String> senias;
	private JComboBox<String> coche;
	
	public BuscadorSospechosos(JFrame unaVentana, Jugador unJugador, JTextArea unaPantalla, JLabel fecha, JLabel durmiendo, Calendario calendario, JComboBox<String> datosSexo, JComboBox<String> datosHobby, JComboBox<String> datosPelo, JComboBox<String> datosSenias, JComboBox<String> datosCoche){
		this.ventana = unaVentana;
		this.jugador = unJugador;
		this.pantalla = unaPantalla;
		this.fecha = fecha;
		this.durmiendo = durmiendo;
		this.calendario = calendario;
		this.sexo = datosSexo;
		this.hobby = datosHobby;
		this.pelo = datosPelo;
		this.senias = datosSenias;
		this.coche = datosCoche;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		jugador.emitirOrdenDeArresto(String.valueOf(sexo.getSelectedItem()),String.valueOf(hobby.getSelectedItem()),String.valueOf(pelo.getSelectedItem()),String.valueOf(senias.getSelectedItem()),String.valueOf(coche.getSelectedItem()));
		calendario.sumarTiempo(jugador.obtenerTiempoRestante(),durmiendo);
		
		if (jugador.obtenerTiempoRestante() <= 0){
			PanelTiempoAgotado panel = new PanelTiempoAgotado(ventana,jugador.obtenerNombre(),jugador.obtenerCantidadDeArrestos());
			
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panel.obtenerPanel());
			ventana.revalidate();
		}
		
		if (jugador.seEmitioOrdenDeArresto()){
			pantalla.setText("Orden de arresto emitida contra "+jugador.obtenerNombreDeLadronBuscado());
		} else {
			pantalla.setText("No hay suficientes pistas para obtener coincidencias");
		}
		fecha.setText(calendario.obtenerDiaActual()+", "+calendario.obtenerHora()+":00 hs");
		fecha.repaint();
		fecha.revalidate();
		
		pantalla.repaint();
		pantalla.revalidate();
	}
}
