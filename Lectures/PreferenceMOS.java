
import java.util.Scanner;

/* 
 * CSE21, Review of CSE20
 * Instructor: Santosh Chandrasekhar
 */
public class PreferenceMOS {
	public static void main(String[] args) {
		// Use scanner to get user inputs
		Scanner input = new Scanner(System.in);
		
		// Get sample size
		System.out.print("Enter the total number of students: ");
		int max = input.nextInt();
	
		// Initialize all tally counters and student choice
		int android, ios, other, choice;
		android = ios = other = choice = 0;
			
		// For each student, get choice and increment appropriate counter 
		System.out.println("Preference? Android (1), iOS (2), or Both (3).");
		for (int i = 0; i < max; i++) {
			System.out.print("Enter choice: ");
			choice = input.nextInt();
			if (choice == 1)
				android++;
			else if (choice == 2)
				ios++;
			else if (choice == 3) {
				android++;
				ios++;
			} else
				other++;
		}
	
		// Output the counts
		System.out.print("See detailed count? Yes (1), or No (0): ");
		int detailed = input.nextInt();
		if (detailed == 1) {
			System.out.println("Prefer Android = " + android);
			System.out.println("Prefer iOS = " + ios);
			System.out.println("Prefer Other = " + other);
		}
		
		input.close(); 
	}
}