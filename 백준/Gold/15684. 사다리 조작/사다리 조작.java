import java.util.*;
import java.io.*;

//목표까지 가는 경로를 다찾아서 저장한다.
//변수를 사용한다.
public class Main{
    static int n, m, h, a, b, ret, max = 987654321;
    static int[][] visit = new int[34][34];
    public static void main(String[] args) throws Exception{
        Scan sc = new Scan();
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        for(int i = 0; i < m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            visit[a][b] = 1;
        }
        ret = max;
        go(1,0);
        System.out.println((ret==max) ? -1 : ret);
    }

    static void go(int here, int cnt){
        if(cnt > 3 || cnt == ret) return;
        if(check()){
            ret = cnt;
            return;
        }

        for(int i = here; i <= h; i++){
            for(int j = 1; j < n; j++){
                if(visit[i][j] == 1 || visit[i][j - 1] == 1 || visit[i][j+1] == 1)
                    continue;
                visit[i][j] = 1;
                go(i, cnt + 1);
                visit[i][j] = 0;
            }
        }
    }

    static boolean check(){
        for(int i = 1; i <= n; i++){
            int start = i;
            for(int j = 1; j <= h; j++){
                if(visit[j][start] == 1) start++;
                else if (start > 1 && visit[j][start - 1] == 1) start--;
            }
            if(start != i) return false;
        }
        return true;
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