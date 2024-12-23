import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        int answer = 0;
        while(K != 0) {
            int index = N-1;
            while(index >= 0) {
                if(K >= arr[index]) {
                    K -= arr[index];
                    answer++;
                }
                else index--;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
