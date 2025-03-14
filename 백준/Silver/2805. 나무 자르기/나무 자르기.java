import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 나무의 수
        int M = Integer.parseInt(input[1]); // 가져가려는 나무 길이

        int[] tree = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) tree[i] = Integer.parseInt(input[i]);

        Arrays.sort(tree);

        long left = 0;
        long right = tree[N-1];
        long answer = 0;
        while(left <= right) {
            long mid = (right + left) / 2;

            long count = 0;     // 잘린 나무 길이
            for(int i=0; i<N; i++) {
                if(tree[i] > mid) count += tree[i] - mid;
            }

            if(count >= M) {
                answer = mid;
                left = mid+1;
            }
            else right = mid-1;   // 나무 조각이 모자란 경우
        }

        System.out.println(answer);

        br.close();
    }
}