package sort;

public class QuickSort extends Sort{
	private static int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int v = a[lo];
		
		while (true) {
			while (less(a[++i], v)) {
				if(i == hi) break;
			}
			while (less(v, a[--j]))  {
				if(j == lo) break;
			}
			if(i >= j) break;
			exec(a, i, j);
		}
		exec(a, lo, j);
		return j;
	}
	
	public static void sort(int[] a) {
		sort(a, 0, a.length-1);
	}
	
	public static void sort3(int[] a) {
		sort3(a, 0, a.length-1);
	}
	
	public static void sort(int[] a, int lo, int hi) {
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j);
		sort(a, j+1, hi);
	}
	
	public static void sort3(int[] a, int lo, int hi) {
		if(hi <= lo) return;
		int lt = lo;
		int i = lo + 1;
		int gt = hi;
		int v = a[lo];
		while (i <= gt) {
			int cmp = a[i] - v;
			if (cmp < 0) exec(a, lt++, i++);
			else if (cmp > 0) exec(a, i, gt--);
			else i++;
		}
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}
}
