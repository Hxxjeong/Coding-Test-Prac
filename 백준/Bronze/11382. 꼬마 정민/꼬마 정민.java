import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sum();

        System.out.println(sum);

        br.close();
    }
}
