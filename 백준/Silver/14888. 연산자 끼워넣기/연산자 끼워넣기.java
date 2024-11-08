import java.io.*;

class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] arr, operator;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(input[i]);

        operator = new int[4];  // +, -, *, /
        String[] opInput = br.readLine().split(" ");
        for (int i=0; i<4; i++) operator[i] = Integer.parseInt(opInput[i]);

        calculate(0, arr[0]);

        System.out.println(max + "\n" + min);

        br.close();
    }

    public static void calculate(int depth, int current) {
        if (depth == N-1) {
            max = Math.max(max, current);
            min = Math.min(min, current);
            return;
        }

        for (int i=0; i<4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch(i) {
                    case 0: // +
                        calculate(depth+1, current + arr[depth+1]);
                        break;
                    case 1: // -
                        calculate(depth+1, current - arr[depth+1]);
                        break;
                    case 2: // *
                        calculate(depth+1, current * arr[depth+1]);
                        break;
                    case 3: // /
                        calculate(depth+1, current / arr[depth+1]);
                        break;
                }

                operator[i]++;    // 원상복구
            }
        }
    }
}