import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str.length()+1][str2.length()+1];
        for(int i=1; i<=str.length(); i++) {
            for(int j=1; j<=str2.length(); j++) {
                if(str.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int i = str.length();
        int j = str2.length();
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0) {
            if(str.charAt(i-1) == str2.charAt(j-1)) {
                sb.append(str.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) i--;
            else j--;
        }

        System.out.println(sb.reverse());

        br.close();
    }
}
