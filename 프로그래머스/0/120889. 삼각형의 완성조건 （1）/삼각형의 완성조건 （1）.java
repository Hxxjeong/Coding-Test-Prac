import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int max = Arrays.stream(sides).max().getAsInt();
        int sum = Arrays.stream(sides).sum() - max;
        
        return max < sum ? 1 : 2;
    }
}