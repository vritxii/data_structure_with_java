package string;
import java.util.ArrayList;

public class Kmp {
	public static int[] next;
	public static void getNext(String s) {
		next = new int[s.length()];
		next[0] = -1;
		int k = -1;
		int j = 0;
		char[] chars = s.toCharArray();
		while (j < (chars.length-1)) {
			if(k == -1 || chars[k] == chars[j]){
				j++;
				k++;
				next[j] = k;
			}else {
				k = next[k];
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "huihuabcdabcabcdabc";
		String s = "abcdabc";
		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();
		getNext(s);
		//System.out.println(next.length);
		int np = p.length();
		int ns = s.length();
		ArrayList<Integer> list = new ArrayList<>();
		int x = 0, y = 0;
		while (x < np) {
			if(sc[y] != pc[x]) y = next[y];
			if(y == ns-1){
				list.add(x-y);
				y = 0;
			}
			x++;
			y++;
		}
		
		System.out.println("index: ");
		for(int ele: list)
			System.out.print(ele + " ");
		System.out.println();
	}

}
