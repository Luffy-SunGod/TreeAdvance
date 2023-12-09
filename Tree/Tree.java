package Tree;

import java.util.*;

 class TreeNode{
    String data;
    TreeNode left;
    TreeNode right;
    public TreeNode(String data){
        // System.out.println("hello");
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
 class Tree {
    public static void main(String[] args){
           Scanner s=new Scanner(System.in);
           String input=s.nextLine();
           String tokens[]=input.split(" ");
           System.out.println(tokens[0]);

           TreeNode root=new TreeNode(tokens[0]);
           
            Queue<TreeNode> q=new LinkedList<>();
            int i=1;
            q.add(root);
            while(!q.isEmpty()&&i<tokens.length){
                int size=q.size();
                while(size-->0&&i<tokens.length){
                    TreeNode rv=q.remove();
                    if(!tokens[i].equals("N")){
                        rv.left=new TreeNode(tokens[i]);
                        i++;
                        q.add(rv.left);
                    }else i++;
                    if(!tokens[i].equals("N")){
                        rv.right=new TreeNode(tokens[i]);
                        i++;
                        q.add(rv.left);
                    }else i++;
                }
            }
            List<String> list=new ArrayList<>();
            rec(root,list);
            System.out.println(list);

        }
        public static void rec(TreeNode root,List<String> list){
            if(root==null)return;
            list.add(root.data);
            rec(root.left,list);
            rec(root.right,list);
        }
}
