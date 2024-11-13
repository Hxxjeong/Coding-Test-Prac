import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 시험장 개수
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] person = new long[N];
        for(int i=0; i<N; i++) person[i] = Integer.parseInt(st.nextToken());

        String[] input = br.readLine().split(" ");
        int B = Integer.parseInt(input[0]);     // 총감독관
        double C = Double.parseDouble(input[1]);     // 부감독관

        long answer = N;
        for(int i=0; i<N; i++) person[i] -= B;  // 총감독 배치
        // 부감독 배치
        for(int i=0; i<N; i++) {
            // 시험장에 사람이 남은 경우 부감독 배치
            if(person[i] > 0)
                answer += (long) Math.ceil((double) person[i] / C);
        }

        System.out.println(answer);

        br.close();
    }
}