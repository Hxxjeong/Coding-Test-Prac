import java.io.*;
import java.util.*;

public class Main {
    static String[] words;
    static char[][] result = new char[3][3];
    static boolean[] visited = new boolean[6];
    static List<String> list = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        words = new String[6];

        for(int i=0; i<6; i++) words[i] = br.readLine();

        // 3개를 골라 가로로 나열했을 때 세로도 일치하는 경우 찾기
        find(0);

        Collections.sort(list);
        System.out.println(!list.isEmpty() ? list.get(0) : 0);

        br.close();
    }

    public static void find(int depth) {
        if(depth == 3) {
            // 세로 단어 확인
            if(isValid()) {
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<3; i++) {
                    sb.append(String.valueOf(result[i])).append("\n");
                }
                list.add(sb.toString().trim());    // 답이 될 수 있는 경우 리스트에 추가
            }
            return;
        }

        for(int i=0; i<6; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            for(int j=0; j<3; j++) {
                result[depth][j] = words[i].charAt(j);  // 가로 단어 배치
            }
            find(depth+1);  // 다음 행으로 이동
            visited[i] = false;     // 백트래킹
        }
    }

    public static boolean isValid() {
        boolean[] temp = Arrays.copyOf(visited, 6);

        for(int i=0; i<3; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<3; j++) {
                sb.append(result[j][i]);    // 세로 단어 구성
            }

            boolean found = false;
            for (int k=0; k<6; k++) {
                // 방문하지 않은 단어 중 존재하는지 확인
                if (!temp[k] && words[k].contentEquals(sb)) {
                    temp[k] = true;
                    found = true;
                    break;
                }
            }

            // 일치하는 단어가 없으면 유효하지 않음
            if (!found) return false;
        }

        return true;
    }
}