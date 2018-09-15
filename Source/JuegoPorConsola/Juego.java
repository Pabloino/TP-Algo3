package JuegoPorConsola;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import modeloTp.Ciudad;
import modeloTp.ComputadoraPolicial;
import modeloTp.ILugar;
import modeloTp.Jugador;
import modeloTp.Pista;

public class Juego {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException{

		Jugador jugador;

		Pista juegoGanado = new Pista("Has atrapado al ladron, has ganado la partida");
		Pista ordenDeArrestoIncorrecta = new Pista("La orden de arresto emitida fue incorrecta, el ladron ha escapado y has perdido la partida");
		Pista ordenDeArrestoNoEmitida = new Pista("No se ha emitido ninguna orden de arresto, el ladron ha escapado y has perdido la partida");

		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);

		int opcionElegida = 0;
		boolean juegoTerminado = false;
		boolean primeraPartida = true;
		int cantidadArrestosJugador = 0;
		
		@SuppressWarnings("unused")
		Random generador = new Random();
		@SuppressWarnings("unused")
		int valor;

		// MUESTRO POR PANTALLA EL MENU PRINCIPAL DEL JUEGO
		System.out.println(" 1)_ Inicio de juego");
		System.out.println(" 2)_ Fin del juego ");

		opcionElegida = entradaEscaner.nextInt();

		if (opcionElegida == 2) {
			juegoTerminado = true;
		}

		System.out.println("Ingrese su nombre: ");
		System.out.println("");
		String nombreDelJugador = entradaEscaner.next();

