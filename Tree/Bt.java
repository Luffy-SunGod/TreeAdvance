package Tree;

import java.util.*;


class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

}
public class Bt {
    public boolean graphColoring(boolean graph[][], int m, int v) {
        int []color=new int[v];
        
        if(coloring(graph,m,v,0,color))return true;
        
        return false;
    }
    
    public boolean coloring(boolean[][]graph,int m,int v,int node,int []color){
        if(node==v)return true ;
        for(int i=1;i<=m;i++){
            if(isPossible(node,i,graph,v,color)){
                color[node]=i;
                if(coloring(graph,m,v,node+1,color))return true;
                color[node]=0;
            }
        }
        return false;
        
    }
    
    public boolean isPossible(int node,int c,boolean[][]graph,int v,int []color){
        for(int i=0;i<v;i++){
            if(i!=node&&graph[i][node]&&color[i]==c)return false;
        }
        return true;
    }
}
