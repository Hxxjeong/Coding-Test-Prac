import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> phoneketmon = new HashMap<>();
        Arrays.sort(nums);
        
        for(int i: nums) {
            phoneketmon.put(i, phoneketmon.getOrDefault(i, 0) + 1);
        }
        
        return Math.min(phoneketmon.size(), nums.length/2);
    }
}