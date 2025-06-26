import java.io.*;
import java.util.*;

//1.물을 움직임 -> 물을 움직여서 녹인다.

// 2.백조가 움직임 -> 만나는 지확인한다.

// 백조가 만남 -> while(백조가 닿을 때까지)

//날짜 증가

public class Main {

    static int max = 1504;
    static int[][] vs = new int[max][max], v = new int[max][max];
    static int r, c , day, sy, sx;
    static char[][] a = new char[max][max];
    static Deque<int[]> wq = new ArrayDeque<>(), wtq = new ArrayDeque<>(), sq = new ArrayDeque<>(), stq = new ArrayDeque<>();
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
           if(a[i][j] == 'L'){
                v[i][j] = 1;
                wq.add(new int[]{i,j});
                sy = i;
                sx = j;
          }
          if(a[i][j] == '.'){
            v[i][j] = 1;
            wq.add(new int[]{i,j});
          }
       }
    }
    
    sq.add(new int[]{sy,sx});
    vs[sy][sx] = 1;
        
        while(true){
            if(moveSwan()) break;
            waterMelting();
            day++;
        }
    System.out.println(day);
}
    
    static void waterMelting(){
        while(!wq.isEmpty()){
            int[] f = wq.poll();
            int y = f[0];
            int x = f[1];
            
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c || v[ny][nx] != 0) continue;
                if(a[ny][nx] == 'X'){
                    v[ny][nx] = 1;
                    wtq.add(new int[]{ny,nx});
                    a[ny][nx] = '.';    
                }
            }
        }
        wq = wtq;
        wtq = new ArrayDeque<>();
    }
    
    static boolean moveSwan(){
        while(!sq.isEmpty()){
            int[] f = sq.poll();
            int y = f[0];
            int x = f[1];
            
            for(int i = 0; i < 4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c || vs[ny][nx] != 0) continue;
                vs[ny][nx] = 1;
                if(a[ny][nx] == '.') sq.add(new int[]{ny, nx});
                else if(a[ny][nx] == 'X') stq.add(new int[]{ny, nx});
                else if(a[ny][nx] == 'L') return true;
            }
        }
        sq = stq;
       stq = new ArrayDeque<>();
        return false;
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
    }
}
