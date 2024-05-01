import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        String[] product = new String[n];
        for(int i=0; i<n; i++) {
            product[i] = br.readLine();
        }

        int[] buy = new int[n];
        for(int i=0; i<buy.length; i++) {
            String[] buys = product[i].split(" ");
            buy[i] = Integer.parseInt(buys[0]) * Integer.parseInt(buys[1]);
        }

        int sum = 0;
        for(int i: buy)
            sum += i;

        System.out.println(total == sum ? "Yes" : "No");

        br.close();
    }
}