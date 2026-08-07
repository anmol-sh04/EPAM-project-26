import java.util.*;
public class Problem2 {
    static ArrayList<Integer>[] graph;
    static int[] distance;
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(distance, -1);
        distance[start] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbour : graph[current]) {
                if (distance[neighbour] == -1) {
                    distance[neighbour] = distance[current] + 1;
                    queue.add(neighbour);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        distance = new int[N + 1];
        bfs(1);
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] != -1 && distance[i] <= D) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
