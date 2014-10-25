package Vista;

import javax.swing.JPanel;

public class PanelOpciones extends JPanel{
	
	PanelOpciones(int inicioenx,int inicioeny,int ancho,int alto )
	{
		
		this.setBounds(inicioenx, inicioeny, ancho,alto);
		this.setLayout(null);
		
		
		this.add(new BtnMarcarObstaculos(0, 0,(int) ancho/4, alto));
		this.add(new BtnMarcarSalida(ancho/4, 0, ancho/4, alto));
		this.add(new BtnMarcarLlegada(ancho/2, 0,ancho/4, alto));
		this.add(new BtnEmpezarAlgoritmo(ancho*3/4, 0,ancho/4, alto));
	}

}
