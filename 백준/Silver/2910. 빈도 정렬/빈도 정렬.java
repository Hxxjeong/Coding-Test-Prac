import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<N; i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();
        for(int i: list) {
            int value = map.get(i);
            for(int j=0; j<value; j++) sb.append(i).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
