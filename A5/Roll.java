package a5;
import java.util.ArrayList;

public class Roll implements Sushi{

	private IngredientPortion[] roll;
	private String name;
	private double amt;
	private ArrayList arr;
	//
	public Roll(String name, IngredientPortion[] roll_ingredients) {
		this.name = name;
		//roll = roll_ingredients.clone();
		//	this.amt = 0.0;

		if(roll_ingredients == null) {
			throw new IllegalArgumentException("roll cannot be null");
		}
		for(int i=0; i<roll_ingredients.length; i++) {
			if(roll_ingredients[i] == null) {
				throw new IllegalArgumentException("roll cannot be null");
			}
		}

		//ArrayList<Ingredient> arr1 = new ArrayList<Ingredient>(roll.length);

		int num = 0;
		// this variable will be used as if this was a switch statement
		// and the num is for each case

		for(int j=0; j<roll_ingredients.length; j++) {

			if(roll_ingredients[j].getName().equals("seaweed")) {

				if(roll_ingredients[j].getAmount() < 0.1) { 

					amt = roll_ingredients[j].getAmount();
					num = 1;
					//	roll[j] = new SeaweedPortion(.1);
					//	arr1.add();


				} else {
					num = 2;
				}

			} 

		}

		if(num == 0) {
			IngredientPortion[] a = new IngredientPortion[roll_ingredients.length + 1];

			for(int k=0; k<roll_ingredients.length; k++) {
				a[k] = roll_ingredients[k];
			}

			a[roll_ingredients.length] = new SeaweedPortion(0.1);
			this.roll = a;


			/*
			 * This if statement basically just adds in the roll_ingredients in a new array but leaves the 
			 * last index empty.
			 * Note: It also adds in a new Seaweed portion at the end of the new array
			 */

		} else if ( num == 1) {
			IngredientPortion[] a = new IngredientPortion[roll_ingredients.length+1];

			for(int l=0; l<roll_ingredients.length; l++) {
				a[l] = roll_ingredients[l];
			}
			a[roll_ingredients.length] = new SeaweedPortion(0.1 - amt);
			this.roll = a;
			/*
			 * This if statement is if the amount of seaweed portion is less than .1
			 * If it is less than .1 as indicated by the case for when num == 1 then, 
			 * the new IngredientPortion[] array will take in every other ingredient from the roll_ingredients array
			 * but at the end of the new array, it will now have a new Seaweed Portion that has the remaining
			 * amount of seaweed needed.
			 * Note: .1-amt is the amount of seaweed that is the rest of the seaweed amount out of .1 that is needed
			 * This array will allow you to have 2 Seaweed ingredients inside the one array and their ouncs of 
			 * seaweed will be added together to have .1 ounces
			 */

		} else if ( num == 2) {
			this.roll = roll_ingredients.clone();
			/*
			 * This if statement allows you to just keep the same array as it is since it has
			 * enough of seaweed
			 */
		}
		else {
			this.roll = roll_ingredients.clone();
			/*
			 * This if statement allows you to just keep the same array as it is since it has
			 * enough of seaweed
			 */
		}



		//		// this arrayList will store the non duplicates and new combined ingredients
		//		// with the combined portions
		//		ArrayList<Ingredient> arr = new ArrayList<Ingredient>(roll.length);
		//


		this.arr = new ArrayList(roll_ingredients.length);
		double amt_total = 0.0;


		IngredientPortion ing;
		IngredientPortion ing_other;
		int i = 0;

		for(int k=0; k<roll_ingredients.length; k++) {

			if(roll_ingredients[k].getName().equals(roll_ingredients[i].getName())) {



				ing = roll_ingredients[k];
				ing_other = roll_ingredients[i];

				IngredientPortion temp = ing.combine(ing_other);

				arr.remove(roll_ingredients[k]);
				arr.remove(roll_ingredients[i]);
				arr.add(temp);

				//					amt_total = ing.getAmount() + ing_other.getAmount();
				//					
				//					arr.add(new RicePortion(amt_total));
				//					arr.remove(roll_ingredients[k]);
				//					arr.remove(roll_ingredients[k+1]);



				// If they have the same name, I want to get both of their amounts
				// make and add them (+)
				// then I want to make a new array with the new amount.

				//amt_total  = roll[k].getAmount() + roll[k+1].getAmount();


				//	arr.add(new roll_ingredients[k].getName());
			} else if (roll_ingredients[k].getName().equals(roll_ingredients[i+1].getName())) {

				ing = roll_ingredients[k];
				ing_other = roll_ingredients[i+1];

				IngredientPortion temp = ing.combine(ing_other);

				arr.remove(roll_ingredients[k]);
				arr.remove(roll_ingredients[i+1]);
				arr.add(temp);
			}
//			else if (roll_ingredients[k].getName().equals(roll_ingredients[i+2].getName())) {
//
//				ing = roll_ingredients[k];
//				ing_other = roll_ingredients[i+2];
//
//				IngredientPortion temp = ing.combine(ing_other);
//
//				arr.remove(roll_ingredients[k]);
//				arr.remove(roll_ingredients[i+2]);
//				arr.add(temp);
//			}
//			else if (roll_ingredients[k].getName().equals(roll_ingredients[i+3].getName())) {
//
//				ing = roll_ingredients[k];
//				ing_other = roll_ingredients[k+1];
//
//				IngredientPortion temp = ing.combine(ing_other);
//
//				arr.remove(roll_ingredients[k]);
//				arr.remove(roll_ingredients[i+3]);
//				arr.add(temp);
//			}
//			else if (roll_ingredients[k].getName().equals(roll_ingredients[i+4].getName())) {
//
//				ing = roll_ingredients[k];
//				ing_other = roll_ingredients[i+4];
//
//				IngredientPortion temp = ing.combine(ing_other);
//
//				arr.remove(roll_ingredients[k]);
//				arr.remove(roll_ingredients[i+4]);
//				arr.add(temp);
//			}
//			else if (roll_ingredients[k].getName().equals(roll_ingredients[i+5].getName())) {
//
//				ing = roll_ingredients[k];
//				ing_other = roll_ingredients[i+5];
//
//				IngredientPortion temp = ing.combine(ing_other);
//
//				arr.remove(roll_ingredients[k]);
//				arr.remove(roll_ingredients[i+5]);
//				arr.add(temp);
//			}
			else {
				arr.add(roll_ingredients[k]);
			}

		}
		//
		//		for(int p=0; p<arr.length; p++) {
		//			if(roll)
		//		}


	}

