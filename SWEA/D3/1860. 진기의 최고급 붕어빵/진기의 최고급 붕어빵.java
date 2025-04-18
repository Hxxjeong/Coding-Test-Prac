import java.util.*;
import java.io.*;

class Solution {
    static int N, M, K;
    static int[] person;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);		// 사람 수
            M = Integer.parseInt(input[1]);		// 만드는 데 걸리는 시간
            K = Integer.parseInt(input[2]);		// 만드는 개수

            person = new int[N];
            String[] str = br.readLine().split(" ");
            for(int i=0; i<N; i++)	person[i] = Integer.parseInt(str[i]);
            Arrays.sort(person);

            sb.append("#").append(test_case).append(serve() ? " Possible" : " Impossible").append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static boolean serve() {
        int bread = 0;
        int index = 0;

        for(int i=0; i<=person[N-1]; i++) {
            // 붕어빵 생산 시간에 붕어빵 추가
            if(i != 0 && i % M == 0) bread += K;

            // 도착한 손님에게 붕어빵 제공
            while(index < N && person[index] == i) {
                if (bread > 0) {
                    bread--;
                    index++;
                }
                else return false;
            }
        }

        return true;
    }
}