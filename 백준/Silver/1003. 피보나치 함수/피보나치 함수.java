import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dpZero = new int[41];
        dpZero[0] = 1;
        dpZero[2] = 1;
        dpZero[3] = 1;

        int[] dpOne = new int[41];
        dpOne[1] = 1;
        dpOne[2] = 1;
        dpOne[3] = 2;

        for(int i=4; i<=40; i++) {
            dpZero[i] = dpZero[i-1] + dpZero[i-2];
            dpOne[i] = dpOne[i-1] + dpOne[i-2];
        }

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dpZero[N] + " " + dpOne[N]);
        }

        br.close();
    }
}
