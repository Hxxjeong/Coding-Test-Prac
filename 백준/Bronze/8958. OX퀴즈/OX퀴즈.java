import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++) {
            String input = br.readLine();

            int score = 0;
            int answer = 0;
            for(char c: input.toCharArray()) {
                if(c == 'O') answer += ++score;
                else score = 0;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
