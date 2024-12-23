import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(n > 0) {
            if(n % 2 == 0) n /= 2;
            else {
                n--;
                answer++;
            }
        }
        
        return answer;
    }
}

/*
5000
2500
1250
625
624 (+1)
312
156
78
39
38 (+1)
19
18 (+1)
9
8 (+1)
4
2
1
0 (+1)
*/
