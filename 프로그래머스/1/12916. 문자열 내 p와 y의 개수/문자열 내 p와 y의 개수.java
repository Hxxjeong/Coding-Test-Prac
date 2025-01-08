class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        
        int count = 0;
        for(char c: s.toCharArray()) {
            if(c == 'p') count++;
            else if(c == 'y') count--;
        }

        return count == 0;
    }
}