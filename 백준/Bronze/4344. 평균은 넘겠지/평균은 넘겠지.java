import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<C; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            List<Integer> list = new ArrayList<>();

            for(int j=1; j<=N; j++) list.add(Integer.parseInt(input[j]));

            int sum = list.stream().mapToInt(Integer::intValue).sum();
            double avg = sum / (double) N;

            long count = list.stream().filter(score -> score > avg).count();
            double ratio = (count / (double) N) * 100;

            sb.append(String.format("%.3f%%\n", ratio));
        }

        System.out.println(sb);

        br.close();
    }
}
