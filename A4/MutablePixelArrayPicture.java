package a4;

public class MutablePixelArrayPicture implements Picture{

	private int width;
	private int height;
	private Pixel[][] pix;



	// Should I create a Private Pixel[][] outside here? or 
	// is it fine to just put it inside of the constructor


	// Creates new object using values provided by pixel_array, matching in size. 
	public MutablePixelArrayPicture(Pixel[][] pixel_array) {

		if(pixel_array == null) {
			throw new IllegalArgumentException("Pixel 2d array cannot be null");
		}
		
		for(int i=0; i<pixel_array.length; i++) {
			if(pixel_array[i] == null ) {
				throw new IllegalArgumentException("Columns cannot be null");
			}
		}
		for(int j=0; j<pixel_array.length; j++) {
			for(int k=0; k<pixel_array[j].length; k++) {
				if(pixel_array[j][k] == null) {
					throw new IllegalArgumentException("Pixels cannot be null");
				}
			}
		}
		
		
		if(pixel_array.length == 0) {
			throw new IllegalArgumentException("Width cannot be 0");
		}
		if(pixel_array[0].length == 0) {
			throw new IllegalArgumentException("Height cannot be 0");
		}


		int a = pixel_array[0].length;
		for(int p=0; p<pixel_array.length; p++) {
			if(pixel_array[p].length != a) {
				throw new IllegalArgumentException("Columns in picture are not all the same height. Exception should be thrown.");
			}
		}


		this.width = pixel_array.length;
		this.height = pixel_array[0].length;
		this.pix = pixel_array;


		/*

		int height;
		height = this.height;
		int width;
		width = this.width;

		if(pix[width][height] == null) {
			throw new RuntimeException("pixel_array is empty");
		}

		for(int i=0; i<pixel_array.length; i++) {

			for(int j=0; j<pixel_array[0].length; j++) {

					pix[i][j] = pixel_array[i][j];

			}
		}
		 */

	}

	// Creates new object by providing geometry of picture and an initial value for all pixels.
	public MutablePixelArrayPicture(int width, int height, Pixel initial_value) {

		if(width <= 0) {
			throw new IllegalArgumentException("width is illegal.");
		}
		if (height <= 0) {
			throw new IllegalArgumentException("Height is illegal.");
		}

		/*if(pix.length <= 0) {
			throw new IllegalArgumentException("Illegal x.");
		}
		 */ 


		this.width = width;
		this.height = height;
		this.pix = new Pixel[width][height];

		for(int i=0; i<pix.length; i++) {

			for(int j=0; j<pix[0].length; j++) {

				pix[i][j] = initial_value;

			}
		}

	}

	// Creates new object by providing geometry of picture. 
	// Initial value of all pixels should be medium gray (i.e., a grayscale pixel with intensity 0.5)
	public MutablePixelArrayPicture(int width, int height){
		//		if(pix.length == 0) {
		//			throw new IllegalArgumentException("Pixel 2d array cannot be null");
		//		}


		if(width <= 0) {
			throw new IllegalArgumentException("Pixel array includes null columns.");
		}
		if (height <= 0) {
			throw new IllegalArgumentException ("Pixel array includes null pixels.");
		}


		GrayPixel color = new GrayPixel(.5);

		this.width = width;
		this.height = height;
		this.pix = new Pixel[width][height];

		for(int i=0; i<pix.length; i++) {

			for(int j=0; j<pix[0].length; j++) {

				pix[i][j] = color;
				//pix[i][j] = new GrayPixel(.5);
			}
		}






	}

