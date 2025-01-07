import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[20_000_001];

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            int index = Integer.parseInt(input[i]);
            arr[index+10_000_000] = 1;
        }

        int M = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            int index = Integer.parseInt(input[i]);
            sb.append(arr[index+10_000_000]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
