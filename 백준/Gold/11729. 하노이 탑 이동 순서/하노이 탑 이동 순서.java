import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        func(1, 3, K);

        System.out.println((int) Math.pow(2, K) - 1);
        System.out.println(sb);

        br.close();
    }

    public static void func(int a, int b, int k) {
        if(k == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }

        func(a, 6-a-b, k-1);  // k-1개의 원판을 a에서 6-a-b로 옮김
        sb.append(a).append(" ").append(b).append("\n");  // k번 원판을 기둥 a에서 기둥 b로 옮김
        func(6-a-b, b, k-1);    // k-1개의 원판을 6-a-b에서 b로 옮김
    }
}
