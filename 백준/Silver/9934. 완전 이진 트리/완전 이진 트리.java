import java.io.*;
import java.util.*;

class Main{
	
    static int n, e;
    static List<Integer>[] ret = new ArrayList[14];
    static int[] a = new int[1030];
    	
    public static void main(String[] args) throws Exception {
     	Scan sc = new Scan();
        n = sc.nextInt();
        e = (int) Math.pow(2,n) - 1;
        
        for(int i = 0; i < e; i++){
            a[i] = sc.nextInt();
        }
        
        for(int i = 0; i < 14; i++){
            ret[i] = new ArrayList<>();
        }
        
        go(0, e, 0);
        var  sb = new StringBuilder();
        
        for(int i = 0; i < n; i++){
            for(int j : ret[i]){
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
    
    static void go(int s, int e, int l){
        if(s > e) return;
      
        int mid = (s + e) / 2;
        ret[l].add(a[mid]);
        go(s,mid - 1, l + 1);
        go(mid + 1, e, l + 1);
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