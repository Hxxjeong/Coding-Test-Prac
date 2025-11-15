import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        char[] food = br.readLine().toCharArray();

        int answer = 0;
        for(int i=0; i<N; i++) {
            if(food[i] == 'P') {
                for(int j=i-K; j<=i+K; j++) {
                    if(j < 0 || j >= N) continue;

                    if(food[j] == 'H') {
                        answer++;
                        food[j] = 'X';
                        break;
                    }
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}