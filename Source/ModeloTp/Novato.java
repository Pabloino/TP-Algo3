package modeloTp;

public class Novato extends Rango{

	public Novato() {
		
		this.nombre = "Novato";
		this.velocidad = 900;
	}

	public Pista pedirPista(ILugar lugar){
		return lugar.verPistaSegunRango(this);
	}	
}
