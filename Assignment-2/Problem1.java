import java.util.*;

public class Problem1 {

    static ArrayList<Integer>[] graph;
    static int[] key;
    static int K;
    static int count = 0;

    static void dfs(int node, int parent, int xorValue) {

        xorValue = xorValue ^ key[node];

        if (xorValue >= K) {
            count++;
        }

        for (int child : graph[node]) {

            if (child != parent) {
                dfs(child, node, xorValue);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();
        key = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            key[i] = sc.nextInt();
        }
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(1, 0, 0);
        System.out.println(count);
    }
}