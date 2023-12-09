package Tree;

import java.util.ArrayList;
import java.util.Scanner;
public class Test {


    static ArrayList<Integer>[] adjList;
    static ArrayList<Pair> constructionPlan;
    static boolean[] visited;

    static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

// 10
// 5 9
// 8 5
// 7 6
// 7 9
// 3 9
// 2 1
// 7 2
// 3 6
// 7 1


    static ArrayList<Pair> dfs(int u, int parent) {
        visited[u] = true;
        ArrayList<Pair> plan = new ArrayList<>();

        for (int v : adjList[u]) {
            if (!visited[v]) {
                ArrayList<Pair> subPlan = dfs(v, u);
                plan.addAll(subPlan);
            }
        }

        if (parent != -1) {
            plan.add(new Pair(parent, u));
        }

// 10
// 5 9
// 8 5
// 7 6
// 7 9
// 3 9
// 2 1
// 7 2
// 3 6
// 7 1
// output is this 
// 2
// 3 6
// 1 7


        return plan;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int test = 0; test < t; test++) {
            int n = scanner.nextInt();
            adjList = new ArrayList[n];
            visited = new boolean[n];
            constructionPlan = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                int a = scanner.nextInt() - 1;
                int b = scanner.nextInt() - 1;
                adjList[a].add(b);
                adjList[b].add(a);
            }

            ArrayList<Pair> plan = dfs(0, -1);

            System.out.println(plan.size());
            for (Pair pair : plan) {
                System.out.println(pair.a + 1 + " " + (pair.b + 1));
            }
        }
    }


}
