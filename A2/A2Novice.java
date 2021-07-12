package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int number_of_ingredients = scan.nextInt();
		// This variable will store the total number of ingredients possible.

		String[] food_names = new String[number_of_ingredients];
		double[] food_price = new double[number_of_ingredients];
		String[] is_veg = new String[number_of_ingredients];
		int[] calories = new int[number_of_ingredients];
		// These arrays will store in the name of the food, its price,
		// whether it is vegetarian or not, and the calories.

		/*For loop to add in the details of the food, its price, its vegetarian status
		 * and calories in 4 separate arrays.
		 * Input: 4 arrays that are empty
		 * Output: 4 arrays that are filled
		 * Note: These arrays will be accessed later to find the lowest
		 * and highest number of calories.
		 */
		for(int i=0; i<number_of_ingredients; i++) {
			food_names[i] = scan.next();
			food_price[i] = scan.nextDouble();
			is_veg[i] = scan.next();
			calories[i] = scan.nextInt();
		}

		int count_veg = 0;
		// This counts how many foods are vegetarian.

		for(int j=0; j<number_of_ingredients; j++) {
			if(is_veg[j].contentEquals("true")) {
				count_veg++;
			}
		} 
		// This for loop finds all the vegetarian items in the array and counts them.

		String high = highest_calories(food_price, calories, food_names);
		String low = lowest_calories(food_price, calories, food_names);
		// These variables call the helper functions used to find the highest
		// and lowest calories.

		scan.close();
		// Scanner is closed since all input is scanned.

		System.out.println("Number of vegetarian ingredients: " +count_veg);
		System.out.println("Highest cals/$: " + high);
		System.out.println("Lowest cals/$: " + low);
		// Print statements to print the number of vegetarian options,
		// the food with the highest and lowest calories.
	}


	/* Helper function to find the food with the highest number of calories.
	 * Input: price of each food, its calories, and the name of the foods.
	 * Output: the name of the food with the highest number of calories per ounce.
	 * Note: The price is used to find the number of calories per ounce.
	 */
	static String highest_calories(double[] price, int[] cal, String[] name) {

		double current = (cal[0]/price[0]);
		String highest_food = name[0];

		for(int i=0; i<price.length; i++) {
			double next = (cal[i]/price[i]);

			if(current < next) {
				current = next;
				highest_food = name[i];
			}
		}

		return highest_food;

	}

	/* Helper function used to find the food with the lowest calories per ounce.
	 * Input: price of each food, its calories, and names.
	 * Output: the name of the food with the lowest calories per ounce.
	 */

	static String lowest_calories(double[] price, int[] cal, String[] name) {

		double current = (cal[0]/price[0]);
		String lowest_food = name[0];

		for(int i=0; i<price.length; i++) {
			double next = (cal[i]/price[i]);

			if(current > next) {
				current = next;
				lowest_food = name[i];
			}
		}

		return lowest_food;

	}

}
