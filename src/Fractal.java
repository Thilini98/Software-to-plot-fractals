/*****************************************************
 * 
 * 
 * 
 * E/17/201
 ******************************************************/


import javax.swing.*;

public class Fractal {

	public static void main(String[] args) {
	// Main method 
		
	double[] array1 = new double[5];	//array to get arguments for mandelbrot set 
	array1[0]=-1.0; array1[1] = 1.0; array1[2] = -1.0; array1[3] = 1.0; array1[4] = 1000;
	
	double[] array2 = new double[3];	//array to get arguments for julia set 
	array2[0]=-0.4; array2[1] = 0.6; array2[2] = 1000;
	
	// no arguments given 
	if(args.length == 0) {
		System.out.println("Usage");
		System.out.println("java Fractal Mandelbrot <region of interest-real > <region of interest-complex> <iterations>");
		System.out.println("java Fractal Julia <constant C-real> <Constant C-complex> <iterations>");
		System.exit(0);
	}
	
	// Mandelbrot set printing 
	if(args[0].equals("Mandelbrot")) {
				
		if(args.length == 1) {
			
			
		} else if(args.length == 2) {
			array1[4] = Double.parseDouble(args[1]);
			
		} else if(args.length == 5) {
			for(int i=0; i < args.length-1;i++) 
				array1[i] = Double.parseDouble(args[i+1]);
		       
		} else if(args.length == 6) {
			for(int i=0; i < args.length-1;i++) 
				array1[i] = Double.parseDouble(args[i+1]);
		   
		}else {
			System.out.println("Incorrect usage of arguments");
			System.exit(0);
		}
					 
		// create a frame
        JFrame frame = new JFrame("Mandelbrot Fractal"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // set the content of the frame as one of this Mandelbrot panel
        frame.setContentPane(new MandelbrotPanel(array1[0],array1[1],array1[2],array1[3],(int)array1[4])); 
        frame.pack(); 
	    frame.setLocationRelativeTo(null); 
	    frame.setVisible(true); 
		
			
	// Julia set printing 	
	}else if(args[0].equals("Julia")) {
		
		if(args.length == 1) {
			
		}else if(args.length == 2) {
			 array2[2] = Double.parseDouble(args[1]);
		
		}else if(args.length == 3) {
			for(int i=0; i < args.length-1;i++) 
				array2[i] = Double.parseDouble(args[i+1]);
		
		}else if(args.length == 4) {
			for(int i=0; i < args.length-1;i++) 
				array2[i] = Double.parseDouble(args[i+1]);
			
		}else {
			System.out.println("Incorrect usage of arguments");
			System.exit(0);
		}
		
		// create a frame
        JFrame frame = new JFrame("Julia Fractal"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // set the content of the frame as one of this Mandelbrot panel
        frame.setContentPane(new JuliaPanel(array2[0],array2[1],(int)array2[2])); 
        frame.pack(); 
	    frame.setLocationRelativeTo(null); 
	    frame.setVisible(true); 
		
			
	// Incorrect argument given 
	}else {
		System.out.println("Usage");
		System.out.println("java Fractal Mandelbrot <region of interest-real > <region of interest-complex> <iterations>");
		System.out.println("java Fractal Julia <constant C-real> <Constant C-complex> <iterations>");
		System.exit(-1);

	}

	}

}
