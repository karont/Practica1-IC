package Controlador;

import java.awt.Color;

import javax.swing.JButton;

import Vista.Celda;
import Vista.PanelCeldas;
import Vista.VentanaPrincipal;

public class Controlador {
	
	enum Marcarcasilla{salida,llegada,obstaculo,nada};
	Marcarcasilla estado;
	VentanaPrincipal ventana;
	
	public void arrancaaplicacion()
	{
		estado = Marcarcasilla.salida;
		ventana = new VentanaPrincipal(this);
	}
	
	public void marcarCelda(Celda celda )
	{
		switch(estado)
		{
			case salida:
				if(((PanelCeldas)ventana.getContentPane().getComponent(0)).getSalidaMarcada() == null)
				{
					celda.setBackground(new Color(72, 124,210));
					((PanelCeldas)ventana.getContentPane().getComponent(0)).setSalidaMarcada(celda);
				}
				else
				{
					((PanelCeldas)ventana.getContentPane().getComponent(0)).getSalidaMarcada().setBackground(null);
					((PanelCeldas)ventana.getContentPane().getComponent(0)).setSalidaMarcada(celda);
					celda.setBackground(new Color(72, 124,210));
				}
					break;
			case llegada:
					celda.setBackground(new Color(114,250,131));
					break;
			case obstaculo:
					celda.setBackground(Color.RED);
					break;
			case nada:
					break;
		}
		
	}
}
