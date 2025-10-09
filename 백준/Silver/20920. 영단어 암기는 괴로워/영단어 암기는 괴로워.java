import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            if(map.get(a).equals(map.get(b))) {
                if (a.length() == b.length()) return a.compareTo(b);
                return b.length() - a.length();
            }
            return map.get(b) - map.get(a);
        });

        StringBuilder sb = new StringBuilder();
        for(String s: list) {
            if(s.length() < M) continue;
            sb.append(s).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
