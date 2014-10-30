package Vista;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import Controlador.Controlador;

public class BtnMarcarObstaculos extends JButton{
	
	Controlador controlador;
	public BtnMarcarObstaculos(int x, int y,int width ,int height,Controlador controlador2)
	{
		this.controlador = controlador2;
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setEnabled(true);
		this.setText("Obstaculos");
		this.setBackground(Color.RED);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				controlador.setEstadoObstaculo();
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
