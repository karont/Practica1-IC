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
		
		JPanel panel = new JPanel();
		double anchopanel =800*5/6;
		double altopanel =  600*5/6;
		panel.setBounds(0, 0, (int)anchopanel,(int)altopanel);
		panel.setLayout(null);
		ventana.getContentPane().add(panel);
		
		int numcolumnas = 6;
		int numfilas = 6;
		double anchodelacelda= (anchopanel )/(numcolumnas);
		double altodelacelda= (altopanel) / (numfilas);
		for(int i = 0; i<numcolumnas; i++)
		{
			for (int e = 0; e<numfilas;e++)
			{
				panel.add(new Celda((int)anchodelacelda*i, (int)altodelacelda*e,(int)anchodelacelda,(int)altodelacelda));
			}
		}
		ventana.setVisible(true);
	}

}