		while (juegoTerminado != true) {

			GeneradorDePartidas generadorDePartidas = new GeneradorDePartidas(juegoGanado, ordenDeArrestoIncorrecta, ordenDeArrestoNoEmitida);
			ArrayList<Ciudad> ciudadesValidas = generadorDePartidas.obtenerRecorridoLadron();
			ArrayList<ILugar> lugaresEnLaCiudad;

			ComputadoraPolicial computadora = new ComputadoraPolicial(generadorDePartidas.generarListaDeLadrones());

			if (primeraPartida) {
				jugador = new Jugador(nombreDelJugador, ciudadesValidas.get(0), computadora);
				primeraPartida = false;

			} else {
				jugador = new Jugador(nombreDelJugador, ciudadesValidas.get(0), computadora);
				
				//El jugador asciende al rango que tenia
				for(int i=0; i< cantidadArrestosJugador; i++){
					jugador.agregarArresto();
				}
			}

			int tiempoAntesDeDormir = jugador.obtenerTiempoRestante();
			boolean partidaTerminada = false;

			System.out.println("Has sido identificado/a como " + jugador.obtenerNombre() + ".");
			System.out.println("");
			System.out.println("Tu graduacion actual es: " + jugador.obtenerRango().obtenerNombre());
			System.out.println("");
			System.out.println("");
			System.out.println("NOTICIAS");
			System.out.println("");
			System.out.println("Tesoro nacional robado en " + jugador.obtenerCiudadActual().obtenerNombre());
			System.out.println("");
			System.out.println("El objeto Robado ha sido identificado como: " + generadorDePartidas.obtenerObjetoRobado().obtenerNombre());
			System.out.println("");
			System.out.println("Un sospechoso de sexo " + generadorDePartidas.obtenerLadronBuscado().obtenerSexo() + " ha sido visto en el lugar del crimen.");
			System.out.println("");
			System.out.println("");
			System.out.println("Tu mision:");
			System.out.println("");
			System.out.println("Perseguir al ladron desde " + jugador.obtenerCiudadActual().obtenerNombre() + " hasta su escondite y arrestarlo.");
			System.out.println("");
			System.out.println("Tienes "+ jugador.obtenerTiempoRestante() + " horas para atrapar al ladron");
			System.out.println("");
			System.out.println("");
			System.out.println("Buena suerte, " + jugador.obtenerNombre() + ".");

			while (partidaTerminada != true) {

				lugaresEnLaCiudad = jugador.obtenerCiudadActual().obtenerLugares();

				System.out.println("");
				System.out.print("Ciudad actual: " + jugador.obtenerCiudadActual().obtenerNombre());
				System.out.print(" / ");
				System.out.println("Tiempo restante: " + jugador.obtenerTiempoRestante() + " Horas");
				System.out.println("");
				System.out.println("1)_ " + lugaresEnLaCiudad.get(0).obtenerNombre());
				System.out.println("2)_ " + lugaresEnLaCiudad.get(1).obtenerNombre());
				System.out.println("3)_ " + lugaresEnLaCiudad.get(2).obtenerNombre());
				System.out.println("4)_ Computadora Policial");
				System.out.println("5)_ Proximas ciudades a viajar");

				opcionElegida = entradaEscaner.nextInt();
				entradaEscaner.nextLine();

				if (opcionElegida == 5) {
					
					/*
					//Aca voy a mezclar la lista de ciudades a viajar para evitar que la ciudad correcta sea siempre la misma opcion
					ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
					for (int i=0; i < 3; i++){
						listaCiudades.add(jugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(i));
					}
					
					jugador.obtenerCiudadActual().obtenerCiudadesAViajar().clear();
					while (listaCiudades.size() > 0){
						valor = generador.nextInt(listaCiudades.size());
						jugador.obtenerCiudadActual().obtenerCiudadesAViajar().add(listaCiudades.get(valor));
						listaCiudades.remove(valor);
					} */
					
					System.out.println("");
					System.out.println("Ciudades a viajar:");
					System.out.println("");
					System.out.println("1)_ " + jugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(0).obtenerNombre());
					System.out.println("2)_ " + jugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(1).obtenerNombre());
					System.out.println("3)_ " + jugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(2).obtenerNombre());

					jugador.viajar(jugador.obtenerCiudadActual().obtenerCiudadesAViajar().get(entradaEscaner.nextInt() - 1));
					if (jugador.obtenerTiempoRestante() != 0) {
						entradaEscaner.nextLine();

						if (generadorDePartidas.obtenerPasoActual() < (generadorDePartidas.obtenerRecorridoLadron().size() - 1)) {
							if (jugador.obtenerCiudadActual() == ciudadesValidas.get(generadorDePartidas.obtenerPasoActual() + 1)) {
								generadorDePartidas.pasarALaSiguienteCiudadDelRecorrido();
							}
						}
					} else {
						System.out.println("El jugador se ha quedado sin tiempo. Ha perdido la partida");
						partidaTerminada = true;
					}

				} else if (opcionElegida == 4) {
					
					System.out.println("Ingrese las caracteristicas del ladron, si alguna no la sabe ingrese la palabra: vacio ");
					System.out.println("");
					System.out.println("Ingrese sexo del sospechoso ");
					String sexo = entradaEscaner.nextLine();
					System.out.println("Ingrese hobby del sospechoso ");
					String hobby = entradaEscaner.nextLine();
					System.out.println("Ingrese cabello del sospechoso ");
					String cabello = entradaEscaner.nextLine();
					System.out.println("Ingrese senia del sospechoso ");
					String senia = entradaEscaner.nextLine();
					System.out.println("Ingrese vehiculo del sospechoso ");
					String vehiculo = entradaEscaner.nextLine();

					jugador.emitirOrdenDeArresto(sexo, hobby, cabello, senia, vehiculo);
					
					if (jugador.obtenerTiempoRestante() != 0) {
						if (jugador.seEmitioOrdenDeArresto()) {
							System.out.println("Orden de arresto emitida contra "+ jugador.obtenerNombreDeLadronBuscado());
						} else
							System.out.println("No se encontro una unica persona con esas caracteristicas. No se pudo emitir una orden de arresto");

					} else {
						System.out.println("El jugador se ha quedado sin tiempo. Ha perdido la partida");
						partidaTerminada = true;
					}
				}

				else {
					Pista pistaObtenida = jugador.visitar(lugaresEnLaCiudad.get(opcionElegida - 1));					
					
					if (jugador.obtenerTiempoRestante() != 0) {
						if (pistaObtenida == juegoGanado) {
							jugador.agregarArresto();
							partidaTerminada = true;
							cantidadArrestosJugador  = cantidadArrestosJugador + 1;

						} else if ((pistaObtenida == ordenDeArrestoIncorrecta)
								| (pistaObtenida == ordenDeArrestoNoEmitida)) {
							partidaTerminada = true;

						}
						System.out.println(pistaObtenida.obtenerContenido());
						entradaEscaner.nextLine();
					} else {
						System.out.println("El jugador se ha quedado sin tiempo. Ha perdido la partida");
						partidaTerminada = true;
					}
				}

				if ((tiempoAntesDeDormir - jugador.obtenerTiempoRestante() > 17) & (partidaTerminada != true)) {

					jugador.dormir();
					if (jugador.obtenerTiempoRestante() != 0) {
						System.out.println("El jugador esta durmiendo");
						tiempoAntesDeDormir = jugador.obtenerTiempoRestante();

					} else {
						System.out.println("El jugador se ha quedado sin tiempo. Ha perdido la partida");
						partidaTerminada = true;
					}
				}

			}

			System.out.println(" 1)_ Desea continuar jugando? ");
			System.out.println(" 2)_ Fin del juego ");

			opcionElegida = entradaEscaner.nextInt();

			if (opcionElegida == 2) {
				juegoTerminado = true;
			}
		}
	}
}