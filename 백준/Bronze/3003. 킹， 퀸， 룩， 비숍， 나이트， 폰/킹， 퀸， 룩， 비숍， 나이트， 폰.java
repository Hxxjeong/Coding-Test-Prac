import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] set = {1, 1, 2, 2, 2, 8};
        for(int i=0; i<6; i++) set[i] = set[i] - input[i];

        Arrays.stream(set).forEach(x -> System.out.print(x + " "));

        br.close();
    }
}
