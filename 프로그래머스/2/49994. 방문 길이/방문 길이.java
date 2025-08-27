import java.util.*;

class Solution {
    

    static Map<Character, int[]> location = new HashMap<>();
    
    static void init(){
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('L', new int[]{-1,0});
        location.put('R', new int[]{1,0});
    }
    
    public int solution(String dirs) {
        init();
        int x = 5, y = 5;
        var ans = new HashSet<String>();
        
        int len = dirs.length();
        for(int i = 0; i < len; i++){
        	var offset = location.get(dirs.charAt(i));
            var nx = x + offset[0];
            var ny = y + offset[1];
            
            if(0 <= nx && nx < 11 && 0 <= ny && ny < 11){
                ans.add(x+""+ y+ "" + nx + "" + ny);
                ans.add(nx+""+ny+""+x+""+y);
                x = nx;
                y = ny;
            }
        }
        
        return ans.size()/2;
        
    }
}