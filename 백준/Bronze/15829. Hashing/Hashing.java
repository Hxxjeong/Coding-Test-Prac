import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int times = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int hash = 0;
        for(int i=0; i<str.length(); i++) {
            int index = str.charAt(i) - 'a'+1;
            hash += index * Math.pow(31, i);
        }

        System.out.println(hash);

        br.close();
    }
}