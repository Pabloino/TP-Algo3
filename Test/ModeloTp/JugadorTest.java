package modeloTp;

/*
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
*/
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import modeloTp.Ciudad;
import modeloTp.Jugador;

public class JugadorTest {

	@Test
	public void deberiaCrearseElJugadorConLosParametrosIntroducidos() {

		
		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new Jugador(null,BuenosAires, null);
		
		Assert.assertTrue(jugador.obtenerCiudadActual() == BuenosAires);
		Assert.assertTrue(jugador.obtenerTiempoRestante() == 154);
				
	} 
	
	@Test
	public void deberiaCambiarseLaCiudadEnDondeEstaElJugador(){

		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Ciudad Paris = new Ciudad("Paris",5,5);
		Jugador jugador = new Jugador(null,BuenosAires, null);
		Assert.assertTrue(jugador.obtenerCiudadActual() == BuenosAires);
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(jugador.obtenerCiudadActual().obtenerNombre() == "Paris");
		
	}
	
	/*//PRUEBA DEL TIEMPO, VER COMO LA MODIFICAMOS.
	@Test(expected=ExcepcionNoHayMasTiempo.class)
	public void deberiaLanzarLaExcepcionCuandoNoHayMasTiempoParaViajarYNoCambiarDeCiudad() throws ExcepcionNoHayMasTiempo {

		Ciudad BuenosAires = new Ciudad("Buenos Aires",1,1);
		Ciudad Paris = new Ciudad("Paris",5000,5000);
		Jugador jugador = new JugadorNovato(BuenosAires, null);
		
		jugador.viajar(Paris);
		
		Assert.assertTrue(jugador.obtenerCiudadActual() == BuenosAires);
						
	} */
	
	@Test
	public void herirAJugadorConCuchilloDeberiaReducirElTiempoDelJugador2Horas(){
		Ciudad buenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new Jugador(null,buenosAires, null);
		
		Integer tiempoInicialJugador = jugador.obtenerTiempoRestante();
		jugador.recibirCuchillazo();
		
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoInicialJugador - 2) );		
		
	}
	
	@Test
	public void herirAJugadorConArmaDeFuegoDeberiaReducirElTiempoDelJugador4Horas(){
		Ciudad buenosAires = new Ciudad("Buenos Aires",1,1);
		Jugador jugador = new Jugador(null,buenosAires, null);
		
		Integer tiempoInicialJugador = jugador.obtenerTiempoRestante();
		jugador.recibirBalazo();
		
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoInicialJugador - 4) );		
		
	}
	
	@Test
	public void deberiaReducirElTiempoDelJugador8HorasSiEsteDuerme(){
		
		Jugador jugador = new Jugador(null,null, null);
		
		Integer tiempoInicialJugador = jugador.obtenerTiempoRestante();
		jugador.dormir();
		
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoInicialJugador - 8) );		
		
	}
	
	@Test
	public void deberiaReducirEltiempoDelJugador3HorasSiSeEmiteOrdenDeArresto(){
		
		Jugador jugador = new Jugador(null,null, new ComputadoraPolicial( new ArrayList<Ladron>() ));
		
		Integer tiempoInicialJugador = jugador.obtenerTiempoRestante();
		jugador.emitirOrdenDeArresto(null, null, null, null, null);
		
		Assert.assertTrue( jugador.obtenerTiempoRestante() == (tiempoInicialJugador - 3) );
	}
	
	/*
	@Test
	public void unJugadorDeberiaGuardarYRecuperarATravesDeXML() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		//Genero un documento XML vacio en la memoria
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Ladron ladronUno = new Ladron("John Wayne", "masculino", "alpinismo", "rubio", "cicatriz", "ninguno");
		Ladron ladronDos = new Ladron("Gracie Kai", "femenino", "paracaidismo", "rojo", "anillo", "ninguno");
		Ladron ladronTres = new Ladron("Jack Norris", "masculino", "ninguno", "negro", "tatuaje", "Limusina");
		
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(ladronUno);
		sospechosos.add(ladronDos);
		sospechosos.add(ladronTres);
		
		Lugar biblioteca = new Lugar("Biblioteca",new Pista("BiblioFacil"),new Pista("BiblioMedia"),new Pista("BiblioDificil"),ladronUno);
		Lugar aeropuerto = new Lugar("Aeropuerto",new Pista("AeroFacil"),new Pista("AeroMedia"),new Pista("AeroDificil"),null);
		Lugar banco = new Lugar("Banco",new Pista("BancFacil"),new Pista("BancMedia"),new Pista("BancDificil"),ladronDos);
		
		Ciudad unaCiudad = new Ciudad("Buenos Aires",1,1,biblioteca,aeropuerto,banco,null);
		
		ComputadoraPolicial unaComputadora = new ComputadoraPolicial(sospechosos);
		
		Jugador unJugador = new Jugador(unaCiudad,unaComputadora);
		
		//Asigno el elemento XML de la instancia al documento generado anteriormente
		Node jugadorSerializado = unJugador.serializar(doc);
		
		assertNotNull(jugadorSerializado);
		
		//Guardo el XML en el disco
		doc.appendChild(jugadorSerializado);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivo = new File("jugadorTest.xml");
		StreamResult streamResult = new StreamResult(archivo);
		transformer.transform(source, streamResult);
						
		assertTrue(archivo.exists());
		
		//Recupero el estado guardado de jugador en una nueva instancia
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
							
		Jugador otroJugador = Jugador.cargarEstado(doc);
		
		assertNotNull(otroJugador);
		assertEquals(unJugador.velocidad, otroJugador.velocidad);
		assertNotNull(otroJugador.obtenerCiudadActual());
		assertEquals(unJugador.obtenerCiudadActual().obtenerNombre(), otroJugador.obtenerCiudadActual().obtenerNombre());
		
		archivo.delete();
	}
	*/
}