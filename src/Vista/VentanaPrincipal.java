package Vista;
import javax.swing.*;
public class VentanaPrincipal extends JFrame{
	final int ANCHO = 800;
	final int ALTO = 600;
	final int margenx =8;
	final int margeny = 8;
	
	public VentanaPrincipal() {
		this.setTitle("Algoritmo A*");
		this.setSize(ANCHO, ALTO);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		this.getContentPane().add(new PanelCeldas(margenx,(ALTO/10)+margeny,ANCHO -2*margenx, ALTO-(ALTO/10)-5*margeny ,10,10));
		this.getContentPane().add(new PanelOpciones(margenx, margeny, ANCHO -2*margenx, ALTO/10));
		
		this.setVisible(true);
	}
		

	public static void main(String[] args) {
		
		VentanaPrincipal ventana = new VentanaPrincipal();		
	}

}
