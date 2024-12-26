import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int j=0; j<3; j++) {
            String[] input = br.readLine().split(" ");
            int[] arr = new int[4];

            int count = 0;
            for(int i=0; i<4; i++) {
                arr[i] = Integer.parseInt(input[i]);
                if(arr[i] == 0) count++;
            }

            switch (count) {
                case 1:
                    System.out.println("A");
                    break;
                case 2:
                    System.out.println("B");
                    break;
                case 3:
                    System.out.println("C");
                    break;
                case 4:
                    System.out.println("D");
                    break;
                case 0:
                    System.out.println("E");
                    break;
            }
        }

        br.close();
    }
}
