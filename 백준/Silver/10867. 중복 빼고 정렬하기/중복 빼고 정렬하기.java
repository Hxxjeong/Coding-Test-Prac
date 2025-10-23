import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++) set.add(Integer.parseInt(input[i]));

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        list.forEach(s -> System.out.print(s + " "));

        br.close();
    }
}