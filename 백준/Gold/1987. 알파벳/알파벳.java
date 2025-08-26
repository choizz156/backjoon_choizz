import java.util.*;
import java.io.*;


public class Main {
    
     static int r, c, ret;
     static char[][] board;
     static boolean[] v = new boolean[26];
     static int[] dy = {-1, 0, 1, 0};
     static int[] dx = {0,1,0,-1};


    public static void main(String[] args) throws Exception{
        
      var sc = new Scan();
      r = sc.nextInt();
      c = sc.nextInt();

      board = new char[r][c];

      for(int i = 0; i < r; i++){
        var l = sc.nextLine();
        board[i] = l.toCharArray();
      }  

      v[board[0][0] - 'A'] = true;
      dfs(0,0,1);
      System.out.println(ret);
    }

    static void dfs(int y, int x, int cnt){
        ret = Math.max(ret, cnt);

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;

            int idx = board[ny][nx] - 'A';

            if(!v[idx]){
                v[idx] = true;
                dfs(ny, nx, cnt + 1);
                v[idx] = false;
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