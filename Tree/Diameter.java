package Tree;

import java.util.*;
import java.io.*;
 class Diameter
{
    
    static int c=0;
    public static void main(String args[])throws IOException{
        
        solve();
      
    }
    
    public static void solve()throws IOException{
        Reader sc = new Reader();
		PrintWriter out = new PrintWriter(System.out);
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
        // Random r=new Random();
        // int x=r.nextInt(n-1);
        int x=0;
        int []dist_x=new int[n];
        dfs(x,list,-1,dist_x,-1);
        int y=0;
        for(int i=0;i<n;i++){
            if(dist_x[i]>dist_x[y])y=i;
        }
        int []dist_y=new int[n];
        dfs(y,list,-1,dist_y,-1);
        // System.out.println(Arrays.toString(dist_x));
        int d=0;
        for(int i=0;i<n;i++){
            if(dist_y[i]>dist_y[d])d=i;
        }
        System.out.println(dist_y[d]);
        

    }

    public static void dfs(int current,List<List<Integer>> adj,int parent,int[] dist,int d){
        dist[current]=d+1;
        for(int i:adj.get(current)){
            if(i!=parent)dfs(i,adj,current,dist,d+1);
        }

    }


    public static int log(int x, int b) {
        return (int) (Math.log(x) / Math.log(b));
    }
    
   static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
  
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
  
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
  
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
  
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
  
            if (neg)
                return -ret;
            return ret;
        }
  
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
  
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
  
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
  
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
  
            if (neg)
                return -ret;
            return ret;
        }
  
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
  
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
  
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

}
   