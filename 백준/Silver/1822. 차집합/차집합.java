import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int nA = Integer.parseInt(input[0]);
        int nB = Integer.parseInt(input[1]);

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        input = br.readLine().split(" ");
        for(int i=0; i<nA; i++) A.add(Integer.parseInt(input[i]));
        input = br.readLine().split(" ");
        for(int i=0; i<nB; i++) B.add(Integer.parseInt(input[i]));

        List<Integer> list = new ArrayList<>();
        for(int i: A) {
            if(!B.contains(i)) list.add(i);
        }

        if(list.isEmpty()) System.out.println(0);
        else {
            Collections.sort(list);
            System.out.println(list.size());
            list.forEach(s -> System.out.print(s + " "));
        }

        br.close();
    }
}
