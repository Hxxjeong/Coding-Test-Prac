import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[1001];

        for(int i=1; i<= 1000; i++) {
            if(i < 100) arr[i] = true; // 한 자리, 두 자리 숫자는 모두 한수
            else {
                int a = i / 100;
                int b = (i / 10) % 10;
                int c = i % 10;
                if((a-b) == (b-c)) arr[i] = true;
            }
        }

        int answer = 0;
        for(int i=1; i<=N; i++) if(arr[i]) answer++;

        System.out.println(answer);

        br.close();
    }
}
