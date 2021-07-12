package a4;

public class TransformedPicture implements Picture {

	private int width;
	private int height;
	private Pixel[][] pix;
	private Picture source;
	private PixelTransformation xform;

	public TransformedPicture (Picture source, PixelTransformation xform) {
	// you have to transform source Picture into a Pixel[][]
		
		Pixel[][] new_p = new Pixel[source.getWidth()][source.getHeight()];
		for(int i=0; i<source.getWidth(); i++) {
			for(int j=0; j<source.getHeight(); j++) {
				new_p[i][j] = source.getPixel(i, j);
			}
		}
		
		/*
		 * This for loop changes the Picture source into a Pixel[][]
		 * It copies each of the pixels from the Picture into the double array
		 * This is so that later you can access this source Pixel[][] in the getPixel method.
		 */
		this.width = new_p.length;
		this.height = new_p[0].length;
		this.source = source;
		
		this.xform = xform;
		this.pix = new_p;
		
		// These need to correspond to the length of the new Pixel[][] so that it can get the accurate length instead
		// of just being 0.

	}

	/*
	 * These are getter methods that utilize the concept of encapsulation.
	 */

	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}


	public Pixel getPixel(int x, int y) {
		
	
		if(x < 0) {
			throw new IllegalArgumentException("x is illegal");
		}
		if(x >= getWidth()) {
			throw new IllegalArgumentException("x is illegal");
		}
		if(y < 0) {
			throw new IllegalArgumentException("y is illegal");
		}
		if(y >= getHeight()) {
			throw new IllegalArgumentException("y is illegal");
		}
		
		
		
		pix[x][y] = xform.transform(source.getPixel(x, y));
		// this transforms the pixel using source
		return pix[x][y];
		// has to return a new Pixel object and not return.this because it is immutable.

	}

	
	/*The rest of these methods are the same as Monochrome because they are all immutable.
	 * I could use default methods to not have to repeat code but it was also easy to see the code within each class.
	 */
	
	public Picture paint(int x, int y, Pixel p) {
		int width = getWidth();
		int height = getHeight();
		Pixel[][] pix2 = new Pixel[width][height];


		for(int i = 0; i<pix.length; i++) {
			for(int j=0; j<pix[0].length; j++) {
				pix2[i][j] = pix[i][j];
			}
		}

		pix2[x][y] = p;
		Picture a = new MutablePixelArrayPicture(pix2);
		return a;


	}

	// @Override
	public Picture paint(int x, int y, Pixel p, double factor) {

		return null;
	}





	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
		width = getWidth();
		height = getHeight();
		Pixel[][] pix2 = new Pixel[width][height];

		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				pix2[i][j] = pix[i][j];
			}
		}
		// copies everything from pix into pix2

		int ax2 = ax;
		int bx2 = bx;
		int ay2 = ay;
		int by2 = by;

		if(ax > bx) {
			bx2 = ax;
			ax2 = bx;
		}
		if(ay > by) {
			bx2 = ax;
			ax2 = bx;
		}

		/* This checks to find the greatest length between them so it's
		 * easier for the for loop to find the pixels that are
		 * inbetween the rectangle.
		 */


		for(int i=0; i<pix.length; i++) {
			for(int j=0; j<pix[0].length; j++) {
				if(i>= ax2 && i <= bx2) {
					if(j>=ay2 && j<= by2) {
						pix2[i][j] = p;
					}
				}
			}
		}
		/* This for loops checks for if the pixel in the array is within the rectangle
		 * described by ax,ay,bx,by. If it is inbetween the rectangle, then paint it.
		 */


		return new MutablePixelArrayPicture(pix2);
		// returns a new object

	}
	
	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
	
		return null;
	}

	public Picture paint(int cx, int cy, double radius, Pixel p) {
		int width = getWidth();
		int height = getHeight();

		Pixel[][] pix2 = new Pixel[width][height];

		for(int i=0; i<width; i++) {
			for(int j=0; j<height;j++) {
				pix2[i][j] = pix[i][j];
			}
		}
		// copies everything from pix into pix2.


		for(int i=0; i<width; i++) {

			for(int j=0; j<height;j++) {
				double d =Math.sqrt((i-cx)*(i-cx) + (j-cy)*(j-cy));
				if(d <= radius){
					pix2[i][j] = p;
				}
			}
		}
		// looks for every pixel that is within the radius of the circle

		return new MutablePixelArrayPicture(pix2);
	}
	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
		// TODO Auto-generated method stub
		return null;
	}


}


