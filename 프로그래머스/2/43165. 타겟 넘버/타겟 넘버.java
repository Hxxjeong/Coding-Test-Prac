class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int sum) {
        if(depth == numbers.length) {
            if(sum == target) answer++;
            return;
        }
        
        dfs(numbers, target, depth+1, sum+numbers[depth]);  // 양수일 때
        dfs(numbers, target, depth+1, sum-numbers[depth]);  // 음수일 때
    }
}