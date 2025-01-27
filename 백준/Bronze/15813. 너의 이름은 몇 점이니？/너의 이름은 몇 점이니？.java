import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String name = br.readLine();

        int answer = 0;
        for(char c: name.toCharArray()) answer += c - 'A' + 1;

        System.out.println(answer);

        br.close();
    }
}
