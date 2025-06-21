import java.util.*;
import java.io.*;


public class Main {
    
    static int n, m, ret;
    static char[][] a;
    static int[][] jh, f;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static Deque<int[]> jq = new ArrayDeque<>();
    static Deque<int[]> fq = new ArrayDeque<>();
    

    public static void main(String[] args) throws Exception{
        var sc = new Scan();
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        jh = new int[n][m];
        f = new int[n][m];

         int inf = Integer.MAX_VALUE;    
        for(int[] r : f){
            Arrays.fill(r, inf);
        }
        
        for(int i = 0; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < m; j++){
                a[i][j] = s.charAt(j);
                if(a[i][j] == 'F'){
                    f[i][j] = 1;
                    fq.add(new int[]{i,j});
                }else if(a[i][j] == 'J'){
                    jh[i][j] = 1;
                    jq.add(new int[]{i,j});
                }
            }
        }
        
        
        
        while(!fq.isEmpty()){
            int[] z = fq.poll();
            
            int y = z[0];
            int x = z[1];
            
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(nx < 0 || ny < 0 || nx >= m || ny >= n || a[ny][nx] == '#') continue;
                if(f[ny][nx] != inf) continue;
                
                f[ny][nx] = f[y][x] + 1;
                fq.addLast(new int[]{ny,nx});
            }
        }
        
        while(!jq.isEmpty()){
            int[] z = jq.poll();
            
            int y = z[0];
            int x = z[1];
            
            
            if(y == n - 1 || x == m - 1 || y == 0 || x == 0){
                ret = jh[y][x];
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if(nx < 0 || ny < 0 || nx >= m || ny >= n || a[ny][nx] == '#' ||jh[ny][nx] != 0) continue;

                if(f[ny][nx] <= jh[y][x] + 1) continue;
                jh[ny][nx] = jh[y][x] + 1;
                jq.addLast(new int[]{ny,nx});
            }
        }
        
        if(ret != 0) System.out.println(ret);
        else System.out.println("IMPOSSIBLE");
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