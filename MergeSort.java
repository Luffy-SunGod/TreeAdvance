import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int []a={5,2,4,9,11,3};
        System.out.println("Before Sorting");
        System.out.println(Arrays.toString(a));
        a=mergeSort(a, 0, a.length-1);
        System.out.println("After Sorting");
        System.out.println(Arrays.toString(a));
    }

    public static int[] mergeSort(int []a,int lo,int hi){
        if(lo==hi){
            return new int[]{a[lo]};
        }
        int mid=(lo+hi)/2;
        int []left=mergeSort(a, lo, mid);
        int []right=mergeSort(a, mid+1,hi);
        return merge2SortedArrays(left,right);
    }
    public static int[] merge2SortedArrays(int []left,int[]right){
        int n=left.length;
        int m=right.length;
        int i=0,j=0,k=0;

        int []ans=new int[n+m];
        while(i<n&&j<m){
            if(left[i]<right[j]){
                ans[k]=left[i];
                k++;
                i++;
            }else{
                ans[k]=right[j];
                k++;
                j++;
            }
        }
        while(i<n){
            ans[k]=left[i];
            k++;
            i++;
        }
        while(j<m){
            ans[k]=right[j];
            k++;
            j++;
        }
        return ans;
    }
}
