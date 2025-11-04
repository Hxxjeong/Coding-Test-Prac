import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        Map<String, Boolean> map = new LinkedHashMap<>();   // value = dummy
        for(int i=0; i<L; i++) {
            String line = br.readLine();
            if(map.containsKey(line)) map.remove(line);

            map.put(line, true);
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(String s: map.keySet()) {
            sb.append(s).append("\n");
            count++;
            if(count == K) break;
        }

        System.out.println(sb);

        br.close();
    }
}
