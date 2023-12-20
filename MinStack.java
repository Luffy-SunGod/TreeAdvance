import java.util.*;

public class MinStack {
    Stack<Integer> s;
    int min;
    public MinStack(){
        s=new Stack<>();
        min=Integer.MAX_VALUE;
    }
    public int size(){
        return this.s.size();
    }
    public boolean isEmpty(){
        return this.isEmpty();
    }

    public void push(int x){
        if(s.size()==0){
            min=x;
        }
        int val=0;
        if(x<min){
             val=2*x-min;
             min=x;
             s.push(val);
             System.out.println(val);
        }else s.push(x);

    }
    public int pop(){
        if(s.isEmpty())return -1;
        if(s.size()==1){
            min=s.peek();
            return min;
        }
        int x=s.pop();
        if(x<min){
            int res=min;
            min=2*min-x;
            return res;
        }
        return min;
    }
}
