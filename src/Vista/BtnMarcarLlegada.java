package Vista;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Controlador.Controlador;

public class BtnMarcarLlegada extends JButton{
	
	Controlador controlador;
	public BtnMarcarLlegada(int x, int y,int width ,int height,Controlador controlador)
	{
		this.controlador = controlador;
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setEnabled(true);
		this.setText("Llegada");
		this.setBackground(new Color(114,250,131));
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
			}
		});
	}
}
