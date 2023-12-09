package Tree;

import java.util.*interface;

public class D {
    static class Pair{
        String city;
        int good;
        int tax;
        public Pair(String city,int good,int tax){
            this.city=city;
            this.good=good;
            this.tax=tax;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();
        String a[][]=new String[n][4];
        HashMap<String,List<Pair>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String str=s.nextLine();
            String arr[]=str.split(" ");
            a[i][0]=arr[0];
            a[i][1]=arr[1];
            a[i][2]=arr[2];
            a[i][3]=arr[3];
            if(!map.containsKey(arr[0])){
                map.put(arr[0],new ArrayList<>());
            }
            map.get(arr[0]).add(new Pair(arr[1],Integer.parseInt(arr[2]),Integer.parseInt(arr[3])));

        }




    }
}
