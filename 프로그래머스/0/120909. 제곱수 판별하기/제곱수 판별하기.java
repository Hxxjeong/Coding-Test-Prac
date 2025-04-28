class Solution {
    public int solution(int n) {
        int answer = (int) Math.sqrt(n);
        double num = Math.sqrt(n);
        return answer == num ? 1 : 2;
    }
}