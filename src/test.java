import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class test extends JPanel{
	
		   
		   
		   public static void main(String[] args) {
		      JFrame frame = new JFrame();
		      frame.setTitle("BattleShips");
		      frame.setSize(800,800);
		      frame.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent e) {
		            System.exit(0);
		         }
		      });
		      Container contentPane = frame.getContentPane();
		      contentPane.add(new test());
		      frame.setVisible(true);
		   }
		   
		   public void paintComponent(Graphics g) {
			  int size = 50;
		      super.paintComponent(g);
		      Polygon p = new Polygon();
		      
		      /*for (int j=0; j<= 12; j++) {
			      for (int i=0; i<= 12; i++)  p.addPoint(100+size*i,100+size*j);
			          g.drawPolygon(p);
			      	  p = new Polygon(); 
		      }
		      for (int j=0; j<= 12; j++) {
			      for (int i=0; i<= 12; i++)  p.addPoint(100+size*j,100+size*i);
			          g.drawPolygon(p);
			      	  p = new Polygon(); 
		      }*/
		      
		      
		      for (int j=0; j< 12; j++) {
			      for (int i=0; i< 12; i++) {
			    	  drawSquare(g,100+50*j,100+50*i,50);
			    	  drawCircle(g,125+50*j,125+50*i,40);
			      }
		      }
		     	      
		     
		   }
		   
		   public void drawCircle(Graphics g, int x, int y, int size) { //draws outwards from x,y
			   Polygon p = new Polygon();
			   int limit = 100;
			   for (int j=0; j<= limit; j++)  p.addPoint(x+(int)(size/2*Math.cos(Math.PI*j/limit)),y+(int)(size/2*Math.sin(Math.PI*j/limit)));
			   for (int j=0; j<= limit; j++)  p.addPoint(x-(int)(size/2*Math.cos(Math.PI*j/limit)),y-(int)(size/2*Math.sin(Math.PI*j/limit)));
			   g.drawPolygon(p);
		   }
		   
		   public void drawSquare(Graphics g, int x, int y, int size) { //from top-left corner
			   Polygon p = new Polygon();
			   int limit = 2;
			   for (int j=0; j<= limit; j++)  p.addPoint(x+(int)+j*size/2,y);
			   for (int j=0; j<= limit; j++)  p.addPoint(x,y+j*size/2);
			   for (int j=0; j<= limit; j++)  p.addPoint(x+size-(int)+j*size/2,y+size);
			   for (int j=0; j<= limit; j++)  p.addPoint(x+size,y+size-j*size/2);
			   g.drawPolygon(p);
		   }
}
