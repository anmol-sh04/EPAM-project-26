# EPAM PROJECT - 26

## Assignment 1: Bank Customer Page using JavaScript

### About the Project

The **Bank Customer Page** is a simple web application developed using **HTML, CSS, and JavaScript**. It allows users to perform basic banking operations through an interactive interface while demonstrating fundamental JavaScript concepts such as functions, conditional statements, and DOM manipulation.

### Features

* Register a new customer
* Deposit money into the account
* Withdraw money from the account
* Check the current account balance
* View transaction history

### Technologies Used

* HTML5
* CSS3
* JavaScript (Vanilla JavaScript)

---

## Assignment 2: Tree of Trusted Servers

### About the Project

The **Tree of Trusted Servers** problem determines the number of trusted servers in a tree based on the XOR of security keys along the path from the root server. The solution uses **DFS traversal** and calculates the path XOR for each server.

### Features

* Represents the tree using an adjacency list
* Calculates path XOR using DFS
* Checks the XOR value against the given threshold `K`
* Counts the number of trusted servers

### Technologies Used

* Java
* DFS (Depth First Search)
* Graph / Adjacency List
* Bitwise XOR

### Code

```java
import java.util.*;

public class Main {

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

        sc.close();
    }
}
```

### Example Input

```text
5 2
1 3 2 5 6
1 2
1 3
3 4
3 5
```

### Example Output

```text
4
```

### Complexity

* **Time Complexity:** `O(N)`
* **Space Complexity:** `O(N)`


