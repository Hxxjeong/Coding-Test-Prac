import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] sets = new int[M];
        int[] pieces = new int[M];
        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            sets[i] = Integer.parseInt(input[0]);
            pieces[i] = Integer.parseInt(input[1]);
        }

        Arrays.sort(sets);
        Arrays.sort(pieces);
        int minSet = sets[0];
        int minPiece = pieces[0];

        // 세트만, 세트+낱개, 낱개만
        int answer = Math.min((N/6 + 1) * minSet, Math.min((N/6) * minSet + (N%6) * minPiece, N * minPiece));

        System.out.println(answer);

        br.close();
    }
}