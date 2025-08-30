import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        if(divisor == 1){
            Arrays.sort(arr);
            return arr;
        }
        
        
         int[] ans = Arrays.stream(arr)
            .filter(i -> i % divisor == 0)
            .sorted()
            .toArray();
        
        return ans.length == 0 ? new int[]{-1} : ans;
       
    }
}