	@Override
	public String getName() {
		return name;
	}


	@Override
	public IngredientPortion[] getIngredients() {


		/*
		 *  Similarly, you should not simply return an encapsulated array reference in order to implement the getIngredients method. 
		 *  You should create a new array to return each time.
		 */
		IngredientPortion[] ing_a = new IngredientPortion[roll.length];

		for(int i=0; i<ing_a.length; i++) {
			ing_a[i] = roll[i];

		}
		return ing_a;
	}

	@Override
	public int getCalories() {

		double total = 0;
		for(int i=0; i<roll.length; i++) {
			total = total + roll[i].getCalories();
		}

		return (int) Math.round(total);

		//		double sum = 0.0;
		//		IngredientPortion[] ing_a = new IngredientPortion[roll.length];
		//
		//		for(int i=0; i<ing_a.length; i++) {
		//			sum = sum + ing_a[i].getCalories();
		//
		//		}
		//
		//
		//		return (int)Math.round(sum);
	}

	@Override
	public double getCost() {

		double y = 0.0;
		//double total = 0.0;


		IngredientPortion[] ing_a = new IngredientPortion[roll.length];
		for(int i=0; i<ing_a.length; i++) {
			ing_a[i] = roll[i];

		}


		for(int j=0; j<ing_a.length; j++) {
			y = y + ing_a[j].getCost();
		}

		y = Math.round(y*100);
		return y/100;



		//		IngredientPortion[] ing_a = new IngredientPortion[roll.length];
		//
		//		double x = 0.0;
		//		double total = 0.0;
		//
		//		for(int i=0; i<ing_a.length; i++) {
		//			ing_a[i] = roll[i];
		//			x = x + ing_a[i].getCost();
		//
		//		}
		//
		//		total = (Math.round(x)*100);
		//		return total/100;
		//
		//
		//		/*
		//		 * 	y = Math.round((ing_a[0].getCost() + ing_a[1].getCost()) * 100); 
		//			total = y / 100;
		//			return total;
		//		 */
	}



	@Override
	public boolean getHasRice() {

		IngredientPortion[] ing_a = new IngredientPortion[roll.length];



		for(int i=0; i<ing_a.length; i++) {
			ing_a[i] = roll[i];
			if(ing_a[i].getIsRice() == true) {
				return true;
			}

		}
		return false;



	}

	@Override
	public boolean getHasShellfish() {
		IngredientPortion[] ing_a = new IngredientPortion[roll.length];



		for(int i=0; i<ing_a.length; i++) {
			ing_a[i] = roll[i];
			if(ing_a[i].getIsShellfish() == true) {
				return true;
			}

		}
		return false;

	}

	@Override
	public boolean getIsVegetarian() {
		return false;

	}



}
