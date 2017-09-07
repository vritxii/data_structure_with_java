package sort;

public class InsertSort extends Sort{
	public static void sort(int[] a) {
		int N = a.length;
		for(int i=1; i<N; i++){
			for(int j=i; j>0 && less(a[j], a[j-1]); j--){
				exec(a, j, j-1);
			}
		}
	}
}
