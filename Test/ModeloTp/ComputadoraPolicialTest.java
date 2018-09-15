package modeloTp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class ComputadoraPolicialTest {
	
	@Test
	public void buscarPosiblesLadronesDeberiaDevolverUnaListaConUnLadronSiSoloUnoCoincideConLasCarateristicasIndicadas(){
		
		Ladron sospechoso1 = new Ladron("Pepe", "masculino", "tennis", "rojo", "joyas", "limusina");
		Ladron sospechoso2 = new Ladron("Maria", "femenino", "handball", "castanio", "cicatriz", "limusina");
		Ladron ladron = new Ladron("Jose", "masculino", "football", "negro", "ninguna", "limusina");
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		sospechosos.add(sospechoso2);
		sospechosos.add(ladron);
		
		ComputadoraPolicial computadora = new ComputadoraPolicial(sospechosos);
		
		ArrayList<Ladron> posiblesLadrones = computadora.buscarPosiblesLadrones("masculino", "football", null, null, "limusina");
		
		Assert.assertTrue( posiblesLadrones.size() == 1 );
		Assert.assertTrue( ( ((Ladron)posiblesLadrones.get(0)).obtenerNombre() ) == ladron.obtenerNombre() );
		
	}
	
	@Test
	public void buscarPosiblesLadronesDeberiaDevolverUnaListaConLosLadronesQueCoincideConLasCarateristicasIndicadas(){
		
		Ladron sospechoso1 = new Ladron("Pepe", "masculino", "tennis", "rojo", "joyas", "limusina");
		Ladron sospechoso2 = new Ladron("Maria", "femenino", "handball", "castanio", "cicatriz", "limusina");
		Ladron sospechoso3 = new Ladron("Jose", "masculino", "football", "negro", "ninguna", "limusina");
		ArrayList<Ladron> sospechosos = new ArrayList<Ladron>();
		sospechosos.add(sospechoso1);
		sospechosos.add(sospechoso2);
		sospechosos.add(sospechoso3);
		
		ComputadoraPolicial computadora = new ComputadoraPolicial(sospechosos);
		
		ArrayList<Ladron> posiblesLadrones = computadora.buscarPosiblesLadrones( null, null , null, null, "limusina");
		
		Assert.assertTrue( posiblesLadrones.size() == 3 );
		Assert.assertTrue( posiblesLadrones.contains(sospechoso1) );
		Assert.assertTrue( posiblesLadrones.contains(sospechoso2) );
		Assert.assertTrue( posiblesLadrones.contains(sospechoso3) );
		
	}
	
	
	/*
	@Test
	public void laComputadoraPolicialDeberiaCrearseConLasCaracteristicasDelLadronYLosSospechososVacias(){
		ComputadoraPolicial computadora = new ComputadoraPolicial( new ArrayList<Ladron>() );
		
		Assert.assertTrue( computadora.obtenerSexoLadron() == null );
		Assert.assertTrue( computadora.obtenerHobbyLadron() == null );
		Assert.assertTrue( computadora.obtenerCabelloLadron() == null );
		Assert.assertTrue( computadora.obtenerSeniaLadron() == null );
		Assert.assertTrue( computadora.obtenerVehiculoLadron() == null );
		
		ArrayList<Ladron> sospechosos = computadora.obtenerSospechosos();
		
		Assert.assertTrue( sospechosos.size() == 0 );
	}
	
	@Test 
	public void laComputadoraDeberiaDevolverLasCaracteristicasDelLadronIngresadas(){
		
		ComputadoraPolicial computadora = new ComputadoraPolicial( new ArrayList<Ladron>() );
		
		computadora.agregarSexoLadron("masculino");
		computadora.agregarHobbyLadron("football");
		computadora.agregarVehiculoLadron("limusina");
		computadora.agregarCabelloLadron("rojo");
		computadora.agregarSeniaLadron("cicatriz");
		
		
		Assert.assertTrue( computadora.obtenerSexoLadron() == "masculino" );
		Assert.assertTrue( computadora.obtenerHobbyLadron() == "football" );
		Assert.assertTrue( computadora.obtenerCabelloLadron() == "rojo" );
		Assert.assertTrue( computadora.obtenerSeniaLadron() == "cicatriz" );
		Assert.assertTrue( computadora.obtenerVehiculoLadron() == "limusina" );
				
	}
	*/
	
	@Test
	public void computadoraPolicialDeberiaGuardarYRecuperarATravesDeXML() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
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
		
		ComputadoraPolicial unaComputadora = new ComputadoraPolicial(sospechosos);
		
		//Asigno el elemento XML de la instancia al documento generado anteriormente
		Node computadoraSerializada = unaComputadora.serializar(doc);
				
		assertNotNull(computadoraSerializada);
		
		//Guardo el XML en el disco
		doc.appendChild(computadoraSerializada);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivo = new File("computadoraTest.xml");
		StreamResult streamResult = new StreamResult(archivo);
		transformer.transform(source, streamResult);
						
		assertTrue(archivo.exists());
		
		//Recupero el estado guardado de computadora en una nueva instancia
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
				
		Element elementoComputadora = (Element) doc.getElementsByTagName("ComputadoraPolicial").item(0);
		ComputadoraPolicial otraComputadora = ComputadoraPolicial.cargarEstado(elementoComputadora);
		
		assertNotNull(otraComputadora);
		assertEquals(otraComputadora.buscarPosiblesLadrones(null,null,null,null,null).size(), 3);
		//assertEquals(otraComputadora.buscarPosiblesLadrones("masculino",null,null,null,null).size(), 2);
		
		archivo.delete();
	}
	
	
}
