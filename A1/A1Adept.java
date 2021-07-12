package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// Reads in the input to process it.

		int total_products = scan.nextInt();

		/* Create 2 arrays for product names and prices of each product
		 * Input: Names of each product and prices of each product
		 * Output: 2 separate arrays. One array for all names of products and one for 
		 * all prices of the products
		 */
		String[] food = new String [total_products];
		double [] prices = new double [total_products];

		for(int i=0; i<total_products; i++) {
			food[i] = scan.next();
			prices[i] = scan.nextDouble();
		} 

		/* Creating 3 for loops to total up the amount of money each individual customer spent.
		 * Input: Total amount of customers, number of products each customer bought, and price of each product.
		 * Output: An array with the amount each customer spent in total.
		 */

		int total_number_of_customers = scan.nextInt();
		double[] individual_cost = new double [total_number_of_customers];
		String[] customer_name = new String [total_number_of_customers];


		for(int i=0; i<total_number_of_customers; i++) {

			// The first for loop will go through the total amount of customers.

			customer_name[i] = scan.next(); 
			customer_name[i] += " " + scan.next();

			// This will store the customer's first and last name in an array.

			int number_of_products = scan.nextInt();

			double overall_cost = 0.0;

			// This variable will sum up the total amount a customer spent.

			for(int j=0; j<number_of_products; j++) {

				// The second for loop goes through the total amount of products a customer bought.

				int quantity = scan.nextInt();
				String food_name = scan.next();

				double cost = 0.0; 

				for(int k=0; k<total_products; k++) {

					/* The third for loop finds and stores the index at which this product was bought and
					 * the index will be used to find the prices of the individual product.
					 */

					if(food_name.equals(food[k])) {
						cost = quantity * prices[k];
						overall_cost = overall_cost + cost;
					} 
				}

				individual_cost[i] = overall_cost;
			}
		}

		/* Variables that call the helper methods and will be used to print out the results 
		 * of the helper methods.
		 */

		String max = max_value(customer_name, individual_cost);
		String min = min_value(customer_name, individual_cost);
		String average = average_value(individual_cost);

		scan.close();
		// All input parsed so close scanner.

		System.out.println("Biggest: " + max);
		System.out.println(" Smallest: " + min);
		System.out.println(" Average: " + average);
		
		// Prints out the desired output using the variables that call the helper functions.

	}

	
	/* Helper function to find the customer that spent the most money.
	 * Input: Array of all customer names, array of the amount of money each customer spent.
	 * Output: The name of the customer that spent the most and how much they spent.
	 */

	static String max_value(String[]name, double[] vals ){

		String spends_most = name[0];
		double current = vals[0];

		for (int i=1; i < vals.length; i++) {

			if (vals[i] > current) {
				current = vals[i];
				spends_most = name[i];
			}

			/* Compares the amount of money spent for each customer and saves the name and value 
			 * of the customer that spent the most.
			 */
		}

		return spends_most + " (" + String.format("%.2f", current) + ")";
	}

	
	/* Helper function to find the customer that spent the least money.
	 * Input: Array of all customer names, array of the amount of money each customer spent.
	 * Output: The name of the customer that spent the least and how much they spent.
	 */

	static String min_value(String[] name, double[] vals) {

		String spends_least = name[0];
		double current = vals[0];

		for (int i=1; i < vals.length; i++) {

			if (vals[i] < current) {
				current = vals[i];
				spends_least = name[i];
			}

			/* Compares the amount of money spent for each customer and saves the name and value 
			 * of the customer that spent the least.
			 */
		}

		return spends_least + " (" + String.format("%.2f", current) + ")";
	}

	
	/* Helper function to find the average amount of money all the customers spent.
	 * Input: Array of the amount of money each customer spent.
	 * Output: The average amount of money spent by all customers.
	 */

	static String average_value(double[] vals) {

		double sum = 0;

		double division = vals.length;
		// Stores the total amount of customers.

		for (int i=0; i<vals.length; i++) {
			sum += vals[i];
		}

		// Sums up the total amount of money spent.

		return String.format("%.2f", sum/division);
	}
	
}



