//package a4;
//
//public class HorizontalStackPicture implements Picture {
//
//	//	private Picture left;
//	//	private Picture right;
//	//	private Pixel[][] pix;
//	//
//	//	public HorizontalStackPicture(Picture left, Picture right) {
//	//
//	//		if (left == null) {
//	//			throw new IllegalArgumentException("parameter cannot be null");
//	//
//	//		}
//	//		if (right == null) {
//	//			throw new IllegalArgumentException("parameter cannot be null");
//	//
//	//		}
//	//
//	//		if(left.getWidth() != right.getWidth() ) {
//	//			throw new IllegalArgumentException("Width not equal");
//	//		}
//	//
//	//		this.left = left;
//	//		this.right = right;
//	//
//	//	}
//	private int width;
//	private int height;
//	private Pixel[][]pix;
//
//	public HorizontalStackPicture(Picture left, Picture right) {
//
//		//		int length = left.getWidth() + right.getWidth();
//		//		int height = left.getHeight();
//		//		
//		if(left == null) {
//			throw new IllegalArgumentException("Left or right is null.");
//		}
//		if(right == null) {
//			throw new IllegalArgumentException("Left or right is null.");
//
//		}
//		if(left.getHeight() != right.getHeight()) {
//			throw new IllegalArgumentException("Left and right are not the same height.");
//		}
//
//
//
////		Pixel[][] new_pix = new Pixel[left.getWidth() + right.getWidth()][left.getHeight()];
////
////		for (int i=0; i<left.getWidth(); i++) {
////
////			for (int j=0; j<left.getHeight(); j++) {
////
////				new_pix[i][j] = left.getPixel(i, j);
////
////			}
////
////		}
////
////		for (int p=0; p<right.getWidth(); p++) {
////
////			for (int l=0; l<right.getHeight(); l++) {
////
////				new_pix[p+left.getWidth()][l] = right.getPixel(p, l);
////
////			}
////
////		}
//				this.width = left.getWidth() + right.getWidth();
//				this.height = left.getHeight();
//
////		this.width = new_pix.length;
////		this.height = new_pix[0].length;
////		this.pix = new_pix;
//
//
//	}
//
//
//
//	public int getWidth() {
//		return this.width;
//	}
//
//
//	public int getHeight() {
//		return this.height;
//	}
//
//
//	public Pixel getPixel(int x, int y) {;
////		if(x > getWidth()-1 || y > getHeight()-1) {
////			throw new IllegalArgumentException("Illegal X & Illegal Y");
////		}
////		if(x == getWidth() || y == getHeight()) {
////			throw new IllegalArgumentException("Illegal X & Illegal Y");
////		}
////	
////		if(x >= pix.length) {
////			throw new IllegalArgumentException("Illegal X & Illegal Y");
////		}
////	 x<0
//	if(x < 0) {
//		throw new RuntimeException("X is out of bounds");
//	}
//	if(x >= pix.length) {
//		throw new RuntimeException("X is out bounds");
//	}
//	if(y<0) {
//		throw new RuntimeException("Y is out bounds");
//	}
//	if( y>= pix[0].length) {
//		throw new RuntimeException("Y is out bounds");
//	}
//
//
//	// y<0
//	// y>=pix[0].length
//	//x>=pix.length
//
//	return pix[x][y];
//	}
//
//	// The various forms of the paint() method return a new
//	// picture object based on this picture with certain pixel
//	// positions "painted" with a new value.
//
//	// paint(int x, int y, Pixel p) paints the pixel at
//	// position (x,y) with the pixel value p. The second 
//	// form includes a factor parameter that specifies a
//	// blending factor. A factor of 0.0 leaves the specified
//	// pixel unchanged. A factor of 1.0 results in replacing
//	// the value with the specified pixel value. Values between
//	// 0.0 and 1.0 blend proportionally.
//
//	public Picture paint(int x, int y, Pixel p) {
//
////				if(p == null) {
////					throw new IllegalArgumentException("Null pixel.");
////				}
////				if(x<= -1) {
////					throw new IllegalArgumentException("Illegal x");
////				}
////				if(y<= -1) {
////					throw new IllegalArgumentException("Illegal y");
////				}
////				if(x == getWidth()) {
////					throw new IllegalArgumentException("Illegal x");
////				}
////				if(y == getHeight()) {
////					throw new IllegalArgumentException("Illegal y");
////				}
////		
////				int width = getWidth();
////				int height = getHeight();
////		
////				if(width <= 0) {
////					throw new IllegalArgumentException("Illegal x");
////				}
////				if(height <=0) {
////					throw new IllegalArgumentException("Illegal y");
////				}
//
//
//		pix[x][y] = p;
//
//		return this;
//
//		// just these 2 lines
//
//	}
//
//	public Picture paint(int x, int y, Pixel p, double factor) {
////		if(p==null) {
////			throw new IllegalArgumentException("Null Pixel");
////		}
////		if(x<=-1) {
////			throw new IllegalArgumentException("X is illegal");
////		}
////		if(y<=-1) {
////			throw new IllegalArgumentException("Y is illegal");
////		}
////		if(x == getWidth()) {
////			throw new IllegalArgumentException("X is illegal");
////		}
////		if(y>=getHeight()) {
////			throw new IllegalArgumentException("Y is illegal");
////		}
////		if(factor > 1) {
////			throw new IllegalArgumentException("Illegal factor");
////		}
////		if(factor < 0) {
////			throw new IllegalArgumentException("Illegal factor");
////		}
////
////		Pixel new_pix = new ColorPixel(p.getRed(), p.getGreen(), p.getBlue());
////		p.getBlue();
////
////		new_pix = pix[x][y].blend(p, factor);
////		pix[x][y] = new_pix;
////		return this;
//
//
//				if(p == null) {
//					throw new IllegalArgumentException("Null pixel.");
//				}
//				if(x<= -1) {
//					throw new IllegalArgumentException("Illegal x");
//				}
//				if(y<= -1) {
//					throw new IllegalArgumentException("Illegal y");
//				}
//				if(x == getWidth()) {
//					throw new IllegalArgumentException("Illegal x");
//				}
//				if(y >= getHeight()) {
//					throw new IllegalArgumentException("Illegal y");
//				}
//				if(factor > 1.0) {
//					throw new IllegalArgumentException("Illegal factor");
//				}
//				if(factor < 0.0) {
//					throw new IllegalArgumentException("Illegal factor");
//				}
//				
//		
//				Pixel new_pix = new ColorPixel(p.getRed(), p.getGreen(), p.getBlue());
//				if(pix.length > getHeight()) {
//					throw new IllegalArgumentException("Illegal x");
//				}
//				
//				new_pix = pix[x][y].blend(p, factor);
//				pix[x][y] = new_pix;
//				return this;
//	}
//
//
//	// paint(int ax, int ay, int bx, int by, Pixel p) paints the
//	// rectangular region defined by the positions (ax, ay) and
//	// (bx, by) with the specified pixel value. The second form
//	// should blend with the specified factor as previously described.
//
//	public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
//
//		int a = ax;
//		int b = bx;
//		int c = ay;
//		int d = by;
//
//		if(ax > bx) {
//			b = ax;
//			a = bx;
//		}
//		if(ay > by) {
//			b = ax;
//			a = bx;
//		}
//		for(int i=0; i<pix.length; i++) {
//			for(int j=0; j<pix[0].length; j++) {
//				if(i>= a && i <= b) {
//					if(j>=c && j<= d) {
//						pix[i][j] = p;
//					}
//				}
//			}
//		}
//		return this;
//	};
//	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
//		return null;
//
//	};
//
//	// paint(int cx, int cy, double radius, Pixel p) sets all pixels in the
//	// picture that are within radius distance of the coordinate (cx, cy) to the
//	// Pixel value p.  Only positive values of radius should be allowed. Any
//	// value of cx and cy should be allowed (even if negative or otherwise
//	// outside of the boundaries of the frame). 
//
//	// Calculate the distance of a particular (x,y) position to (cx,cy) with
//	// the expression: Math.sqrt((x-cx)*(x-cx)+(y-cy)*(y-cy))	
//
//	// The second form with factor, blends as previously described.
//
//	public Picture paint(int cx, int cy, double radius, Pixel p) {
//		for(int i=0; i<width; i++) {
//
//			for(int j=0; j<height;j++) {
//				double d =Math.sqrt((i-cx)*(i-cx) + (j-cy)*(j-cy));
//				if(d <= radius){
//					pix[i][j] = p;
//				}
//			}
//		}
//		// looks for every pixel that is within the radius of the circle
//
//		return this;
//	};
//	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
//		return null;
//	};
//
//
//
//
//}
//
//
//
//
//
//
//
//
//
//
//
package a4;


