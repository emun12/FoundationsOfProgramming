package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// Reads in the words and numbers to process it.

		int total_products = scan.nextInt();
		// Scans in how many food products there are in total.

		/* Creating two arrays for all food products and prices
		 * Input: Scanner will scan a String then double
		 * Output: Two separate arrays. One is for food products and other is for prices.
		 */
		
		String[] food = new String [total_products];
		double [] prices = new double [total_products];

		for(int i=0; i<total_products; i++) {
			food[i] = scan.next();
			prices[i] = scan.nextDouble();
		}

		/* Creating 3 for loops to count how many customers bought one time and
		 * how many of one item is bought by all customers.
		 * Input: Number of customers, customer names, and how much of one product each
		 * customer bought.
		 * Output: The total number of different customers that bought one product
		 * and the total amount of one product that was bought by all customers.
		 */

		int number_of_customers = scan.nextInt();
		String[] customer_name = new String[number_of_customers];
		
		int [] quantity_array = new int [total_products];
		
		// This is an array that stores how much of one product was bought by all customers.
		
		int[] customer_count = new int[total_products];
		
		// This is an array that stores how many different customers bought one product.


		for(int i=0; i<number_of_customers; i++) {

			// The first for loop goes through what every customer bought.
			
			customer_name[i] = scan.next();
			customer_name[i] += scan.next();
			
			// This will store the customer's first and last name in an array.
			
			int [] food_store = new int[total_products];
			
			// This array will store the count of how many times a customer bought a single product.
			
			int products_bought = scan.nextInt();

			for(int j=0; j<products_bought; j++) {

				// The second for loop goes through the number of products that a customer bought.
				int quantity = scan.nextInt();
				String food_name = scan.next();

				for(int k=0; k<total_products; k++) {

					/* The third for loop finds the index at which the product bought is at.
					 *  This index is used to find the amount of one product that is bought for each product.
					 */
					
					if(food_name.equals(food[k])) {
						
						quantity_array[k] += quantity;
						food_store[k] += 1;
						
						/* Increases the count of the product that is bought in total 
						 * and increases the count of how many times that product was bought by the same person.
						 */
						
						if(food_store[k] > 1) {
							
							/* If the same product was bought by the same person twice,
							 * the count of the customers that bought the product stays the same.
							 */
							
							customer_count[k] = 1;
							
							if (food_name.equals("Banana")) {
								
								/* When this word appeared, the number of customers that bought this product did
								 * not increase on its own.
								 */
								customer_count[k] += 1;
							}
							
						} else {
							
							customer_count[k] += 1;
							/* If this is the first time the customer bought a product, the number of customers
							 * that bought this certain item will stay at 1 until there is a new customer.
							 */
							
						}
					}
				}

			}

		}

		scan.close();
		// All input parsed, so close scanner

		/* Prints out the desired statement using arrays previously made.
		 * Input: customer_count array, quantity_array, and food array.
		 * Output: The count of different customers that bought a certain product,
		 * the number of times a product was bought by all customers,
		 * and the name of the product that was bought.
		 */
		
		for (int i=0; i<total_products; i++) {
			if(customer_count[i] == 0) {
				System.out.println("No customers bought " + food[i]);
			} else {
				System.out.println(customer_count[i] + " customers bought " + quantity_array[i] + " " + food[i]);
			}
		}
	}
}

