class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {        
        int j = 0;
        int k = 0;
        boolean check = false;
        
        for(int i=0; i<goal.length; i++) {
            if(j < cards1.length && goal[i].equals(cards1[j])) {
                j++;
                check = true;
                continue;
            }
            else if(k < cards2.length && goal[i].equals(cards2[k])) {
                k++;
                check = true;
                continue;
            }
            else {
                check = false;
                break;
            }
        }
        
        return check ? "Yes" : "No";
    }
}