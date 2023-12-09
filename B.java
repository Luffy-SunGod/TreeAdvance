import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String input_Stream=s.nextLine();
        int W=s.nextInt();

        String arr[]=input_Stream.split(" ");
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(!arr[i].equals(("0")))
            list.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(list,Collections.reverseOrder());
        int i=0;
        int j=list.size()-1;
        int c=0;
        while(i<=j){
            if(list.get(j)+list.get(i)<=W){
                j--;
            }
            i++;
            c++;
            
        }
        System.out.println(c);
    }
    

    
    
}
