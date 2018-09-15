package visual.componentes;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelTiempoAgotado {
	
	private JPanel tiempoAgotadoPanel = new JPanel();
	
	public PanelTiempoAgotado(JFrame unaVentana,String nombre,int arrestos){
		
		tiempoAgotadoPanel.setLayout(null);
		JLabel tiempoAgotadoTitulo = new JLabel("Tiempo agotado");
		tiempoAgotadoTitulo.setFont(new Font("Arial",Font.BOLD,20));
		tiempoAgotadoTitulo.setBounds(20,35,660,30);
		tiempoAgotadoPanel.add(tiempoAgotadoTitulo);
		
		JTextArea areaTexto = new JTextArea(
				"El tiempo de busqueda paso del Domingo a las 17 hs y ha terminado. Has perdido la partida."
				+ "\n"
				+ "\n"	
				+ "Seleccione Siguiente para iniciar el siguiente caso, ¿estas prepardo/a?"
				);
		
		areaTexto.setOpaque(false);
		areaTexto.setFocusable(false);
		areaTexto.setFont(new Font("Arial",Font.BOLD,14));
		areaTexto.setLineWrap(true);
		areaTexto.setWrapStyleWord(true);
		areaTexto.setBounds(15,105,660,250);
		tiempoAgotadoPanel.add(areaTexto);
		
		JButton botonComenzar = new JButton("Siguiente");
		botonComenzar.setBounds(296,370,100,30);
		botonComenzar.addActionListener(new CargarSiguienteCaso(unaVentana,nombre,arrestos));
		tiempoAgotadoPanel.add(botonComenzar);
		
		ImageIcon imagen = new ImageIcon("src/visual/recursos/AlgoThieftPantallaBienvenida_img.jpg");
		JLabel fondo = new JLabel(imagen);
		fondo.setBounds(0,0,695,450);
		tiempoAgotadoPanel.add(fondo);
		
	}
	
	public JPanel obtenerPanel(){
		return tiempoAgotadoPanel;
	}

}
