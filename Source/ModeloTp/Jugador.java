package modeloTp;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private Ciudad ciudadActual;
	private int tiempoRestante;
	private int tiempoPorEntrarALugar;
	private int tiempoPorHeridaDeCuchillo;
	private int tiempoPorHeridaDeBala;
	private int tiempoPorDormir;
	private int tiempoEmitirOrdenDeArresto;
	private String nombreDelLadronBuscado;
	private ComputadoraPolicial computadoraPolicial;
	private int cantidadDeArrestos;
	private Rango rangoActual;
	private Pista pistaVacia;
	
	static final int arrestosParaCambiarADetective = 5;
	static final int arrestosParaCambiarAInvestigador = 10;
	static final int arrestosParaCambiarASargento = 20;
	
	public Jugador(String nombreDelJugador, Ciudad ciudad, ComputadoraPolicial computadoraPolicial){
		
		this.nombre = nombreDelJugador;
		this.ciudadActual = ciudad;
		this.tiempoRestante = 154; 
		this.tiempoPorEntrarALugar = 1;
		this.tiempoPorHeridaDeCuchillo = 2;
		this.tiempoPorHeridaDeBala = 4;
		this.tiempoPorDormir = 8;
		this.tiempoEmitirOrdenDeArresto = 3;
		this.computadoraPolicial = computadoraPolicial;
		this.cantidadDeArrestos = 0;
		this.nombreDelLadronBuscado = null;
		this.rangoActual = new Novato();
		this.pistaVacia = new Pista("Vacia");
		
	}

	public Pista visitar(ILugar lugar){
		
		lugar.registarSiEstaElLadron(this);
		if (this.tiempoRestante != 0){
			return (this.rangoActual).pedirPista(lugar);
		}
		return this.pistaVacia;
	}
	
	public String obtenerNombre(){
		return this.nombre;
	}
	
	public void agregarArresto(){
		
		this.cantidadDeArrestos = this.cantidadDeArrestos + 1;
		this.actualizarRango();
		
	}
	
	private void actualizarRango() {
		
		if(this.cantidadDeArrestos < arrestosParaCambiarADetective) this.rangoActual = new Novato();
		else if(this.cantidadDeArrestos < arrestosParaCambiarAInvestigador) this.rangoActual = new Detective();
		else if(this.cantidadDeArrestos < arrestosParaCambiarASargento) this.rangoActual = new Investigador();
		else this.rangoActual = new Sargento();
		
	}

	public int obtenerCantidadDeArrestos(){
		
		return this.cantidadDeArrestos;
	}
	
	public void restarTiempoPorEntrarALugar(){
		reducirTiempo(tiempoPorEntrarALugar);
		
		if (this.tiempoPorEntrarALugar < 3){
			this.tiempoPorEntrarALugar = this.tiempoPorEntrarALugar + 1;
		}
	}
	
	
	private void cambiarDeCiudad(Ciudad ciudad) {
		this.ciudadActual = ciudad;
		
	}

	public void viajar(Ciudad ciudad){
		
		int tiempoPorViajar = this.calcularTiempoDeViaje(ciudad.obtenerDistancia(this.ciudadActual));
		this.reducirTiempo(tiempoPorViajar);
		
		if( this.tiempoRestante != 0 ){
			this.cambiarDeCiudad(ciudad);
			this.tiempoPorEntrarALugar = 1;
		}
	}

	private int calcularTiempoDeViaje(int distancia) {
	
		return (int)distancia/this.rangoActual.obtenerVelocidad();
	}

	public int obtenerTiempoRestante() {
		return this.tiempoRestante;
	}

	public Ciudad obtenerCiudadActual() {
		
		return this.ciudadActual;
	}

	public void recibirCuchillazo() {
		
		reducirTiempo(tiempoPorHeridaDeCuchillo);
		
	}

	public void recibirBalazo() {
		
		reducirTiempo(tiempoPorHeridaDeBala);
	}

	public void dormir() {
		
		reducirTiempo(tiempoPorDormir);
		
	}
	
	public void emitirOrdenDeArresto(String sexo, String hobby, String cabello,  String senia, String vehiculo){
		
		reducirTiempo( this.tiempoEmitirOrdenDeArresto);
		if( this.tiempoRestante != 0 ){
			
			ArrayList<Ladron> posiblesLadrones = this.computadoraPolicial.buscarPosiblesLadrones(sexo, hobby, cabello, senia, vehiculo);
			
			if (posiblesLadrones.size() == 1){
				this.nombreDelLadronBuscado = ( (Ladron)posiblesLadrones.get(0) ).obtenerNombre();
			}
		}
	}
	
	private void reducirTiempo( Integer tiempo ){
		
		if( this.tiempoRestante <= tiempo){
			this.tiempoRestante = 0;
		} else {
			this.tiempoRestante = this.tiempoRestante - tiempo;
		}
	}
	
	public String obtenerNombreDeLadronBuscado() {
		
		return this.nombreDelLadronBuscado;
	}

	public boolean seEmitioOrdenDeArresto() {
		return (this.nombreDelLadronBuscado != null);
	}

	public Rango obtenerRango() {
		
		return this.rangoActual;
	}

} 