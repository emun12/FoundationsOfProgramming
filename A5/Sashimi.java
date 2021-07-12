package a5;

public class Sashimi implements Sushi {

	
	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP}

	
	private SashimiType sash;
	
	public Sashimi(SashimiType type) {
		this.sash = type;
		
	}
	
	
	@Override
	public String getName() {
	//	return sash + " Sashimi";
		String name = "";
		
		switch(sash) {
		case TUNA:
			//return SashimiType.TUNA + " sashimi";
//			String total = SashimiType.TUNA.toString() + " sashimi";
			
			name =  "tuna sashimi";
			return name;
			
		
		case YELLOWTAIL:
//			String total1 = SashimiType.YELLOWTAIL.toString() + " sashimi";
//			return total1;
			//return SashimiType.YELLOWTAIL + " sashimi";
			
			name = "yellowtail sashimi";
			return name;
		case EEL:
			name = "eel sashimi";
			return name;
//			String total2 = SashimiType.EEL.toString() + " sashimi"; 
//			return total2;
			//return SashimiType.EEL + " sashimi";
		case CRAB:
			name = "crab sashimi";
			return name;
//			String total3 = SashimiType.CRAB.toString() + " sashimi";
//			return total3;
			//return SashimiType.CRAB + " sashimi";
		case SHRIMP:
			name = "shrimp sashimi";
			return name;
//			String total4 = SashimiType.SHRIMP.toString() + " sashimi"; 
//			return total4;
		//	return SashimiType.SHRIMP + " sashimi";
		default:
			return name;
			 
		} 
	}

	@Override
	public IngredientPortion[] getIngredients() {
		switch(sash) {
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[1];
			ing_a[0] = new TunaPortion(.75);
			return ing_a;
			
		
		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[1];
			ing_b[0] = new YellowtailPortion(.75);
			return ing_b;
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[1];
			ing_c[0] = new EelPortion(.75);
			return ing_c;
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[1];
			ing_d[0] = new CrabPortion(.75);
			return ing_d;
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[1];
			ing_e[0] = new ShrimpPortion(.75);
			return ing_e;
		default:
			return null;
			
		}
	}

	@Override
	public int getCalories() {
		switch(sash) {
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[1];
			ing_a[0] = new TunaPortion(.75);
			double sum = ing_a[0].getCalories();
			return (int)Math.round(sum);
			
		
		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[1];
			ing_b[0] = new YellowtailPortion(.75);
			double sum1 = ing_b[0].getCalories();
			return (int)Math.round(sum1);
			
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[1];
			ing_c[0] = new EelPortion(.75);
			double sum2 = ing_c[0].getCalories();
			return (int)Math.round(sum2);
			
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[1];
			ing_d[0] = new CrabPortion(.75);
			double sum3 = ing_d[0].getCalories();
			return (int)Math.round(sum3);
			
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[1];
			ing_e[0] = new ShrimpPortion(.75);
			double sum4 = ing_e[0].getCalories();
			return (int)Math.round(sum4);
			
		default:
			return 0;
		}
			
		
	}

	@Override
	public double getCost() {
		
		double y = 0.0;
		double total = 0.0;
		
		switch(sash) {
		
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[1];
			ing_a[0] = new TunaPortion(.75);
			
			y = Math.round((ing_a[0].getCost()) * 100); 
			total = y / 100;
			return total;
			
		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[1];
			ing_b[0] = new YellowtailPortion(.75);

			
			y = Math.round((ing_b[0].getCost()) * 100); 
			total = y / 100;
			return total;
			
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[1];
			ing_c[0] = new EelPortion(.75);
			
			
			y = Math.round((ing_c[0].getCost()) * 100); 
			total = y / 100;
			return total;
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[1];
			ing_d[0] = new CrabPortion(.75);
			
			
			y = Math.round((ing_d[0].getCost()) * 100); 
			total = y / 100;
			return total;
		
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[1];
			ing_e[0] = new ShrimpPortion(.75);
		
			
			y = Math.round((ing_e[0].getCost()) * 100); 
			total = y / 100;
			return total;
			
		default:
			return total;
			
		}
		 
//		switch(sash) {
//		case TUNA:
//			IngredientPortion[] ing_a = new IngredientPortion[1];
//			ing_a[0] = new TunaPortion(.75);
//			double sum = ing_a[0].getCost();
//			
//			//return Math.round((sum*100)/100);
////			double total= Math.round(sum * 100) / 100;
////			System.out.println(total);
//			
//			
////			DecimalFormat df = new DecimalFormat("###.###");
////			System.out.println(df.format(PI));
//			//String.format("%.2f", val);
//		
//
//		case YELLOWTAIL:
//			IngredientPortion[] ing_b = new IngredientPortion[1];
//			ing_b[0] = new YellowtailPortion(.75);
//			double sum1 = ing_b[0].getCost();
//			return Math.round((sum1 * 100) / 100);
//			
//		case EEL:
//			IngredientPortion[] ing_c = new IngredientPortion[1];
//			ing_c[0] = new EelPortion(.75);
//			double sum2 = ing_c[0].getCost();
//			return Math.round((sum2 * 100) / 100);
//			
//		case CRAB:
//			IngredientPortion[] ing_d = new IngredientPortion[1];
//			ing_d[0] = new CrabPortion(.75);
//			double sum3 = ing_d[0].getCost();
//			return Math.round((sum3 * 100) / 100);
//			
//		case SHRIMP:
//			IngredientPortion[] ing_e = new IngredientPortion[1];
//			ing_e[0] = new ShrimpPortion(.75);
//			double sum4 = ing_e[0].getCost();
//			return Math.round((sum4 * 100) / 100);
//			
//		default:
//			return 0.0;
//			
//		}
	
		/* getCost()
		 * 
		 * Getter for sum of costs of component ingredient
		 * portions rounded to nearest cent.
		 */
	}

	@Override
	public boolean getHasRice() {
		switch(sash) {
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[1];
			ing_a[0] = new TunaPortion(.75);
			return ing_a[0].getIsRice();
			

		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[1];
			ing_b[0] = new YellowtailPortion(.75);
			return ing_b[0].getIsRice();
			
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[1];
			ing_c[0] = new EelPortion(.75);
			return ing_c[0].getIsRice();
			
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[1];
			ing_d[0] = new CrabPortion(.75);
			return ing_d[0].getIsRice();
			
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[1];
			ing_e[0] = new ShrimpPortion(.75);
			return ing_e[0].getIsRice();
			
		default:
			return false;
		}
		
		
		/* getHasRice()
		 * getHasShellfish()
		 * 
		 * Returns true if any of the component ingredients
		 * is rice or shellfish respectively. Otherwise false.
		 * 
		 */
	}

	@Override
	public boolean getHasShellfish() {
		switch(sash) {
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[1];
			ing_a[0] = new TunaPortion(.75);
			return ing_a[0].getIsShellfish();
			

		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[1];
			ing_b[0] = new YellowtailPortion(.75);
			return ing_b[0].getIsShellfish();
			
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[1];
			ing_c[0] = new EelPortion(.75);
			return ing_c[0].getIsShellfish();
			
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[1];
			ing_d[0] = new CrabPortion(.75);
			return ing_d[0].getIsShellfish();
			
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[1];
			ing_e[0] = new ShrimpPortion(.75);
			return ing_e[0].getIsShellfish();
			
		default:
			return false;
		}
		
	}

	@Override
	public boolean getIsVegetarian() {
		switch(sash) {
		case TUNA:
			IngredientPortion[] ing_a = new IngredientPortion[1];
			ing_a[0] = new TunaPortion(.75);
			return ing_a[0].getIsVegetarian();
			

		case YELLOWTAIL:
			IngredientPortion[] ing_b = new IngredientPortion[1];
			ing_b[0] = new YellowtailPortion(.75);
			return ing_b[0].getIsVegetarian();
			
		case EEL:
			IngredientPortion[] ing_c = new IngredientPortion[1];
			ing_c[0] = new EelPortion(.75);
			return ing_c[0].getIsVegetarian();
			
		case CRAB:
			IngredientPortion[] ing_d = new IngredientPortion[1];
			ing_d[0] = new CrabPortion(.75);
			return ing_d[0].getIsVegetarian();
			
		case SHRIMP:
			IngredientPortion[] ing_e = new IngredientPortion[1];
			ing_e[0] = new ShrimpPortion(.75);
			return ing_e[0].getIsVegetarian();
			
		default:
			return false;
		}
		
		
		/* getIsVegetarian()
		 * 
		 * Returns true only if all of the component
		 * ingredients are vegetarian. Otherwise false.
		 */
	};



}
