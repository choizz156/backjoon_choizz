import java.util.*;
import java.io.*;


public class Main {
    
    static int n;
    static int[] a;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{

        var sc =  new Scan();
        n = sc.nextInt();
        a = new int[n + 1];

        for(int i = 1; i <= n; i++){
            var r = sc.next();
            int v = 1;
            for(int j = 0; j < n; j++){
                if(r.charAt(j) == 'T'){
                    a[i] |= v;
                }
                v <<= 1;
            }
        }

        go(1);

        System.out.println(ret);
      
    }


    static void go(int here){
        if(here == n + 1){
            int t = 0;
            for(int i = 1; i < (1 << n); i *= 2){
                int cnt = 0;
                for(int j = 1; j <= n; j++){
                    if((a[j] & i) != 0){
                        cnt++;
                    }
                }

                t += Math.min(cnt, n - cnt);
            }

            ret = Math.min(ret, t);
            return;
        }

        go(here + 1);
        a[here] = ~a[here];
        go(here + 1);
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


