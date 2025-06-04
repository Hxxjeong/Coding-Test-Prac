import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<n; t++) {
            int m = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int i=0; i<m; i++) {
                String[] input = br.readLine().split(" ");
                String type = input[1];
                map.put(type, map.getOrDefault(type, 0)+1);
            }

            int answer = 1;
            for(int count: map.values()) {
                answer *= (count+1); // 입지 않는 경우 포함
            }

            sb.append(answer-1).append("\n");   // 아무것도 입지 않는 경우 제외
        }

        System.out.println(sb);

        br.close();
    }
}