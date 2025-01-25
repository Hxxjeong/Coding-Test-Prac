import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] str = input.split("-");

        int answer = sum(str[0]);   // 첫번째 연산 무조건 더하기

        // 이후 부분 빼기
        for(int i=1; i<str.length; i++) answer -= sum(str[i]);

        System.out.println(answer);

        br.close();
    }

    public static int sum(String s) {
        String[] nums = s.split("\\+");
        int sum = 0;
        for(String num: nums) sum += Integer.parseInt(num);
        return sum;
    }
}