	@Override
	public int getWidth() {
		return this.width;
	}
	@Override
	public int getHeight() {
		return this.height;
	}
	// getPixel(x, y) retrieves the pixel at position (x,y) in the
	// picture. The coordinate (0,0) is the upper left
	// corner of the picture. The coordinate (getWidth()-1, getHeight()-1)
	// is the lower right of the picture. An IllegalArgumentException
	// is thrown if x or y are not in range.
	public Pixel getPixel(int x, int y) {

		if(x > getWidth()-1 || y > getHeight()-1) {
			throw new IllegalArgumentException("Illegal X & Illegal Y");
		}
		//		if(x == getWidth()-1 && y== getHeight()-1) {
		//			throw new IllegalArgumentException("Illegal X & Illegal Y");
		//		}
		if(x >= pix.length) {
			throw new IllegalArgumentException("Illegal X & Illegal Y");
		}


		//		if(pix.length <= 0) {
		//			throw new IllegalArgumentException("Illegal x.");
		//		} 


		//		if(x < 0) {
		//			throw new IllegalArgumentException("Illegal X");
		//		}
		//		if(y < 0) {
		//			throw new IllegalArgumentException("Illegal y");
		//		}


		/*
		int width = getWidth();
		int height = getHeight();
		Pixel[][] pix2 = new Pixel[width][height];
		pix2 = this.pix;
		 */
		/*	for(int i=0; i<pix.length;i++) {
			for(int j=0; j<pix[0].length; j++) {
				pix[i][j]=
			}
		}

		 */

		return pix[x][y];
	}

	// The various forms of the paint() method return a new
	// picture object based on this picture with certain pixel
	// positions "painted" with a new value.

	// paint(int x, int y, Pixel p) paints the pixel at
	// position (x,y) with the pixel value p. The second 
	// form includes a factor parameter that specifies a
	// blending factor. A factor of 0.0 leaves the specified
	// pixel unchanged. A factor of 1.0 results in replacing
	// the value with the specified pixel value. Values between
	// 0.0 and 1.0 blend proportionally.

	public Picture paint(int x, int y, Pixel p) {

		int width = getWidth();
		int height = getHeight();

		if(width <= 0) {
			throw new IllegalArgumentException("Illegal x");
		}
		if(height <=0) {
			throw new IllegalArgumentException("Illegal y");
		}


		pix[x][y] = p;

		return this;
		// returns the same object but it just changed one pixel.


	}

	public Picture paint(int x, int y, Pixel p, double factor) {

		if(p == null) {
			throw new IllegalArgumentException("Null pixel.");
		}
		if(x<= -1) {
			throw new IllegalArgumentException("Illegal x");
		}
		if(y<= -1) {
			throw new IllegalArgumentException("Illegal x");
		}
		if(x == getWidth()) {
			throw new IllegalArgumentException("Illegal x");
		}
		if(y == getHeight()) {
			throw new IllegalArgumentException("Illegal x");
		}
		if(factor > 1.0) {
			throw new IllegalArgumentException("Illegal factor");
		}
		if(factor < 0.0) {
			throw new IllegalArgumentException("Illegal factor");
		}


		Pixel new_pix = new ColorPixel(p.getRed(), p.getGreen(), p.getBlue());
		new_pix = pix[x][y].blend(p, factor);
		pix[x][y] = new_pix;
		return this;
	};


	// paint(int ax, int ay, int bx, int by, Pixel p) paints the
	// rectangular region defined by the positions (ax, ay) and
	// (bx, by) with the specified pixel value. The second form
	// should blend with the specified factor as previously described.

	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {

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
						pix[i][j] = p;
					}
				}
			}
		}
		/* This for loops checks for if the pixel in the array is within the rectangle
		 * described by ax,ay,bx,by. If it is inbetween the rectangle, then paint it.
		 */
		
		return this;

	}

	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		return null;
	};

	// paint(int cx, int cy, double radius, Pixel p) sets all pixels in the
	// picture that are within radius distance of the coordinate (cx, cy) to the
	// Pixel value p.  Only positive values of radius should be allowed. Any
	// value of cx and cy should be allowed (even if negative or otherwise
	// outside of the boundaries of the frame). 

	// Calculate the distance of a particular (x,y) position to (cx,cy) with
	// the expression: Math.sqrt((x-cx)*(x-cx)+(y-cy)*(y-cy))	

	// The second form with factor, blends as previously described.

	public Picture paint(int cx, int cy, double radius, Pixel p) {
		
		
	
		
		for(int i=0; i<width; i++) {
			for(int j=0; j<height;j++) {
				double d = Math.sqrt((i-cx)*(i-cx) + (j-cy)*(j-cy));
				// this finds the distance that it will paint in.
				if( d <= radius){
					pix[i][j] = p;
				}
			}
		}
		// looks for every pixel that is within the radius of the circle
		
		return this;
		// Just has to return this because it is the same object.
	};
	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
		return null;
	};

}







