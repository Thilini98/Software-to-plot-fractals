

import java.awt.*; /* java abstract window toolkit */
import javax.swing.*;
import java.awt.geom.Line2D;

// MandelbrotPanel class extend from JPanel
public class MandelbrotPanel extends JPanel {
	
	private final double regx1;
	private final double regx2;
	private final double regy1;
	private final double regy2;
	// variable store the no. of iterations given by user 
	private final int iterate;
	
	private static final long serialVersionUID = 1L;	
	
	{
		// set the size of the panel
        setPreferredSize(new Dimension(800, 800));	
    }
	
	// Constructor of the class 
	MandelbrotPanel(double x1, double x2, double y1, double y2, int iteration) {
		this.regx1 = x1;
		this.regx2 = x2 ;
		this.regy1 = y1;
		this.regy2 = y2;
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
               	  
            	// create a mandelbrot number based on given parameters 
            	ComplexM num = new ComplexM(x,y,this.regx1,this.regx2,this.regy1,this.regy2);
            	
            	// check wether the number is in mandelbrot set or not
            	if( num.checkM(this.iterate) ) { 
            		
            		int m = num.iterations;                              //get the no. of iterations when abs(Z) > 2 
            		float Hue = (float) (((m/this.iterate)*0.001)+0.611);
            		// set color based on itearations if number is not in mandelbrot set
     				c = Color.getHSBColor(Hue,1 , m/(m+5f));
            	}
            	else {
            		// set the color to black as the number is in mandelbrot set
            		c = Color.BLACK;
            	}
               	// print the point for given co-ordinate and set color 
            	printPoint((Graphics2D)g, c,x,y);
            }
		}
		
	}
	

	
}
