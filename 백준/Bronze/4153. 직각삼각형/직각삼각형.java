import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        StringBuilder sb = new StringBuilder();
        while(!(input = br.readLine()).equals("0 0 0")) {
            double[] arr = Arrays.stream(input.split(" ")).mapToDouble(Double::parseDouble).toArray();
            Arrays.sort(arr);
            double A = arr[0];
            double B = arr[1];
            double C = arr[2];

            if(Math.pow(C, 2) == Math.pow(A, 2) + Math.pow(B, 2)) sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}