import java.io.*;
import java.util.*;

class Medal {
    int country;
    int gold;
    int silver;
    int bronze;

    public Medal(int country, int gold, int silver, int bronze) {
        this.country = country;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Medal> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            int country = Integer.parseInt(input[0]);
            int gold = Integer.parseInt(input[1]);
            int silver = Integer.parseInt(input[2]);
            int bronze = Integer.parseInt(input[3]);

            list.add(new Medal(country, gold, silver, bronze));
        }

        list.sort(Comparator.comparing((Medal m) -> -m.gold)
                .thenComparing(m -> -m.silver)
                .thenComparing(m -> -m.bronze));

        int rank = 1;
        for(int i=0; i<list.size(); i++) {
            if(i > 0) {
                Medal prev = list.get(i-1);
                Medal cur = list.get(i);

                // 동점이 아닐 경우 순위 증가
                if(cur.gold != prev.gold || cur.silver != prev.silver || cur.bronze != prev.bronze) rank = i+1;
            }

            if (list.get(i).country == K) {
                System.out.println(rank);
                return;
            }
        }

        br.close();
    }
}
