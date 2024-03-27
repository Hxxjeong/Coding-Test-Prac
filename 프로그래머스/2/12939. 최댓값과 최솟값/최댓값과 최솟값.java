class Solution {
    public String solution(String s) {
        String answer = " ";
        String[] str = s.split(" ");
        int max = Integer.parseInt(str[0]);
        int min = Integer.parseInt(str[0]);
        for(int i=0; i<str.length; i++) {
            if (max < Integer.parseInt(str[i]))
                max = Integer.parseInt(str[i]);
            if (min > Integer.parseInt(str[i]))
                min = Integer.parseInt(str[i]);
        }

        answer = min + " " + max;
        return answer;
    }
}