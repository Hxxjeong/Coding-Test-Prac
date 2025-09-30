import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        for(char c: chars) map.put(c, map.getOrDefault(c, 0) + 1);

        int length = input.length();
        long count = map.values().stream().filter(s -> s % 2 != 0).count();
        List<Character> list = new ArrayList<>(map.keySet().stream().sorted().collect(Collectors.toList()));
        StringBuilder first = new StringBuilder();  // 반쪽의 앞부분
        StringBuilder sb = new StringBuilder();

        if(length % 2 == 0) {   // 모든 문자열이 짝수 개여야 함
            if(count > 0) {
                System.out.println("I'm Sorry Hansoo");
                return;
            }

            for(char c: list) {
                for(int i=0; i<map.get(c)/2; i++) first.append(c);
            }

            sb.append(first).append(first.reverse());
        }
        else {
            if(count != 1) {    // 홀수 개인 문자가 하나만 있어야 함
                System.out.println("I'm Sorry Hansoo");
                return;
            }

            char middle = 0;
            for(char c: list) {
                int num = map.get(c);
                if (num % 2 == 1) middle = c;
                for (int i = 0; i < num/2; i++) first.append(c);
            }

            sb.append(first).append(middle).append(first.reverse());
        }

        System.out.println(sb);

        br.close();
    }
}