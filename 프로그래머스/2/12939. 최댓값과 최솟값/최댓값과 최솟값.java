class Solution {
    public String solution(String s) {
        String answer = " ";
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] str = s.split(" ");
        
        for(int i=0; i<str.length; i++) {
            if (max < Integer.parseInt(str[i]))
                max = Integer.parseInt(str[i]);
            if (min > Integer.parseInt(str[i]))
                min = Integer.parseInt(str[i]);
        }

        answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}