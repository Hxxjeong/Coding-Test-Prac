import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = input.length();
        String answer = null;
        for(int i=0; i<n-2; i++) {
            for(int j=i+1; j<n-1; j++) {
                String a = new StringBuilder(input.substring(0, i+1)).reverse().toString();
                String b = new StringBuilder(input.substring(i+1, j+1)).reverse().toString();
                String c = new StringBuilder(input.substring(j+1)).reverse().toString();

                String newWord = a + b + c;
                if(answer == null || answer.compareTo(newWord) > 0) answer = newWord;
            }
        }

        System.out.println(answer);

        br.close();
    }
}