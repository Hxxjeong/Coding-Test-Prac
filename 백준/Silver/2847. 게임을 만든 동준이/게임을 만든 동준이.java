import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        int answer = 0;
        int prev = arr[N-1];
        for(int i=N-2; i>=0; i--) {
            if(arr[i] >= prev) {
                int diff = arr[i] - prev + 1;
                answer += diff;
                prev = arr[i] - diff;
            }
            else prev = arr[i];
        }

        System.out.println(answer);

        br.close();
    }
}