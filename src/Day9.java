
public class Day9 {
	
	
	
	private static int countMatchesHelper(String[] items, String target, int start) {
		// base case - empty range
		if (start == items.length) {
			return 0;
		}
		// recursive leap(s)
		if (items[start].equals(target)) {
			return 1 + countMatchesHelper(items, target, start+1);
		} else {
			return 0 + countMatchesHelper(items, target, start+1);
		}
	}
	
	public static int countMatches(String[] items, String target) {
		int result = countMatchesHelper(items, target, 0);
		return result;
	}
	
	// n is NOT prime if there is ANY number x that divides n,
	// where x >= 2 and x <= n/2
	
	private static boolean hasFactor(int n, int start) {
		// check if any number from start up to n-1
		
		// base cases
		if (start == n) { // no more factors to look at
			return false;
		} else if (n % start == 0) { // start itself is a factor!
			return true;
		}
		
		// recursive step
		return hasFactor(n, start+1);
	}
	
	public static boolean isPrime(int n) {
		boolean result = !(hasFactor(n, 2));
		return result;
	}

	public static void main(String[] args) {
		String[] things = { "A", "B", "A", "C", "A" };
		System.out.println(countMatches(things, "A"));
		
		for (int i = 2; i < 100; i++) {
			if (isPrime(i)) 
				System.out.println(i + " is prime");
		}

	}

}
