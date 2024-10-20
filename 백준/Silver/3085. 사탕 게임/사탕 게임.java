import java.io.*;

public class Main {
    static char[][] candy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        candy = new char[N][N];
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++) {
                candy[i][j] = input.charAt(j);
            }
        }

        int answer = 0;

        // 인접한 사탕을 바꾸어 최대가 되는지 확인 (가로)
        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {
                // 색이 다르면 교환
                if(candy[i][j] != candy[i][j+1]) {
                    swap(i, j, i, j+1);
                    answer = Math.max(answer, getMax(N));   // 최대 연속 개수 갱신
                    swap(i, j+1, i, j);     // 원래대로
                }
            }
        }

        // 세로 확인
        for (int j=0; j<N; j++) {
            for (int i=0; i<N-1; i++) {
                // 서로 다른 사탕이면 교환
                if (candy[i][j] != candy[i+1][j]) {
                    swap(i, j, i+1, j);
                    answer = Math.max(answer, getMax(N));
                    swap(i, j, i+1, j);
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

    public static void swap(int i1, int i2, int j1, int j2) {
        char temp = candy[i1][i2];
        candy[i1][i2] = candy[j1][j2];
        candy[j1][j2] = temp;
    }

    // 연속된 사탕 개수 최대 구하기
    public static int getMax(int N) {
        int max = 1;    // 본인만 포함일 때

        // 가로
        for (int i=0; i<N; i++) {
            int count = 1;
            for (int j=1; j<N; j++) {
                // 같은 색인 경우 count 증가
                if (candy[i][j] == candy[i][j-1]) count++;
                // 연속이 끊긴 경우 센 사탕의 최대 개수 갱신
                else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count); // 마지막 연속 검사
        }

        // 세로
        for (int j=0; j<N; j++) {
            int count = 1;
            for (int i=1; i<N; i++) {
                if (candy[i][j] == candy[i-1][j]) count++;
                else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count); // 마지막 연속 검사
        }

        return max;
    }
}