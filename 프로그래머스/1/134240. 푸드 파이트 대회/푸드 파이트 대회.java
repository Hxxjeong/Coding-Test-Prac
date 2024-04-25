class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=1; i<food.length; i++) {
            answer += String.valueOf(i).repeat(food[i]/2);
        }
        
        StringBuilder onePlayer = new StringBuilder(answer);    // 한 선수의 음식
        answer += "0";  // 물
        answer += onePlayer.reverse().toString();
        
        return answer;
    }
}