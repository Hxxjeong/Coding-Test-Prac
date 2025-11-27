import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean java = isJava(s);
        boolean cpp = isCpp(s);

        if(!java && !cpp) {
            System.out.println("Error!");
            return;
        }

        if(java) System.out.println(javaToCpp(s));
        else System.out.println(cppToJava(s));
    }

    static boolean isJava(String s) {
        if(!Character.isLowerCase(s.charAt(0))) return false;

        for(char c: s.toCharArray()) if(c == '_') return false;

        return true;
    }

    static boolean isCpp(String s) {
        if(s.charAt(0) == '_' || s.charAt(s.length()-1) == '_') return false;
        if(s.contains("__")) return false;

        for(char c: s.toCharArray()) if(Character.isUpperCase(c)) return false;

        return true;
    }

    static String javaToCpp(String s) {
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()) {
            if(Character.isUpperCase(c)) {
                sb.append('_');
                sb.append(Character.toLowerCase(c));
            }
            else sb.append(c);
        }

        return sb.toString();
    }

    static String cppToJava(String s) {
        StringBuilder sb = new StringBuilder();
        boolean upper = false;

        for(char c: s.toCharArray()) {
            if(c == '_') upper = true;
            else {
                if(upper) {
                    sb.append(Character.toUpperCase(c));
                    upper = false;
                }
                else sb.append(c);
            }
        }

        return sb.toString();
    }
}
