import java.util.*;
import java.io.*;

public class Main {

    static int n, m, mx;
    static char[][] a = new char[54][54];
    static int[][] visit;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1}; 


    public static void main(String[] args) throws Exception{
       Scan sc = new Scan();
       n = sc.nextInt();
       m = sc.nextInt();

       for(int i = 0; i < n; i++){
        String s = sc.next();
        for(int j = 0; j < m; j++){
            a[i][j] = s.charAt(j);
        }
       }

        mx = -111111;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visit = new int[54][54];
                if(a[i][j] == 'L'){
                    bfs(i,j);
                }
            }
        }

        System.out.println(mx - 1);

    }

    static void bfs(int y, int x){
        visit[y][x] = 1;

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{y,x});

        while(!q.isEmpty()){
            int[] f = q.pollFirst();
            y = f[0];
            x = f[1];

            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || visit[ny][nx] != 0 || a[ny][nx] == 'W') 
                    continue;
                visit[ny][nx] = visit[y][x] + 1;
                q.addLast(new int[]{ny, nx});
                mx = Math.max(mx, visit[ny][nx]);
            }
        }

    }



    static class Scan{
        BufferedReader br;
        StringTokenizer st;

        Scan(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws Exception{
            while(st == null || !st.hasMoreElements()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws Exception{
            return Integer.parseInt(next());
        }

        String nextLine() throws Exception{
            return br.readLine();
        }
    }
}
