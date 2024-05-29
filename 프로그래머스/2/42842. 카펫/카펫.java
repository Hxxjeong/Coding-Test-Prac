class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // yellow_w * 2 + yellow_h * 2 + 4 = brown
        // brown의 가로와 세로는 yellow+2
        
        int l = (int)Math.ceil(Math.sqrt(yellow));
        
        for(int i=1; i<=l; i++) {
            // yellow의 사각형 후보
            if(yellow % i == 0) {
                answer[0] = Math.max(yellow/i, i);
                answer[1] = Math.min(yellow/i, i);
            }
            
            if((answer[0]+answer[1])*2 + 4 == brown) {
                answer[0] += 2;
                answer[1] += 2;
                break;
            }
        }
        
        return answer;
    }
}