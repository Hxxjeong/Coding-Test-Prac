import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String A = input[0];
        String B = input[1];

        int answer = Integer.MAX_VALUE;

        for(int i=0; i<=B.length()-A.length(); i++) {
            int count = 0;

            // 윈도우 내 비교
            for(int j=0; j<A.length(); j++) {
                if(A.charAt(j) != B.charAt(i+j)) count++;
            }

            answer = Math.min(answer, count);
            if(answer == 0) break;
        }

        System.out.println(answer);

        br.close();
    }
}
