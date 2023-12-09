import java.util.*;

public class F {

    public static void main(String[] args) {
        int []a={5,1,2,6,6,1,3,1,4,3,4,3,4,6,1,2,4,1,6,2};
        int n=a.length;
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(rec(a,0,-1,dp));
    }
    public static  int rec(int []a,int i,int prev,int []dp){
        if(i>=a.length-1)return 0;
        if(i==-1&&dp[0])
        if(dp[i/2+1]!=-1)return dp[i/2+1];
        int take=0,not=0;
        if(prev==-1||prev==a[i]){
            take=1+rec(a,i+2,a[i+1],dp);
        }
        not=rec(a,i+2,prev,dp);
        return dp[i/2+1]=Math.max(take, not);
    }
   
}