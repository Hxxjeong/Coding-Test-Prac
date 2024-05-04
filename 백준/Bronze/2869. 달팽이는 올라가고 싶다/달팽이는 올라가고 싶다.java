import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int[] snail = new int[3];
        for(int i=0; i<input.length; i++) {
            snail[i] = Integer.parseInt(input[i]);
        }

        int a = snail[0];
        int b = snail[1];
        int v = snail[2];

        int day = (v-b) / (a-b);

        // 미끄러지고 나서 갈 거리가 있을 때
        if((v-b) % (a-b) != 0) day++;

        System.out.println(day);
        br.close();
    }
}