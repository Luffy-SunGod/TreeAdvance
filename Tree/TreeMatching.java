package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TreeMatching {
    
    
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)map.put(i,new HashMap<>());
        for(int []a:edges){
            map.get(a[0]).put(a[1],a[2]);
            map.get(a[1]).put(a[0],a[2]);
        }

            List<Integer> ans=new ArrayList<>();
        int []m={0};
        for(int []a:queries){
            List<Integer> list=new ArrayList<>();
            List<Integer> list2=new ArrayList<>();
            int cost=0;            
            dfs(a[0],-1,a[1],m,list,map);
            int max=Integer.MIN_VALUE;
            for(int i=1;i<list.size();i++)list2.add(map.get(list.get(i-1)).get(list.get(i)));
            for(int i:list2)max=Math.max(max,i);
            for(int i:list2)cost+=(max-i);
            ans.add(cost);
        }
            System.out.println(ans);
        
        return m;
    }

    public boolean dfs(int src,int p,int des,int []max,List<Integer> list,HashMap<Integer,HashMap<Integer,Integer>> map){
        if(src==des){
            list.add(des);
        return true;
        }
        for(int i:map.get(src).keySet()){
            if(i!=p){
                list.add(src);
                if(dfs(i,src,des,max,list,map))return true;
                list.remove(list.size()-1);
            }
        }
        return false;
    }
}
