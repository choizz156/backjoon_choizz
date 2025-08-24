import java.util.*;

class Solution {
    
    public int[] solution(int[] n) {
		int len = n.length;
        var l = new TreeSet<Integer>();
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                int a = n[i];
                int b = n[j];
                l.add(a + b);
            }
        }
        
        var ans = new int[l.size()];
		
     	int idx = 0;
        for(int v : l){
            ans[idx++] = v;
        }
      return ans;
    }
}

