import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]); // 학생 수
        double K = Double.parseDouble(input[1]);

        int[] student = new int[12];   // 학년 별 남/녀 인원
        for(int i=0; i<N; i++) {
            String[] stu = sc.nextLine().split(" ");
            int S = Integer.parseInt(stu[0]);   // 성별
            int Y = Integer.parseInt(stu[1]);   // 학년
            student[(Y-1)*2+S]++;
        }

        int room = 0;
        for (int i=0; i<student.length; i++) {
            room += (int) Math.ceil(student[i]/K);
        }

        System.out.println(room);
        sc.close();
    }
}