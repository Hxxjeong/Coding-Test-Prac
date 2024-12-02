class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String binaryN = Integer.toBinaryString(n);
        
        int countOne = 0;
        for(char c: binaryN.toCharArray()) {
            if(c == '1') countOne++;
        }
        
        String num = null;
        // 모든 자릿수가 1인 경우
        // if(countOne == binaryN.length()) num = "10" + (countOne-1;
        
        int number = n;
        while(true) {
            number++;
            String nums = Integer.toBinaryString(number);
            
            int count = 0;
            for(char c: nums.toCharArray()) {
                if(c == '1') count++;
            }
            
            if(count == countOne) {
                answer = Integer.parseInt(nums, 2);
                break;
            }
        }
        
            
        return answer;
    }
}