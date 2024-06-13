class Solution {
    // 상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int index = 1;   // 우측 방향으로 진행
        
        int col = 0;
        int row = 0;
        int k = n*n;
        int value = 1;
        
        while (k > 1) { // 계속 회전하는 것을 방지하기 위함
            int nr = row + dr[index];
            int nc = col + dc[index];
            
            // 값이 있거나 배열을 벗어나면 회전
            if(nc < 0 || nr < 0 || nc >= n || nr >= n || answer[nr][nc] != 0) {
                index = (index+1) % 4;
                continue;
            }
           
            answer[row][col] = value;
            value++;
            col = nc;
            row = nr;
            
            k--;
        }
        
        // while 문에서 마지막 원소를 넣지 않았기 때문
        answer[row][col] = value;
        
        return answer;
    }
}