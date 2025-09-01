import java.util.*;

class Solution {
    boolean solution(String s) {
        
        var st = new ArrayDeque<Character>();
        
        var a = s.toCharArray();
        for(char c: a){
            if(c == '('){
                st.addFirst(c);
            }
            else {
                if(st.isEmpty() || st.removeLast() == c){
                    return false;
                }
            }
        }
        
        return st.isEmpty();
    }
}