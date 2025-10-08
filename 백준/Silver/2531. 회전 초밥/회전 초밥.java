import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) list.add(Integer.parseInt(br.readLine()));

        // 처음 초밥
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<k; i++) map.put(list.get(i), map.getOrDefault(list.get(i), 0)+1);
        int answer = map.size();
        if(!map.containsKey(c)) answer++;  // 행사 초밥이 없는 경우 +1

        for(int i=1; i<N; i++) {
            int remove = list.get(i-1);
            int add = list.get((i+k-1) % N);

            // 제거
            map.put(remove, map.get(remove)-1);
            if(map.get(remove) == 0) map.remove(remove);

            // 추가
            map.put(add, map.getOrDefault(add, 0)+1);

            int count = map.size();
            if(!map.containsKey(c)) count++;
            answer = Math.max(answer, count);
        }

        System.out.println(answer);

        br.close();
    }
}
