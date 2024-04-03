class Solution {
    public String solution(String s, int n) {
        String answer = "";
        int num = 0;
        
        for(int i=0; i<s.length(); i++) {
            num = s.charAt(i) + n; // 거리만큼 민 값
            
            // 공백일 때 그냥 push
            if(s.charAt(i) == ' ')
                answer += s.charAt(i);
            // z나 Z의 ASCII가 넘을 때
            else if(s.charAt(i) < 91 && num > 90 || num > 122) {
                num -= 26;
                answer += (char)num;
            }
            else
                answer += (char)num;
        }
        return answer;
    }
}