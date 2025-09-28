import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a1 = Integer.parseInt(input[0]);
        int a0 = Integer.parseInt(input[1]);

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        boolean o = true;

        for(int n = n0; n <= 100; n++) {
            if (a1 * n + a0 > c * n) {
                o = false;
                break;
            }
        }

        System.out.println(o ? 1 : 0);

        br.close();
    }
}