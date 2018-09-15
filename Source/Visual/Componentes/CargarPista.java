package visual.componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import JuegoPorConsola.GeneradorDePartidas;
import modeloTp.Jugador;

public class CargarPista implements ActionListener{
	
	private int numeroDeLugar;
	private JFrame ventana;
	private GeneradorDePartidas generador;
	private Jugador jugador;
	private Calendario calendario;
	private int arrestos;

	public CargarPista(int numeroDeLugar, JFrame unaVentana, GeneradorDePartidas generador, Jugador unJugador, Calendario calendario, int arrestos){
		this.numeroDeLugar = numeroDeLugar;
		this.ventana = unaVentana;
		this.generador = generador;
		this.jugador = unJugador;
		this.calendario = calendario;
		this.arrestos = arrestos;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PanelPistas panelPistas = new PanelPistas(numeroDeLugar,ventana,generador,jugador,calendario,arrestos);
		
		if (jugador.obtenerTiempoRestante() <= 0){
			PanelTiempoAgotado panelTiempoAgotado = new PanelTiempoAgotado(ventana,jugador.obtenerNombre(),jugador.obtenerCantidadDeArrestos());
			
			ventana.getContentPane().removeAll();
			ventana.getContentPane().add(panelTiempoAgotado.obtenerPanel());
			ventana.revalidate();
		} else {	
			//Compruebo si el lugar donde ingreso el jugador se encuentra el ladron
			if (panelPistas.obtenerPistaActual() == generador.obtenerPistaJuegoGanado()){
				PanelJuegoGanado panelJuegoGanado = new PanelJuegoGanado(ventana,jugador);
				
				ventana.getContentPane().removeAll();
				ventana.getContentPane().add(panelJuegoGanado.obtenerPanel());
				ventana.revalidate();	
			} else {
				if (panelPistas.obtenerPistaActual() == generador.obtenerPistaPerdidoPorNoEmitirOrdenDeArresto()){
					PanelJuegoPerdidoSinEmision panelJuegoPerdidoSinEmision = new PanelJuegoPerdidoSinEmision(ventana,jugador);
					
					ventana.getContentPane().removeAll();
					ventana.getContentPane().add(panelJuegoPerdidoSinEmision.obtenerPanel());
					ventana.revalidate();
				} else {
					if(panelPistas.obtenerPistaActual() == generador.obtenerPistaPerdidoPorOrdenIncorrecta()){
						PanelJuegoPerdidoConEmisionIncorrecta panelJuegoPerdidoConEmisionIncorrecta = new PanelJuegoPerdidoConEmisionIncorrecta(ventana,jugador);
						
						ventana.getContentPane().removeAll();
						ventana.getContentPane().add(panelJuegoPerdidoConEmisionIncorrecta.obtenerPanel());
						ventana.revalidate();
					} else {
						ventana.getContentPane().removeAll();
						ventana.getContentPane().add(panelPistas.obtenerPanel());
						ventana.revalidate();
					}
				}
			}
		}
	}	
}
