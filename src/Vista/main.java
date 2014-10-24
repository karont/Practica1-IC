package Vista;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana = new JFrame("Algoritmo A*");
		int ancho = 800;
		int alto = 600;
		ventana.setSize(ancho, alto);
		ventana.setResizable(false);
		ventana.getContentPane().setFocusable(false);
		ventana.setFocusable(false);
		
		JPanel paneldeceldas = new JPanel();
		double anchopanelceldas =ancho*5/6;
		double altopanelceldas =  alto*19/20;
		paneldeceldas.setBounds(0, 0, (int)anchopanelceldas,(int)altopanelceldas);
		paneldeceldas.setLayout(null);
		ventana.getContentPane().add(paneldeceldas);
		
		JPanel paneldeopciones = new JPanel();
		double anchopanelopciones = ancho - anchopanelceldas;
		double altopanelopciones = alto;
		paneldeopciones.setBounds((int)ancho*5/6, 0, (int)anchopanelopciones,(int) altopanelopciones);
		
		
		int numcolumnas = 10;
		int numfilas = 10;
		double anchodelacelda= (anchopanelceldas )/(numcolumnas);
		double altodelacelda= (altopanelceldas) / (numfilas);
		for(int i = 0; i<numcolumnas; i++)
		{
			for (int e = 0; e<numfilas;e++)
			{
				paneldeceldas.add(new Celda((int)anchodelacelda*i, (int)altodelacelda*e,(int)anchodelacelda,(int)altodelacelda));
			}
		}
		ventana.setVisible(true);
	}

}
