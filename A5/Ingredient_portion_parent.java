package a5;

public abstract class Ingredient_portion_parent implements IngredientPortion{

	private Ingredient ing;
	private double amount;
	// private IngredientPortion ing_p;


	public Ingredient_portion_parent(Ingredient ing, double amount) {
		this.ing = ing;
		this.amount = amount;
	//	this.ing_p = ing_p;
	}


	@Override
	public Ingredient getIngredient() {
		return ing;
	}

	@Override
	public double getAmount() {
		//return ing_p.getAmount();
		 return amount;
	}

	@Override
	public String getName() {
		return ing.getName();
	}

	@Override
	public boolean getIsVegetarian() {
		return ing.getIsVegetarian();
	}

	@Override
	public boolean getIsRice() {
		return ing.getIsRice();
	}

	@Override
	public boolean getIsShellfish() {
		return ing.getIsShellfish();
	}

	@Override
	public double getCalories() {
		return getAmount() * ing.getCaloriesPerOunce();
	}

	@Override
	public double getCost() {
		return getAmount() * ing.getPricePerOunce();
	}

//	@Override
//	public IngredientPortion combine(IngredientPortion other) {
//
//		if(other == null) {
//			return ing_p;
//		} 
//
//		if (other.getIngredient() != getIngredient()) {
//			throw new IllegalArgumentException("cannot be unequal.");
//		}
//
//		if(ing.equals(other.getIngredient())) {
//			double total_amount = ing_p.getAmount() + other.getAmount();
////			return new Ingredient_portion_parent(ing, total_amount);
//			
//			IngredientPortion new_ing_p;
//			double t_amount = new_ing_p.getAmount();
//			
//			t_amount = ing.getAmount() + other.getAmount();
//			
//			
//			
//		}
//
//	}


	/*
	 * combine(IngredientPortion other)
	 * 
	 * If other is null, returns this ingredient portion.
	 * Otherwise...
	 * If Ingredient associated with other is equal
	 * to this ingredient, returns new ingredient portion which
	 * represents the combined amounts of this ingredient portion and
	 * the other ingredient portion. Uses equals() method of the
	 * Ingredient interface to test equality.
	 * 
	 * If other ingredient is not equal to this ingredient, 
	 * throws an IllegalArgumentException().
	 */
	
	
	/*
	 * 1.Make a parent class that implements IngredientPortion (Ingredient_portion_parent)
	 * 2.subclasses like AvocadoPortion providing appropriate constructor  & combine
	 */
	
}
