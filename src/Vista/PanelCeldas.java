package Vista;

import javax.swing.JPanel;

import Controlador.Controlador;

public class PanelCeldas extends JPanel{
	
	Celda[][] matrizdeceldas;
	Controlador controlador;
	private Celda salidamarcada;
	PanelCeldas(int inicioenx,int inicioeny,int ancho,int alto , int filas, int columnas, Controlador controlador)
	{
		this.controlador =controlador;
		
		this.setBounds(inicioenx,inicioeny , ancho,alto);
		this.setLayout(null);
		double anchodelacelda= (ancho )/(columnas);
		double altodelacelda= (alto) / (filas);
		matrizdeceldas = new Celda[filas][columnas];
		Celda celdaauxiliar;
		
		for(int i = 0; i<columnas; i++)
		{
			for (int e = 0; e<filas;e++)
			{
				celdaauxiliar = new Celda((int)anchodelacelda*i, (int)altodelacelda*e,(int)anchodelacelda,(int)altodelacelda,i,e,this.controlador);
				this.add(celdaauxiliar);
				matrizdeceldas[i][e]=celdaauxiliar;
			}
		}
	}
	public Celda getSalidaMarcada()
	{
		return salidamarcada;	
	}
	public void setSalidaMarcada(Celda marcada)
	{
		salidamarcada = marcada;
	}
}
