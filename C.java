import java.util.*;

// 123456
// RLTDRRTRS2S1

public class C {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String  x1=s.nextLine();
        String a1[]=x1.split(" ");
        int p=Integer.parseInt(a1[0]);
        int v=Integer.parseInt(a1[1]);
        
        String passenger[]=new String[p];
        for(int i=0;i<p;i++){
            passenger[i]=s.nextLine();
        }
        String vehicle[]=new String[v];
        for(int i=0;i<v;i++){
            vehicle[i]=s.nextLine();
        }
        // System.out.println(Arrays.toString(passenger));
        // System.out.println(Arrays.toString(vehicle));
        Set<String> set=new HashSet<>();
        int ans=0;
        Arrays.sort(passenger);
        Arrays.sort(vehicle);
        for(int i=0;i<p;i++){
            String arr[]=passenger[i].split(" ");
            int x=Integer.parseInt(arr[1]);
            int y=Integer.parseInt(arr[2]);
            int min=Integer.MAX_VALUE;
            String vh="";
            for(int j=0;j<v;j++){
                String arr2[]=vehicle[j].split(" ");
                if(set.contains(arr2[0]))continue;
                int d1=Integer.parseInt(arr2[1]);
                int d2=Integer.parseInt(arr2[2]);
                if(Math.abs(x-d1)+Math.abs(y-d2)<min){
                    min=Math.min(min,Math.abs(x-d1)+Math.abs(y-d2));
                    vh=arr2[0];
                }
                
            }
            // System.out.println(arr[0]+"->"+vh);
            ans+=min;
            set.add(vh);
        }
        System.out.println(ans);

    }
}

// 4 8
// Vishnu 4 4
// Ravali 1 6
// Krishna 8 3
// Vaishnavi 3 2
// v106 6 4
// v42 2 4
// v69 4 1
// v45 3 3
// v66 5 3
// v312 9 5
// v93 8 1
// v123 4 6

// 3 5
// Maya 4 4
// Neha 1 1
// Tara 7 1
// v11 3 6
// v82 1 6
// v69 4 1
// v109 3 3
// v26 10 5




