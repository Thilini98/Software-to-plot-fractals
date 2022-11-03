
import java.awt.*; /* java abstract window toolkit */
import javax.swing.*;
import java.awt.geom.Line2D;

//JuliaPanel class extend from JPanel
public class JuliaPanel extends JPanel {
	
	private final double constX;
	private final double constY;
	// variable store the no. of iterations given by user 
	private final int iterate;
			
	private static final long serialVersionUID = 1L;	
	
	{
		// set the size of the panel
        setPreferredSize(new Dimension(800, 800));	
    }
	
	// Constructor of the class 	
	JuliaPanel(double cx, double cy, int iteration) {
		this.constX = cx;
		this.constY = cy;
		this.iterate = iteration;	
	}
	
	// Method that print a point in the panel given x and y co-ordinates 
	private static void printPoint(Graphics2D frame, Color c, int x,int y) {					

		frame.setColor(c); 
	    frame.draw(new Line2D.Double(x, y, 
	                         x,y)); 
    }
	
	public void paintComponent(Graphics g) {
		
		//  call the paintComponent from parent class
		super.paintComponent(g);
		Color c ;	
		// iterate over pixels in x and y co-ordinates 
		for (int y = 0; y < 800; y++) {
            for (int x = 0; x < 800; x++) {
            	
            	// create a julia number based on given parameters 
            	ComplexJ  oldz = new ComplexJ(x,y);
            	ComplexJ newz = new ComplexJ();
				int i=0;
				
				// get the no. of iterations until abs(Z) < 2
				while( (ComplexNum.absoluteZ(newz) < 2)&&(i < this.iterate) ) {
					newz = oldz.add(this.constX,this.constY);        // Z(n+1) = Z(n) +C							
					oldz = newz;                 					 //Z(n) = Z(n+1)
					i++;
				}
								
				if(i == this.iterate) {
					// set color to black if the number in julia set   
					c= Color.BLACK;
				}else {
					// set color based on no. of iterations done for abs(Z) >2  where number is not in julia set
					float Hue = i/256f;
				    c = Color.getHSBColor(Hue, 1, 1);
				}
				// print the point based on x any co-ordinates and color 
				printPoint((Graphics2D)g, c,x,y);
			
             }
		}
	}
	
	
}
	
	