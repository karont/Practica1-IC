package Vista;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class BtnMarcarObstaculos extends JButton{
	
	public BtnMarcarObstaculos(int x, int y,int width ,int height)
	{
		this.setBounds(x, y, width, height);
		this.setVisible(true);
		this.setEnabled(true);
		this.setText("Obstaculos");
		this.setBackground(Color.RED);
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
