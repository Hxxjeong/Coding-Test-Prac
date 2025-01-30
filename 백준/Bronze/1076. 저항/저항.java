import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = List.of("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white");
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<list.size(); i++) map.put(list.get(i), (int) Math.pow(10, i));

        StringBuilder str = new StringBuilder();
        for(int i=0; i<2; i++) {
            String input = br.readLine();
            str.append(list.indexOf(input));
        }

        long answer = Long.parseLong(str.toString()) * map.get(br.readLine());

        System.out.println(answer);

        br.close();
    }
}
