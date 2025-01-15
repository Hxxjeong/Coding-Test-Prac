import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[246913];

        for(int i=2; i<=246912; i++) isPrime[i] = true;

        for(int i=2; i*i<=246912; i++) {
            for(int j=i*i; j<=246912; j+=i) {
                isPrime[j] = false;
            }
        }

        String input;
        StringBuilder sb = new StringBuilder();
        while(!(input = br.readLine()).equals("0")) {
            int num = Integer.parseInt(input);
            int answer = 0;
            for(int i=num+1; i<=num*2; i++) if(isPrime[i]) answer++;

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
