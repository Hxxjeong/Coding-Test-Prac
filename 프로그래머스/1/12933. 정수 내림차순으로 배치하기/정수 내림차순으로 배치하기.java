import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public long solution(long n) {
        String answer = "";
        List<Long> list = new ArrayList<>();

        while(n != 0){
            list.add(n % 10);
            n /= 10;
        }

        Collections.sort(list, Collections.reverseOrder());

        for(int i=0; i<list.size(); i++){
            answer += Long.toString(list.get(i));
        }

        return Long.parseLong(answer);
    }
}