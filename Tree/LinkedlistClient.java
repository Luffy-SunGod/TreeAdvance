package Tree;

import java.util.*;


public class LinkedlistClient{
    public static void main(String[] args) {
        
       int []a={1,2,3,4,5,6};
       int []b={3,5,7,8,9};
       System.out.println(median(a,b));



        
    }
    public static double median(int[] a, int[] b) {
        int n1=a.length;
        int n2=b.length;
        if(n1>n2)return median(b,a);
        int n=n1+n2+1;
        int left=(n+1)/2;
        int lo=0;
        int hi=a.length;
        while(lo<=hi){
           int mid1 = (lo + hi) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);// for odd length;
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;// for even length
            } else if (l1 > r2) hi = mid1 - 1;
            else lo =mid1 + 1;
        }
        return 0;
    }
 
     
    

  


}
