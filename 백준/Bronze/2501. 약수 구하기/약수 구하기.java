import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            if(N % i == 0) list.add(i);
        }

        System.out.println(list.size() < K ? 0 : list.get(K-1));
    }
}