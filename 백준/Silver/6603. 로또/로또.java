import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while(!(input = br.readLine()).equals("0")) {
            String[] str = input.split(" ");
            int[] arr = new int[str.length-1];
            for(int i=1; i<str.length; i++) arr[i-1] = Integer.parseInt(str[i]);
            Arrays.sort(arr);

            int[] result = new int[6];
            visited = new boolean[arr.length];
            dfs(result, arr, 0, 0);

            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void dfs(int[] result, int[] arr, int depth, int start) {
        if(depth == 6) {
            for(int num: result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<arr.length; i++) {
            result[depth] = arr[i];
            dfs(result, arr, depth+1, i+1);
        }
    }
}