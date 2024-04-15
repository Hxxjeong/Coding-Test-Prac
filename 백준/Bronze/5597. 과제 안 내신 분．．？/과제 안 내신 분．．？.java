import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> student = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        int total = 465;    // 1부터 30까지의 합
        int sum = 0;
        for(int i=1; i<=28; i++) {
            int num = Integer.parseInt(br.readLine());
            student.add(num);
        }
        Collections.sort(student);

        int[] students = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

        for(int i=0; i<student.size(); i++) {
            if(student.get(i)-1 != i) {
                answer.add(students[i]);
                break;
            }
        }

        for(Integer i: student) {
            sum += i;
        }
        answer.add(1, total-sum-answer.get(0));

        System.out.println(answer.get(0));
        System.out.println(answer.get(1));
    }
}