public class HorizontalStackPicture implements Picture {


	private int width;

	private int height;

	private Pixel[][] pix; 


	public HorizontalStackPicture(Picture left, Picture right) {
		/*
		 * These if statements check for IllegalArgumentExceptions where the arguments inputted
		 * are invalid.
		 */

		if (left == null) {

			throw new IllegalArgumentException("Picture cannot be null");

		}

		if (right == null) {

			throw new IllegalArgumentException("Picture cannot be null");

		}

		if (left.getHeight() != right.getHeight()) {

			throw new IllegalArgumentException("Heights cannot be different");

		}


		/*
		 *  This creates a new Pixel that combines the left and right Pictures 
		 *  The first for loop puts in the pixels from the left Picture
		 *  The second for loop puts in the pixels from the right picture but the height starts at where
		 *  the first for loop ended.
		 */

		Pixel[][] new_pix = new Pixel[left.getWidth() + right.getWidth()][left.getHeight()];

		for (int i=0; i<left.getWidth(); i++) {

			for (int j=0; j<left.getHeight(); j++) {

				new_pix[i][j] = left.getPixel(i, j);

			} 

		}

		for (int k=0; k<right.getWidth(); k++) {

			for (int l=0; l<right.getHeight(); l++) {

				new_pix[k+left.getWidth()][l] = right.getPixel(k, l);

			}

		}

		this.width = new_pix.length;

		this.height = new_pix[0].length;

		this.pix = new_pix;
		// These will put in the new values for the combined picture.

	}


/*
 * These are getters which help with the idea of encapsulation so that the methods that need to use these values
 * will be able to use them without changing the actual original value.
 */
	public int getWidth() {

		return this.width;

	}




