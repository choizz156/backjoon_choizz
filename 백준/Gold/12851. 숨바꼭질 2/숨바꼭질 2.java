import java.util.*;
import java.io.*;

public class Main {
    
    static int MAX = 200000;
    static int[] visited = new int[MAX + 4];
    static long[] cnt = new long[MAX + 4];
 

    public static void main(String[] args) throws Exception{
     Scan sc = new Scan();
     int n = sc.nextInt();
     int m = sc.nextInt();

     if(n == m){
        System.out.println("0");
        System.out.println("1");
        return;
     }

        visited[n] = 1;
        cnt[n] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (0 <= next && next <= MAX) {
                    if (visited[next] == 0) {
                        q.add(next);
                        visited[next] = visited[now] + 1;
                        cnt[next] += cnt[now];
                    } else if (visited[next] == visited[now] + 1) {
                        cnt[next] += cnt[now];
                    }
                }
            }
        }
        System.out.println(visited[m] - 1);
        System.out.println(cnt[m]);
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
                                                                                                                                                                                                                                                               