import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++) set.add(br.readLine());

        List<String> answer = new ArrayList<>();
        for(int i=0; i<M; i++) {
            String line = br.readLine();
            if(set.contains(line)) answer.add(line);
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        answer.forEach(System.out::println);

        br.close();
    }
}
