import java.io.*;

public class Main {
    static int n;
    static char[][] arr;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        arr = new char[n][n];
        int index = 0;

        // 입력
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                arr[i][j] = input.charAt(index++);
            }
        }

        answer = new int[n];
        if(find(0)) {
            for(int i: answer)
                System.out.print(i + " ");
        }

        br.close();
    }

    // depth 번째 수 찾기
    private static boolean find(int depth) {
        if(depth == n) return true; //  수열을 다 찾은 경우

        // -10 ~ 10에서 탐색
        for(int i=-10; i<=10; i++) {
            answer[depth] = i;

            // 조건이 맞으면 다음 자리 탐색
            if(isValid(depth)) {
                if(find(depth+1)) return true;
            }
        }

        return false;
    }

    // depth까지의 조건이 맞는지 확인
    static boolean isValid(int depth) {
        for(int i=0; i<=depth; i++) {
            int sum = 0;
            for (int j=i; j<=depth; j++) {
                sum += answer[j];

                // arr[i][j]의 부호를 확인해서 맞지 않으면 false 처리
                if ((arr[i][j] == '+' && sum <= 0) || (arr[i][j] == '-' && sum >= 0) || (arr[i][j] == '0' && sum != 0))
                    return false;
            }
        }

        return true;
    }
}