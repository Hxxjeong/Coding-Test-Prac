import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        int[] first = new int[26];
        for(char c: input.toCharArray()) first[c-'A']++;

        int answer = 0;
        for(int i=1; i<n; i++) {
            String word = br.readLine();
            int[] arr = new int[26];
            for(char c: word.toCharArray()) arr[c-'A']++;

            int diff = 0;
            for(int j=0; j<26; j++) diff += Math.abs(first[j] - arr[j]);

            if(diff == 0 || diff == 1 || (diff == 2 && input.length() == word.length())) answer++;
        }

        System.out.println(answer);

        br.close();
    }
}