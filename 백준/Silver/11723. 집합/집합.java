import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int bitmask = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            String[] input = br.readLine().split(" ");
            int num = 0;
            if(input.length > 1) num = Integer.parseInt(input[1]);

            switch (input[0]) {
                case "add":
                    bitmask |= (1 << (num - 1));
                    break;
                case "remove":
                    bitmask &= ~(1 << (num - 1));
                    break;
                case "check":
                    sb.append((bitmask & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    bitmask ^= (1 << (num - 1));
                    break;
                case "all":
                    bitmask = (1 << 20) - 1;
                    break;
                case "empty":
                    bitmask = 0;
                    break;
            }
        }

        System.out.println(sb);

        br.close();
    }
}