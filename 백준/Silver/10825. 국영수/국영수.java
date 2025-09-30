import java.io.*;
import java.util.*;

class Student {
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new Student(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])));

        }

        list.sort(
                Comparator.comparingInt((Student s) -> -s.kor)   // 국어 내림차순
                        .thenComparingInt(s -> s.eng)          // 영어 오름차순
                        .thenComparingInt(s -> -s.math)        // 수학 내림차순
                        .thenComparing(s -> s.name)            // 이름 사전순
        );

        for(Student s : list) System.out.println(s.name);

        br.close();
    }
}