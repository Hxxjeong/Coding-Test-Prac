import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int score = Integer.parseInt(input[1]);
        int P = Integer.parseInt(input[2]);

        int[] arr = new int[N];
        if(N > 0) {
            input = br.readLine().split(" ");
            for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);
        }

        // 점수가 아무도 없을 때
        if(N == 0) {
            System.out.println(1);
            return;
        }

        // 랭킹이 꽉 찼고, 마지막 점수보다 작거나 같을 경우 진입 불가
        if(N == P && score <= arr[N-1]) {
            System.out.println(-1);
            return;
        }

        int rank = 1;
        for(int i=0; i<N; i++) {
            if(arr[i] > score) rank++;
            else break;
        }

        System.out.println(rank);

        br.close();
    }
}
