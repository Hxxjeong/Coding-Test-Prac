class Solution {
    public int solution(String s) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<10; i++) {
            // num에 해당하는 문자열 숫자로 변경
            s = s.replace(num[i], String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}