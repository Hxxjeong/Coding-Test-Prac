import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<String> list = new ArrayList<>();

        while(!(input = br.readLine()).equals("0")) {
            StringBuilder sb = new StringBuilder(input);
            String str = sb.reverse().toString().equals(input) ? "yes" : "no";
            list.add(str);
        }

        list.forEach(System.out::println);
    }
}