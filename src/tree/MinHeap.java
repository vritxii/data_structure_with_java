package tree;

import java.util.Arrays;

/*************************************************************************
 * > File Name: MinHeap.java
 * > Author: zt
 * > Mail: nkdzt@foxmail.com
 * > Created Time: 2016年12月07日 星期三 01时37分09秒
 ************************************************************************/

public class MinHeap {

    private int[] pq;
    private int N = 0;

    private MinHeap(int MaxN) { pq = new int[MaxN + 1]; }

    private boolean isEmpty() { return N == 0; }

    private int size() { return N; }

    private void insert(int v) {
        pq[++N] = v;
        swim(N);
    }

    private int delMin() {
        int Min = pq[1];
        delete(1);
        return Min;
    }

	private void delete(int pos){
		swap(pos, N--);
		sink(pos);
	}

    private boolean great(int i, int j) { return pq[i] - pq[j] > 0; }

    private void swap(int i, int j) {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private void swim(int k) {
        while (k > 1 && great(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;

            if (j < N && great(j, j + 1))
                j++;

            if (!great(k, j))
                break;

            swap(k, j);
            k = j;
        }
    }

    private int[] up_sort() {
        int[] temp = Arrays.copyOf(pq, pq.length);
        int tN = N;
        int[] sorted_arr = new int[pq.length];

        for (int i = 1; i <= tN; i++) {
            sorted_arr[i] = delMin();
        }

        pq = temp;
        N = tN;
        return sorted_arr;
    }

    private int[] down_sort() {
        int[] sorted_arr = Arrays.copyOf(up_sort(), N + 1);
        int len = sorted_arr.length;

        for (int i = 1; i <= len / 2; i++) {
            int tmp = sorted_arr[i];
            sorted_arr[i] = sorted_arr[len - i];
            sorted_arr[len - i] = tmp;
        }

        return sorted_arr;
    }

    private void DecreaseKey(int pos, int deta) {
        if ((pq[pos] - deta) < 0) {
            System.out.println("值小于0，更新失败");
            return;
        }

        pq[pos] = pq[pos] - deta;
        swim(pos);
        sink(pos);
    }

    private void IncreaseKey(int pos, int deta) {
        pq[pos] = pq[pos] + deta;
        sink(pos);
        swim(pos);
    }

    private void build_heap(int[] arr) {
        for (int ele : arr) {
            insert(ele);
        }
    }

    private void print_arr(int[] arr) {
        String str = "";
        for (int i = 1; i <= N; i++) {
            str += (arr[i] + " ");
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        int[] arr = {45, 18, 72, 30, 15, 35};
        MinHeap heap = new MinHeap(args.length > 0? Integer.parseInt(args[0]): 36);

        heap.build_heap(arr);
        System.out.println("heap is empty? " + heap.isEmpty() + ".\nsize = " + heap.size());
        heap.print_arr(heap.pq);

        heap.IncreaseKey(1, 10);
        heap.print_arr(heap.pq);

        heap.DecreaseKey(4, 34);
        heap.print_arr(heap.pq);

        heap.print_arr(heap.up_sort());

        heap.print_arr(heap.down_sort());

        heap.delete(4);
        heap.print_arr(heap.pq);

    }
}
