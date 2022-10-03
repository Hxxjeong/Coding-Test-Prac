// Level1 Æò±Õ ±¸ÇÏ±â

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int i=0; i<arr.length; i++) {
            answer += arr[i];
        }
        answer /= arr.length;
        return answer;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 2, 3, 4};
        System.out.println(s.solution(arr));
    }
}
