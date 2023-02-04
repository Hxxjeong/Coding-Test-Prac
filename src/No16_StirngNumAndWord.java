
public class No16_StirngNumAndWord {

	public int solution(String s) {
        int answer = 0;
        
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i=0; i<num.length; i++) {
            s = s.replace(num[i], Integer.toString(i));
        }
        
        answer = Integer.parseInt(s);
        return answer;
    }
	
	public static void main(String[] args) {
		No16_StirngNumAndWord s = new No16_StirngNumAndWord();
		System.out.println(s.solution("one4seveneight"));
	}

}
