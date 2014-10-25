package Vista;

import javax.swing.JPanel;

import Controlador.Controlador;

public class PanelOpciones extends JPanel{
	Controlador controlador;
	PanelOpciones(int inicioenx,int inicioeny,int ancho,int alto,Controlador controlador )
	{
		this.controlador = controlador;
		this.setBounds(inicioenx, inicioeny, ancho,alto);
		this.setLayout(null);
		
		
		this.add(new BtnMarcarObstaculos(0, 0,(int) ancho/4, alto,this.controlador));
		this.add(new BtnMarcarSalida(ancho/4, 0, ancho/4, alto,this.controlador));
		this.add(new BtnMarcarLlegada(ancho/2, 0,ancho/4, alto,this.controlador));
		this.add(new BtnEmpezarAlgoritmo(ancho*3/4, 0,ancho/4, alto,this.controlador));
	}

}
