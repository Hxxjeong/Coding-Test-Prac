import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        
        int n = num_list.length;
        int one = num_list[n-1];
        int two = num_list[n-2];
        if(one > two) list.add(one-two);
        else list.add(one*2);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}