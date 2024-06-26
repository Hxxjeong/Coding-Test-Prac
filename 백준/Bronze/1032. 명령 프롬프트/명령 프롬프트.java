import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(br.readLine());
        for(int i=0; i<N-1; i++) {
            String input = br.readLine();
            for(int j=0; j<input.length(); j++) {
                if(sb.charAt(j) != input.charAt(j)) {
                    sb.replace(j, j+1, "?");
                }
            }
        }

        System.out.println(sb);

        br.close();
    }
}