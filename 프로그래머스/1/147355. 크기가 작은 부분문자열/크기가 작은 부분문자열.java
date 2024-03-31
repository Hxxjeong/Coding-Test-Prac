class Solution {
    public int solution(String t, String p) {
        int answer = 0;        
        String[] str = new String[t.length()-p.length()+1];
        
        for (int i=0; i<str.length; i++) {
            str[i] = t.substring(i, i+p.length());
        }
        
        // 인덱스 내용을 숫자로 변경
        long[] ints = new long[str.length];
        
        for(int i=0; i<ints.length; i++) {
            ints[i] = Long.parseLong(str[i]);
        }
        
        for (int i=0; i<ints.length; i++) {
            if (ints[i] <= Long.parseLong(p))
                answer++;
        }
        
        return answer;
    }
}