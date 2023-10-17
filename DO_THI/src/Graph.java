import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

  static int n, m;
  static ArrayList < Integer > [] adj;
  static boolean[] visited;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println("Tim kiem chieu rong");
    inp();
    bfs(1);
    System.out.println();
    System.out.println("Tim kiem chieu sau");
    inp();
    dfs(1);

  }
  public static void inp() {
    n = 1001;
    m = 1001;
    adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList < > ();
    }

    // Đọc dữ liệu đầu vào
    // Nếu bạn muốn nhập từ bàn phím, bạn có thể sử dụng lớp Scanner
    // Scanner scanner = new Scanner(System.in);
    // n = scanner.nextInt();
    // m = scanner.nextInt();
    // for (int i = 0; i < m; i++) {
    //     int x = scanner.nextInt();
    //     int y = scanner.nextInt();
    //     adj[x].add(y);
    //     adj[y].add(x);
    // }

    n = 5;
    m = 6;
    int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 5}};
    for (int i = 0; i < m; i++) {
      int x = edges[i][0];
      int y = edges[i][1];
      adj[x].add(y);
      adj[y].add(x);
    }
    visited = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      visited[i] = false;
    }
  }
  public static void bfs(int u) {
    Queue < Integer > q = new LinkedList < > ();
    q.add(u);
    visited[u] = true;

    while (!q.isEmpty()) {
      int v = q.poll();
      System.out.print(v + " ");
      for (int x: adj[v]) {
        if (!visited[x]) {
          q.add(x);
          visited[x] = true;
        }
      }
    }
  }
  public static void dfs(int u) {
    System.out.print(u + " ");
    visited[u] = true;
    for (int v: adj[u]) {
      if (!visited[v]) {
        dfs(v);
      }
    }
  }
}