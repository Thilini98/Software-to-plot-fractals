import java.lang.Math; 

// Class for Complex number 

public class ComplexNum {
	
	public double cX;  // variable store the value of real part of the complex number 
	public double cY;  // variable store the value of imaginary part of the complex number 
		
	// constructors of the class
	
	public ComplexNum() {
		
	}
	
	public ComplexNum(double x, double y) {
		// create a complex number in the default region relative to the co-ordinates  
		this.cX = ((x/800)*2) - 1;
		this.cY = ((y/800)*2) - 1;
	}
	
	// Method return the absolute value of a complex number
	public  static double absoluteZ(ComplexNum c ) {
		// return abs(Z);   
		return Math.sqrt((c.cX*c.cX)+(c.cY*c.cY));
	}
	
	
}
