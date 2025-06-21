import java.util.*;
import java.io.*;

public class Main {
    static int n, ret;
    static int[] a = new int[3];
    static int[][][] visit = new int[64][64][64];

    static int[][] c ={
        {9,3,1},
        {9,1,3},
        {1,3,9},
        {1,9,3},
        {3,1,9},
        {3,9,1},
    };
 
    
 
    public static void main(String[] args) throws Exception{
        Scan sc = new Scan();
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        } 

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(a);

        while(!q.isEmpty()){
            int[] f = q.pollFirst();
            int y = f[0];
            int x = f[1];
            int z = f[2];

            if(visit[0][0][0] != 0) {
                 ret = visit[0][0][0];
                 break;
            }

            for(int i = 0 ; i < 6; i++){
                int[] next = new int[3];
                for(int j = 0; j < 3; j++){
                    next[j] = Math.max(0, f[j] - c[i][j]);
                }
                if(visit[next[0]][next[1]][next[2]] != 0) continue;
                visit[next[0]][next[1]][next[2]] = visit[y][x][z] + 1;
                q.addLast(next);
            }
        }

        System.out.println(ret);
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
