package a5;

public class Ingredient_parent implements Ingredient{

	private String name;
	private int calories_ounce;
	// private double calories_dollar;
	private double price_ounce;
	private boolean is_veg;
	private boolean is_rice;
	private boolean is_shell_fish;

	public Ingredient_parent(String name, double price_ounce, int calories_ounce,
			boolean is_veg, boolean is_rice, boolean is_shell_fish){
		this.name = name;
		this.calories_ounce = calories_ounce;
		// this.calories_dollar = calories_dollar;
		this.is_rice = is_rice;
		this.price_ounce = price_ounce;
		this.is_veg = is_veg;
		this.is_shell_fish = is_shell_fish;
	}

	public String getName() {
		return name;
	}

	@Override
	public double getCaloriesPerDollar() {
		//	return calories_dollar;
		return calories_ounce / price_ounce;
	}

	@Override
	public int getCaloriesPerOunce() {
		return calories_ounce;
	}

	@Override
	public double getPricePerOunce() {
		return price_ounce;
	}

	@Override
	public boolean getIsVegetarian() {
		return is_veg;
	}

	@Override
	public boolean getIsRice() {
		return is_rice;
	}

	@Override
	public boolean getIsShellfish() {
		return is_shell_fish;
	}

	@Override
	public boolean equals(Ingredient other) {

		if(other == null) {
			throw new IllegalArgumentException("other cannot be null");
		} 
//		if(getName().equals(other.getName()) && getCaloriesPerOunce() == other.getCaloriesPerOunce()) {
//			double difference_price = getPricePerOunce() - other.getPricePerOunce();
//			if(difference_price <= .01 && getIsVegetarian() == other.getIsVegetarian()) {
//				if(getIsRice() == other.getIsRice() && getIsShellfish() == other.getIsShellfish()) {
//					return true;
//				}
//			}


		//}
		
		if(getName().equals(other.getName())) {
			if(getCaloriesPerOunce() == other.getCaloriesPerOunce()) {
				if(getPricePerOunce()-other.getPricePerOunce() <= .01) {
					if(getIsVegetarian() == other.getIsVegetarian()) {
						if(getIsRice() == other.getIsRice()) {
							if(getIsShellfish() == other.getIsShellfish()) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;

	}

	/* equals(Ingredient other)
	 * 
	 * If other is null, returns false.
	 * Otherwise...
	 * Compares ingredient to other and returns true if both
	 * ingredients have the same name, same calories per ounce,
	 * is within 1 cent in price per ounce, and has the same 
	 * characteristics with regard to being vegetarian, rice, or 
	 * shellfish.
	 * 
	 */

}
