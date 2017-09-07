package sort;

public class TopMerge extends Sort{

	public static void sort(int[] a) {
		aux = new int[a.length];
		sort(a, 0, a.length-1);
	}
	
	public static void sort(int[] a, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
}
