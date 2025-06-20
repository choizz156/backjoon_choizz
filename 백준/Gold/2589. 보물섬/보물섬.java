import java.util.*;
import java.io.*;

class Main {
    
    static int n, m;
    static int[][] a, v;
    
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
   
    public static void main(String[] args) throws Exception{
      
        var sc = new Scan();
        
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        
        for(int i = 0; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < m; j++){
                a[i][j] = (s.charAt(j) == 'W') ? 0 : 1;
            }
        }
        
        int max = -1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                v = new int[n][m];
                int d = 0;
                if(v[i][j] == 0 && a[i][j] == 1){
                    d = bfs(i,j);
                }
                max = Math.max(max, d);
            }
        }
        
        System.out.println(max);
    }
    
    static int bfs(int y, int x){
        int k = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y,x});
        v[y][x] = 1;
        
        while(!q.isEmpty()){
            
            int[] f = q.poll();
            int fy = f[0];
            int fx = f[1];
            
            for(int i = 0; i < 4; i++){
                int ny = fy + dy[i];
                int nx = fx + dx[i];
                
                if(ny < 0 || nx < 0 || nx >= m || ny >= n || v[ny][nx] != 0 || a[ny][nx] == 0) continue;
                v[ny][nx] = v[fy][fx] + 1;
                k = v[ny][nx];
                q.add(new int[]{ny,nx});                
            }
        }
        
        return k - 1;
    }

    static class Scan{
        BufferedReader br;
        StringTokenizer st;
        
        public Scan(){
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