
// Class that extended from ComplexNum for Mandelbrot numbers
public class ComplexM extends ComplexNum {
	
	// store the value of the no. of iterations that require to get abs(Z)> 2
	public int iterations; 
	
	
	// Constructors of the class
	
	public ComplexM() {
		super();
	}

	public ComplexM(double x, double y, double regx1,double regx2,double regy1,double regy2) {
		// create the complex number in given region of interest 
		super(x,y);
		this.cX = ((x/800)*(regx2-regx1)) + regx1;
		this.cY = ((y/800)*(regy2-regy1)) + regy1 ;
	}
	
	// Calculate z^2+C and return the new complex number 
	private   ComplexM add(ComplexM oldz) {
		ComplexM newm = new ComplexM();
			
		newm.cX = (oldz.cX * oldz.cX) - (oldz.cY * oldz.cY) + this.cX; // real part
		newm.cY = (2.0 * oldz.cX * oldz.cY) + this.cY;                 // imaginary part
		
		return  newm;
	}
	
	// Calculate the maximum no. of iterations while ABS(Z) <= 2
	// Method check weather a number is in mandelbrot set or not 
	public boolean checkM(int ITER) {
		
		 ComplexM nxtz = new ComplexM();
		 ComplexM z = new ComplexM();
		 z.cX = 0;   z.cY = 0;                        // Z0 =0
	
        for (int i=0;i< ITER;i++) { 	
            nxtz = add(z);                           // Z(n+1) = Z(n) +C
           
            if( ComplexNum.absoluteZ(nxtz) > 2) {
            	this.iterations = i;                 // assign the no. of iterations done if abs(Z) > 2
            	return true;
            }else {
            	z = nxtz;                            // Z(n) = Z(n+1)
            }
	    }
       
		return false;                               // return false for a mandelbrot number  
	}
	
    
}
