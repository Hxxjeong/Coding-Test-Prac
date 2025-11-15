import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) sb.append(br.readLine()).append("a");

        String[] str = sb.toString().split("[a-z]");
        List<BigInteger> list = new ArrayList<>();
        for(int i=0; i<str.length; i++) {
            if(str[i].isEmpty()) continue;
            list.add(new BigInteger(str[i]));
        }

        Collections.sort(list);
        for(int i=0; i<list.size(); i++) System.out.println(list.get(i));

        br.close();
    }
}