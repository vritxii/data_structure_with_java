package sort;

public class ChooseSort extends Sort{
	public static void sort(int[] a) {
		int N = a.length;
		for(int i=0; i<N; i++){
			int min = i;
			for(int j=i; j<N; j++){
				if(less(a[j], a[min])) min = j;
			exec(a, i, min);
			}
		}
	}
}
