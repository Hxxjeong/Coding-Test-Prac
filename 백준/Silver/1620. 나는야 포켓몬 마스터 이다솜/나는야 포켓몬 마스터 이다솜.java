import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[N+1];     // 번호를 통해 이름을 찾기 위한 배열
        for(int i=1; i<=N; i++) {
            String name = br.readLine();
            map.put(name, i);
            arr[i] = name;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            String line = br.readLine();

            try {
                int index = Integer.parseInt(line);
                sb.append(arr[index]).append("\n");
            }
            catch(Exception e) {
                sb.append(map.get(line)).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
