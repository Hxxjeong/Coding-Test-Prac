import java.io.*;
import java.util.*;

class Person {
    String name;
    int day;
    int month;
    int year;

    public Person(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Person> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Person(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])));
        }

        // 나이 적은 순
        list.sort((p1, p2) -> {
            if(p1.year == p2.year) {
                if(p1.month == p2.month) return p2.day - p1.day;
                else return p2.month - p1.month;
            }
            return p2.year - p1.year;
        });

        System.out.println(list.get(0).name);
        System.out.println(list.get(n-1).name);

        br.close();
    }
}
