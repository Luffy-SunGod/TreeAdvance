package Tree;

import java.util.ArrayList;

public class Priorityqueue {
    private ArrayList<Integer> list;
    private int size;
    public Priorityqueue(){
        list=new ArrayList<>();
        this.size=0;
    }
    public void add(int data){
        this.list.add(data);
        this.size++;
        upHeapify(this.list.size()-1);

    }
    private void upHeapify(int ci){
        int pi=(ci-1)/2;
        if(this.list.get(ci)<this.list.get(pi)){
            swap(ci,pi);
            upHeapify(pi);
        }
    }
    private void swap(int ci, int pi) {
        int ith=this.list.get(ci);
        int jth=this.list.get(pi);
        this.list.set(ci, jth);
        this.list.set(pi, ith);
    }
    public int remove(){
        int x=this.list.get(0);
        swap(0,this.list.size()-1);
        this.list.remove(this.list.size()-1);
        downHeapify(0);
        return x;
    }
    private void downHeapify(int pi) {
        int mini=pi;
        int lc=2*pi+1;
        int rc=2*pi+2;
        if(lc<this.list.size()-1&&this.list.get(lc)<this.list.get(mini)){
            mini=lc;
        }
        if(rc<this.list.size()-1&&this.list.get(rc)<this.list.get(mini)){
            mini=rc;
        }
        if(mini!=pi){
            swap(pi,mini);
            downHeapify(mini);
        }
    }

    public int size(){

        return this.list.size();
    }
}

