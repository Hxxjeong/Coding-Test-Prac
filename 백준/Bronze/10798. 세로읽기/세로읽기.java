import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] arr = new String[5][15];
        for(int i=0; i<5; i++) {
            String input = br.readLine();
            for(int j=0; j<input.length(); j++) arr[i][j] = String.valueOf(input.charAt(j));
        }

        StringBuilder sb = new StringBuilder();
        for(int j=0; j<15; j++) {
            for(int i=0; i<5; i++) {
                if(arr[i][j] != null) sb.append(arr[i][j]);
            }
        }

        System.out.println(sb);

        br.close();
    }
}