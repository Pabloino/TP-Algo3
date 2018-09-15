package modeloTp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import modeloTp.Pista;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class PistaTest {
	
	@Test
	public void obtenerContenidoDePistaDeberiaDevolverElTextoIngresado() {
		
		Pista pista = new Pista("unTexto");
		
		Assert.assertTrue(pista.obtenerContenido() == "unTexto");
		
	}
	
	@Test
	public void pistaDeberiaGuardarYRecuperarATravesDeXML() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		//Genero un documento XML vacio en la memoria
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();	
		
		Pista unaPista = new Pista("Contenido de pista");
		
		//Asigno el elemento XML de la instancia al documento generado anteriormente
		Node pistaSerializada = unaPista.serializar(doc);
		
		assertNotNull(pistaSerializada);
		
		//Guardo el XML en el disco
		doc.appendChild(pistaSerializada);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivo = new File("pistaTest.xml");
		StreamResult streamResult = new StreamResult(archivo);
		transformer.transform(source, streamResult);
		
		assertTrue(archivo.exists());
		
		//Recupero el estado guardado de pista en una nueva instancia
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
		
		Element elementoPista = (Element)doc.getElementsByTagName("Pista").item(0);
		Pista otraPista = Pista.cargarEstado(elementoPista);
		
		assertNotNull(otraPista);
		assertEquals(unaPista.obtenerContenido(), otraPista.obtenerContenido());
		
		archivo.delete();	
	}
	
}
