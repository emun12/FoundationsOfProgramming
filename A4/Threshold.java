package a4;

public class Threshold implements PixelTransformation {

	private double threshold;
	
	public Threshold (double threshold) {
		
		
		this.threshold = threshold;
	}

	
	public Pixel transform(Pixel p) {
	double thresh = this.threshold;
		if(p.getIntensity() > thresh) {
			return p.lighten(1);
		}
		else {
			return p.darken(1);
		}
	}
	
	
	
}
