import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=8; i++) map.put(i, Integer.parseInt(br.readLine()));

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        int sum = 0;
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<5; i++) {
            sum += map.get(list.get(i));
            answer.add(list.get(i));
        }

        Collections.sort(answer);
        System.out.println(sum);
        answer.stream().forEach(s -> System.out.print(s + " "));

        br.close();
    }
}