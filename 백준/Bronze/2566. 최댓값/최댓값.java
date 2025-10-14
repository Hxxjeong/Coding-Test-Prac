import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<9; i++) list.add(new ArrayList<>());

        for(int i=0; i<9; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<9; j++) list.get(i).add(Integer.parseInt(input[j]));
        }

        int answer = 0;
        int x = 0, y = 0;
        for(int i=0; i<9; i++) {
            Integer max = list.get(i).stream().max(Integer::compareTo).get();
            if(max > answer) {
                answer = max;
                x = i;
                y = list.get(i).indexOf(max);
            }
        }

        System.out.println(answer);
        System.out.println((x+1) + " " + (y+1));

        br.close();
    }
}