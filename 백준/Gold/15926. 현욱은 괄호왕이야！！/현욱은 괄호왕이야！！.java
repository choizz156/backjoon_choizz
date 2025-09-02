import java.util.*;
import java.io.*;


public class Main {
 
    static int n;
    static String s;
    static int[] c;
    static Deque<Integer> st = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{
        
        var sc = new Scan();
        n = sc.nextInt();
        s = sc.next();

        c = new int[n];

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else if(!st.isEmpty()){
                int idx = st.removeFirst();
                c[i] = 1;
                c[idx] = 1;
            }
        }


        int cnt = 0, ret = 0;
        for(int i = 0; i < n; i++){
            if(c[i] == 1){
                cnt++;
                ret = Math.max(ret, cnt);
            }else{
                cnt = 0;
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


