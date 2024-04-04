class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        int reset = 1;
        
        for(int i=0; i<str.length; i++) {
            if(str[i].equals(" ")) {
                answer += str[i];
                reset = 1;
                continue;
            }
            else {          
                if(reset % 2 != 0)
                    answer += str[i].toUpperCase();
                else
                    answer += str[i].toLowerCase();
                reset++;
            }
        }
        
        return answer;
    }
}