import java.util.Scanner;

public class CheeseShop{
	public static void main(String []args) {

		//Create Variables
		Scanner scnr = new Scanner(System.in);
		double hFog = 0.0,teleme = 0.0, redHawk = 0.0, total = 0.0, hFogPrice = 0.0;
		double telemePrice = 0.0, redHawkPrice = 0.0, hFogDiscount = 0.0, redHawkDiscount =0.0;
		int itemList = 0;


		System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
		System.out.println("Humboldt Fog: $25.0 per pound");
		System.out.println("Red Hawk: $40.5 per pound");
		System.out.println("Teleme: $17.25 per pound");
		System.out.println("");

		System.out.print("Enter the amount of Humboldt Fog in lbs: ");
		hFog = scnr.nextDouble();

		while(hFog % (.5) !=0 || hFog <0) {
			while(hFog % (.5) !=0){
				System.out.print("Invalid input. Enter a value that's multiple of 0.5:");
				hFog = scnr.nextDouble();
			}
			while(hFog < 0) {
				System.out.print("Invalid input. Enter a value >=0:");
				hFog = scnr.nextDouble();

			}
		}
		System.out.print("Enter the amount of Red Hawk in lbs: ");
		redHawk = scnr.nextDouble();

		while(redHawk % (.5) !=0 || redHawk <0) {
			while(redHawk % (.5) != 0) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5:");
				redHawk = scnr.nextDouble();
			}

			while(redHawk < 0) {
				System.out.print("Invalid input. Enter a value >=0:");
				redHawk = scnr.nextDouble();

			}
		}

		System.out.print("Enter the amount of Teleme in lbs: ");
		teleme = scnr.nextDouble();

		while(teleme %(.5) != 0 || teleme < 0) {
			while(teleme % (.5) != 0) {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5:");
				teleme = scnr.nextDouble();
			}

			while(teleme < 0) {
				System.out.print("Invalid input. Enter a value >=0:");
			}
		}

		System.out.println("");

		//Lecture Logic
		hFogDiscount =hFog * 25.0;
		hFog = hFog * 2;
		hFogPrice = hFog * 25.0;

		redHawkDiscount = (int)redHawk * .5 * 40.5;
		redHawk = redHawk + (int)redHawk * .5;
		redHawkPrice = redHawk * 40.5;

		telemePrice = teleme * 17.25;
		total = hFogPrice + redHawkPrice + telemePrice;

		System.out.print("Display the itemized list? (1 for yes) ");
		itemList = scnr.nextInt();


		if(itemList == 1) {
			if(hFog>0) {
				System.out.println(hFog + " lb of Humbold Fog @ $25.0 = $" + hFogPrice);
			}
			if(redHawk>0) {
				System.out.println(redHawk + " lb of Red Hawk @ $40.5 = $" + redHawkPrice);
			}
			if(teleme>0) {
				System.out.println(teleme + " lb of Teleme @ $17.25 = $" + telemePrice);
			}

		}
		System.out.println("");
		System.out.println("Sub total:" + "\t" +"\t" +"\t" + "  " + "$" + total);
		if((redHawk ==0 && hFog == 0) && (teleme == 0)) {
			System.out.println("No items were purchased");
		}
		System.out.println("Discounts...");

		if(hFog == 0 && redHawk ==0) {
			System.out.println("None" + "\t "+ "\t" + "\t"+ "\t"+" -$" + (hFogDiscount + redHawkDiscount));
		}

		if(hFogDiscount > 0 && redHawkDiscount > 0) {
			System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + hFogDiscount);
			System.out.println("Red Hawk (Buy 2 Get 1 Free):     -$" + redHawkDiscount);
		}
		else if(hFogDiscount > 0 && redHawkDiscount == 0) {
			System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + hFogDiscount);

		}
		System.out.println("Total:"+"\t" +"\t" +"\t" + "\t" + "  " + "$" +(total - hFogDiscount - redHawkDiscount));

	}


}