package a4;

public class ImmutablePixelArrayPicture implements Picture {
	private int width;
	private int height;
	private Pixel[][] pix;
	// These variables need to be private for encapsulation.

	// Creates new object using values provided by pixel_array, matching in size.
	public ImmutablePixelArrayPicture(Pixel[][] pixel_array) {

		if(pixel_array == null) {
			throw new IllegalArgumentException("Pixel 2d array cannot be null");
		}
		// These check for illegal arguments when invalid arguments are inputed.

		for(int k = 0; k<pixel_array.length; k++) {
			if(pixel_array[k] == null) {
				throw new IllegalArgumentException("Columns cannot be null");
			}
		}

		for(int p = 0; p<pixel_array.length; p++) {
			for(int l = 0; l<pixel_array[p].length; l++) {
				if(pixel_array[p][l] == null) {
					throw new IllegalArgumentException("Pixels cannot be null");
				}
			} 
		}

		// These for loops check if any pixel in the pixel_array are null.

		if(pixel_array.length == 0) {
			throw new IllegalArgumentException("Pixel array has illegal geometry.");
		}
		if(pixel_array[0].length == 0) {
			throw new IllegalArgumentException("Pixel array has illegal geometry.");
		}


		// the length cannot be empty as well
		int a = pixel_array[0].length;
		for(int i=0; i<pixel_array.length; i++) {
			if(pixel_array[i].length != a) {
				throw new IllegalArgumentException(	"Columns in picture are not all the same height.");
			}

		}
		// This checks if the columns do not align because they are not equal.

		width = pixel_array.length;
		height = pixel_array[0].length;
		pix = pixel_array;
	}


	// Creates new object by providing geometry and initial value for all pixels.
	public ImmutablePixelArrayPicture(int width, int height, Pixel initial_value) {

		if(width <= 0) {
			throw new IllegalArgumentException("width cannot be 0.");
		}
		if (height <= 0) {
			throw new IllegalArgumentException("Height cannot be 0.");

		}
		if(initial_value == null) {
			throw new IllegalArgumentException("Initial value cannot be 0");
		}

		//These check for illegal arguments that cannot occur


		this.width = width;
		this.height = height;
		this.pix = new Pixel[width][height];

		for(int i=0; i<pix.length; i++) {

			for(int j=0; j<pix[0].length; j++) {

				pix[i][j] = initial_value;

			}
		}

	}

	// Creates new object by providing geometry. Initial value should be medium gray.
	public ImmutablePixelArrayPicture(int width, int height) {



		this.width = width;
		this.height = height;
		this.pix = new Pixel[width][height];

		for(int i=0; i<pix.length; i++) {

			for(int j=0; j<pix[0].length; j++) {

				pix[i][j] = new GrayPixel(.5);

			}
		}

	}


	/*
	 * These are getter methods to get the width, height, and pixel that is specified.
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
		if(x >= pix.length) {
			throw new IllegalArgumentException("x is illegal");
		}
		if(y < 0) {
			throw new IllegalArgumentException("y is illegal");
		}
		if(y >= pix[0].length) {
			throw new IllegalArgumentException("y is illegal");
		}
		// These check for illegal arguments that cannot occur.


		return pix[x][y];

	}

	public Picture paint(int x, int y, Pixel p) {




		Pixel[][] pix2 = new Pixel[width][height];


		for(int i = 0; i<width; i++) {
			for(int j=0; j<height; j++) {
				pix2[i][j] = pix[i][j];
			}
		}

		pix2[x][y] = p;

		return new MutablePixelArrayPicture(pix2);
		
// This returns a new MutablePixelArrayPicture because it is an immutable object

	}

	
	public Picture paint(int x, int y, Pixel p, double factor) {

		if(p == null) {
			throw new IllegalArgumentException("Null pixel.");
		}
		if(x <= -1) {
			throw new IllegalArgumentException("Illegal x.");
		}
		if (y <= -1) {
			throw new IllegalArgumentException("Illegal y.");

		}
		if(x == getWidth()) {
			throw new IllegalArgumentException("Illegal x.");
		}
		if (y == getHeight()) {
			throw new IllegalArgumentException("Illegal y.");

		}
		if (factor > 1.0) {
			throw new IllegalArgumentException("Illegal factor.");

		}
		if (factor < 0) {
			throw new IllegalArgumentException("Illegal factor.");

		}
		// These are argument exceptions that cannot happen. 
		

		Pixel arr = new ColorPixel(p.getRed(), p.getGreen(), p.getBlue());
		arr = pix[x][y].blend(p, factor);
		pix[x][y] = arr;
		return new MutablePixelArrayPicture(pix);
	}





	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
	
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
		 * in between the rectangle.
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
		//	int width = getWidth();
		//	int height = getHeight();

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

	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
		// These can be used as default methods.
		return null;
	}


}

