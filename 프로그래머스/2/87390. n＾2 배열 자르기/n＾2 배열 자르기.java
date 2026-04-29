class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left+1)];

        for(long i=left; i<=right; i++) {
            // i = row * n + col
            long row = i / n;
            long col = i % n;

            // 각 칸은 행 번호와 열 번호 중 큰 값 + 1
            answer[(int) (i-left)] = (int) (Math.max(row, col) + 1);
        }

        return answer;
    }
}

/*
n=3
123223333

n=4
1234223433344444

n=5
1234522345333454444555555
*/