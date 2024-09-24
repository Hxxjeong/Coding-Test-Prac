import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while((input = br.readLine()) != null) {
            int[] arr = new int[4]; // 소문자, 대문자, 숫자, 공백

            for(char c: input.toCharArray()) {
                if(c >= 'a' && c <= 'z') arr[0]++;
                else if(c >= 'A' && c <= 'Z') arr[1]++;
                else if(c >= '0' && c <= '9') arr[2]++;
                else if(c == ' ') arr[3]++;
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for(int i: arr) bw.write(i + " ");
            bw.flush();

            System.out.println();
        }

        br.close();
    }
}