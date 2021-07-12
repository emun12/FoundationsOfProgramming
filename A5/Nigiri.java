package a5;

public class Nigiri implements Sushi{

	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};


	private NigiriType nigiri;

	public Nigiri(NigiriType type) {
		this.nigiri = type;
	}

	@Override
	public String getName() {
		String name = "";

		switch(nigiri) {
		case TUNA:
			name =  "tuna nigiri";
			return name;


		case YELLOWTAIL:
			

			name = "yellowtail nigiri";
			return name;
		case EEL:
			name = "eel nigiri";
			return name;
			
		case CRAB:
			name = "crab nigiri";
			return name;
			
		case SHRIMP:
			name = "shrimp nigiri";
			return name;
		
		default:
			return name;

		} 
	}

	@Override
	public IngredientPortion[] getIngredients() {
		switch(nigiri) {
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[2];
			ing_a[0] = new TunaPortion(.75);
			ing_a[1] = new RicePortion(.50);
			return ing_a;
			
		
		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[2];
			ing_b[0] = new YellowtailPortion(.75);
			ing_b[1] = new RicePortion(.50);
			return ing_b;
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[2];
			ing_c[0] = new EelPortion(.75);
			ing_c[1] = new RicePortion(.50);
			return ing_c;
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[2];
			ing_d[0] = new CrabPortion(.75);
			ing_d[1] = new RicePortion(.50);
			return ing_d;
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[2];
			ing_e[0] = new ShrimpPortion(.75);
			ing_e[1] = new RicePortion(.50);
			return ing_e;
		default:
			return null;
			
		}
	}

	@Override
	public int getCalories() {
		switch(nigiri) {
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[2];
			ing_a[0] = new TunaPortion(.75);
			ing_a[1] = new RicePortion(.50);
			double sum = ing_a[0].getCalories() + ing_a[1].getCalories();
			return (int)Math.round(sum);
			
		
		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[2];
			ing_b[0] = new YellowtailPortion(.75);
			ing_b[1] = new RicePortion(.50);
			double sum1 = ing_b[0].getCalories() + ing_b[1].getCalories();
			return (int)Math.round(sum1);
			
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[2];
			ing_c[0] = new EelPortion(.75);
			ing_c[1] = new RicePortion(.50);
			double sum2 = ing_c[0].getCalories() + ing_c[1].getCalories();
			return (int)Math.round(sum2);
			
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[2];
			ing_d[0] = new CrabPortion(.75);
			ing_d[1] = new RicePortion(.50);
			double sum3 = ing_d[0].getCalories() + ing_d[1].getCalories();
			return (int)Math.round(sum3);
			
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[2];
			ing_e[0] = new ShrimpPortion(.75);
			ing_e[1] = new RicePortion(.50);
			double sum4 = ing_e[0].getCalories()+ ing_e[1].getCalories();
			return (int)Math.round(sum4);
			
		default:
			return 0;
		}
	}

	@Override
	public double getCost() {
		
		double y = 0.0;
		double total = 0.0;
		
		switch(nigiri) {
		
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[2];
			ing_a[0] = new TunaPortion(.75);
			ing_a[1] = new RicePortion(.50);
			
			y = Math.round((ing_a[0].getCost() + ing_a[1].getCost()) * 100); 
			total = y / 100;
			return total;
			
		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[2];
			ing_b[0] = new YellowtailPortion(.75);
			ing_b[1] = new RicePortion(.50);
			
			y = Math.round((ing_b[0].getCost() + ing_b[1].getCost()) * 100); 
			total = y / 100;
			return total;
			
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[2];
			ing_c[0] = new EelPortion(.75);
			ing_c[1] = new RicePortion(.50);
			
			y = Math.round((ing_c[0].getCost() + ing_c[1].getCost()) * 100); 
			total = y / 100;
			return total;
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[2];
			ing_d[0] = new CrabPortion(.75);
			ing_d[1] = new RicePortion(.50);
			
			y = Math.round((ing_d[0].getCost() + ing_d[1].getCost()) * 100); 
			total = y / 100;
			return total;
		
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[2];
			ing_e[0] = new ShrimpPortion(.75);
			ing_e[1] = new RicePortion(.50);
			
			y = Math.round((ing_e[0].getCost() + ing_e[1].getCost()) * 100); 
			total = y / 100;
			return total;
			
		default:
			return total;
			
		}
		

	}

	@Override
	public boolean getHasRice() {
		switch(nigiri) {
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[2];
			ing_a[0] = new TunaPortion(.75);
			ing_a[1] = new RicePortion(.50);
			if( ing_a[0].getIsRice() == true || ing_a[1].getIsRice() == true) {
				return true;
			}
			

		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[2];
			ing_b[0] = new YellowtailPortion(.75);
			ing_b[1] = new RicePortion(.50);
			if( ing_b[0].getIsRice() == true || ing_b[1].getIsRice() == true) {
				return true;
			}
			
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[2];
			ing_c[0] = new EelPortion(.75);
			ing_c[1] = new RicePortion(.50);
			if( ing_c[0].getIsRice() == true || ing_c[1].getIsRice() == true) {
				return true;
			}
			
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[2];
			ing_d[0] = new CrabPortion(.75);
			ing_d[1] = new RicePortion(.50);
			if( ing_d[0].getIsRice() == true || ing_d[1].getIsRice() == true) {
				return true;
			}
			
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[2];
			ing_e[0] = new ShrimpPortion(.75);
			ing_e[1] = new RicePortion(.50);
			if( ing_e[0].getIsRice() == true || ing_e[1].getIsRice() == true) {
				return true;
			}
			
		default:
			return false;
		}
	}

	@Override
	public boolean getHasShellfish() {
		switch(nigiri) {
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[2];
			ing_a[0] = new TunaPortion(.75);
			ing_a[1] = new RicePortion(.50);
			if( ing_a[0].getIsShellfish() == true || ing_a[1].getIsShellfish() == true) {
				return true;
			}
			

		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[2];
			ing_b[0] = new YellowtailPortion(.75);
			ing_b[1] = new RicePortion(.50);
			if( ing_b[0].getIsShellfish() == true || ing_b[1].getIsShellfish() == true) {
				return true;
			}
			
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[2];
			ing_c[0] = new EelPortion(.75);
			ing_c[1] = new RicePortion(.50);
			if( ing_c[0].getIsShellfish() == true || ing_c[1].getIsShellfish() == true) {
				return true;
			}
			
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[1];
			ing_d[0] = new CrabPortion(.75);
			ing_d[1] = new RicePortion(.50);
			if( ing_d[0].getIsShellfish() == true || ing_d[1].getIsShellfish() == true) {
				return true;
			}
			
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[2];
			ing_e[0] = new ShrimpPortion(.75);
			ing_e[1] = new RicePortion(.50);
			if( ing_e[0].getIsShellfish() == true || ing_e[1].getIsShellfish() == true) {
				return true;
			}
			
		default:
			return false;
		}
	}

	@Override
	public boolean getIsVegetarian() {
		switch(nigiri) {
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[2];
			ing_a[0] = new TunaPortion(.75);
			ing_a[1] = new RicePortion(.50);
			if( ing_a[0].getIsVegetarian() == true && ing_a[1].getIsVegetarian() == true) {
				return true;
			}
			

		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[2];
			ing_b[0] = new YellowtailPortion(.75);
			ing_b[1] = new RicePortion(.50);
			if( ing_b[0].getIsVegetarian() == true && ing_b[1].getIsVegetarian() == true) {
				return true;
			}
			
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[2];
			ing_c[0] = new EelPortion(.75);
			ing_c[1] = new RicePortion(.50);
			if( ing_c[0].getIsVegetarian() == true && ing_c[1].getIsVegetarian() == true) {
				return true;
			}
			
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[2];
			ing_d[0] = new CrabPortion(.75);
			ing_d[1] = new RicePortion(.50);
			if( ing_d[0].getIsVegetarian() == true && ing_d[1].getIsVegetarian() == true) {
				return true;
			}
			
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[2];
			ing_e[0] = new ShrimpPortion(.75);
			ing_e[1] = new RicePortion(.50);
			if( ing_e[0].getIsVegetarian() == true && ing_e[1].getIsVegetarian() == true) {
				return true;
			}
			
		default:
			return false;
		}
	}



}
