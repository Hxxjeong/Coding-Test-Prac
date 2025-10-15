import java.io.*;

public class Main {
    static int[][] arr = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<5; j++) arr[i][j] = Integer.parseInt(input[j]);
        }

        for(int i=0; i<5; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<5; j++) {
                int num = Integer.parseInt(input[j]);
                mark(num);

                if(countBingo() >= 3) {
                    System.out.println(i*5 + (j+1));
                    return;
                }
            }
        }

        br.close();
    }

    public static void mark(int num) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(arr[i][j] == num) {
                    arr[i][j] = 0;
                    return;
                }
            }
        }
    }

    public static int countBingo() {
        int count = 0;

        // 가로
        for(int i=0; i<5; i++) {
            boolean bingo = true;
            for(int j=0; j<5; j++) {
                if(arr[i][j] != 0) {
                    bingo = false;
                    break;
                }
            }
            if(bingo) count++;
        }

        // 세로 체크
        for(int j=0; j<5; j++) {
            boolean bingo = true;
            for(int i=0; i<5; i++) {
                if (arr[i][j] != 0) {
                    bingo = false;
                    break;
                }
            }
            if(bingo) count++;
        }

        // 우하향 대각선
        boolean bingo = true;
        for(int i=0; i<5; i++) {
            if(arr[i][i] != 0) {
                bingo = false;
                break;
            }
        }
        if(bingo) count++;

        // 우하향 대각선
        boolean bingo2 = true;
        for(int i=0; i<5; i++) {
            if(arr[i][4-i] != 0) {
                bingo2 = false;
                break;
            }
        }
        if(bingo2) count++;

        return count;
    }
}