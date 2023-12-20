package Tree;

import java.util.ArrayList;

public class Ip {
    public static void main(String[] args) {
        String s="1111";
        System.out.println(genIp(s));
    }
    public static ArrayList<String> genIp(String s){
        ArrayList<String> list=new ArrayList<>();
         rec(s,0,0,list,"");
         return list;
    }
    public static  void rec(String s,int i,int nd,ArrayList<String> list,String ans){
        if(i>=s.length()||nd>3)return ;
        if(nd==3&&i==s.length()-1)return ;
        if(nd==3){
            // System.out.println(s.substring(i, s.length()));
            if(s.substring(i,s.length()).length()>0&&Integer.parseInt(s.substring(i,s.length()))<=255){
                list.add(ans);
            }
            return;
        }
        for(int j=1;j<=3;j++){
            if(i+j<=s.length()&&Integer.parseInt(s.substring(i,i+j))<=255){
                System.out.print(s+"--->");
                System.out.println(s.substring(i,i+j));
                if(ans.length()==0)rec(s,i+j,nd+1,list,s.substring(0,Math.min(i+j,s.length()))+"."+s.substring(Math.min(i+1,s.length()),s.length()));
                else rec(s,i+j,nd+1,list,ans.substring(0,Math.min(i+j+1+nd,ans.length()))+"."+ans.substring(Math.min(i+2+nd,ans.length()),ans.length()));
            }
        }
    }
}
