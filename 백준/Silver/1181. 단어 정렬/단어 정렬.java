import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            if(!list.contains(input)) list.add(input);
        }

        list.sort((o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            return o1.length() - o2.length();
        });

        list.forEach(System.out::println);

        br.close();
    }
}