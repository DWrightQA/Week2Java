import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class game extends JPanel implements MouseListener {
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(
		        RenderingHints.KEY_ANTIALIASING,
		        RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.blue);
		g2d.fillRect(30, 40, 25*20, 25*20); //x,y,width,height
		g2d.setColor(Color.cyan);
		for (int j=0; j<12; j++) {
			for (int i=0; i<12; i++) g2d.fillRect(40+40*j, 50+40*i, 38, 38); //x,y,width,height	
		}
		g2d.setColor(Color.blue);
		g2d.fillRect(630, 40, 25*20, 25*20); //x,y,width,height
		for (int j=0; j<12; j++) {
			g2d.setColor(Color.cyan);
			for (int i=0; i<12; i++) g2d.fillRect(640+40*j, 50+40*i, 38, 38); //x,y,width,height		
			//g2d.setColor(Color.red);
			//for (int i=0; i<12; i++) g2d.fillOval(40+40*j, 50+40*i, 38, 38);
		}
		
		
	}
	
	public static void main(String[] args) {
		runthis();
	}
	
	public static void runthis() {
		JFrame frame = new JFrame("Battleships");
		frame.add(new game());
		int height = 400;
		int width = 400;
		frame.setSize(width, height);
		MouseListener mouseListener = null;
		frame.addMouseListener(mouseListener);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}