package sort;

public abstract class Sort {
	public static int[] aux;

	public static boolean less(int v, int w) {
		return v - w < 0;
	}

	public static void exec(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void merge(int[] a, int lo, int mid, int hi) {
		//aux = new int[a.length];
		int i = lo;
		int j = mid + 1;
		//System.out.println("lo="+lo+" mid="+mid+" hi="+hi);
		//System.out.println(aux.length);
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = a[j++];
			else
				a[k] = aux[i++];
		}
	}

	public static void show(int[] a) {
		for (int ele : a) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}

	public static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
}
