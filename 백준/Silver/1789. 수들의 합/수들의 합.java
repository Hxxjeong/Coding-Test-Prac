import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long sum = 0;
        int i = 1;
        int answer = 0;
        while(true) {
            sum += i;
            if(sum <= S) {
                answer++;
                i++;
            }
            else break;
        }

        System.out.println(answer);

        br.close();
    }
}
