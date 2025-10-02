import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            Set<Integer> set1 = new HashSet<>();
            for(int j=0; j<N; j++) set1.add(Integer.parseInt(input[j]));

            int M = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            for(String s: input) sb.append(set1.contains(Integer.parseInt(s)) ? "1" : "0").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}