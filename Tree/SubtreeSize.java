package Tree;

import java.util.*;

public class SubtreeSize {
    public static void main(String[] args) {
        
    }

    public void dfs(int node, int parent ,HashMap<Integer,List<Integer>> map,int []dp){
        
        for(int i:map.get(node)){
            if(i!=parent)dfs(i,node,map,dp);
            dp[node]+=dp[i];
        }
        dp[node]+=map.get(node).size()-(node!=1?1:0);

    }
}
