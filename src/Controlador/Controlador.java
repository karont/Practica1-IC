package Controlador;

import Vista.VentanaPrincipal;

public class Controlador {
	
	enum marcarcasilla{salida,llegada,obstaculo};
	VentanaPrincipal ventana;
	
	public void arrancaaplicacion()
	{
		ventana = new VentanaPrincipal(this);
	}
}
