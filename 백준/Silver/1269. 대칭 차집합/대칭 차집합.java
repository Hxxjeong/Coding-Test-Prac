import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<A; i++) {
            int key = Integer.parseInt(input[i]);
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        input = br.readLine().split(" ");
        for(int i=0; i<B; i++) {
            int key = Integer.parseInt(input[i]);
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        long answer = map.values().stream()
                .filter(s -> s == 1)
                .count();
        System.out.println(answer);

        br.close();
    }
}