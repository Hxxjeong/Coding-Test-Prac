import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        // i번째까지 가장 작은 수가 발표 점수
        for(int i=0; i<k; i++) {
            if(i > score.length-1) break;
            else
                answer[i] = Arrays.stream(score).limit(i+1).min().orElse(0);
        }
        
        // k번째까지의 명예의 전당
        int[] hallOfFame = new int[k];
        for(int i=0; i<k; i++) {
            if(i > score.length-1) break;
            else hallOfFame[i] = score[i];
        }
        Arrays.sort(hallOfFame);
        
        // 명예의 전당 갱신 후 발표 점수 계산
        for(int i=k; i<score.length; i++) {
            a:for(int j=0; j<hallOfFame.length; j++) {
                if(hallOfFame[j] < score[i]) {
                    hallOfFame[j] = score[i];
                    Arrays.sort(hallOfFame);
                }
                break a;
            }
            answer[i] = hallOfFame[0];
        }
        return answer;
    }
}