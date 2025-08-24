import java.util.*;

class Solution {
     int retA, retB, retC;
	 final int[][] a = {
        {-1},
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    public int[] solution(int[] ans) {
        	var cnt = new int[4];
            
            for(int i = 0; i < ans.length; i++){
                for(int j = 1; j < a.length; j++){
                    if(ans[i] == a[j][i % a[j].length]){
                        cnt[j]++;
                    }
                }
            }
        
        	int max = Arrays.stream(cnt).max().getAsInt();
        	var ret = new ArrayList<Integer>();
        	for(int i = 1; i < cnt.length; i++){
                if(cnt[i] == max){
                    ret.add(i);
                }
            }
        
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}