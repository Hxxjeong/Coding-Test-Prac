import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++) list.add(br.readLine());

        Collections.sort(list, (a, b) -> {
            if(a.length() != b.length()) return a.length() - b.length();

            int sumA = 0;
            int sumB = 0;
            for(char c: a.toCharArray()) {
                if(Character.isDigit(c)) sumA += c - '0';
            }
            for(char c: b.toCharArray()) {
                if (Character.isDigit(c)) sumB += c - '0';
            }

            if(sumA != sumB) return sumA - sumB;

            return a.compareTo(b);
        });

        for(int i=0; i<N; i++) System.out.println(list.get(i));

        br.close();
    }
}
