package Poly;

/**
 * Created by vrit on 16-10-12.
 */
public class ArrayPoly{
    int[] coef;

    public ArrayPoly(int[] coef){
        this.coef = coef;

    }
    public static ArrayPoly add(ArrayPoly p1,ArrayPoly p2){
        int[] coef_sum;
        int p1l = p1.coef.length;
        int p2l = p2.coef.length;
        int diff = Math.abs(p1l-p2l);
    //    System.out.println(diff);
        int i = 0;
        if(p1l > p2l) {
            coef_sum = new int[p1l];
            while (i < diff) {
                coef_sum[i] = p1.coef[i];
                i++;
            }
            while (i < p1l){
                coef_sum[i] = p1.coef[i]+p2.coef[i-diff];
                i++;
            }
        }else {
            coef_sum = new int[p2l];
            while (i < diff) {
                coef_sum[i] = p2.coef[i];
            }
            while (i < p1l){
                coef_sum[i] = p2.coef[i]+p1.coef[i-diff];
                i++;
            }
        }
        return new ArrayPoly(coef_sum);
    }

    public static ArrayPoly sub(ArrayPoly p1,ArrayPoly p2){
        int[] coef_sub;
        int p1l = p1.coef.length;
        int p2l = p2.coef.length;
        int diff = Math.abs(p1l-p2l);
        int i = 0;
        if(p1l > p2l) {
            coef_sub = new int[p1l];
            while (i < diff) {
                coef_sub[i] = p1.coef[i];
                i++;
            }
            while (i < p1l){
                coef_sub[i] = p1.coef[i]-p2.coef[i-diff];
                i++;
            }
        }else {
            coef_sub = new int[p2l];
            while (i < diff) {
                coef_sub[i] = -p2.coef[i];
            }
            while (i < p1l){
                coef_sub[i] = -p2.coef[i]+p1.coef[i-diff];
                i++;
            }
        }
        return new ArrayPoly(coef_sub);
    }

    public static ArrayPoly mul_2(ArrayPoly p1,ArrayPoly p2){
        int[] result = new int[p1.coef.length + p2.coef.length - 1];
        for (int i = 0; i < p1.coef.length; i++) {
            for (int j = 0; j < p2.coef.length; j++) {
                result[i + j] += (p1.coef[i] * p2.coef[j]);
            }
        }
        return new ArrayPoly(result);
    }

    public static ArrayPoly dif(ArrayPoly p){
        int n = p.coef.length-1;
        int[] coef_sub = new int[n];
        for(int i=0;i<n;i++)
            coef_sub[i]=(n-i)*p.coef[i];
        return new ArrayPoly(coef_sub);
    }

    public void print_all(){
        int n = coef.length;
        String src = "";
        for(int i=0;i<n;i++){
            if(coef[i]!=0)
                src+=((coef[i]>0?"+":"")+coef[i]+"x^"+(coef.length-1-i));
        }
        System.out.println("result = "+src);
    }

    public static void main(String[] args){
        int[] coef = {3,8,2};
        int[] coef_1={3,5,9};
        ArrayPoly a = new ArrayPoly(coef);
        ArrayPoly b = new ArrayPoly(coef_1);
        System.out.print("微分:\n");
        ArrayPoly result = dif(a);
        result.print_all();
        System.out.println("相加:");
        result = add(a,b);
        result.print_all();
        System.out.print("相减:\n");
        result = sub(a,b);
        result.print_all();
        System.out.println("相乘:");
        result = mul_2(a,b);
        result.print_all();
    }
}
