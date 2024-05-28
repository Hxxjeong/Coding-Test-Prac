class Solution {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        
        for (int[] size: sizes) {
            if (size[0] > size[1]) {    // 가로가 세로보다 긴 경우 교환
                int tmp = size[0];
                size[0] = size[1];
                size[1] = tmp;
            }
            w = Math.max(w, size[1]);
            h = Math.max(h, size[0]);
        }
        
        return w * h;
    }
}