import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        int P = Integer.parseInt(input[1]);

        List<Long> list = new ArrayList<>();
        list.add(A);
        int index = 0;
        while(true) {
            String num = list.get(index).toString();
            long next = 0;
            for(char c: num.toCharArray()) next += (long) Math.pow(c - '0', P);

            if(list.contains(next)) {
                index = list.indexOf(next);
                break;
            }

            list.add(next);
            index++;
        }

        System.out.println(index);

        br.close();
    }
}