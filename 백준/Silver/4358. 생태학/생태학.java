import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        Map<String, Integer> map = new TreeMap<>(Comparator.naturalOrder());
        int total = 0;
        while((input = br.readLine()) != null) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            total++;
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", entry.getValue() * 100.0 / total)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
