package Tree;

import java.util.*;
import java.io.*;
 class Basics
{
    static PrintWriter out=new PrintWriter((System.out));
    static Reader sc=new Reader();
    static int c=0;
    public static void main(String args[])throws IOException{
        
            solve();
        out.close();
    }
    
    public static void solve(){
        int n=sc.nextInt();
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        // System.out.println(list);
        for(int i=0;i<n-1;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            a--;b--;
            list.get(a).add(b);
            list.get(b).add(a);
        }  
        System.out.println(list);
        List<Integer> path=new ArrayList<>();
        int []level=new int[n];
        int []subtree=new int[n];
        dfs(list,0,subtree,-1,0);
        System.out.println(Arrays.toString(subtree));
    }

    public static void dfs(List<List<Integer>> adj ,int src,int[]subtree,int parent,int level){
        for(int i:adj.get(src)){
            if(i!=parent)dfs(adj,i,subtree,src,level+1);
            subtree[src]=subtree[i];
        }
        subtree[src]++;

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


// 5
// 1 2
// 1 3 
// 3 4
// 3 5

