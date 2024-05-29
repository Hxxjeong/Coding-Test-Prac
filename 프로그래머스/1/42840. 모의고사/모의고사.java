import java.util.*;

class Solution {
    public Integer[] solution(int[] answers) {     
        List<Integer> answer = new ArrayList<>();
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];   // 각 수포자들의 점수
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == p1[i%5])
                score[0]++;
            if(answers[i] == p2[i%8])
                score[1]++;
            if(answers[i] == p3[i%10])
                score[2]++;
        }
        
        // 최댓값
        int max = Arrays.stream(score).max().orElse(score[0]);
        
        // 최댓값과 같으면 추가
        for(int i=0; i<score.length; i++) {
            if(max == score[i])
                answer.add(i+1);
        }
        
        return answer.toArray(new Integer[0]);
    }
}