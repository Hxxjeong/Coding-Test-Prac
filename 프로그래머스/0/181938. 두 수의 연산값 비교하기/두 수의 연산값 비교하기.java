class Solution {
    public int solution(int a, int b) {
        String s = String.valueOf(a) + String.valueOf(b);
        int aa = 2*a*b;
        int bb = Integer.parseInt(s);
        return bb >= aa ? bb : aa;
    }
}