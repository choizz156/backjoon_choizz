import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Position> cp = new ArrayList<>(16);
    static List<Position> hp = new ArrayList<>(54);
    static List<List<Position>> list = new ArrayList<>();
    static int[][] a, v;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String args[]) throws Exception{

        var sc = new Scan();

        n = sc.nextInt();
        m = sc.nextInt();

        a = new int[n][n];
        v = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int v = sc.nextInt();

                if(v == 2) cp.add(new Position(i,j));
                if(v == 1) {
                    hp.add(new Position(i,j));
                    a[i][j] = v;
                }
            }
        }
        combine(0, new ArrayList<>(m));

        //hp 좌표
        //cp 좌표
        int ret = Integer.MAX_VALUE; 
        for(List<Position> l : list){
            int sum = 0;
            for(Position house : hp){
                int min = Integer.MAX_VALUE;
                for(Position chicken : l){
                     min = Math.min(Position.getDistance(chicken, house), min);
                }
               sum += min;
            }

            ret = Math.min(sum,ret);
        }

        System.out.println(ret);


    }

    static void combine(int k, List<Position> l){
        if(l.size() == m){
            list.add(new ArrayList(l));
        }else{
            for(int i = k; i < cp.size(); i++){
                l.add(cp.get(i));
                combine( i + 1 , l);
                l.remove(l.size() - 1);
            }
        }
    }


    static class Position{

        Position(int y, int x){
            this.x = x;
            this.y = y;
        }

        int x;
        int y;


        static int getDistance(Position cp, Position hp){
            return Math.abs(cp.y - hp.y) + Math.abs(cp.x - hp.x);
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


    }    
}