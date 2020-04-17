package oop;

public class Runner {

	public static void main(String[] args) {
		testCounter();

		testCounter7Statements();

		testModNCounter2();

		testDecrementableCounter();

	    testSeasonCounter();
	}

	
	public static void testCounter() {
		System.out.println("-- Testing Counter");

		Counter c = new Counter();
		c.increment();
		System.out.println("Current value: " + c.value());

	}

	
	public static void testCounter7Statements() {
		Counter c = new Counter();
		System.out.println("-- Testing 7 statements");
		// include exactly 7 increment() and reset() statements below

		System.out.println("Current value: " + c.value());
	}
	
	public static void testModNCounter2() {
		ModNCounter2 d = new ModNCounter2(5);
		System.out.print("Current ModN2 value: ");
		for (int i = 0; i <= 4; i++) {
			System.out.print(d.value() + " ");
			d.increment();
		}
		System.out.print(d.value() + " ");
		d.increment();
		System.out.print(d.value() + " ");
		System.out.println();
	}

	public static void testDecrementableCounter() {
		DecrementableCounter e = new DecrementableCounter();
		for (int i = 0; i < 4; i++) {
			e.increment();
		}
		e.decrement();
		System.out.println("Current Decrement value: " + e.value());
	}

	public static void testSeasonCounter() {
		SeasonCounter f = new SeasonCounter();
		for (int i = 0; i < 6; i++) {
			System.out.print(f.toString() + " ");
			f.increment();
		}
	}

}

}
