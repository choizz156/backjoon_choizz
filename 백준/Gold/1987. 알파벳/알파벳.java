import java.util.*;
import java.io.*;

public class Main {
   	
    static int r, c, ret;
    static char[][] a = new char[24][24];
    static int[] v = new int[26];
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        
        Scan sc = new Scan();
        r = sc.nextInt();
        c = sc.nextInt();
        for(int i = 0; i < r; i++){
            String s = sc.next();
            for(int j = 0; j < c; j++){
                a[i][j] = s.charAt(j);
            }
        }
        
        v[a[0][0] - 'A'] = 1;
        go(0,0,1);
        System.out.println(ret);
      
    }
    
    static void go(int y, int x, int cnt){
        ret = Math.max(ret,cnt);
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= r || nx >=c) continue;
            int next = a[ny][nx] - 'A';
            if(v[next] == 0){
                v[next] = 1;
                go(ny,nx,cnt + 1);
                v[next] = 0;
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
