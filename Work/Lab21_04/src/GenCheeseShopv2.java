import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	/*
	 * Displays the intro message informing the user of various cheeses sold 
	 * while populating the names and prices arrays, and initializing the
	 * amounts array.
	 */
	public static void intro(String[] names, double[] prices, double[] amounts) {
		// Fill-in
		Random randomNum = new Random(100);
		System.out.println("");
		System.out.println("We sell "+ names.length + " types of Cheese (in 0.5lb packages):");
		if(names.length >0 && names.length < 2) {//1
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
			System.out.printf("%s: $%.1f per pound \n", names[0],prices[0]);


		}

		if(names.length >1 && names.length < 3) {//2
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;

			names[1] = "Red Hawk";
			prices[1] = 40.50;

			System.out.printf("%s: $%.1f per pound \n", names[0],prices[0]);
			System.out.printf("%s: $%.1f per pound \n", names[1],prices[1]);

		}
		if(names.length > 2) {//3
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;

			names[1] = "Red Hawk";
			prices[1] = 40.50;

			names[2] = "Teleme";
			prices[2] = 17.25;

			System.out.printf("%s: $%.1f per pound \n", names[0],prices[0]);
			System.out.printf("%s: $%.1f per pound \n", names[1],prices[1]);
			System.out.printf("%s: $%.2f per pound \n", names[2],prices[2]);


		}

		if(names.length > 0 & names.length <= 20) {


			for (int i = 3; i < names.length; i++) {
				names[i] = "Cheese Type " + (char)('A' + i);
				prices[i] = randomNum.nextInt(1000)/100.0;
				amounts[i] = 0;

				System.out.printf("%s: $%.2f per pound \n", names[i],prices[i]);
			}
			
		}
	}
	
	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation 
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		// Fill-in
		System.out.println("");
		for (int i = 0; i < names.length; i++) {
			System.out.printf("Enter the amount of %s in lbs: ", names[i]);
			amounts[i] = sc.nextDouble();
			while(amounts[i] % (.5) !=0 || amounts[i] <0) {
				while(amounts[i] % (.5) !=0){
					System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
					amounts[i] = sc.nextDouble();
				}
				while(amounts[i] < 0) {
					System.out.print("Invalid input. Enter a value >=0:");
					amounts[i] = sc.nextDouble();

				}
			}
		}
		
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		// Fill-in
		double total = 0.0;
		for(int i = 0; i < names.length; i++) {
			total += prices[i] * amounts[i];
		}
		
		if(total <=0) {
			System.out.println("No items were purchased.");
		}
		
		if(total > 0) {
		for(int i =0; i < names.length; i++) {
			if(amounts[i] != 0) {
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amounts[i], names[i],
						prices[i], prices[i]*amounts[i]);
			}
			
			}
		}
	}

	
	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		// Fix
		double subTotal = 0;
		for(int i =0; i < amounts.length; i++) {
			subTotal += (amounts[i]* prices[i]);
			
		}
		return Math.abs(subTotal);
		
	}

	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices){
		// Fix
		double[] disSpecials = new double[amounts.length];
		double hFogDiscount = 0;
		double redHawkDiscount = 0;
		if(prices.length ==1) {//1
			//hFog
			hFogDiscount = Math.floor(amounts[0])/2;//hFog is index 0;
			hFogDiscount = hFogDiscount * 25.0;
			disSpecials[0] = hFogDiscount;
		}
		if(prices.length > 1) {
			hFogDiscount = Math.floor(amounts[0])/2;//hFog is index 0;
			hFogDiscount = hFogDiscount * 25.0;
			disSpecials[0] = hFogDiscount;
			//redHawk
			redHawkDiscount = amounts[1] *2;
			redHawkDiscount = redHawkDiscount /3;
			redHawkDiscount = (int)redHawkDiscount;
			redHawkDiscount = redHawkDiscount * 20.25;
			disSpecials[1] = redHawkDiscount;
			
		}
		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
		// Fix
		String cash = "$";
		String minusCash = "-$";//shhhh
		double none = 0.0;
		double returnedSub = subTotal;
		//System.out.println(returnedSub);
		System.out.println("");
		System.out.printf("Original Sub Total: %15s%.2f \n", cash,subTotal);

		System.out.println("Specials...");
		
		if(disSpecials.length >=1 && disSpecials[0] > 0) {
			System.out.printf("Humboldt Fog (Buy 1 Get 1 Free): %2s%.2f \n",minusCash, disSpecials[0]);
		}
		if(disSpecials.length>= 2 && disSpecials[1] > 0) {
			System.out.printf("Red Hawk (Buy 2 Get 1 Free): %6s%.2f \n",minusCash,disSpecials[1]);
		}
		
		if(subTotal ==0) {
			System.out.printf("None %30s%.1f \n",minusCash,none);
		}
		
		for(int i = 0; i < disSpecials.length; i++) {
			returnedSub -= disSpecials[i];
		}
		
		//System.out.println(returnedSub);
		return returnedSub;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		// Fill-in
		String cash = "$";
		String percent = "%";
		
		String minusCash = "-$";//shhhh
		
		System.out.printf("New Sub Total: %20s%.2f \n", cash, Math.abs(newSubTotal));
		double discount = 0;
		if(newSubTotal < 150) {
			discount = newSubTotal*0.0;
		}
		if(newSubTotal >= 150 && newSubTotal < 250) {
			discount = newSubTotal*.1;
		}
		if(newSubTotal >= 250) {
			discount = newSubTotal*.25;
		}
		if(discount > 1) {
			System.out.printf("Additional 10%s Discount: %10s%.2f \n",percent, minusCash, Math.abs(discount));
		}
		else if(discount <= 0) {
			System.out.printf("Additional 0%s Discount: %11s%.1f \n",percent, minusCash, Math.abs(discount));

		}
		double finalTotal = newSubTotal - discount;
		System.out.printf("Final Total : %21s%.2f",cash, Math.abs(finalTotal));

	}
	
	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = sc.nextInt();

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(sc, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);
		
		
		if (MAXCHEESE != 0 ) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();
			
			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));
		
		printFinalTotal(newSubTotal);
		
		sc.close();
	}
}