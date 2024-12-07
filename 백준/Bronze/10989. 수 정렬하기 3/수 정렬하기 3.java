import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[10001]; // 숫자의 범위: 1 ~ 10,000

        for(int i=0; i<N; i++) count[Integer.parseInt(br.readLine())]++;    // 숫자의 빈도

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000; i++) {
            while(count[i] > 0) {
                sb.append(i).append("\n");
                count[i]--;
            }
        }

        System.out.println(sb);

        br.close();
    }
}
