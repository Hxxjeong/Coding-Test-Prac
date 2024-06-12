class Solution {
    static boolean[] check;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        check = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if (!check[i]) {
                dfs(i, computers);
                answer++;   // dfs 횟수 = 네트워크 개수
            }
        }
        
        return answer;
    }
    
    public static void dfs(int i, int[][] computers) {
        check[i] = true;
        
        for (int j = 0; j < computers[i].length; j++) {
            if (computers[i][j] == 1 && !check[j]) {
                dfs(j, computers);
            }
        }
    }
}