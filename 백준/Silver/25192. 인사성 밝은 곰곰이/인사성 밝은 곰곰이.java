import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int answer = 0;
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            if(line.equals("ENTER")) {
                answer += set.size();
                set = new HashSet<>();
                continue;
            }
            set.add(line);
        }

        System.out.println(answer + set.size());

        br.close();
    }
}