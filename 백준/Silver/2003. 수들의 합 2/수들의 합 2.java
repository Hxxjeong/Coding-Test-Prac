import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);

        int start = 0;
        int end = 0;
        int sum = 0;
        int answer = 0;
        while(end < N) {
            sum += arr[end];

            while(sum >= M) {
                if(sum == M) answer++;
                sum -= arr[start];
                start++;
            }

            end++;
        }

        System.out.println(answer);

        br.close();
    }
}