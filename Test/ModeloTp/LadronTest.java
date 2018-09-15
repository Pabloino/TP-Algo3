package modeloTp;

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

import org.junit.Test;
import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class LadronTest {

	@Test
	public void ladronDeberiaCrearseConTodasLasCaracteristicas(){
		
		Ladron ladron = new Ladron("Pepe", "masculino", "tennis", "rojo", "joyas", "limusina");
		
		Assert.assertTrue( ladron.obtenerNombre() == "Pepe");
		Assert.assertTrue( ladron.obtenerSexo() == "masculino");
		Assert.assertTrue( ladron.obtenerHobby() == "tennis");
		Assert.assertTrue( ladron.obtenerCabello() == "rojo");
		Assert.assertTrue( ladron.obtenerSenia() == "joyas");
		Assert.assertTrue( ladron.obtenerVehiculo() == "limusina");
	}
	
	@Test
	public void unLadronDeberiaGuardarYRecuperarATravesDeXML() throws ParserConfigurationException, TransformerException, SAXException, IOException{
		
		//Genero un documento XML vacio en la memoria
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		Ladron unLadron = new Ladron("John Wayne", "masculino", "alpinismo", "rubio", "cicatriz", "ninguno");
		
		//Asigno el elemento XML de la instancia al documento generado anteriormente
		Node ladronSerializado = unLadron.serializar(doc);
		
		assertNotNull(ladronSerializado);
		
		//Guardo el XML en el disco
		doc.appendChild(ladronSerializado);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		File archivo = new File("ladronTest.xml");
		StreamResult streamResult = new StreamResult(archivo);
		transformer.transform(source, streamResult);
						
		assertTrue(archivo.exists());
		
		//Recupero el estado guardado de ladron en una nueva instancia
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(archivo);
		doc.getDocumentElement().normalize();
				
		Element elementoLadron = (Element) doc.getElementsByTagName("Ladron").item(0);
		Ladron otroLadron = Ladron.cargarEstado(elementoLadron);
				
		assertNotNull(otroLadron);
		assertEquals(unLadron.obtenerNombre(),otroLadron.obtenerNombre());
		assertEquals(unLadron.obtenerSexo(),otroLadron.obtenerSexo());
		assertEquals(unLadron.obtenerHobby(),otroLadron.obtenerHobby());
		assertEquals(unLadron.obtenerCabello(),otroLadron.obtenerCabello());
		assertEquals(unLadron.obtenerSenia(),otroLadron.obtenerSenia());
		assertEquals(unLadron.obtenerVehiculo(),otroLadron.obtenerVehiculo());
		
		archivo.delete();
	}
}
