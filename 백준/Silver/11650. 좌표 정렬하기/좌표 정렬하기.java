import java.io.*;
import java.util.*;

public class Main {
    static class Index {
        int x;
        int y;

        Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Index[] indices = new Index[N];

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            indices[i] = new Index(x, y);
        }

        Arrays.sort(indices, (i1, i2) -> {
            if (i1.x == i2.x) return Integer.compare(i1.y, i2.y);   // x좌표가 같으면 y좌표순
            return Integer.compare(i1.x, i2.x);
        });

        StringBuilder sb = new StringBuilder();
        for(Index i: indices) sb.append(i.x).append(" ").append(i.y).append("\n");

        System.out.println(sb);

        br.close();
    }
}
