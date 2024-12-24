import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            map.put(Integer.parseInt(input[i]), map.getOrDefault(Integer.parseInt(input[i]), 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        int[] answer = new int[M];
        for(int i=0; i<M; i++) {
            answer[i] = map.get(Integer.parseInt(input[i])) == null ? 0 : map.get(Integer.parseInt(input[i]));
        }

        Arrays.stream(answer).forEach(x -> System.out.print(x + " "));

        br.close();
    }
}
