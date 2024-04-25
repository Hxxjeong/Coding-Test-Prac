class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder player = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
            player.append(String.valueOf(i).repeat(food[i]/2));
        }
        
        answer = player + "0";
        answer += player.reverse();
        
        return answer;
    }
}