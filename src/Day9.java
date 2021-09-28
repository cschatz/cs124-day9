
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
	
	private static void towersHelper(Towers towers, int n, int start, int end) {
		// base case 
		if (n == 0) {
			return;
		}
		
		// determine which tower is the "intermediate" tower
		int intermediate = 6 - (start + end);
		
		// move n-1 towers
		towersHelper(towers, n-1, start, intermediate);
		
		// move a single disc
		towers.moveDisc(start, end);
		towers.display();
		try {
			Thread.sleep(1000);
		} catch (Exception e){
			
		}
		
		// move n-1 towers
		towersHelper(towers, n-1, intermediate, end);
	}

	public static void solveTowers(Towers towers, int n) {
		towersHelper(towers, n, 1, 3);
	}

	public static void main(String[] args) {
//		String[] things = { "A", "B", "A", "C", "A" };
//		System.out.println(countMatches(things, "A"));
//		
//		for (int i = 2; i < 100; i++) {
//			if (isPrime(i)) 
//				System.out.println(i + " is prime");
//		}
		
		
		Towers mytowers = new Towers(5);
		mytowers.display();
		solveTowers(mytowers, 5);
		mytowers.display();
		
		
		

	}

}
