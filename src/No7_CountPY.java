// Level1 ���ڿ� �� p�� y�� ����

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
