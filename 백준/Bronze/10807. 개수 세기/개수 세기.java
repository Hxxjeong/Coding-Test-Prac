import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[201];  // -100 ~ 100

        for(int i=0; i<N; i++) {
            int n = sc.nextInt();
            nums[n+100]++;  // -100이 0번 인덱스
        }

        int v = sc.nextInt();

        System.out.println(nums[v+100]);
        sc.close();
    }
}