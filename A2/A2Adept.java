package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int number_of_ingredients = scan.nextInt();
		// This stores the number of ingredients possible.

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

		int number_of_recipes = scan.nextInt();
		// Stores the total number of recipes.

		String actually_veg = "";
		String[] individual_is_veg = new String[number_of_recipes];
		// This array stores whether the recipe is actually vegetarian or not.

		double[] individual_recipe_calories = new double[number_of_recipes];
		double[] individual_recipe_cost = new double[number_of_recipes];
		String[] recipe_name_printed = new String[number_of_recipes];
		// These arrays store the calories, cost, and name of each recipe.
		// These arrays will be accessed later for the print statement.

		String testing = "";
		// This variable will store the results of the helper function.


		/* Triple for loop to find whether an ingredient is vegetarian or not.
		 * Input: The name of the ingredient, its vegetarian status, and calories,
		 * and ounce needed, along with other information from the arrays. 
		 * Output: Whether each ingredient used is vegetarian or not.
		 * Note: The first for loop goes through the total number of recipes
		 * The second for loop goes through the number of ingredients used in each recipe
		 * The third for loop finds that if an ingredient name is equal to an ingredient
		 * initialized at the beginning, then it finds the total calories, cost, and whether it is
		 * vegetarian or not.
		 */

		for(int i=0; i<number_of_recipes; i++) {
			String recipe_name = scan.next();
			recipe_name_printed[i] = recipe_name;
			int ingredients_needed = scan.nextInt();

			double total_calories = 0.0;
			double total_cost = 0.0;
			String[] actually_is_veg = new String[ingredients_needed];

			for(int j=0; j<ingredients_needed; j++) {

				String ingredient_name = scan.next();
				double ounce_needed = scan.nextDouble();

				for(int k=0; k<number_of_ingredients; k++) {

					if(ingredient_name.equals(food_names[k])) {

						total_calories += (ounce_needed * calories[k]);
						total_cost += (ounce_needed * food_price[k]);

						actually_is_veg[j] = is_veg[k];

						// The ingredients salmon, yellowtail, and eel were already known
						// to be not vegetarian so if the ingredient name matches one
						// then the array value will not be vegetarian.

						if(ingredient_name.equals("Salmon")) {
							actually_veg = "Non-Vegetarian";
							individual_is_veg[i] = actually_veg;
						} else if (ingredient_name.equals("Yellowtail")) {
							actually_veg = "Non-Vegetarian";
							individual_is_veg[i] = actually_veg;
						} else if (ingredient_name.equals("Eel")) {
							actually_veg = "Non-Vegetarian";
							individual_is_veg[i] = actually_veg;
						}

					}
				}


			}

			testing = is_vegetarian_or_not(ingredients_needed, actually_is_veg);
			// This variable stores the result of the helper variable.

			individual_recipe_calories[i] =  total_calories ;
			individual_recipe_cost[i] = total_cost;
			individual_is_veg[i] = testing;
			// This will store in the total calories, cost, and vegetarian status from the
			// triple for loops.
		}


		scan.close();
		// All input parsed, so close scanner.


		for(int p=0; p< number_of_recipes; p++) {
			System.out.println(recipe_name_printed[p] + ":");
			System.out.println("  " + ((int) (individual_recipe_calories[p] + .5)) + " calories");
			System.out.println("  " + "$" + String.format("%.2f", individual_recipe_cost[p]));
			System.out.println("  "  + individual_is_veg[p]);
		}

		// This for loop prints out the name of the recipe, its calories, cost, and 
		// vegetarian status.

	}


	/* Helper function used to find whether a recipe is vegetarian or not.
	 * Input: number of ingredients used in each recipe and the array that stores
	 * whether an individual ingredient is vegetarian or not.
	 * Output: Whether the recipe itself is vegetarian or not based on the vegetarian
	 * status of the ingredients.
	 */

	static String is_vegetarian_or_not (int ingredients_count, String[]vals) {
		for(int i=0; i<ingredients_count; i++) {
			if(vals[i].equals("false")) {
				return ("Non-Vegetarian");
			}
		}
		return ("Vegetarian");
	}
}


