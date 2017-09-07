package string;

public class MaxStr {

	public static Pos getPos(String s, String p) {
		Pos t = new Pos();
		int m = s.length();
		int n = p.length();
		int[] no1 = new int[m];
		int[] no2 = new int[m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (p.charAt(i) == s.charAt(j)) {
					if (j != 0)
						no2[j] = no1[j - 1] + 1;
					else
						no2[j] = 1;
					if (no2[j] > t.len)
						t.len = no2[j];
					t.x = j;
					t.y = i;
				} else
					no2[j] = 0;
			}
			for(int k=0; k<m; k++)
				no1[k] = no2[k];
			no2 = new int[m];
		}
		return t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello world";
		String p = "cpp hello wjava";
		Pos t = getPos(s, p);
		System.out.printf("位置为s的第%d个，p的第%d个，值为%s\n",t.x+1-t.len, t.y+1-t.len, s.substring(t.x+1-t.len, t.x+1));
	}
}

class Pos {
	int x, y, len;

	public Pos() {
		x = 0;
		y = 0;
		len = 0;
	}
}
