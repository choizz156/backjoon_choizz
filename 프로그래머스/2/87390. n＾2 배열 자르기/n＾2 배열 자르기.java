import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
       int len = (int)(right - left + 1);
       int[] ans = new int[len];
       
       for(int i = 0; i < len; i++){
           long idx = left + i;
           int row = (int)(idx / n);
           int col = (int)(idx % n);
           ans[i] = Math.max(col, row) + 1;
       }
        
        return ans;
    }
}