// Level1 문자열 내 p와 y의 개수

public class No7_CountPY {
	
	boolean solution(String s) {
		
        int countP = 0;
        int countY = 0;
        
        String uppers = s.toUpperCase();
        
        for(int i=0; i<uppers.length(); i++) {
        	if(uppers.charAt(i) == 'P') {
        		countP++;
        	}
        	if(uppers.charAt(i) == 'Y') {
        		countY++;
        	}
        }

        return countP == countY ? true : false;
    }

	public static void main(String[] args) {
		No7_CountPY c = new No7_CountPY();
		System.out.println(c.solution("Pyy"));
	}

}
