import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> phoneketmon = new HashSet<>();
        Arrays.sort(nums);
        
        for(int i: nums) {
            phoneketmon.add(i);
        }
        
        return Math.min(phoneketmon.size(), nums.length/2);
    }
}