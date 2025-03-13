import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Integer> list = new LinkedList<>();
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++) list.add(Integer.parseInt(input[i]));

        Collections.sort(list);
        System.out.println(list.get(K-1));

        br.close();
    }
}
