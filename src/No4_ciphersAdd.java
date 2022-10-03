// Level1 자릿수 더하기

public class No4_ciphersAdd {
    public int solution(int n) {
    	
        int answer = 0;
        
        while(n > 0)
        {
            answer += n % 10;
            n = n / 10;
        }
        
        return answer;
        
    }
    
    public static void main(String[] args) {
    	No4_ciphersAdd c = new No4_ciphersAdd();
    	System.out.println(c.solution(123));
    }
}