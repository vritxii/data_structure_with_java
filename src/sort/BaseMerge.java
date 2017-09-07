package sort;

public class BaseMerge extends Sort{
	
	public static void sort(int[] a) {
		int N = a.length;
		aux = new int[a.length];
		for(int sz=1; sz<N; sz*=2){
			for(int lo=0; lo < N-sz; lo += 2*sz)
				merge(a, lo, lo+sz-1, Math.min(lo+2*sz-1, N-1));
		}
	}
}
