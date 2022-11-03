
// Class that extended from ComplexNum for Julia numbers
public class ComplexJ extends ComplexNum {
	
	// store the value of the no. of iterations that require to get abs(Z)> 2
	public int iterations;
	
	
	// Constructors of the class 
	
	public ComplexJ() {
		super();
	}
	
	public ComplexJ(double x, double y) {
		// create the point in the default region
		this.cX = ((x/800)*2) - 1;
		this.cY = ((y/800)*2) - 1;
	}
	
	// Calculate z^2+C and return the new complex number 
	public ComplexJ add(double constX, double constY) {
		ComplexJ newj  = new ComplexJ();
		
		newj.cX = (this.cX * this.cX) - (this.cY * this.cY) + constX;
		newj.cY = (2.0 * this.cX * this.cY) + constY;
		
		return  newj;
		
	}	
	
}