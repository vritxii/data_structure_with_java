package others;

/**
 * Created by vrit on 16-11-8.
 */
public class TurnStr {
    public static String turn(char[] ss) {
        int n = ss.length;
        char t = ss[0];
        int index = 0;
        int k = 1;
        while (index != (n - k)) {
            if (index + k > n) {
                ss[index] = ss[(index + k) % n];
                index = (index + k) % n;
            } else {
                ss[index] = ss[index + k];
                index += k;
            }
        }
        ss[index] = t;
        System.out.println(String.valueOf(ss));
        return String.valueOf(ss);
    }

    public static void main(String[] args) {
        char[] ss = "abcdefg".toCharArray();
        String st = "fgabcde";
        int n = ss.length;
        int m = st.length();
        if (m != n) {
            System.out.println("No");
            return;
        }
        if(st.equals(ss.toString())){
            System.out.println("两个完全相同");
            return;
        }
        boolean b = false;
        int k = 1;
        while (m == n && !b && k < (m-1)) {
            b = st.equals(turn(ss));
            k+=1;
        }
        if (b) {
            System.out.printf("右移%d位",k);
        }
    }
}
