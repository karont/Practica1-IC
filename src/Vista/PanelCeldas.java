package Vista;

import javax.swing.JPanel;

public class PanelCeldas extends JPanel{
	
	PanelCeldas(int inicioenx,int inicioeny,int ancho,int alto , int filas, int columnas)
	{
		this.setBounds(inicioenx,inicioeny , ancho,alto);
		this.setLayout(null);
		double anchodelacelda= (ancho )/(columnas);
		double altodelacelda= (alto) / (filas);
		

		for(int i = 0; i<columnas; i++)
		{
			for (int e = 0; e<filas;e++)
			{
				this.add(new Celda((int)anchodelacelda*i, (int)altodelacelda*e,(int)anchodelacelda,(int)altodelacelda));
			}
		}
	}

}
