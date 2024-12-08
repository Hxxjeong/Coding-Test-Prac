import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) set.add(Integer.parseInt(input[i]));

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            if(set.contains(Integer.parseInt(input[i]))) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
