package a4;

public class GammaCorrect implements PixelTransformation{
	
	private double gamma;
	
	public GammaCorrect (double gamma) {
		this.gamma = gamma;
		
	}

	
	public Pixel transform(Pixel p) {
		
		double red = p.getRed();
		double new_red;
		new_red = Math.pow(red, (1.0/gamma));
		
		
		double green = p.getGreen();
		double new_green;
		new_green = Math.pow(green, (1.0/gamma));
		
		double blue = p.getBlue();
		double new_blue;
		new_blue = Math.pow(blue, (1.0/gamma));
		
		
		Pixel new_pix = new ColorPixel(new_red, new_green, new_blue);
		
		return new_pix;

//		double old = this.gamma;
//		
//		double new_p;
//		
//		new_p = Math.pow(old, (1.0/gamma));
		
		// have to change the intensity for each red, green, and blue
	}
	
	
}
