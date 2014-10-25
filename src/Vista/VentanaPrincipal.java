package Vista;
import javax.swing.*;
public class VentanaPrincipal {

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
		int iniciopanelopciones=(int)ancho*5/6;
		paneldeopciones.setBounds(iniciopanelopciones, 0, (int)anchopanelopciones,(int) altopanelopciones);
		paneldeopciones.setLayout(null);
		ventana.getContentPane().add(paneldeopciones);
		
		paneldeopciones.add(new BtnMarcarObstaculos(iniciopanelopciones, alto/10,(int) anchopanelopciones*9/10, (int)altopanelopciones/10));
		paneldeopciones.add(new BtnMarcarSalida(iniciopanelopciones, alto*3/10, (int) anchopanelopciones*9/10, (int)altopanelopciones/10));
		paneldeopciones.add(new BtnMarcarLlegada(iniciopanelopciones, alto/2,(int) anchopanelopciones*9/10,(int) altopanelopciones/10));
		paneldeopciones.add(new BtnEmpezarAlgoritmo(iniciopanelopciones, alto*7/10,(int) anchopanelopciones*9/10,(int) altopanelopciones/10));
		
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
