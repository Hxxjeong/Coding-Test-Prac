import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list);

        int p = (int) Math.round(n * 0.15);
        int sum = 0;
        for(int i=p; i<n-p; i++) sum += list.get(i);

        int person = n - p*2;
        System.out.println((int) Math.round(sum/(double) person));

        br.close();
    }
}