import java.util.ArrayList;

public class Towers {

	public Towers(int n) {
		posts = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 3; i++)
			posts.add(new ArrayList<Integer>());
		for (int i = 1; i <= n; i++)
			posts.get(0).add(i);
		numDiscs = n;
	}
	
	public int size() {
		return numDiscs;
	}
	
	public void moveDisc(int origin, int destination) {
		if (origin < 1 || origin > 3)
			throw new Error("Illegal origin tower number " + origin);
		if (destination < 1 || destination > 3)
			throw new Error("Illegal destination tower number " + destination);
		ArrayList<Integer> origPost = posts.get(origin-1);
		ArrayList<Integer> destPost = posts.get(destination-1);	
		if (origPost.isEmpty())
			throw new Error("Attempt to remove disc from empty tower #" + origin);
		int disc = origPost.get(0);
		origPost.remove(0);
		if (!destPost.isEmpty() && destPost.get(0) < disc)
			throw new Error("Illegal move - attempt to put disc size "
						+ disc + " on top of disc size " + destPost.get(0));
		destPost.add(0, disc);
	}
	
	public void display() {
		int maxWidth = 2*numDiscs - 1;
		int spacer = 3;
		System.out.println();
		for (int level = numDiscs; level >= 1; level--) {
			for (int i = 0; i < 3; i++) {
				System.out.print(" ".repeat(spacer));
				int size = posts.get(i).size();
				if (size < level) {
					System.out.print(" ".repeat(maxWidth));
				} else {
					int width = 2*posts.get(i).get(size-level) - 1;
					System.out.print(" ".repeat((maxWidth-width)/2));
					System.out.print("#".repeat(width));
					System.out.print(" ".repeat((maxWidth-width)/2));
				}
			}
			System.out.println();
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(" ".repeat(spacer + maxWidth/2));
			System.out.print(i+1);
			System.out.print(" ".repeat(maxWidth/2));
		}
		System.out.print("\n\n");
	}

	private int numDiscs;
	private ArrayList<ArrayList<Integer>> posts;
}

