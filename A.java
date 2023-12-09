import java.util.*;
import java.io.*;

class A {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    
        String input=s.nextLine();
        String arr[]=input.split(" ");

        StringBuilder s1=new StringBuilder(arr[0]);
        String name=arr[1];
        s1.append(".");
        System.out.println(arr[0].replaceFirst("^0+(?!$)", ""));
    }

}
// 4->3->4->3->4->3