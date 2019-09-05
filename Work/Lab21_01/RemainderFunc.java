import java.util.Scanner;
public class RemainderFunc {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the max number: ");
		int maxNum = input.nextInt();

		while (maxNum < 0) {
			System.out.println("Invalid input, Please enter a valid max number (>= 0) : ");
			maxNum = input.nextInt();
			
		}
		
		System.out.println("Please enter the divisor: ");
		int divisor = input.nextInt();
		
		while (divisor <= 0) {
			System.out.println("Invalid input, Please enter a valid max divisor (> 0) : ");
			divisor = input.nextInt();
			
		}
		
		System.out.println("Multiples of " + divisor + " between 1 and "+ maxNum + " (inclusive) are: ");
		
		
		for(int i = 1; i <= maxNum; i++) {
			 if (maxNum < divisor) {
				System.out.println("No numbers were found");
				break;			
			}
			 else if(i % divisor == 0) {
					System.out.println(i);
			}
		
	}
}
}
