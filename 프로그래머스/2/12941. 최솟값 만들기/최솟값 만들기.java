import java.util.*;

class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int Blen = B.length;
        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[Blen-1-i];
        }

        return answer;
    }
}