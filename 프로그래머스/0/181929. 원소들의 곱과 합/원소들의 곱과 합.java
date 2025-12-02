import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int sum = (int) Math.pow(Arrays.stream(num_list).sum(), 2);
        int mul = 1;
        for(int i: num_list) mul *= i;
        
        return sum > mul ? 1 : 0;
    }
}