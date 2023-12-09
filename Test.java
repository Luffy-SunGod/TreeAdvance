import java.util.LinkedList;
import java.util.*;

public class Test {
    static class Pair{
        int r;
        int c;
        int val;
        public Pair(int r,int c,int val){
            this.r=r;
            this.c=c;
            this.val=val;
        }
        
    }
    public static void main(String[] args) {
        int [][]a={ {4,4,0,0,0},
                    {3,4,0,2,2},
                    {3,3,0,2,2},
                    {0,0,1,2,2},
                    {0,0,1,1,1}};
        int n=a.length;
        int m=a[0].length;
        int i=2;
        int j= 2; 
        int h=3;
        
        System.out.println(rec(a,n,m,h,i,j));
        
        
    }
    public static int rec(int [][]a,int n ,int m,int h,int i, int j){
        int count=0;
        if(a[i][j]!=0)return 0;
        
        int []r={1,0,-1,0};
        int []c={0,1,0,-1};
        for(int k=0;k<r.length;k++){
            int row=i+r[k];
            int col=j+c[k];
            // System.out.println("hello");
            if(row<0||row>=n||col<0||col>=m||a[row][col]>h||a[row][col]==0)continue;
            else{
                if(a[row][col]<=h){
                    System.out.println(row+"->"+col);
                    dfs(a,row,col,a[row][col]);
                    count++;
                }
                    System.out.println(Arrays.deepToString(a));
                }
            }
            return count;
        }
        
    public static void dfs(int [][]a,int r,int c,int val){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(r,c,a[r][c]));
            int []row={1,0,-1,0};
            int []col={0,1,0,-1};
            while(!q.isEmpty()){
                Pair rv=q.remove();
                System.out.println(rv.r+"->"+rv.c);
                a[rv.r][rv.c]=0;
                for(int i=0;i<row.length;i++){
                    int newr=rv.r+row[i];
                    int newc=rv.c+col[i];
                if(newr>=0&&newr<a.length&&newc>=0&&newc<a[0].length&&a[newr][newc]!=0&&a[newr][newc]==val){
                    q.add(new Pair(newr,newc,a[newr][newc]));
                }
            }

        }
    }
}
