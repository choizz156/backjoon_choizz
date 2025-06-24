import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m, ret, max = 200004;
    static int[] v = new int[max + 4];
    static int[] prev = new int[max + 4];
    static List<Integer> p = new ArrayList<>();


 

    public static void main(String[] args) throws Exception{
     Scan sc = new Scan();
      n = sc.nextInt();
      m = sc.nextInt();
      v[n] = 1;

      Deque<Integer> q = new ArrayDeque<>();
      q.add(n);

      while(!q.isEmpty()){
        int now = q.poll();
        if(now == m){
            ret = v[now];
            break;
        }
        for(int next : new int[]{now + 1, now - 1, now * 2}){
            if(next >= max || next < 0 || v[next] != 0) continue;
            v[next] = v[now] + 1;
            prev[next] = now;
            q.add(next);
        }
      }


      for(int i = m; i != n; i = prev[i]){
        p.add(i);
      }
      p.add(n);
      Collections.reverse(p);

      var sb = new StringBuilder();
      for(int i : p){
        sb.append(i).append(" ");
      }
      System.out.println(ret-1);
      System.out.println(sb);
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
