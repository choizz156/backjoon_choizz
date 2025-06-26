import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int x1, y1, x2, y2;
    static char[][] a;
    static int[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        Scan sc = new Scan();
        n = sc.nextInt();
        m = sc.nextInt();

        a = new char[n][m];
        visited = new int[n][m];

    
        y1 = sc.nextInt() - 1;
        x1 = sc.nextInt() - 1;
        y2 = sc.nextInt() - 1;
        x2 = sc.nextInt() - 1;

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = line.charAt(j);
                  if (a[i][j] == '*') {
                    y1 = i;
                    x1 = j;
                } else if (a[i][j] == '#') {
                    y2 = i;
                    x2 = j;
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        
         var q = new ArrayDeque<int[]>();
         var next = new ArrayDeque<int[]>();
         q.add(new int[]{y1, x1});
         visited[y1][x1] = 1;
        
        int jumps = 0;
        while (visited[y2][x2] == 0) {
            jumps++;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int y = cur[0];
                int x = cur[1];

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if (visited[ny][nx] != 0) continue;

                    visited[ny][nx] = 1;
               
                    if (a[ny][nx] == '#') {
                        return jumps;
                    } else if (a[ny][nx] == '0') {
                        q.add(new int[]{ny, nx});
                    } else if (a[ny][nx] == '1') {
                        next.add(new int[]{ny, nx});
                        a[ny][nx] = '0';
                    }
                }
            }
            q = next;
            next = new ArrayDeque<>();
        }
        
        return jumps;
    }


    static class Scan {
        BufferedReader br;
        StringTokenizer st;

        Scan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws Exception {
            return Integer.parseInt(next());
        }

        String nextLine() throws Exception {
            return br.readLine();
        }
    }
}
