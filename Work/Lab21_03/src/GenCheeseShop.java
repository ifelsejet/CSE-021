import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {
	public static void main(String [] args) {
		Scanner scnr = new Scanner(System.in);

		System.out.print("Enter the number of Cheeses for shop setup: ");
		final int MAXCHEESE = scnr.nextInt();
		Random randomNum = new Random(100);

		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		//keep track of total
		double[] subtotal = new double[MAXCHEESE];
		double total = 0.0;
		int discount = 0;
		double hFogDiscount = 0.0;
		double redHawkDiscount = 0.0;
		double discountAmount = 0.0;

		int list = 0;
		
		String cash = "$";
		String minusCash = "-$";

		System.out.println("");
		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages)");


		if(MAXCHEESE >0 && MAXCHEESE < 2) {//1
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
			System.out.printf("%s: $%.1f per pound \n", names[0],prices[0]);


		}

		if(MAXCHEESE >1 && MAXCHEESE < 3) {//2
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;

			names[1] = "Red Hawk";
			prices[1] = 40.50;

			System.out.printf("%s: $%.1f per pound \n", names[0],prices[0]);
			System.out.printf("%s: $%.1f per pound \n", names[1],prices[1]);

		}
		if(MAXCHEESE > 2) {//3
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

		if(MAXCHEESE > 0 & MAXCHEESE <= 20) {


			for (int i = 3; i < MAXCHEESE; i++) {
				names[i] = "Cheese Type " + (char)('A' + i);
				prices[i] = randomNum.nextInt(1000)/100.0;
				amounts[i] = 0;

				System.out.printf("%s: $%.2f per pound \n", names[i],prices[i]);
			}//list other cheeses than the 3 special ones

			System.out.println("");
			for (int i = 0; i < MAXCHEESE; i++) {
				System.out.printf("Enter the amount of %s in lbs: ", names[i]);
				amounts[i] = scnr.nextDouble();
				while(amounts[i] % (.5) !=0 || amounts[i] <0) {
					while(amounts[i] % (.5) !=0){
						System.out.print("Invalid input. Enter a value that's multiple of 0.5:");
						amounts[i] = scnr.nextDouble();
					}
					while(amounts[i] < 0) {
						System.out.print("Invalid input. Enter a value >=0:");
						amounts[i] = scnr.nextDouble();

					}
				}
				subtotal[i] = amounts[i] * prices[i];
				total = subtotal[i] + total;
			}
			System.out.println("");
			System.out.print("Display the itemized list? (1 for yes) ");
			list = scnr.nextInt();

			if(list == 1) {
				if(total <= 0) {
					System.out.println("No items were purchased.");
				}
				if(total >0) {
					for(int i =0; i < MAXCHEESE; i++) {
						if(amounts[i] != 0) {
							System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amounts[i], names[i],
									prices[i], prices[i]*amounts[i]);
							//System.out.println(amounts[i] + " lb of " + names[i] + " @ $" + prices[i] + " = $"+ Math.round(subtotal[i]*100)/100.0);
						}//FIX THIS
					}
				}
			}

		}			if(MAXCHEESE >= 1 && MAXCHEESE < 2) {//1
			hFogDiscount = amounts[0];
			hFogDiscount = Math.floor(hFogDiscount)/2;
			hFogDiscount = hFogDiscount * 25.0;

		}
		if(MAXCHEESE >= 2) {//2
			hFogDiscount = amounts[0];
			hFogDiscount = Math.floor(hFogDiscount)/2;
			hFogDiscount = hFogDiscount * 25.0;

			redHawkDiscount = amounts[1];
			redHawkDiscount = redHawkDiscount * 2;
			redHawkDiscount = redHawkDiscount /3;
			redHawkDiscount = (int)redHawkDiscount;
			redHawkDiscount = redHawkDiscount * 20.25;
		}

		System.out.println("");
		double originSub = Math.round(total*100)/100.0;
		System.out.printf("Original Sub Total: %15s%.2f \n", cash,originSub);

		System.out.println("Specials...");
		if(hFogDiscount >0) {
			System.out.printf("Humboldt Fog (Buy 1 Get 1 Free): %2s%.2f \n",minusCash, hFogDiscount);
		}
		if(redHawkDiscount>0) {
			System.out.printf("Red Hawk (Buy 2 Get 1 Free): %6s%.2f \n",minusCash,redHawkDiscount);
		}
		double none = 0.0;
		if(hFogDiscount ==0 && redHawkDiscount ==0) {
			System.out.printf("None %30s%.1f \n",minusCash,none);
		}


		total = total -hFogDiscount;
		total = total - redHawkDiscount;
		if(total < 0) {
			total = 0;
		}
		double newSub = Math.round(total*100)/100.0;
		System.out.printf("New Sub Total: %20s%.2f \n", cash, newSub);
		if(total < 150) {
			discount = 0;
		}
		if(total >= 150 && total < 250) {
			discount = 10;
		}
		if(total >= 250) {
			discount = 25;
		}

		discountAmount = (total*discount)/100;
		double discountInCash = Math.round(discountAmount*100)/100.0;
		String percent = "%";
		if(discountInCash < 1) {
			System.out.printf("Additional %d%s Discount: %11s%.1f \n", discount,percent, minusCash, discountInCash);
		}
		else if(discountInCash >1) {
			System.out.printf("Additional %d%s Discount: %10s%.2f \n", discount,percent, minusCash, discountInCash);

		}
		double finalTotal =  Math.round((total - discountAmount)*100)/100.0;
		System.out.printf("Final Total : %21s%.2f",cash, finalTotal);


	}
}
