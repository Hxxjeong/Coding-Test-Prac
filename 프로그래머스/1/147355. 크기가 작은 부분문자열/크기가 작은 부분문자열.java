class Solution {
    public int solution(String t, String p) {
        int answer = 0;        
        String[] str = new String[t.length()-p.length()+1];
        
        for (int i=0; i<str.length; i++) {
            str[i] = t.substring(i, i+p.length());
        }
        
        for (int i=0; i<str.length; i++) {
            if(Long.parseLong(str[i]) <= Long.parseLong(p))
                answer++;
        }
        
        return answer;
    }
}