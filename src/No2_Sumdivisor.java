// Level1 약수의 합

public class No2_Sumdivisor {
	public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
			if(n%i == 0)
				answer += i;
		}
        
        return answer;
    }
    
    public static void main(String[] args) {
        No2_Sumdivisor s = new No2_Sumdivisor();
		System.out.println(s.solution(12));
	}

}