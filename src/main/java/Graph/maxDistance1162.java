package Graph;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 712
 * @function:
 * @create 2021/5/13 21:18
 */
public class maxDistance1162 {
    Queue<int[]> q = new LinkedList<>();
    int max = 0;
    public int maxDistance(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(isValid(grid,x-1,y)){
                q.offer(new int[]{x-1,y});
                grid[x-1][y] = grid[x][y]+1;
                max = Math.max(max,grid[x-1][y]);
            }
            if(isValid(grid,x+1,y)){
                q.offer(new int[]{x+1,y});
                grid[x+1][y] = grid[x][y]+1;
                max = Math.max(max,grid[x+1][y]);
            }
            if(isValid(grid,x,y-1)){
                q.offer(new int[]{x,y-1});
                grid[x][y-1] = grid[x][y]+1;
                max = Math.max(max,grid[x][y-1]);
            }
            if(isValid(grid,x,y+1)){
                q.offer(new int[]{x,y+1});
                grid[x][y+1] = grid[x][y]+1;
                max = Math.max(max,grid[x][y+1]);
            }
        }
        return max-1;
    }
    boolean isValid(int[][] grid, int x,int y){
        return x>=0 && x<grid.length &&
                y>=0 && y<grid[0].length &&
                grid[x][y] == 0;
    }
    @Test
    public void test(){
        maxDistance1162 maxDistance1162 = new maxDistance1162();
        int[][] grid = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        int res = maxDistance1162.maxDistance(grid);
        System.out.println(res);
    }
}
