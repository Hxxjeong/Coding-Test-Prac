// Level1 정수 제곱근 판별

public class No5_sqrtTest {
	public long solution(long n) {
		
        long answer = 0;
        
        if(Math.floor(Math.sqrt(n)) == Math.sqrt(n)) {
        	answer = (long)Math.pow(Math.sqrt(n) + 1, 2);
        }
        else
        	answer = -1;
        
        return answer;
    }

	public static void main(String[] args) {
		No5_sqrtTest s = new No5_sqrtTest();
		System.out.println(s.solution(121));
	}

}