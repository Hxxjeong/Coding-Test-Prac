import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static StringBuilder sb = new StringBuilder();
    static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');   // 모음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        char[] arr = new char[C];
        for(int i=0; i<C; i++) arr[i] = st.nextToken().charAt(0);
        Arrays.sort(arr);

        char[] result = new char[L];
        dfs(result, arr,0, 0);

        System.out.println(sb);

        br.close();
    }

    public static void dfs(char[] result, char[] arr, int depth, int start) {
        if(depth == L) {
            // 유효한 문자열일 때만 추가
            if(isValid(result)) {
                for(char c: result) {
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i=start; i<arr.length; i++) {
            result[depth] = arr[i];
            dfs(result, arr, depth+1, i+1);
        }
    }

    private static boolean isValid(char[] result) {
        int vowelCount = 0;
        int consonantCount = 0;

        for(char c: result) {
            if(vowels.contains(c)) vowelCount++;
            else consonantCount++;
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }
}