package a2;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);


		int total_ingredient = 0;
		int total_recipe = 0;
		int recipe_item_count =0;
		// These variables are initialized so that I can add scanner values in them.

		String temp = "";
		total_ingredient = scan.nextInt();
		String[][] ingredient_details = new String[total_ingredient][2]; 
		String[][] recipe_details = new String[1000][3];		
		// These arrays are going to store details of the order name, ounces, and ingredients used
		// Note: These arrays are stored as Strings so that the 2D array can hold in all the variables needed.
		// At the end, the string will be changed into a double for the ounces used.

		/* loop to store name of ingredient in the array
		 * Input: name of the ingredient used
		 * Output: an array of the ingredient names all in the first column of the 2D array
		 */
		for(int i=0; i < total_ingredient; i++) {

			ingredient_details[i][0] = scan.next();

			temp = scan.next();
			temp = scan.next();
			temp = scan.next();
		}


		total_recipe = scan.nextInt();
		// This is the amount of recipes the customer can choose orders from

		int counter = 0;
		// Counts a row for each recipe ordered

		/* Double for loop used to add recipe names, ingredient names, and ounces of the ingredients used in a 2D array.
		 * Input: name of the recipes, ingredients used in each recipe, ounces of each ingredient in different recipes.
		 * Output: Name of recipe in first column, one ingredient used in second column, and ounce of that ingredient used
		 * in third column.
		 * Note: This creates a 2D array with as many rows as needed to go through each recipe and 3 columns
		 * for the name of the recipe, its ingredient used, and ounces of the ingredient used.
		 * Note: The counter is used so that each row will have different ingredients used in one recipe but the recipe name
		 * in the first column will stay the same until it is a new recipe.
		 */
		for(int i=0; i < total_recipe; i++) {
			String recipe_name = scan.next();

			recipe_item_count = scan.nextInt();
			//This stores the details for each ingredient

			for(int j=0; j < recipe_item_count; j++) {
				recipe_details[counter][0] = recipe_name;
				recipe_details[counter][1]=scan.next();
				recipe_details[counter][2]=scan.next();

				counter=counter+1;	
			}
		}



		String[] order_details = new String[1000];
		double[] ingredient_weight = new double [total_ingredient];
		// The first array will store in the name of the recipe ordered by the customer.
		// The second array will be the array that will be printed at the end that has the total 
		// ounces of each ingredient used.

		/* While loop to go through each recipe ordered.
		 * Input: name of the order and the end of the order noted by the string "EndOrder" 
		 * Output: An array of all the orders.
		 * Note: Could not use a for loop since you did not know how many orders the customer
		 * will order beforehand.
		 */

		int count = 1;
		int counter_array = 0;
		while(count > 0) {


			String next_order = scan.next();
			if(next_order.equals("EndOrder")) {
				count = 0;
			}
			else {
				order_details[counter_array] = next_order;			
				counter_array++;

			}



		}

		/* Triple for loop to find the total ounces of ingredients used from all the orders.
		 * Input: Arrays: ingredient details, recipe details, and ingredient weight.
		 * Output: The total ounces of ingredients used.
		 * Note: First for loop goes through each of the orders.
		 * Second for loop finds whether the ingredients used matches an ingredient first initialized
		 * at the beginning.
		 * Third for loop adds in the ounces of the ingredients used for each order.
		 * Note: Had to use Double.parseDouble() because the arrays I made were all String types so
		 * to get the output as a number, I had to change the type to a double.
		 */

		for(int i=0; i<counter_array; i++) {

			for(int j=0; j<1000; j++) {

				if(order_details[i].equals(recipe_details[j][0])) {

					for(int k=0; k<total_ingredient;k++) {

						if(recipe_details[j][1].equals(ingredient_details[k][0])) {

							ingredient_weight[k] += Double.parseDouble(recipe_details[j][2]);
						}
					}
				}
			}
		}

		scan.close();
		// Close the scanner since everything is done.

		/* Print statement with a for loop to go through each ingredient used.
		 * Input: array of ingredient weight and ingredient details.
		 * Output: number of ounces used for each ingredient.
		 */

		System.out.println("The order will require:");

		for(int i=0; i< total_ingredient; i++) {
			System.out.println(String.format("%.2f", ingredient_weight[i])+" ounces of "+ ingredient_details[i][0]);
		}

	}
}
