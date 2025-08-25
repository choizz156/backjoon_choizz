import java.util.*;

class Solution {
    
    public int[] solution(int[] n) {
	    int len = n.length;
        var ts = new TreeSet<Integer>();
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                ts.add(n[i] + n[j]);
            }
        }
        
        return ts.stream().mapToInt(Integer::intValue).toArray();
    }
}

