import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ascend = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] descend = {8, 7, 6, 5, 4, 3, 2, 1};

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(Arrays.equals(input, ascend)) System.out.println("ascending");
        else if(Arrays.equals(input, descend)) System.out.println("descending");
        else System.out.println("mixed");

        br.close();
    }
}