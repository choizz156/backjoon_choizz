import java.util.*;
import java.io.*;


public class Main {

    static int max = Integer.MAX_VALUE;
    static int n;
    static int a[];
    static ArrayList<Integer>[] adj;
    static int[] comp;
    static boolean[] v;
    static int ret = max;

    static class A{
        int nodeCount;
        int sum;

        A(int nodeCount, int sum){
            this.nodeCount = nodeCount;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws Exception{

        var sc = new Scan();
        n = sc.nextInt();

        a = new int[n + 1];
        adj = new ArrayList[n + 1];
        comp = new int[n + 1];
        v = new boolean[n + 1];

        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
            adj[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++){
            int m = sc.nextInt();
            for(int j = 0; j < m; j++){
                adj[i].add(sc.nextInt());
            }
        }

          // 비트마스크를 이용해 모든 부분집합을 순회
        // 1부터 (1 << n) - 2 까지 순회하여 빈 집합이거나 전체 집합인 경우를 제외
        for(int i = 1; i < (1 << n) - 1; i++){
            Arrays.fill(comp, 0);
            Arrays.fill(v, false);

            //각각 시작 지점이므로 -1로 초기화
            int idx1 = -1, idx2 = -1;


            // 비트마스크를 기반으로 두 선거구(comp 0과 1)로 나눔
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0 ){
                    comp[j + 1] = 1;
                    idx1 = j + 1;// 1번 선거구의 시작 노드
                }else{
                    idx2 = j + 1;// 1번 선거구의 시작 노드
                }
            }

             // 각 선거구에 대해 DFS를 수행하여 연결성 확인
            A com1 = dfs(idx1, 1);
            A com2 = dfs(idx2, 0);

               // 두 선거구에서 방문한 노드의 합이 전체 노드 수와 같다면
            // 두 선거구 모두 각각 연결되어 있다는 의미
            if(com1.nodeCount + com2.nodeCount == n){
                ret = Math.min(ret, Math.abs(com1.sum - com2.sum));
            }
        }
             System.out.println(ret == max ? -1 : ret);
    }

    static A dfs(int here, int value){
        v[here] = true;
        A result = new A(1, a[here]);

        for(int there : adj[here]){
            if(comp[there] == value && !v[there]){
                var tmp = dfs(there, value);
                result.nodeCount += tmp.nodeCount;
                result.sum += tmp.sum;
            }
        }

        return result;
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


