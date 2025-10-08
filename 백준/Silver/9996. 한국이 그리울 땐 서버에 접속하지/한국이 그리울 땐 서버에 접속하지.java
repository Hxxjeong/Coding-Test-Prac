import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String format = br.readLine();
        String[] strs = format.split("\\*");
        String regex = "^" + strs[0] + ".*" + strs[1] + "$";  // 정규식 형태로 변환
        Pattern pattern = Pattern.compile(regex);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()) sb.append("DA").append("\n");
            else sb.append("NE").append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
