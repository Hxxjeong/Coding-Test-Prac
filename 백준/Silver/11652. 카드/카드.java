import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Long> map = new TreeMap<>();
        for(int i=0; i<N; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0L)+1);
        }

        long max = 0;
        long key = 0;
        for(Map.Entry<Long, Long> entry: map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }

        System.out.println(key);

        br.close();
    }
}