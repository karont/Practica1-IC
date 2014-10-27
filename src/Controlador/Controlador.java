package Controlador;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.util.Deque;

//import javax.swing.JButton;
import javax.swing.JOptionPane;

import Modelo.Casilla;
import Modelo.Logica;
import Modelo.Mapa;
import Vista.Celda;
import Vista.PanelCeldas;
import Vista.VentanaPrincipal;

public class Controlador {
	
	enum Marcarcasilla{salida,llegada,obstaculo,nada};
	Marcarcasilla estado = Marcarcasilla.nada;
	VentanaPrincipal ventana;
	Mapa mapa;
	boolean terminado;
	
	public void arrancaaplicacion()
	{
		ventana = new VentanaPrincipal(this);
		mapa = new Mapa(10,10);
		terminado = false;
	}
	public void reiniciaraplicacion()
	{
		ventana.dispatchEvent(new WindowEvent(ventana, WindowEvent.WINDOW_CLOSING));
		arrancaaplicacion();
	}
	public void setEstadoSalida()
	{
		if(terminado == true)
		{
			reiniciaraplicacion();
		}
		this.estado = Marcarcasilla.salida;
	}
	public void setEstadoLLegada()
	{
		if(terminado == true)
		{
			reiniciaraplicacion();
		}
		this.estado = Marcarcasilla.llegada;
	}
	public void setEstadoObstaculo()
	{
		if(terminado == true)
		{
			reiniciaraplicacion();
		}
		this.estado= Marcarcasilla.obstaculo;
	}
	public void setEstadoNada()
	{
		if(terminado == true)
		{
			reiniciaraplicacion();
		}
		this.estado = Marcarcasilla.nada;
	}
	public void marcarCelda(Celda celda )
	{
		if(terminado == true)
		{
			reiniciaraplicacion();
		}
		switch(estado)
		{
			case salida:
				
				if(celda.isMarcadacomollegada())
				{
					celda.setMarcadacomollegada(false);
					((PanelCeldas)ventana.getContentPane().getComponent(0)).setLlegadaMarcada(null);
				}
				else if(celda.isMarcadacomoobstaculo())
				{
					celda.setMarcadaComoObstaculo(false);
					mapa.removeObstaculo(celda.getposx(),celda.getposy());
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
				else if(celda.isMarcadacomoobstaculo())
				{
					celda.setMarcadaComoObstaculo(false);
					mapa.removeObstaculo(celda.getposx(),celda.getposy());
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
					else if(celda.isMarcadacomoobstaculo())
					{
						celda.setMarcadaComoObstaculo(false);
						celda.setBackground(null);
						mapa.removeObstaculo(celda.getposx(),celda.getposy());
					}
					else
					{
						celda.setBackground(Color.RED);
						celda.setMarcadaComoObstaculo(true);
						mapa.setObstaculo(celda.getposx(),celda.getposy());
					}
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
		Logica logica = new Logica(mapa, salida.getposx(), salida.getposy(), llegada.getposx(),llegada.getposy());
		Deque<Casilla> solucion = logica.algoritmo();
		if (solucion != null)
		{
			while( solucion.size()>0)
			{
				panel.getceldaenpos(solucion.getFirst().nodo.x, solucion.getFirst().nodo.y).setBackground(new Color(232,241,114));
				solucion.removeFirst();
			}
			terminado = true;
		} else {
			new JOptionPane();
			JOptionPane.showMessageDialog(null,"No hay camino posible para alcanzar la meta.");
		}
	}
}
