import java.util.*;
import java.io.*;


public class Main {
 

    static class A{
        int mp, mf, ms, mv, c;

        A(int mp, int mf, int ms, int mv, int c){
            this.mp = mp;
            this.mf = mf;
            this.ms = ms;
            this.mv = mv;
            this.c = c;
        }
    }

    static int n, mp, mf, ms, mv;



    public static void main(String[] args) throws Exception{
        var sc = new Scan();

        n = sc.nextInt();
        mp = sc.nextInt();
        mf = sc.nextInt();
        ms = sc.nextInt();
        mv = sc.nextInt();

        A[] a = new A[n];
        for(int i = 0; i < n; i++){
            a[i] = new A(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        int INF = 987654321;
        int mc = INF;

        List<Integer> bestCom = new ArrayList<>();

        for(int i = 0; i < (1 << n); i++){
            int tMp = 0, tMf = 0, tMs = 0, tMv = 0, tc = 0;
            List<Integer> com = new ArrayList<>();


            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    com.add(j + 1);
                    tMp += a[j].mp;
                    tMf += a[j].mf;
                    tMs += a[j].ms;
                    tMv += a[j].mv;
                    tc += a[j].c;
                }
            }

            if(tMp >= mp && tMf >= mf && tMs >= ms && tMv >= mv){
                if(tc < mc ||(tc == mc && isSmaller(com, bestCom))){
                    mc = tc;
                    bestCom = new ArrayList<>(com);
                }
            }
        }

        if(mc == INF){
            System.out.println(-1);
        }else{
            System.out.println(mc);
            for(int num : bestCom){
                System.out.print(num+" ");
            }
        }
    }

    static boolean isSmaller(List<Integer> com1, List<Integer> com2){
        for(int i = 0; i < Math.min(com1.size(), com2.size()); i++){
            if(!com1.get(i).equals(com2.get(i))){
                return com1.get(i) < com2.get(i);
            }
        }
        return com1.size() < com2.size();
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


