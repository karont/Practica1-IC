package Controlador;

import java.awt.Color;
import java.util.Deque;

import javax.swing.JButton;

import Modelo.Casilla;
import Modelo.Logica;
import Modelo.Mapa;
import Modelo.Nodo;
import Vista.Celda;
import Vista.PanelCeldas;
import Vista.VentanaPrincipal;

public class Controlador {
	
	enum Marcarcasilla{salida,llegada,obstaculo,nada};
	Marcarcasilla estado;
	VentanaPrincipal ventana;
	Mapa mapa;
	
	public void arrancaaplicacion()
	{
		estado = Marcarcasilla.obstaculo;
		ventana = new VentanaPrincipal(this);
		mapa = new Mapa(10,10);
	}
	
	public void setEstadoSalida()
	{
		this.estado = Marcarcasilla.salida;
	}
	public void setEstadoLLegada()
	{
		this.estado = Marcarcasilla.llegada;
	}
	public void setEstadoObstaculo()
	{
		this.estado= Marcarcasilla.obstaculo;
	}
	public void setEstadoNada()
	{
		this.estado = Marcarcasilla.nada;
	}
	public void marcarCelda(Celda celda )
	{
		switch(estado)
		{
			case salida:
				
				if(celda.isMarcadacomollegada())
				{
					celda.setMarcadacomollegada(false);
					((PanelCeldas)ventana.getContentPane().getComponent(0)).setLlegadaMarcada(null);
				}
				
				if(((PanelCeldas)ventana.getContentPane().getComponent(0)).getSalidaMarcada() == null)
				{
					celda.setBackground(new Color(72, 124,210));
					((PanelCeldas)ventana.getContentPane().getComponent(0)).setSalidaMarcada(celda);
				}
				else
				{
					((PanelCeldas)ventana.getContentPane().getComponent(0)).getSalidaMarcada().setBackground(null);
					((PanelCeldas)ventana.getContentPane().getComponent(0)).getSalidaMarcada().setMarcadacomosalida(false);
					((PanelCeldas)ventana.getContentPane().getComponent(0)).setSalidaMarcada(celda);
					celda.setBackground(new Color(72, 124,210));
				}
				celda.setMarcadacomosalida(true);
				break;
			case llegada:
				
				if(celda.isMarcadacomosalida())
				{
					celda.setMarcadacomosalida(false);
					((PanelCeldas)ventana.getContentPane().getComponent(0)).setSalidaMarcada(null);
				}
				
				if(((PanelCeldas)ventana.getContentPane().getComponent(0)).getLlegadaMarcada() == null)
				{
					celda.setBackground(new Color(114,250,131));
					((PanelCeldas)ventana.getContentPane().getComponent(0)).setLlegadaMarcada(celda);
				}
				else
				{
					((PanelCeldas)ventana.getContentPane().getComponent(0)).getLlegadaMarcada().setBackground(null);
					((PanelCeldas)ventana.getContentPane().getComponent(0)).getLlegadaMarcada().setMarcadacomollegada(false);
					((PanelCeldas)ventana.getContentPane().getComponent(0)).setLlegadaMarcada(celda);
					celda.setBackground(new Color(114,250,131));					
				}
					celda.setMarcadacomollegada(true);
					break;
			case obstaculo:
					if(celda.isMarcadacomosalida())
					{
						celda.setMarcadacomosalida(false);
						((PanelCeldas)ventana.getContentPane().getComponent(0)).setSalidaMarcada(null);
					}
					else if(celda.isMarcadacomollegada())
					{
						celda.setMarcadacomollegada(false);
						((PanelCeldas)ventana.getContentPane().getComponent(0)).setLlegadaMarcada(null);
					}
					celda.setBackground(Color.RED);
					mapa.setObstaculo(new Nodo(celda.getposx(),celda.getposy()));
					//si se quita obstaculo quitarlo del mapa
					break;
			case nada:
					break;
		}
		
	}
	public void calcularRecorrido()
	{
		PanelCeldas panel =((PanelCeldas)ventana.getContentPane().getComponent(0));
		Celda salida =panel.getSalidaMarcada();
		Celda llegada =panel.getLlegadaMarcada();
		Nodo nsalida = new Nodo(salida.getposx(), salida.getposy());
		Nodo nllegada = new Nodo(llegada.getposx(),llegada.getposy());
		Logica logica = new Logica(mapa, nsalida, nllegada);
		Deque<Casilla> solucion = logica.algoritmo();
		
		while( solucion.size()>0)
		{
			panel.getceldaenpos(solucion.getFirst().nodo.x, solucion.getFirst().nodo.y).setBackground(new Color(232,241,114));
			solucion.removeFirst();
		}
	}
}
