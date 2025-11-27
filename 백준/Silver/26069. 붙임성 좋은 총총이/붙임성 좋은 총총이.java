import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            String A = input[0];
            String B = input[1];

            if(A.equals("ChongChong") || B.equals("ChongChong")) {
                set.add(A);
                set.add(B);
                answer = set.size();
            }
            else if(set.contains(A) || set.contains(B)) {
                set.add(A);
                set.add(B);
                answer = set.size();
            }
        }

        System.out.println(answer);

        br.close();
    }
}
