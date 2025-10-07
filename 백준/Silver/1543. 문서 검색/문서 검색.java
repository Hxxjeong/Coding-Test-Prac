import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String find = br.readLine();

        int index;
        int answer = 0;
        while((index = input.indexOf(find)) != -1) {
            answer++;
            input = input.substring(index + find.length());
        }

        System.out.println(answer);

        br.close();
    }
}
