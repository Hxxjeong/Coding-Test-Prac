import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            for(int i=0; i<M; i++) br.readLine();

            sb.append(N-1).append("\n");    // 그래프를 이루는 최소 간선 = n-1개
        }

        System.out.println(sb);

        br.close();
    }
}