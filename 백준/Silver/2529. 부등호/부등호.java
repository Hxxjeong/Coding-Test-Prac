import java.io.*;

public class Main {
    static int k;
    static String[] input;
    static boolean[] visited;
    static StringBuilder max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");

        max = new StringBuilder();
        min = new StringBuilder();

        visited = new boolean[10];
        find(new StringBuilder(), 0, true);
        find(new StringBuilder(), 0, false);

        System.out.println(max);
        System.out.println(min);

        br.close();
    }

    public static void find(StringBuilder sb, int depth, boolean findMax) {
        // 길이만큼 찾은 경우 결과 리턴
        if(depth == k+1) {
            if(findMax) {
                // 초기 저장 or max 값 갱신
                if (max.length() == 0 || sb.toString().compareTo(max.toString()) > 0) {
                    max.setLength(0); // 기존 값을 지움
                    max.append(sb);   // 새로운 최대값 저장
                }
            } else {
                // 초기 저장 or min 값 갱신
                if (min.length() == 0 || sb.toString().compareTo(min.toString()) < 0) {
                    min.setLength(0); // 기존 값을 지움
                    min.append(sb);   // 새로운 최소값 저장
                }
            }
            return;
        }

        // findMax에 따라 0 to 9 / 9 to 0로 찾기
        for(int i=findMax ? 9 : 0; (findMax ? i >= 0 : i <= 9); i+=(findMax ? -1 : 1)) {
            if(visited[i]) continue;

            // 부등호 조건이 맞을 때만 다음 수 선택
            if(depth == 0 || check(sb.charAt(depth-1) - '0', i, input[depth-1])) {    // 첫 자리인 경우 부등호 비교 필요 X
                visited[i] = true;
                sb.append(i);   //  숫자 추가
                find(sb, depth+1, findMax);     // 다음 숫자 탐색
                sb.deleteCharAt(sb.length()-1); // 원래 상태 복원
                visited[i] = false;
            }
        }
    }

    // 부등호 조건 확인
    public static boolean check(int pre, int next, String sign) {
        if(sign.equals("<")) return pre < next;
        else return pre > next;
    }
}