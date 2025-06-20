
import java.util.*;
import java.io.*;

public class Main {

    static int n, r, l, sum;
    static int[][] a = new int[54][54];
    static int[][] visit;

    static List<int[]> p = new ArrayList<>();

    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
      Scan sc = new Scan();
      n = sc.nextInt();
      r = sc.nextInt();
      l = sc.nextInt();

      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            a[i][j] = sc.nextInt();
        }
      }

      int day = 0;
      while(true){
        visit = new int[n][n];
        boolean flag = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visit[i][j] == 0){
                    p.clear();
                    sum = 0;
                    dfs(i, j);
                    if(p.size() == 1){
                        continue;
                    }

                    for(int[] v : p){
                        a[v[0]][v[1]] = sum / p.size();
                    }
                    flag = false;
                }
            } 
        }

        if(flag) break;
        day++;
     }

     System.out.println(day);
 }  

      static void dfs(int y, int x){
        visit[y][x] = 1;
        p.add(new int[]{y, x});
        sum += a[y][x];

        for(int i = 0 ; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n || visit[ny][nx] != 0) continue;
            if(Math.abs(a[ny][nx] - a[y][x]) >= r && Math.abs(a[ny][nx] - a[y][x]) <=  l){
                dfs(ny,nx);
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
    }

}
