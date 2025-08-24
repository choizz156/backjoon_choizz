import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        int len = line.length;
        var points = new ArrayList<Point>();
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                var inter = its(line[i][0],line[i][1],line[i][2],line[j][0],line[j][1],line[j][2]);
                  if(inter != null){
                 points.add(inter); 
            }
            }
            
            
        }
        
        var min = getMin(points);
        var max = getMax(points);
        
        int w = (int)(max.x - min.x + 1);
        int h = (int)(max.y - min.y + 1);
       
        
        
        char[][] arr = new char[h][w];
        for(char[] row : arr){
            Arrays.fill(row, '.');
        }
        
        for(Point p : points){
            int x = (int)(p.x - min.x);
            int y = (int)(max.y - p.y);
            arr[y][x] = '*';
        }
        
        var result = new String[arr.length];
        for(int i = 0; i < result.length; i++){
            result[i] = new String(arr[i]);
        }
        return result;
    }
    
    Point getMin(List<Point> points){
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points){
            if(p.x < x) x = p.x;
            if(p.y < y) y = p.y;
        }
        
        return new Point(x,y);
    }
    
    Point getMax(List<Point> points){
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points){
            if(p.x > x) x = p.x;
            if(p.y > y) y = p.y;
        }
        
        return new Point(x,y);
    }
    

    
    Point its(long a1, long b1, long c1, long a2, long b2,long c2){
        double x = (double)(b1*c2 - b2*c1) / (a1*b2 - a2*b1);
        double y = (double)(a2*c1 - a1*c2) / (a1*b2 - a2*b1);
        
        if(x % 1 != 0 || y % 1 != 0) return null;
        
        return new Point((long) x, (long) y);
    }
    
  
   static class Point{
       final long x, y;
       Point(long x, long y){
           this.x = x;
           this.y = y;
       }
   }
    
}

