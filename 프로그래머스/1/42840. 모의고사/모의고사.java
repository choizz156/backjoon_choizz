import java.util.*;

class Solution {
	int[][] a = {
        {},
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    public int[] solution(int[] ans) {
        var cnt = new int[4];
       	int len = ans.length;
      	
        for(int i = 0; i < len; i++){
            for(int j = 1; j < a.length; j++){
                if(ans[i] == a[j][i % a[j].length]){
                    cnt[j]++;
                }
            }
        }
        
        int max = Arrays.stream(cnt).max().getAsInt();
		var l = new ArrayList<Integer>();
		int idx = 0;
        for(int v : cnt){
           if(v == max) {
               l.add(idx); 
           }
            idx++;
        }
       	
       return l.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}