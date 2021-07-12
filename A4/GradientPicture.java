package a4;

public class GradientPicture implements Picture{

	private Pixel[][] pix;
	private int width;
	private int height;
	private Pixel upper_left;
	private Pixel upper_right; 
	private Pixel lower_left;
	private Pixel lower_right;


	public GradientPicture(int width, int height, Pixel upper_left, Pixel upper_right, Pixel lower_left, Pixel lower_right) {
		// make sure the parameters are valid
		// set the corner colors to private fields

		if(width <= 0) {
			throw new IllegalArgumentException("Width is illegal value.");
		}
		if(height <= 0) {
			throw new IllegalArgumentException("Height is illegal value.");
		}
		if(upper_left == null) {
			throw new IllegalArgumentException("Null value for at least one pixel.");
		}
		if(upper_right == null) {
			throw new IllegalArgumentException("Null value for at least one pixel.");
		}
		if(lower_left == null) {
			throw new IllegalArgumentException("Null value for at least one pixel.");
		}
		if(lower_right == null) {
			throw new IllegalArgumentException("Null value for at least one pixel.");
		}




		this.width = width;
		this.height = height;

		this.pix = new Pixel[width][height];
		for(int i=0; i<pix.length; i++) {
			for(int j=0; j<pix[0].length; j++) {
				pix[i][j] = upper_left;
			}
		}


		this.upper_left = upper_left;
		this.upper_right = upper_right;
		this.lower_left = lower_left;
		this.lower_right = lower_right;
	}



	/*
	 * These are getter methods so that the concept of 
	 * encapsulation can be used. This is so that methods that need to use them
	 *  can be used without changing the original value.
	 */
	public int getWidth() {
		//		if(width <= 0) {
		//			throw new IllegalArgumentException("Width is illegal.");
		//		}
		return this.width;
	}
	public int getHeight() {
		//		if(height <= 0) {
		//			throw new IllegalArgumentException("Height is illegal.");
		//		}
		return this.height;
	}	

	public Pixel getPixel(int x, int y) {

		if(x < 0) {
			throw new IllegalArgumentException("x is illegal value");
		}
		if(x >= pix.length) {
			throw new IllegalArgumentException("x is illegal value");
		}
		if(y < 0) {
			throw new IllegalArgumentException("y is illegal value");
		}
		if(y >= pix[0].length) {
			throw new IllegalArgumentException("y is illegal value");
		}

		//
		//		Pixel new_pix = new ColorPixel(upper_left.getRed(), upper_left.getGreen(), upper_left.getBlue());
		//		//new_pix = pix[x][y].blend(, top_right);
		//		pix[x][y] = new_pix;
		//		
		//
		//		return pix[x][y];

		//		for(int i=0; i<pix.length; i++) {
		//			for(int j=0; j<pix[0].length;j++) {
		//				
		//			}
		//		
		//
		//	}

		return pix[x][y];
	}

	public Picture paint(int x, int y, Pixel p) {
		//		int width = getWidth();
		//		int height = getHeight();
		//		Pixel[][] pix2 = new Pixel[width][height];
		//
		//
		//		for(int i = 0; i<pix.length; i++) {
		//			for(int j=0; j<pix[0].length; j++) {
		//				pix2[i][j] = pix[i][j];
		//			}
		//		}
		//
		//		pix2[x][y] = p;
		//		Picture a = new MutablePixelArrayPicture(pix2);
		//		return a;


		Pixel[][] arr = new Pixel[width][height];
		for(int i=0; i<width; i++) {
			for(int k=0; k<height; k++) {
				arr[i][k] = pix[i][k];
			}
		}

		arr[x][y] = p;
		return new MutablePixelArrayPicture(arr);


	}

	// @Override
	public Picture paint(int x, int y, Pixel p, double factor) {



		if(p==null) {
			throw new IllegalArgumentException("Null Pixel");
		}
		if(x <= -1) {
			throw new IllegalArgumentException("X cannot be negative value");
		}
		if(y<= -1) {
			throw new IllegalArgumentException("Y is illegal value");
		}
		if(x==getWidth()) {
			throw new IllegalArgumentException("X is illegal value");	
		}
		if(y==getHeight()) {
			throw new IllegalArgumentException("Y is illegal value");
		}
		if(factor > 1.0) {
			throw new IllegalArgumentException("Illegal factor value");
		}
		if(factor < 0) {
			throw new IllegalArgumentException("Illegal factor value");
		}

		Pixel arr = new ColorPixel(upper_left.getRed(), upper_left.getGreen(), upper_left.getBlue());
		arr = pix[x][y].blend(p, factor);
		pix[x][y] = arr;

		return new MutablePixelArrayPicture(pix);



	}




	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
		//		width = getWidth();
		//		height = getHeight();
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








	@Override
	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Picture paint(int cx, int cy, double radius, Pixel p) {
		

		Pixel[][] arr = new Pixel[width][height];

		for(int i=0; i<width; i++) {
			for(int j=0; j<width; j++) {
				arr[i][j] = pix[i][j];
			}
		}

		for(int a=0; a<width; a++) {
			for(int q=0; q<height; a++) {
				double d = Math.sqrt(((a-cx)*(a-cx))+((q-cy)*(q-cy)));
				if(d <= radius) {
					arr[a][q] = p;
				}
			}
		}
		return new MutablePixelArrayPicture(arr);

		//	int width = getWidth();
		//	int height = getHeight();
		//
		//	Pixel[][] pix2 = new Pixel[width][height];
		//
		//	for(int i=0; i<width; i++) {
		//		for(int j=0; j<height;j++) {
		//			pix2[i][j] = pix[i][j];
		//		}
		//	}
		//	// copies everything from pix into pix2.
		//
		//
		//	for(int i=0; i<width; i++) {
		//
		//		for(int j=0; j<height;j++) {
		//			double d =Math.sqrt((i-cx)*(i-cx) + (j-cy)*(j-cy));
		//			if(d <= radius){
		//				pix2[i][j] = p;
		//			}
		//		}
		//	}
		//	// looks for every pixel that is within the radius of the circle
		//
		//	return new MutablePixelArrayPicture(pix2);
		//}

	}
}
