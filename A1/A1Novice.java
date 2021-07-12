package a1;

import java.util.Scanner;

public class A1Novice {

	static Scanner scan = new Scanner(System.in);
	/* Reads in the inputs to process it.
	 * It is in the class and not main so that the helper
	 * functions can use the scanner.
	 */

	public static void main(String[] args) {

		int total_customers = scan.nextInt();

		/* Finding first initial of first name and last name of customer.
		 * Input: The total amount of customers, first name and last name
		 * of the customer.
		 * Output: The first initial, last name, and total items bought 
		 * by the customer.
		 * 
		 * Note: There are 2 for loops because the first one goes through
		 * each of the customer's first and last names.
		 * The second for loop sums up the total amount that the customer spent.
		 */

		for(int i = 0; i < total_customers; i++) {

			char first_initial = scan.next().charAt(0);
			String last_name = scan.next();

			int total_bought = scan.nextInt();
			double temp = 0.0;

			for(int j = 0; j < total_bought; j++) {

				temp = temp + total_sum();
			}

			System.out.println(first_initial + ". " + last_name + ": " +  String.format("%.2f", temp));
			// Prints out the desired results and formats the total spent into having two decimal places.

		}

		scan.close();
		// All input parsed, so close scanner.
	}

	/* Helper function to sum of the total amount a customer spent.
	 * Input: The total amount of items a customer bought and the prices of each item bought.
	 * Output: Total cost of the items
	 * 
	 * Note: The while loop is used so that the total amount of money spent will continue
	 * until all of the items the customer spent has been accounted for.
	 */
	static double total_sum()  {

		int total_items = scan.nextInt();

		String word = scan.next();
		/* This variable is not used because it is not needed for the final print statement
		 * and the scanner still needs to read the input in order.
		 */

		double price = scan.nextDouble();
		double cost = 0.0;

		while (total_items > 0) {
			cost = cost + price;
			total_items--;
		}

		return cost;

	}

}




