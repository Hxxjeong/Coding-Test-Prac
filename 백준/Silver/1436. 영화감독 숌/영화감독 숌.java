import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int num = 666;

        while(true) {
            if(String.valueOf(num).contains("666")) {
                count++;
                if(count == N) break;
            }
            num++;
        }

        System.out.println(num);

        br.close();
    }
}
