public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10001];

        for(int i=1; i<=10000; i++) {
            String num = String.valueOf(i);

            int self = i;
            for(int j=0; j<num.length(); j++) {
                self += num.charAt(j)-'0';
            }

            if(self <= 10000) arr[self]++;
        }

        for(int i=1; i<=10000; i++) {
            if(arr[i] == 0) System.out.println(i);
        }
    }
}
