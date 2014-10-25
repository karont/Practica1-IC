package Vista;
import javax.swing.*;

import Controlador.Controlador;
public class VentanaPrincipal extends JFrame{
	final int ANCHO = 800;
	final int ALTO = 600;
	final int margenx =8;
	final int margeny = 8;
	Controlador controlador;
	
	public VentanaPrincipal(Controlador controlador) {
		this.setTitle("Algoritmo A*");
		this.setSize(ANCHO, ALTO);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.controlador=controlador;
		
		this.getContentPane().add(new PanelCeldas(margenx,(ALTO/10)+margeny,ANCHO -2*margenx, ALTO-(ALTO/10)-5*margeny ,10,10,this.controlador));
		this.getContentPane().add(new PanelOpciones(margenx, margeny, ANCHO -2*margenx, ALTO/10,this.controlador));
		
		this.setVisible(true);
	}



}
