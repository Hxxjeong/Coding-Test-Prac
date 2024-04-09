class Solution {
    public long solution(long price, int money, int count) {
        long answer = 0;
        long sum = price;
        
        // count만큼 계산
        for(int i=2; i<=count; i++) {
            sum += price * i;
        }

        // 모자란 금액
        answer = sum - money;
        
        // 돈이 남으면 0 return
        return answer>0 ? answer : 0 ;
    }
}