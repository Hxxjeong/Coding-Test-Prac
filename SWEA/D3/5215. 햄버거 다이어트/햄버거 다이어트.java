import java.io.*;

public class Solution {
    static int N, L;
    static int max;
    static int[] score, cal;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test_case=1; test_case<=T; test_case++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);        // 재료의 수
            L = Integer.parseInt(input[1]);        // 제한 칼로리

            score = new int[N];
            cal = new int[N];
            for (int i=0; i<N; i++) {
                String[] ham = br.readLine().split(" ");
                score[i] = Integer.parseInt(ham[0]);
                cal[i] = Integer.parseInt(ham[1]);
            }

            max = Integer.MIN_VALUE;
            calculate(0, 0, 0);
            sb.append("#").append(test_case).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    public static void calculate (int depth, int scoreSum, int calSum){
        // 칼로리가 초과된 경우
        if (calSum > L) return;

        // 재료를 다 고른 경우
        if (depth == N) {
            max = Math.max(max, scoreSum);
            return;
        }

        // 현재 재료를 고르는 경우
        calculate(depth+1, scoreSum + score[depth], calSum + cal[depth]);

        // 현재 재료를 고르지 않는 경우
        calculate(depth+1, scoreSum, calSum);
    }
}