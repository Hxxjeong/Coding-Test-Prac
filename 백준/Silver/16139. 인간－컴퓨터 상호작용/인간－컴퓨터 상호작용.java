import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<q; i++) {
            String[] input = br.readLine().split(" ");
            char a = input[0].charAt(0);
            int start = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[2]);

            int count = 0;
            String str = S.substring(start, end+1);
            for(char c: str.toCharArray()) {
                if(c == a) count++;
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
