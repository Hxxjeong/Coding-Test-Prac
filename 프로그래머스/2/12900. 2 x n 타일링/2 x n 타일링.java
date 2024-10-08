class Solution {
    public int solution(int n) {
        int[] arr = new int[60001];
        arr[1] = 1;
        arr[2] = 2;
        
        // 1부터 6까지
        // 1 2 3 5 8 13 -> 피보나치 수열
        for(int i=3; i<arr.length; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1_000_000_007;
        }
        
        return arr[n];
    }
}