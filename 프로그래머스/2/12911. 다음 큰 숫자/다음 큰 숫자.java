class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String binaryN = Integer.toBinaryString(n);
        
        int countOne = 0;
        for(char c: binaryN.toCharArray()) {
            if(c == '1') countOne++;
        }
        
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