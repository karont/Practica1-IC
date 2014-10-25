package Vista;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Controlador.Controlador;

public class Celda extends JButton{
	int posicionx;
	int posiciony;
	Controlador controlador;
	boolean marcadacomollegada;
	boolean marcadacomosalida;
	
	public Celda(int x, int y,int width ,int height,int posicionx,int posiciony,Controlador controlador)
	{
		this.controlador = controlador;
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setEnabled(true);
		this.posicionx = posicionx;
		this.posiciony = posiciony;
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				tratarcelda();
			}
		});
	}
	public boolean isMarcadacomollegada() {
		return marcadacomollegada;
	}
	public void setMarcadacomollegada(boolean marcadacomollegada) {
		this.marcadacomollegada = marcadacomollegada;
	}
	public boolean isMarcadacomosalida() {
		return marcadacomosalida;
	}
	public void setMarcadacomosalida(boolean marcadacomosalida) {
		this.marcadacomosalida = marcadacomosalida;
	}
	void tratarcelda()
	{
		this.controlador.marcarCelda(this);
		
	}
	public int getposx()
	{
		return posicionx;
	}
	public int getposy()
	{
		return posiciony;
	}
	
}
