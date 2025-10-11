import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[26][S.length()];
        arr[S.charAt(0)-'a'][0] = 1;
        for(int i=1; i<S.length(); i++) {
            for(int j=0; j<26; j++) arr[j][i] = arr[j][i-1];
            arr[S.charAt(i)-'a'][i]++;
        }

        for(int i=0; i<q; i++) {
            String[] input = br.readLine().split(" ");
            char a = input[0].charAt(0);
            int start = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]);

            if (start == 0) sb.append(arr[a-'a'][end]).append("\n");
            else sb.append(arr[a-'a'][end] - arr[a-'a'][start-1]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
