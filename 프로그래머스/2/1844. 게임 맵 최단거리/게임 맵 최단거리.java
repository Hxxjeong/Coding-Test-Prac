import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited = new boolean[n][m];
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            int dist = arr[2];
            
            for(int r=0; r<4; r++) {
                int nx = dx[r] + x;
                int ny = dy[r] + y;
                
                if(nx == n-1 && ny == m-1) return dist+1;
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                queue.add(new int[]{nx, ny, dist+1});
                visited[nx][ny] = true;
            }
        }
        
        return answer;
    }
}