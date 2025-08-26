import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] c = new int[N + 2];
        for(int stage: stages){
            c[stage]++;
        }
        
        var f = new HashMap<Integer, Double>();
        double total = stages.length;
        
        for(int i = 1; i <= N; i++){
            if(c[i] == 0){
                f.put(i,0D);
            }else{
                f.put(i, c[i] / total);
                total -= c[i];
            }
        }
        
        return f.entrySet().stream().sorted((
        	(o1,o2) ->
            {
                int cnt = o2.getValue().compareTo(o1.getValue());
                if(cnt == 0){
                    o1.getKey().compareTo(o2.getKey());
            }
                return cnt;
            })).mapToInt(Map.Entry::getKey).toArray();
    }
}