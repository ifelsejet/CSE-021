import java.util.Scanner;


public class Shop{
	 //Global Variables
	static Scanner input = new Scanner(System.in);
	static double discount = 0.0;
	static int qualifyValue = 0;
	//Functions 
	public static int setUp(String[] names, double[] prices, double[] discountAmount) {
		System.out.print("Please enter the number of items to setup shop: ");
		int numOfItems = input.nextInt();
		System.out.println("");
		
		for(int i = 1; i <= numOfItems; i++) {
			System.out.print("Enter the name of the " + numSuffix(i) + " product: ");
			names[i] = input.next();
			System.out.print("Enter the per package price of " + names[i] + ": ");
			prices[i] = input.nextDouble();
			System.out.print("Enter the number of packages('x') to qualify for Special Discount (buy 'x' get 1 free) for "+ names[i]+ ", or 0 if no Special Discount offered: ");
			discountAmount[i] = input.nextInt();
		}
		
		System.out.println("");//Spacing
		System.out.print("Enter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
		qualifyValue = input.nextInt();
		
		if(qualifyValue == 0) {
			System.out.println("");
		}
		else {
			System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
			discount = input.nextDouble();
			if(discount < 0 || discount > .5) {
				System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
				discount = input.nextDouble();
				
			}
			System.out.println("");
			
		}
		return numOfItems;
		
	}
	public static String numSuffix(int i) {
		int rem = i % 10;
		switch (rem) {
		case 0:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		return (i + "th");
		case 1:
		if (i % 100 != 11)
		return (i + "st");
		else
		return (i + "th");
		case 2:
		if (i % 100 != 12)
		return (i + "nd");
		else
		return (i + "th");
		case 3:
		if (i % 100 != 13)
		return (i + "rd");
		else
		return (i + "th");
		default:
		break;
		}
		return "";
		}

	
	public static void buyItems(String[] names, double[] prices, int[] amounts,int numOfItems) {
		System.out.println("");
		for(int i = 1; i <= numOfItems; i++) {
			System.out.print("Enter the number of " + names[i] + " packages to buy: ");
			amounts[i] = input.nextInt();
			while(amounts[i] < 0) {
				System.out.print("Invalid input. Enter a value >=0: ");
				amounts[i] = input.nextInt();
			}
			}
		System.out.println("");
		}
		
	
	public static void listItems(String[] names, double[] prices, int[] amounts,int numOfItems) {
		double total = 0.0;
		System.out.println("");
		
		for(int i = 1; i <= numOfItems; i++) {
			total = (double) (prices[i] * amounts[i]);
			if(amounts[i] == 0) {
				System.out.print("");
			}
			else {
				//System.out.println(amounts[i] +" packages of " + names[i] + " @ $" + prices[i] + " per pkg = $" + total);
				System.out.printf("%d packages of %s @ $%.2f per pkg = $%.2f \n", amounts[i],names[i],prices[i],total);
			}
		}
		if(total == 0) {
			System.out.println("No items were purchased");
		}
		System.out.println("");
	}
	
	public static double specialDiscount(int[] amounts, double[] price, double[] discountAmnt) {
		double specialDiscount = 0.0;
		for(int i = 0; i < amounts.length; i++) {
			specialDiscount += (int)((amounts[i]*discountAmnt[i]) / (discountAmnt[i]) +1) * (price[i] * 2);
			if(discountAmnt[i] == 0) {
				//System.out.println("No Special Discounts applied");
				break; 
			}
		}
		return specialDiscount;
	}
	public static void checkOut(int[] amounts, double[] price, double specialDiscount) {
		double subTotal = 0.0;
		
		for(int i = 0; i < amounts.length; i++) {
			subTotal = (price[i] * amounts[i]) + subTotal;
		}
		
		if(subTotal >= qualifyValue) {
			double newSubTotal = subTotal - specialDiscount;
			double newDiscount = subTotal * discount;
			double total = newSubTotal - newDiscount;
			int discountPercent = (int)(discount*100);
			double minusDiscountPercent = total*discount;
			double finalTotal = total - minusDiscountPercent;
			 System.out.println("");//Spacing
			//System.out.println("Original Sub Total:       $" + subTotal);
			System.out.printf("Original Sub Total:        $%.2f \n",subTotal);

			if(newDiscount != 0) {
			//System.out.println("Special Discounts:       -$" + newDiscount);
			System.out.printf("Special Discounts:        -$%.2f \n", newDiscount);

			}
			if(newDiscount == 0) {
				System.out.println("No Special Discounts applied");
			}
			//System.out.println("New Sub Total:            $" + total);
			System.out.printf("New Sub Total:             $%.2f \n", total);
			if(minusDiscountPercent != 0) {
			//System.out.println("Additional " + discountPercent + "% Discount: -$"+ minusDiscountPercent);
			System.out.printf("Additional %d%% Discount:  -$%.2f \n", discountPercent,minusDiscountPercent);
			}
			if(minusDiscountPercent ==0) {
				System.out.println("You did not qualify for an Additional Discount");
			}
			System.out.printf("Final Sub Total:           $%.2f \n", finalTotal);
			System.out.println("");
			System.out.println("Thanks for coming!");
			System.out.println("");
			
		}
		else if(subTotal < qualifyValue) {
			System.out.println("");
			System.out.println("Thanks for coming!");
			System.out.printf("Sub Total:    $%.2f \n",subTotal);
			System.out.println("You did not qualify for an additional discount");
			System.out.printf("Total: $%.2f \n", subTotal);

			
		}
		
		
		
	}
	
	public static void main(String args[]) {
		final int MAX = 100;
		int numOfItems = 0;
		String[] names = new String[MAX];
		double[] prices = new double [MAX];
		int[] amounts = new int[MAX];
		double[] discAmount = new double[MAX];
		boolean isSetUp = false;
		boolean isItemsBought = false;
		boolean isDone = false;
		double specialDiscount = 0;
		
		do {
		System.out.println("This program supports 4 functions:");
		System.out.println("    1. Set Up Shop");
		System.out.println("    2. Buy");
		System.out.println("    3. List Items");
		System.out.println("    4. Checkout");
		System.out.print("Please choose the function you want: ");
		int functionChoice = input.nextInt();
		switch(functionChoice) {
		case 1: {//1 Setup Shop
			if(isSetUp== false) {
			numOfItems = setUp(names,prices,discAmount);
			}
			if(isSetUp == true) {
				numOfItems = setUp(names,prices,discAmount);
			}
			isSetUp = true;
			break;
		}
		case 2:{
			if(isSetUp == true) {
				buyItems(names,prices,amounts, numOfItems);
				isItemsBought = true;
			}
			else {
				System.out.println("");
				System.out.println("Shop is not setup yet!");
				System.out.println("");
				break;
			}
			isItemsBought = true;
			break;
			
		}
		case 3:{
			if(isSetUp == true && isItemsBought == true) {
				listItems(names, prices, amounts, numOfItems);
				break;
			}
			if(isSetUp == true && isItemsBought == false) {
				System.out.println("");
				System.out.println("You have not bought anything!");
				System.out.println("");

				break;
			}
			if(isSetUp == false) {
				System.out.println("");
				System.out.println("Shop is not setup yet!");
				System.out.println("");
				break;
			}
		}
		case 4:{
			if(isSetUp == true && isItemsBought == true) {
				double theRealDiscount = specialDiscount(amounts,prices,discAmount);
				checkOut(amounts, prices,theRealDiscount);
				isDone = true;
			}
			if(isSetUp == true && isItemsBought == false) {
				System.out.println("");
				System.out.println("Items have not been bought yet!");
				System.out.println("");
				break;
			}
		}
		}
		if(functionChoice > 4) {
			System.out.println("");
			System.out.println("Error do not know the function: "+ functionChoice);
			System.out.println("");
		}
		if(isDone == true) {
			System.out.println("---------------------------------------------");
			System.out.print("Would you like to re-run (1 for yes, 0 for no)? ");
			int reRun = input.nextInt();
			if(reRun == 1) {
				System.out.println("---------------------------------------------");
				System.out.println("");

				main(args);//runs main function
			}
			else {
				System.out.println("---------------------------------------------");
				System.exit(0);//exits program
			}

		}
	}while(true);
}
}