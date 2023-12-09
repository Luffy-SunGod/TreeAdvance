    import java.util.*;
    class SegmentTree {
     class Node{
        int data=0;
        Node left;
        Node right;
        int si;
        int ei;
        public Node(int si,int ei){
            this.si=si;
            this.ei=ei;
        }
        public String toString(){
            return ""+this.si+"->"+this.ei;
        }
    }

    Node root;
    public SegmentTree(int []a,int si,int ei){
        root=createTree(a,si,ei);

    }
    public Node createTree(int []a,int si,int ei){
        if(si>ei)return new Node(-1,-1);
        if(si==ei){
            Node newNode=new Node(si,ei);
            newNode.data+=a[si];
            return newNode;
        }
        Node root=new Node(si,ei);
        int mid=(si+ei)/2;
        root.left=createTree(a, si, mid);
        root.right=createTree(a,mid+1,ei);
        root.data+=root.left.data+root.right.data;
        return root;

    }
    public void Display(){
        Display(root);
    }
    private void Display(Node root){
        if(root==null)return;
        String s="==>"+root.data+"<==";
        if(root.left!=null)s=root.left.data+s;
        else s="null"+s;
        if(root.right!=null)s=s+root.right.data;
        else s=s+"null";
        System.out.println(s);
        Display(root.left);
        Display(root.right);
    }

    public int query(int si,int ei){
        return query(root,si,ei);
    }

    private int query(Node root,int si,int ei){
        if(root==null)return 0;
        if(root.si>=si&&root.ei<=ei){
            int ans=root.data;
            return ans;
        }
        else if(si>=root.si||ei<=root.ei){
            int ans= query(root.left, si,ei)+query(root.right, si,ei);
            return ans;
        }else {
            return 0;
        }


    }

    public void query2(int l,int u,List<Integer> list){
        query2(root,l,u,list);
    }
    private void query2(Node root,int l,int u,List<Integer> list){
        if(root==null)return;
        if(l>=root.data&&root.data<=u)list.add(root.data);
        query2(root.left,l,u,list);
        query2(root.right,l,u,list);
    }



    public int countRangeSum(int[] nums, int lower, int upper) {
        SegmentTree t=new SegmentTree(nums,0,nums.length-1);
        List<Integer> list=new ArrayList<>();
        t.query2(lower,upper,list);
        return list.size();

    }
}
