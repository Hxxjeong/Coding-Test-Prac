import java.io.*;
import java.util.*;

class Student {
    int num, count, time;

    Student(int num, int count, int time) {
        this.num = num;
        this.count = count;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Student> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int cur = arr[i];
            boolean found = false;

            // 이미 있는 학생인 경우
            for(Student s: list) {
                if(s.num == cur) {
                    s.count++;
                    found = true;
                    break;
                }
            }

            if(found) continue;

            // 없으면 추가
            if(list.size() == N) {
                list.sort((a, b) -> a.count == b.count ? a.time - b.time : a.count - b.count);
                list.remove(0);
            }

            list.add(new Student(cur, 1, i)); // 새 학생 추가
        }

        list.sort(Comparator.comparingInt(a -> a.num));
        for(Student s: list) System.out.print(s.num + " ");

        br.close();
    }
}