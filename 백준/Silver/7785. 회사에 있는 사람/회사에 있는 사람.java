import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String status = input[1];

            if(status.equals("enter")) set.add(name);
            else if(status.equals("leave")) set.remove(name);
        }

        List<String> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String s: list) sb.append(s).append("\n");
        System.out.println(sb);

        br.close();
    }
}
