package a4;

public class VerticalStackPicture implements Picture{
	
	private int width;
	private int height;

	private Picture top;
	private Picture bottom;
	private Pixel[][] pix;
	 
	// These variables need to be private for encapsulation.
	

	public VerticalStackPicture(Picture top, Picture bottom) {
		
		
		/*
		 * These are argument exceptions so that if an argument is inputted that cannot happen, it will 
		 * make an error to show that it cannot work.
		 */
		
		if(top == null) {
			throw new IllegalArgumentException("Left or right is null.");
		}
		if(bottom == null) {
			throw new IllegalArgumentException("Left or right is null.");

		}
		if(top.getWidth() != bottom.getWidth()) {
			throw new IllegalArgumentException("Left and right are not the same height.");
		}
		
		
		/*
		 *   This new pixel will be the pixel that combines both the top and bottom picture
		 *   The first for loop inputs the first pixels from top into the new Pixel[][]
		 *   The second for loop inputs the next pixels starting from the height of the last pixels from the first
		 *   for loop. That is why it is l+top.getHeight() so that it doesn't overcode over the pixels
		 *   in the first for loop.
		 */
		Pixel[][] new_pix = new Pixel [top.getWidth()][top.getHeight() + bottom.getHeight()];

		
		for(int j=0; j<top.getWidth(); j++) {
			for(int k=0; k<top.getHeight(); k++) {
				new_pix[j][k] = top.getPixel(j,k);
			}
		}

		for(int p=0; p<bottom.getWidth(); p++) {
			for(int l=0; l<bottom.getHeight(); l++) {
				new_pix[p][l+top.getHeight()] = bottom.getPixel(p,  l);
			}
		}


	

		this.top = top;
		this.bottom = bottom;
		this.width = new_pix.length;
		this.height = new_pix[0].length;
		this.pix = new_pix;

		// The new width and height will be the width and height of the combined new Pixel[][]



	}

	public int getWidth() {
		return this.width;
	}


	public int getHeight() {
		return this.height;
	}

	public Pixel getPixel(int x, int y) {
		
	int p_length = pix.length;
	int p_row_length = pix[0].length;
	
	if(x < 0) {
		throw new RuntimeException("X cannot be negative");
	}
	if(x>= p_length) {
		throw new RuntimeException("X cannot be greater");
	}
	if(y<0) {
		throw new RuntimeException("y cannot be negative");
	}
	if(y>=p_row_length) {
		throw new RuntimeException("Y cannot be greater");
	}

	// These runTimeExceptions will indicate when an argument is invalid.


	return pix[x][y];
	//It returns the pixel at [x][y].
	
	}


	public Picture paint(int x, int y, Pixel p) {

		// This makes the new value of p into the pixel at [x][y].
		// it returns this because this is a mutable class.

		pix[x][y] = p;
		return this;



	}

	public Picture paint(int x, int y, Pixel p, double factor) {
		if(p == null) {
			throw new IllegalArgumentException("Null pixel.");
		}
		if(x<= -1) {
			throw new IllegalArgumentException("Illegal x value");
		}
		if(y<= -1) {
			throw new IllegalArgumentException("Illegal y value");
		}
		if(x == getWidth()) {
			throw new IllegalArgumentException("Illegal x value");
		}
		if(y >= getHeight()) {
			throw new IllegalArgumentException("Illegal y value");
		}
		if(factor > 1.0) {
			throw new IllegalArgumentException("Illegal factor value");
		}
		if(factor < 0) {
			throw new IllegalArgumentException("Illegal factor value");
		}

		// These check for illegal arguments in which the argument is invalid. 
		
		
		/* This creates a new ColorPixel so that the new pixel can blend using the factor.
		 * It returns this because it is a mutable class.
		 */
		
		
		Pixel new_p = new ColorPixel(p.getRed(), p.getGreen(), p.getBlue());
		new_p = pix[x][y].blend(p, factor);
		pix[x][y] = new_p;
		return this;
	}




	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
		
		/*
		 * These int variables will correspond with the arguments so that I can test the arguments without 
		 * having to change the actual argument.
		 */
		
		int ax2 = ax;
		int bx2 = bx;
		int ay2 = ay;
		int by2 = by;
		
		
		/*
		 * These if statements check to see which side/coordinate is biggest so that the actual width
		 * and length will be accurate.
		 */

		if(ax > bx) {
			bx2 = ax;
			ax2 = bx;
		}

		if(ay > by) {

			bx2 = ax;
			ax2 = bx;

		}

		
		/*
		 * This for loop will find the pixel that corresponds to the if statements and change that pixel in pix to the value
		 * of the constructor.
		 */
		
		for(int i=0; i<pix.length; i++) {
			for(int d=0; d<pix[0].length; d++) {
				if(i>=ax2 && d<=bx2) {
					if(d>=ay2 && d <= by2) {
						pix[i][d] = p;
					}
				}
			}
		}
		return this;


	};
	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		return null;
	};



	public Picture paint(int cx, int cy, double radius, Pixel p) {
		
		/*
		 * This for loop goes through the width and height and it finds the area that the circle is in.
		 * This area is found using the distance formula and if the distance of that pixel is within the radius of the circle
		 * then it will be painted.
		 */

		for(int m=0; m<width; m++) {
			for(int n=0; n<height; n++) {
				double d = Math.sqrt(((m-cx)* (m-cx)) + ((n-cy) * (n-cy)));
				if(d <= radius) {
					pix[m][n] = p;
				}
			}



		}
		return this;
		// it returns this because it is a mutable class
	}

	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
		return null;
	};




}


