import java.io.*;
import java.util.Arrays;

public class Main {
    static class Member {
        int age;
        String name;
        int index;

        Member(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Member[] members = new Member[N];

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            members[i] = new Member(age, name, i);
        }

        Arrays.sort(members, (m1, m2) -> {
            if (m1.age == m2.age) return Integer.compare(m1.index, m2.index);   // 나이가 같으면 가입순
            return Integer.compare(m1.age, m2.age);
        });

        for(Member m: members) {
            System.out.println(m.age + " " + m.name);
        }

        br.close();
    }
}
