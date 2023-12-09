package Tree;

import java.io.IOException;
import java.util.*;

public class Lca {
    static Reader s=new Reader();
    static int n;
    public static void main(String[] args) throws IOException {
         n=s.nextInt();
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=n-1;i++)list.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){
            int a=s.nextInt();
            int b=s.nextInt();
            a--;b--;
            list.get(a).add(b);
            list.get(b).add(a);
        }
        // 5
        // 1 2
        // 1 3 
        // 3 4
        // 3 5
        // 3 4
        // 2
        // System.out.println(list);
        int x=s.nextInt();
        int y=s.nextInt();
        x--;
        y--;
        // int k=s.nextInt();

        int[]parent=new int[n];
        int[]level=new int[n];
        level(parent,level, list, 0, -1, 0);
        b.preComputeParent(n,parent);
        System.out.println(lca(x, y, level));
        
    }
    static BinaryLifting b=new BinaryLifting();
    public static int lca(int x,int y,int []level){
        if(level[x]>level[y]){
            x=b.kthParent(x, level[x]-level[y]);
            System.out.println("hiiii");
        }
        if(level[y]>level[x])y=b.kthParent(y, level[y]-level[x]);
        System.out.println("x->"+x+"->y->"+y);
        for(int i=log(n, 2);i>=0;i--){
            int a=b.kthParent(x, i);
            int b1=b.kthParent(y, i);
            if(a!=b1){
                x=a;
                y=b1;
            }
        }
        return b.kthParent(x, 0);
    }

    public  static void level(int []parent,int []level,List<List<Integer>> adj,int c,int p,int l){
        for(int i:adj.get(c)){
            if(i!=p){
                level[i]=l+1;
                parent[i]=c;
                level(parent,level,adj,i,c,level[i]);
            }
        }
    }

    public static  int log(int x, int b) {
        return (int) (Math.log(x) / Math.log(b));
    }


// 5
// 1 2
// 1 3 
// 3 4
// 3 5
// 3 1
    

}
