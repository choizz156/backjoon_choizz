import java.io.*;
import java.util.*;


public class Main {
    
    static int n;
    static String t;


    public static void main(String[] args) throws Exception {
        Scan sc = new Scan();
        n = sc.nextInt();
        t = sc.nextLine();

        int a = t.indexOf('*');
        String f = t.substring(0,a);
        String b = t.substring(a+1);


        while(n-- > 0){
            String s = sc.nextLine();
            if(s.length() < f.length() + b.length()){
                System.out.println("NE");
                continue;
            }

            String t1 = s.substring(0, f.length());
            String t2 = s.substring(s.length() - b.length());

            if(t1.equals(f) && t2.equals(b)){
                System.out.println("DA");
            }else{
                System.out.println("NE");
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

        String nextLine() throws Exception{
            return br.readLine();
        }

        void clear() throws Exception{
            br.close();
        }

   }

}