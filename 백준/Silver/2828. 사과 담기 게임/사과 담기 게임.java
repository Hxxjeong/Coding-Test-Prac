import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int J = Integer.parseInt(br.readLine());
        int left = 1;
        int right = M;
        int answer = 0;
        for(int i=0; i<J; i++) {
            int pos = Integer.parseInt(br.readLine());

            if(pos < left) { // 왼쪽으로 이동
                answer += (left - pos);
                left = pos;
                right = pos + M - 1;
            }
            else if(pos > right) { // 오른쪽으로 이동
                answer += (pos - right);
                right = pos;
                left = pos - M + 1;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
