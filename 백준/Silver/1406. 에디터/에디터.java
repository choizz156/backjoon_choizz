// 영어 소문자만을 기록
//600,000글자까지
// L인 문자열 커서가 위치할 수 있는 곳은 L+1
// L -> 커서 왼쪽 한 칸(맨 앞이면 무시)
// D -> 커서 오른쪽 한칸
// B -> 커서 왼쪽 문자 삭제 
// P $ -> $라는 문자를 커서 왼쪽에 추가

//모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성
//커서는 문장의 맨 뒤에 위치

//문자 길이는 100,000을 넘지 않음
// 명령어의 개수는 50만개이하

//길이 + 길이 + 1; => 리스트
//명령어를 저장 => 리스트
//int l = 

import java.util.*;
import java.io.*;

class Main {
    
    static String s;
    static int n;
    static Deque<Character> a, cl, cr;
    
    public static void main(String[] args) throws Exception{
        var sc = new Scan();
        s = sc.next();
        n = sc.nextInt();
        
        a = new ArrayDeque<Character>();
        for(char c : s.toCharArray()){
            a.add(c);
        }
        
        cl = a;
        cr = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            String t = sc.nextLine();
            char tc = t.charAt(0);

                if(tc == 'L'){
                    if(!cl.isEmpty()){
                       cr.addFirst(cl.removeLast());
                    }   
                }else if(tc == 'D'){
                    if(!cr.isEmpty()){
                        cl.addLast(cr.removeFirst());
                    }
                }else if(tc == 'B'){
                    if(!cl.isEmpty()){
                        cl.removeLast();
                    }
                }else{
                    char ch = t.charAt(2);
                    cl.addLast(ch);
                }
            }
       
        
       var ret = new StringBuilder();
        for(char c : cl){
            ret.append(c);
        }
        
        for(char c : cr){
            ret.append(c);
        }
        
        sc.to().write(ret.toString());
        sc.to().flush();
        sc.to().close();
  }
        
       
    static class Scan{
        BufferedReader br;
        BufferedWriter bw;
        StringTokenizer st;
        
        public Scan(){
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        
        BufferedWriter to(){
            return bw;
        }
        
    }
}
