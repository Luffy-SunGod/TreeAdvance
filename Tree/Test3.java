package Tree;

import java.util.*;


public class Test3 {
    public static int maxBitCount(long[] A) {
        int maxCount = 0;

        for (int i = 0; i <= 31; i++) {
            int count = 0;

            for (long num : A) {
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    // public static void main(String[] args) {
    //     int[] A = {1,2,3,6,5};

    //     // int maxBitCountValue = maxBitCount(A);
    //     System.out.println("Maximum value of f(x): " + maxBitCountValue);
	// }

    

}
