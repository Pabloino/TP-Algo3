package modeloTp;


import org.junit.Test;
import org.junit.Assert;


public class LugarTest{

	@Test 
	public void elLugarDeberiaDevolverElNombreIngresado(){
		
		Lugar bolsa = new Lugar("bolsa", null, null, null);
		
		Assert.assertTrue( bolsa.obtenerNombre() == "bolsa" );
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaFacilSiElPersonajeEsNovato(){
	
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Jugador jugador = new Jugador(null,null, null);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil);
		Rango rangoJugador = jugador.obtenerRango();
		
		Assert.assertTrue(rangoJugador.pedirPista(aeropuerto) == pistaFacil);
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaMedioSiElPersonajeEsDetective(){
		
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Jugador jugador = new Jugador(null,null, null);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil);
		
		for(int i=0;i < 10; i++) jugador.agregarArresto();
		
		Rango rangoJugador = jugador.obtenerRango();
		
		Assert.assertTrue(rangoJugador.pedirPista(aeropuerto)== pistaMedia);
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaDificilSiElPersonajeEsSargento(){
	
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Jugador jugador = new Jugador(null,null, null);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil);
		
		for(int i=0;i < 25; i++) jugador.agregarArresto();
		
		Rango rangoJugador = jugador.obtenerRango();
		
		Assert.assertTrue(rangoJugador.pedirPista(aeropuerto) == pistaDificil);
	}
	
	@Test
	public void elLugarDeberiaDevolverLaPistaMediaSiElPersonajeEsInvestigador(){
		
		Pista pistaFacil = new Pista("a");
		Pista pistaMedia = new Pista("b");
		Pista pistaDificil = new Pista("c");
		
		Jugador jugador = new Jugador(null,null, null);
		Lugar aeropuerto = new Lugar("Aeropuerto",pistaFacil, pistaMedia, pistaDificil);
		
		for(int i=0;i < 15; i++) jugador.agregarArresto();
		
		Rango rangoJugador = jugador.obtenerRango();	
		
		Assert.assertTrue(rangoJugador.pedirPista(aeropuerto) == pistaMedia);
	}
	
}
