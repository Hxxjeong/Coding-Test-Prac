import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        boolean[] sifter = new boolean[N+1];
        Arrays.fill(sifter, true);
        sifter[0] = sifter[1] = false;

        int count = 0;
        for(int i=2; i<=N; i++) {
            if(sifter[i]) {
                for(int j=i; j<=N; j+=i) {
                    if(sifter[j]) {
                        sifter[j] = false;
                        count++;
                        if(count == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }

        br.close();
    }
}
