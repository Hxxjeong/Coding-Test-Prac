import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = new int[3];

        for(int i=0; i<3; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int count = 0;
        int same = 0;

        if(nums[0] == nums[1] && nums[1] == nums[2])
            count = 3;
        else if (nums[0] == nums[1]) {
            count = 2;
            same = nums[0];
        }
        else if (nums[1] == nums[2]) {
            count = 2;
            same = nums[1];
        }
        else count = 0;

        switch (count) {
            case 0:
                System.out.println(nums[2]*100);
                break;
            case 2:
                System.out.println(1000+same*100);
                break;
            case 3:
                System.out.println(10000+nums[0]*1000);
        }

        sc.close();
    }
}