	public int getHeight() {

		return this.height;

	}




	public Pixel getPixel(int x, int y) {



		if (x < 0){

			throw new RuntimeException("Illegal X value");

		}

		if (x >= pix.length) {

			throw new RuntimeException("X cannot be greater");

		}

		if (y < 0) {

			throw new RuntimeException("Illegal Y value");

		}

		if (y >= pix[0].length) {

			throw new RuntimeException("Y cannot be greater");

		}

		return pix[x][y];

	}




	public Picture paint(int x, int y, Pixel p) {



		pix[x][y] = p;

		return this;

		// It returns this because it is a mutable object

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

		if (ax > bx) {

			ax2 = bx;

			bx2 = ax;

		}

		if (ay > by) {

			ax2 = bx;

			bx2 = ax;

		}



		/*
		 * This for loop will find the pixel that corresponds to the if statements and change that pixel in pix to the value
		 * of the constructor.
		 */

		for (int i=0;i<pix.length;i++) {

			for (int j=0;j<pix[0].length;j++) {

				if (i>=ax2 && i<=bx2) {

					if (j>=ay2 && j<=by2) {

						pix[i][j] = p;

					}

				}

			}

		}

		return this;
		// this returns this because it is a mutable class.

	}




	public Picture paint(int cx, int cy, double radius, Pixel p) {

		/*
		 * This for loop goes through the width and height and it finds the area that the circle is in.
		 * This area is found using the distance formula and if the distance of that pixel is within the radius of the circle
		 * then it will be painted.
		 */

		for (int m=0; m<width; m++) {

			for (int n=0; n<height; n++) {
				double d = Math.sqrt(((m-cx)*(m-cx))+((n-cy)*(n-cy)));

				if (d <= radius) {

					pix[m][n] = p;

				}

			}

		}

		return this;

	}



	public Picture paint(int x, int y, Pixel p, double factor) {


		if (p == null) {

			throw new IllegalArgumentException("Null pixel");

		}

		if (x <= -1) {

			throw new IllegalArgumentException("X is illegal value");

		}

		if (y <= -1) {

			throw new IllegalArgumentException("Y is illegal value");

		}

		if (x == getWidth()) {

			throw new IllegalArgumentException("X is illegal value");

		}

		if (y >= getHeight()) {

			throw new IllegalArgumentException("Y is illegal value");

		}

		if (factor > 1.0) {

			throw new IllegalArgumentException("Illegal factor value");

		}

		if (factor < 0) {

			throw new IllegalArgumentException("Illegal factor value");

		}

		// These check for illegal arguments in which the argument is invalid. 


		/* This creates a new ColorPixel so that the new pixel can blend using the factor.
		 * It returns this because it is a mutable class.
		 */

		Pixel new_pix = new ColorPixel(p.getRed(), p.getGreen(), p.getBlue());

		new_pix = pix[x][y].blend(p, factor);

		pix[x][y] = new_pix;

		return this;

	}



	public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {

	

		return null;

	}



	public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {


		return null;

	}

}

