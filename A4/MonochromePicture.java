package a4;

public class MonochromePicture implements Picture{
	private int width;
	private int height;
	private Pixel[][] pix;



	public MonochromePicture(int width, int height, Pixel value) {
 
		if(width<=0) {
			throw new IllegalArgumentException("Width cannot be 0");
		}
		if(height<=0) {
			throw new IllegalArgumentException("Height cannot be 0");
		}
		if(value == null) {
			throw new IllegalArgumentException("value cannot be null");
		}

		this.width = width;
		this.height = height;
		this.pix = new Pixel[width][height];



		for(int i=0; i<pix.length; i++) {

			for(int j=0; j<pix[0].length; j++) {
				pix[i][j] = value;

			}
		}


		// so this is a good visualization of how to put in values, but this is a constructor
		// so you just need to use the this. something keyword! Also, if you want a for loop, it already gives the
		// width and height so just do
		/*
		 *  for (int i=0; i<width; i++) stuff like that
		 */
	}

	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}


	public Pixel getPixel(int x, int y) {


		//		if(x > getWidth()-1 && y >getHeight()-1) {
		//			throw new IllegalArgumentException("Illegal X");
		//		}
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


		//		int width = getWidth();
		//		int height = getHeight();
		//	Pixel[][] pix = new Pixel[width][height];
		//
		//		
		//		
		//		for(int i=0; i<pix.length; i++) {
		//			pix2[i] = 
		//		}
		//		
		return pix[x][y];

	}

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
		//		Pixel[][] pix = new Pixel[width][height];
		//		
		//		Picture pic = new Picture();
		//		
		//		for(int i=0; i<pix.length; i++) {
		//
		//			for(int j=0; j<pix[0].length; j++) {
		//				if (pix[i][j] == p) {
		//					return pic;
		//				}
		//				
		//			}
		//		}

	}

	// @Override
	public Picture paint(int x, int y, Pixel p, double factor) {

		return null;
	}



	// paint(int ax, int ay, int bx, int by, Pixel p) paints the
	// rectangular region defined by the positions (ax, ay) and
	// (bx, by) with the specified pixel value. The second form
	// should blend with the specified factor as previously described.

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
		
		
//		int width = getWidth();
//		int height = getHeight();
//		Pixel[][] pix2 = new Pixel[width][height];
//		int t_width = bx-ax;
//		int t_height = by-ay;
//		double d = java.lang.Math.sqrt(((t_width)*(t_width)) +((t_height)*(t_height)) );
//
//
//		for(int i = 0; i<pix.length; i++) {
//			for(int j=0; j<pix[0].length; j++) {
//				pix2[i][j] = pix[i][j];
//			}
//		}
//		// this copies everything in pix to pix2
////		for(int i = 0; i<t_width; i++) {
////			for(int j=0; j<t_height; j++) {
////				pix2[i][j] = p;
////			}
////		}
//		
//		for(int i = 0; i<pix.length; i++) {
//			for(int j=0; j<pix[0].length; j++) {
//				if(pix[i][j] < d) {
//					
//				}
//			}
//		}
//		
//		Picture a = new MutablePixelArrayPicture(pix2);
//		return a;
	}
	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
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

	// create all of these as default methods
	/* ** Default methods are only allowed in interfaces**
	 *  for example, for Picture paint (the one with factor parameter) put in default Picture paint(parameters){
	 *  return picture pain(intx,iny,pixel p, 1.0);
	 *  **just need to add in the value of factor and call the previous method you made
	 *  }
	 */
}
