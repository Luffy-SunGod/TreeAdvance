package Tree;

import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        int []a={5,2,4,9,11,3};
        System.out.println("Before Sorting --->");
        System.out.println(Arrays.toString(a));
        QuickSort(a, 0, a.length-1);
        System.out.println("After Sorting --->");
        System.out.println(Arrays.toString(a));
        


    }

    public static void QuickSort(int []a,int si,int ei){
        if(si>ei)return ;
        int pi=findPivot_Index(a,si,ei);// pivot index
        QuickSort(a, si, pi-1);
        QuickSort(a ,pi+1,ei);
    }
    public static int findPivot_Index(int []a,int si,int ei){
        int pivot=a[ei];
        int pi=si;

        for(int i=si;i<ei;i++){
            if(a[i]<=pivot){
                int temp=a[i];
                a[i]=a[pi];
                a[pi]=temp;
                pi++;
            }

        }
        int temp=a[ei];
        a[ei]=a[pi];
        a[pi]=temp;
        return pi;
    }

}
