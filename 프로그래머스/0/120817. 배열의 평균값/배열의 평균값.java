import java.util.*;

class Solution {
    public double solution(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        return (double) sum / numbers.length;
    }
}