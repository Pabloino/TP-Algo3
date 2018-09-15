package visual.componentes;

import java.util.ArrayList;

import javax.swing.JLabel;

import modeloTp.Jugador;

public class Calendario {
	
	private ArrayList<String> diasDeSemana = new ArrayList<String>();
	private int hora;
	private int diaActual;
	private int tiempoDisponibleEnHoras;
	private Jugador jugador;
	
	public Calendario(int tiempo, Jugador unJugador){
		diasDeSemana.add("Lunes");
		diasDeSemana.add("Martes");
		diasDeSemana.add("Miercoles");
		diasDeSemana.add("Jueves");
		diasDeSemana.add("Viernes");
		diasDeSemana.add("Sabado");
		diasDeSemana.add("Domingo");	
		
		hora = 7;
		diaActual = 0;
		this.tiempoDisponibleEnHoras = tiempo;
		this.jugador = unJugador;
	}
	
	public int obtenerHora(){
		return hora;
	}
	
	public String obtenerDiaActual(){
		return diasDeSemana.get(diaActual);
	}
	
	public void sumarTiempo(int unValor, JLabel durmiendoLabel){
		int tiempo = (this.tiempoDisponibleEnHoras - unValor);
		
		while(tiempo > 0){
			hora++;
			if (hora > 23){
				hora = 0;
				diaActual++;
			}
			tiempo--;
		}
		
		//Compruebo el horario para que el jugador duerma
		if ((0 <= hora)&&(hora < 7)){
			jugador.dormir();
			hora = hora+8;
			durmiendoLabel.setVisible(true);
		} else {
			durmiendoLabel.setVisible(false);
		}
		
		this.tiempoDisponibleEnHoras = jugador.obtenerTiempoRestante();
	}
	
}
