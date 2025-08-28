import java.util.*;

class Solution {
    
    static Map<Character, int[]> l = new HashMap<>();
    
    public int solution(String dirs) {
    	
        l.put('U', new int[]{0,1});
        l.put('D', new int[]{0,-1});
        l.put('L', new int[]{-1,0});
        l.put('R', new int[]{1,0});
        
        int x = 5, y = 5;
        var ans = new HashSet<String>();
        
        int len = dirs.length();
        for(int i = 0; i < len; i++){
            var f = l.get(dirs.charAt(i));
            var nx = x + f[0];
            var ny = y + f[1];
            
            if(0 <= nx && nx < 11 && 0 <= ny && ny < 11){
                ans.add(""+ x + y + nx + ny);
                ans.add(""+ nx + ny + x + y);
                
                x = nx;
                y = ny;
            }
        }
        
        return ans.size() / 2;
       
    }
        
       
        
}