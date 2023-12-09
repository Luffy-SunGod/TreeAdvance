package Tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left,right;
    public TreeNode(int val){
        this.val=val;
    }
    public TreeNode(){
       
    }
}
public class Bst {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int a[]={21,10,32,6,3,15,25,45,34};
        TreeNode root=new TreeNode();
        while(true){
            int d=s.nextInt();
            if(d==-1)break;
            root=insert(root,d);
        }
        
        display(root);
        
    }
    public static TreeNode insert(TreeNode root,int i) {
        if(root==null)return new TreeNode(i);
        if(i>root.val){
            root.right=insert(root.right, i);
        }else{
            root.left=insert(root.left, i);
        }
        return root;
    }

    public static void display(TreeNode root){
        if(root==null)return ;
        String s="<-"+root.val+"->";
        if(root.left!=null){
            s=root.left.val+s;
        }else s="null"+s;
        if(root.right!=null){
            s=s+root.right.val;
        }else s=s+"null";
        System.out.println(s);
        display(root.left);
        display(root.right);
    }
}
