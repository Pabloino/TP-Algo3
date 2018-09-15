package visual.componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaAcercaDe implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog ventanaAcercaDe = new JDialog();
		JPanel panelDeVentana = new JPanel();
		panelDeVentana.setLayout(null);
		
		ImageIcon imagen = new ImageIcon("src/visual/recursos/AlgoThieftAcercaDe_img.jpg");
		JLabel fondo = new JLabel(imagen);
		panelDeVentana.setBackground(Color.WHITE);
		panelDeVentana.add(fondo);
		fondo.setBounds(42,10,299,84);
		
		JLabel desarrolladores = new JLabel("Desarrolladores:");
		panelDeVentana.add(desarrolladores);
		desarrolladores.setFont(new Font("Arial",Font.BOLD,16));
		desarrolladores.setBounds(130,50,400,160);
		
		JLabel domoni = new JLabel("Luciano Domoni");
		panelDeVentana.add(domoni);
		domoni.setFont(new Font("Arial",Font.BOLD,14));
		domoni.setBounds(137,80,400,160);
		
		JLabel ludueno = new JLabel("Lucas Ludueno");
		panelDeVentana.add(ludueno);
		ludueno.setFont(new Font("Arial",Font.BOLD,14));
		ludueno.setBounds(140,100,400,160);
		
		JLabel inoriza = new JLabel("Pablo Inoriza");
		panelDeVentana.add(inoriza);
		inoriza.setFont(new Font("Arial",Font.BOLD,14));
		inoriza.setBounds(148,120,400,160);			
		
		JLabel tpFinal = new JLabel("TP Final de Algoritmos III - Fiuba. 1C 2014");
		panelDeVentana.add(tpFinal);
		tpFinal.setFont(new Font("Arial",Font.BOLD,14));
		tpFinal.setBounds(52,160,400,160);

		
		ventanaAcercaDe.setTitle("Acerca de Algo Thieft");
		ventanaAcercaDe.setBounds(380,250,400,300);
		ventanaAcercaDe.setResizable(false);
		ventanaAcercaDe.add(panelDeVentana);
		
		ventanaAcercaDe.setVisible(true);		
	}

}
