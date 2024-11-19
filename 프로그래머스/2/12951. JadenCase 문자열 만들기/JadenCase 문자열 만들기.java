class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        s = s.toLowerCase();
        
        char prev = s.charAt(0);
        if(prev >= 'a' && prev <= 'z') answer.append(String.valueOf(prev).toUpperCase());
        else answer.append(prev);
        
        for(int i=1; i<s.length(); i++) {
            if(prev == ' ') {
                // 첫 문자가 소문자일 때 대문자로 변환
                if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    answer.append(String.valueOf(s.charAt(i)).toUpperCase());
                else answer.append(s.charAt(i));
            }
            else answer.append(s.charAt(i));
            
            prev = s.charAt(i);
        }
        
        return answer.toString();
    }
}