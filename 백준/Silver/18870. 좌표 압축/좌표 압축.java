import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] sort = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            sort[i] = arr[i];
        }

        Arrays.sort(sort);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int i: sort) {
            if (!map.containsKey(i)) map.put(i, rank++);
        }

        StringBuilder sb = new StringBuilder();
        for(int i: arr) sb.append(map.get(i)).append(" ");

        System.out.println(sb);

        br.close();
    }
}
