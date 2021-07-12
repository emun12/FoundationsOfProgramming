package a5;

public class TunaPortion extends Ingredient_portion_parent implements IngredientPortion {

	private double amount;
	private IngredientPortion ing_p;
	//private Avocado avo = new Avocado();

	//	public AvocadoPortion(Ingredient Avocado, double amount) {
	//		super(Avocado, amount);
	//	}
	//	

	public TunaPortion(double amount) {
		//this(new Avocado, amount);
		super(new Tuna(), amount);
		// amount is in ounces.

		//avo = new Avocado();
		this.amount = amount;
		if(amount < 0) {
			throw new IllegalArgumentException("amount cannot be zero");
		}
		// this.amount = amount;
	}




	@Override
	public IngredientPortion combine(IngredientPortion other) {

		if(other == null) {
			return this;
		}  
		if(this.getIngredient().equals(other.getIngredient())) {
			// IngredientPortion ing_new = ing_p + other;
			//IngredientPortion ing_new = this.getAmount() + other.getAmount();

			// make a new IngredientPortion ing_new but its getAmount() is equal
			// to the amount of the original + amount of other


			double total_amount = this.getAmount() + other.getAmount();


			//IngredientPortion ing_new = (new Avocado(), total_amount);
			//	IngredientPortion p = new IngredientPortion();
			IngredientPortion a = new TunaPortion(total_amount);
			return a;


		} 
		else if (!other.getIngredient().equals(this.getIngredient())){ 

			throw new IllegalArgumentException("Ingredients are different");
		}
		else {
			return this;
		}

	}
}