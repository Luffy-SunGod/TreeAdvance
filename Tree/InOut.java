package Tree;

import java.util.*;
import java.io.*;

public class InOut {
    
    static PrintWriter out=new PrintWriter((System.out));
    static Reader sc=new Reader();
    static int c=0;
    public static void main(String args[])throws IOException{
        solve();
        out.close();
    }
    
    public static void solve(){
        int t=sc.nextInt();
        while(t-->0){
          int n=sc.nextInt();
          String str=sc.next();
          int []a=new int[n];
          int total=0;
          for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            total+=a[i];
          }
          char []b=str.toCharArray();
          HashMap<Character,Integer> map=new HashMap<>();
          int i=0;
          for(char c:b){
            map.put(c,Math.max(map.getOrDefault(c,0),a[i]));
            i++;
          }
          // System.out.println(map);
          
          for(char c:map.keySet())total-=map.get(c);
          System.out.println(total);
        }
        

    }

    public static void dfs(int current,List<List<Integer>> adj,int parent,int []d,int[] in,int[] out,List<Integer> euler){
        in[current]=++d[0];
        euler.add(current);
        for(int i:adj.get(current)){
            if(i!=parent)dfs(i, adj, current, d, in, out,euler);
        }
        out[current]=++d[0];
        euler.add(current);
    }

    public static List<Integer> rec(List<List<Integer>> map ,int []in,int []out,int [][]q){
        List<Integer> ans=new ArrayList<>();
        for(int []a :q){
            int n=a.length;
            Set<Integer> set=new HashSet<>();
            for(int i=0;i<n;i++){
                boolean flag=false;
                for(int j=0;j<n;j++){
                    if(a[i]==a[j])continue;
                    if(in[a[i]]>in[a[j]]&&out[a[i]]<out[a[j]]){
                        flag=true;
                        break;
                    }
                }
                if(!flag)set.add(a[i]);
            }
            for(int x:set){
                n=n-((in[x]+out[x])/2);
            }
            ans.add(n);
        }
        return ans;
    }
    
    
    
    
}


class Reader 
{ 
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer("");
    public String next()
    {
        while(!st.hasMoreTokens())
        {
            try
            {
                st=new StringTokenizer(br.readLine());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    public int nextInt()
    {
        return Integer.parseInt(next());
    }

    public long nextLong()
    {
        return Long.parseLong(next());
    }
    public double nextDouble()
    {
        return Double.parseDouble(next());
    }
    public String nextLine()
    {
        try
        {
            return br.readLine();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public boolean hasNext()
    {
        String next=null;
        try
        {
            next=br.readLine();
        }
        catch(Exception e)
        {
        }
        if(next==null)
        {
            return false;
        }
        st=new StringTokenizer(next);
        return true;
    }
}
