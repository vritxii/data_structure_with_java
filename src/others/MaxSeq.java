package others;

import java.util.Random;

public class MaxSeq {
	
	public static int maxSum(int[] array){
        int maxSum = 0, curSum = 0;
        for (int i = 0; i < array.length; i++){
            curSum += array[i];
            if(curSum > maxSum){
                maxSum = curSum;
            }else if(curSum < 0){
                curSum = 0;
            }
        }
        return maxSum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array;
        Random random = new Random();
      
        for(int i=0;i<5;i++){
            int n = (int)Math.pow(10,i+1);
            array = new int[n];
            for(int j=0;j<n;j++){
                array[j] = random.nextInt(200)-100;
            }
            System.out.println("第"+(i+1)+"次测试（n="+n+"):");
            System.out.println(maxSum(array));
            System.out.printf("\n"+"-----------------------------****分割线君****----------------------------------"+"\n");
        }
	}

}
