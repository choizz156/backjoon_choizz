import java.io.*;
import java.util.*;

class Main{
    
  static int n;
    static char[] a = new char[10];
    static boolean[] v = new boolean[10];
    static List<String> ret = new ArrayList<>();
    

    public static void main(String[] args) throws Exception{
        var sc = new Scan();
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            a[i] = sc.next().charAt(0);
        }

        go(0, "");

        Collections.sort(ret);
		System.out.println(ret.get(ret.size()-1));
		System.out.println(ret.get(0));
    }

    static void go(int idx, String num){
        if(idx == n + 1){
            ret.add(num);
            return;
        }

        for(int i = 0; i <= 9; i++){
            if(v[i]) continue;
            if(idx == 0 || good(num.charAt(idx - 1), (char)(i + '0'), a[idx - 1])){
                v[i] = true;
                go(idx + 1, num + i);
                v[i] = false;
            }
        }
    }

    static boolean good(char x, char y, char op){
        if(x < y && op == '<') return true;
        if(x > y && op == '>') return true;
        return false;
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