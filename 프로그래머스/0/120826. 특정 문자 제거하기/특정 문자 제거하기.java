class Solution {
    public String solution(String my_string, String letter) {        
        for(char c: letter.toCharArray()) {
            my_string = my_string.replaceAll(c+"", "");
        }
        
        return my_string;
    }
}